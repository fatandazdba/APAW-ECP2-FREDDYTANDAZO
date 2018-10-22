package api.businessController;

import api.dtos.CocheDto;
import api.entities.Coche;
import api.daos.DaoFactory;
import api.exceptions.NotFoundException;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

public class CocheBusinessController {

    public String create(CocheDto cocheDto) {
        LogManager.getLogger(this.getClass()).debug("   CocheBusinessController: " + cocheDto);
        Coche coche = new Coche(cocheDto.getNoMatricula(), cocheDto.getMarca(), cocheDto.getCocheActivo(), cocheDto.getAccesorios());
        DaoFactory.getFactory().getCocheDao().save(coche);
        return coche.getId();
    }

    public void update(String id, CocheDto cocheDto) {
        Coche coche = DaoFactory.getFactory().getCocheDao().read(id)
                .orElseThrow(() -> new NotFoundException("Persona id: " + id));
        coche.setNoMatricula(cocheDto.getNoMatricula());
        coche.setCocheActivo(cocheDto.getCocheActivo());
        coche.setMarca(cocheDto.getMarca());
        DaoFactory.getFactory().getCocheDao().save(coche);
    }

    public void updateAccesorio(String id, String cocheDto) {
        Coche coche = DaoFactory.getFactory().getCocheDao().read(id)
                .orElseThrow(() -> new NotFoundException("Persona id: " + id));
        coche.setAccesorio(cocheDto);
        DaoFactory.getFactory().getCocheDao().save(coche);
    }

    public List<String> findByAccesorio(String accesorio) {
        ArrayList<String> results = new ArrayList<>();
        List<Coche> coche = DaoFactory.getFactory().getCocheDao().findAll();
        for(Coche g: coche) {
            if(g.getAccesorio().equals(accesorio)) {
                results.add("{id: "+g.getId()+",marca: "+g.getMarca()+",matricula: "+g.getNoMatricula()+"Accesorio: "+g.getAccesorio()+"}");
            }
        }
        return results;
    }
}
