package api.apiControllers;

import api.businessController.PersonaBusinessController;
import api.dtos.PersonaDto;
import api.exceptions.ArgumentNotValidException;

public class PersonaApiController {

    public static final String PERSONAS = "/personas";

    public static final String ID_ID = "/{id}";

    private PersonaBusinessController personaBusinessController = new PersonaBusinessController();

    public String create(PersonaDto personaDto) {
        this.validate(personaDto, "personaDto");
        this.validate(personaDto.getNombre(), "PersonaDto Nombre");
        return this.personaBusinessController.create(personaDto);
    }

    public void update(String id, PersonaDto personaDto) {
        this.validate(personaDto, "personaDto");
        this.validate(personaDto.getNombre(), "PersonaDto Nombre");
        this.personaBusinessController.update(id, personaDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
