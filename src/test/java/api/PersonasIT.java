package api;

import api.apiControllers.PersonaApiController;
import api.dtos.PersonaDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonasIT {

    @Test
    void testCreatePersona() {
        this.createPersona();
    }

    private String createPersona() {
        HttpRequest request = HttpRequest.builder(PersonaApiController.PERSONAS).body(new PersonaDto("freddy","freddy@email",12)).post();
        return (String) new Client().submit(request).getBody();
    }



    @Test
    void testUpdatePersona() {
        String id = this.createPersona();
        HttpRequest request = HttpRequest.builder(PersonaApiController.PERSONAS).path(PersonaApiController.ID_ID)
                .expandPath(id).body(new PersonaDto("Luis", "Ruíz",50)).put();
        assertEquals(HttpStatus.OK, new Client().submit(request).getStatus());
    }

    @Test
    void testUpdatePersonaWithoutPersonaDto() {
        String id = this.createPersona();
        HttpRequest request = HttpRequest.builder(PersonaApiController.PERSONAS).path(PersonaApiController.ID_ID)
                .expandPath(id).body(null).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdatePersonaNotFoundException() {
        HttpRequest request = HttpRequest.builder(PersonaApiController.PERSONAS).path(PersonaApiController.ID_ID)
                .expandPath("s5FdeGf54D").body(new PersonaDto("dos","",45)).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }
}