package api.daos.memory;

import api.daos.ConsesionariaDao;
import api.entities.Consesionaria;

public class ConsesionariaDaoMemory extends GenericDaoMemory<Consesionaria> implements ConsesionariaDao {
    @Override
    public String getId(Consesionaria consesionaria) {
        return consesionaria.getId();
    }

    @Override
    public void setId(Consesionaria consesionaria, String id) {
        consesionaria.setId(id);
    }

}
