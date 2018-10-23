package api.businessController;

import api.daos.DaoFactory;
import api.dtos.AlquilerCreationDto;
import api.dtos.AlquilerIdReferenceDto;
import api.entities.Alquiler;
import api.entities.Coche;
import api.entities.Persona;
import api.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class AlquilerBusinessController {
    public String create(AlquilerCreationDto alquilerCreationDto) {
        Persona persona = null;
        Coche coche= null;
        if (alquilerCreationDto.getPersonaId() != null) {
            persona = DaoFactory.getFactory().getPersonaDao().read(alquilerCreationDto.getPersonaId())
                    .orElseThrow(() -> new NotFoundException("Persona (" + alquilerCreationDto.getPersonaId() + ")"));
        }
        Alquiler alquiler = Alquiler.builder(alquilerCreationDto.getPaisFabricacion(),persona,coche).build();
        DaoFactory.getFactory().getAlquilerDao().save(alquiler);
        return alquiler.getId();
    }

    public void delete(String id) {
        DaoFactory.getFactory().getAlquilerDao().deleteById(id);
    }

    public List<AlquilerIdReferenceDto> readAll() {
        List<AlquilerIdReferenceDto> A=DaoFactory.getFactory().getAlquilerDao().findAll().stream().map(AlquilerIdReferenceDto::new).collect(Collectors.toList());
        return DaoFactory.getFactory().getAlquilerDao().findAll().stream().map(AlquilerIdReferenceDto::new).collect(Collectors.toList());
    }


}
