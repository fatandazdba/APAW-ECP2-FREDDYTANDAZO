package api.apiControllers;
import api.dtos.CocheDto;
import api.businessController.CocheBusinessController;
import api.entities.Accesorios;
import api.exceptions.ArgumentNotValidException;

import java.util.List;

public class CocheApiController {

    public static final String COCHES = "/coches";

    public static final String ID_ID = "/{id}";

    public static final String ACCESORIOS = "/accesorios";

    public static final String SEARCH = "/search";

    private CocheBusinessController cocheBusinessController = new CocheBusinessController();

    public String create(CocheDto cocheDto) {
        this.validate(cocheDto, "cocheDto");
        this.validate(cocheDto.getMarca(), "CocheDto marca");
        return this.cocheBusinessController.create(cocheDto);
    }

    public void update(String id, CocheDto cocheDto) {
        this.validate(cocheDto, "cocheDto");
        this.validate(cocheDto.getMarca(), "CocheDto Marca");
        this.cocheBusinessController.update(id, cocheDto);
    }

    public void updateAccesorio(String id, String cocheDtoAccesorio) {
        this.validate(cocheDtoAccesorio, "cocheDto");
        this.validate(cocheDtoAccesorio, "CocheDto accesorio");
        this.cocheBusinessController.updateAccesorio(id, cocheDtoAccesorio);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
    public List<String> findByAccesorio(String category) {
        this.validate(category, "accesorio");
        if(isAccesorio(category)) {
            return cocheBusinessController.findByAccesorio(category);
        } else throw new ArgumentNotValidException("Not a valid Game Rating category for search");

    }

    public boolean isAccesorio(String accesorio) {
        for(Accesorios coche: Accesorios.values()) {
            if(coche.name().equals(accesorio)) {
                return true;
            }
        } return false;
    }
}
