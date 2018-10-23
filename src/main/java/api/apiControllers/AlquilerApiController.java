package api.apiControllers;

import api.businessController.AlquilerBusinessController;
import api.dtos.AlquilerCreationDto;
import api.dtos.AlquilerIdReferenceDto;
import api.exceptions.ArgumentNotValidException;

import java.util.List;

public class AlquilerApiController {

        public static final String ALQUILERS = "/alquilers";

        public static final String ID_ID = "/{id}";

        public static final String PERSONAS = "/personas";

        public static final String AVERAGE = "/average";

        public static final String COCHES = "/coches";

        public static final String SEARCH = "/search";

        private AlquilerBusinessController alquilerBusinessController = new AlquilerBusinessController();

        public String create(AlquilerCreationDto alquilerDto) {
                this.validate(alquilerDto, "alquilerDto");
                this.validate(alquilerDto.getPaisFabricacion(), "alquilerDto paisFabricacion");
                this.validate(alquilerDto.getPersonaId(), "alquilerDto personaId");
                this.validate(alquilerDto.getCocheId(), "alquilerDto cocheId");
                return this.alquilerBusinessController.create(alquilerDto);
        }

        public void delete(String id) {
                this.alquilerBusinessController.delete(id);
        }

        private void validate(Object property, String message) {
                if (property == null) {
                        throw new ArgumentNotValidException(message + " is missing");
                }
        }

        public List<AlquilerIdReferenceDto> readAll() {
                return this.alquilerBusinessController.readAll();
        }

}
