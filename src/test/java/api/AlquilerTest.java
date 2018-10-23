package api;

import static org.junit.jupiter.api.Assertions.*;

import api.apiControllers.*;
import api.dtos.*;
import http.Client;
import http.HttpRequest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class AlquilerTest {
    @Test
    void testCreateTheme() {
        this.createAlquiler("Alquiler");
    }

    private String createAlquiler(String alquiler) {
        String personaId = this.createPersona();
        String cocheId = this.createCoche();
        HttpRequest request = HttpRequest.builder(AlquilerApiController.ALQUILERS)
                .body(new AlquilerCreationDto( LocalDateTime.now(), LocalDateTime.now(),"COREA", personaId, cocheId )).post();
        return (String) new Client().submit(request).getBody();
    }

    private String createPersona() {
        HttpRequest request = HttpRequest.builder(PersonaApiController.PERSONAS).body(new PersonaDto("FREDDY","TANDAZO",2)).post();
        return (String) new Client().submit(request).getBody();
    }

    private String createCoche() {
        HttpRequest request = HttpRequest.builder(CocheApiController.COCHES).body(new CocheDto("ERTF","HYUNDAY",true, "AMPLIFICADOR")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testReadAll() {
        for (int i = 0; i < 5; i++) {
            this.createAlquiler("Alquiler" + i);
        }
        HttpRequest request = HttpRequest.builder(AlquilerApiController.ALQUILERS).get();
        List<AlquilerIdReferenceDto> themes = (List<AlquilerIdReferenceDto>) new Client().submit(request).getBody();
        assertTrue(themes.size() >= 5);
    }




}