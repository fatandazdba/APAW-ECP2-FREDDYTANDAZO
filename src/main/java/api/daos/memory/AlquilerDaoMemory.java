package api.daos.memory;

import api.daos.AlquilerDao;
import api.entities.Alquiler;

import java.util.List;
import java.util.stream.Collectors;

public class AlquilerDaoMemory extends GenericDaoMemory<Alquiler> implements AlquilerDao {
    @Override
    public String getId(Alquiler alquiler) {
        return alquiler.getId();
    }

    @Override
    public void setId(Alquiler alquiler, String id) {
                alquiler.setId(id);
    }

}
