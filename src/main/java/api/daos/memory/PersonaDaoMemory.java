package api.daos.memory;

import api.daos.PersonaDao;
import api.entities.Persona;
import api.entities.Persona;

public class PersonaDaoMemory extends GenericDaoMemory<Persona> implements PersonaDao {

    @Override
    public String getId(Persona user) {
        return user.getId();
    }

    @Override
    public void setId(Persona user, String id) {
        user.setId(id);
    }
}
