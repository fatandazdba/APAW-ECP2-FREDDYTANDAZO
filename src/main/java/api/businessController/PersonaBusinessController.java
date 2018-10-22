package api.businessController;
import api.daos.DaoFactory;
import api.dtos.PersonaDto;
import api.entities.Persona;
import api.exceptions.NotFoundException;

public class PersonaBusinessController {

    public String create(PersonaDto personaDto) {
        Persona persona = new Persona(personaDto.getNombre(), personaDto.getApellido(), personaDto.getEdad());
        DaoFactory.getFactory().getPersonaDao().save(persona);
        return persona.getId();
    }

    public void update(String id, PersonaDto personaDto) {
        Persona persona = DaoFactory.getFactory().getPersonaDao().read(id)
                .orElseThrow(() -> new NotFoundException("Persona id: " + id));
        persona.setNombre(personaDto.getNombre()).setApellido(personaDto.getApellido());
        persona.setEdad(personaDto.getEdad());
        DaoFactory.getFactory().getPersonaDao().save(persona);
    }
}
