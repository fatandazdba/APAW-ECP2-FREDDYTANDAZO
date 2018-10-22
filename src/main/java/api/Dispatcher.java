package api;

import api.apiControllers.*;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.*;
import api.exceptions.ArgumentNotValidException;
import api.exceptions.NotFoundException;
import api.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

    static {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private PersonaApiController personaApiController = new PersonaApiController();

    private CocheApiController cocheApiController = new CocheApiController();

    private AlquilerApiController alquilerApiController= new AlquilerApiController();

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case PUT:
                    this.doPut(request);
                    break;
               /* case GET:
                    this.doGet(request, response);
                    break;
                case PATCH:
                    this.doPatch(request);
                    break;
                case DELETE:
                    this.doDelete(request);
                    break;*/
                default: // Unexpected
                    throw new RequestInvalidException("method error: " + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(CocheApiController.COCHES)) {
            response.setBody(this.cocheApiController.create((CocheDto) request.getBody()));
        }/*else if (request.isEqualsPath(PersonaApiController.PERSONAS)) {
            response.setBody(this.personaApiController.create((PersonaDto) request.getBody()));
        }else if (request.isEqualsPath(CocheApiController.COCHES)) {
            response.setBody(this.cocheApiController.create((CocheDto) request.getBody()));
        }else if (request.isEqualsPath(AlquilerApiController.ALQUILERS)) {
            response.setBody(this.alquilerApiController.create((AlquilerCreationDto) request.getBody()));
        } */else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }
/*
    private void doGet(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(AlquilerApiController.ALQUILERS)) {
            response.setBody(this.alquilerApiController.readAll());
        } else if (request.isEqualsPath(CocheApiController.COCHES + CocheApiController.SEARCH)) {
            response.setBody(this.cocheApiController.findByAccesorio(request.getParams().get("q")));
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }
*/
    private void doPut(HttpRequest request) {
        if (request.isEqualsPath(cocheApiController.COCHES + CocheApiController.ID_ID)) {
            this.cocheApiController.update(request.getPath(1), (CocheDto) request.getBody());
        }else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }
/*
    private void doPatch(HttpRequest request) {
        if (request.isEqualsPath(CocheApiController.COCHES + CocheApiController.ID_ID + CocheApiController.ACCESORIOS)) {
            String a="ee";
            this.cocheApiController.updateAccesorio(request.getPath(1), String.valueOf(request.getBody()));
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doDelete(HttpRequest request) {
        if (request.isEqualsPath(AlquilerApiController.ALQUILERS + AlquilerApiController.ID_ID)) {
            this.alquilerApiController.delete(request.getPath(1));
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }
*/
}
