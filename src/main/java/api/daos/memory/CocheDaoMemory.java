package api.daos.memory;

import api.daos.CocheDao;
import api.daos.GenericDao;
import api.entities.Coche;

import java.util.List;
import java.util.Optional;

public class CocheDaoMemory extends GenericDaoMemory<Coche>  implements CocheDao{


    @Override
    public String getId(Coche coche) {
        return coche.getId();
    }

    @Override
    public void setId(Coche coche, String id) {
          coche.setId(id);
    }
}
