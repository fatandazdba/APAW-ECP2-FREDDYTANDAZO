package api;

import api.apiControllers.CocheApiController;
import api.dtos.CocheDto;
import api.entities.Accesorios;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CocheTest {

    @Test
    void testCreateCoche() {
        this.createCoche();
    }

    private String createCoche() {
        HttpRequest request = HttpRequest.builder(CocheApiController.COCHES).body(new CocheDto("ERER","Chevrolet",false, "RIN_ACERO")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testCreateCocheWithoutCocheDto() {
        HttpRequest request = HttpRequest.builder(CocheApiController.COCHES).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateCocheWithoutCocheDtoMarca() {
        HttpRequest request = HttpRequest.builder(CocheApiController.COCHES).body(new CocheDto("9876 ERER",null,null, null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }


    @Test
    void testUpdateCoche() {
        String id = this.createCoche();
        HttpRequest request = HttpRequest.builder(CocheApiController.COCHES).path(CocheApiController.ID_ID)
                .expandPath(id).body(new CocheDto("5467 LLI","MITSUBIHI",true, "RIN_ACERO")).put();
        assertEquals(HttpStatus.OK, new Client().submit(request).getStatus());
    }

    @Test
    void testUpdateCocheWithoutCocheDto() {
        String id = this.createCoche();
        HttpRequest request = HttpRequest.builder(CocheApiController.COCHES).path(CocheApiController.ID_ID)
                .expandPath(id).body(null).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateAccesorios() {
        String id = this.createCoche();
        HttpRequest request = HttpRequest.builder(CocheApiController.COCHES).path(CocheApiController.ID_ID)
                .expandPath(id).path(CocheApiController.ACCESORIOS).body(Accesorios.AMPLIFICADOR).patch();
        new Client().submit(request);
        assertEquals(HttpStatus.OK, new Client().submit(request).getStatus() );
    }
}