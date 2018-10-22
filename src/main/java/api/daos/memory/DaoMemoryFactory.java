package api.daos.memory;

import api.daos.*;

public class DaoMemoryFactory extends DaoFactory {

    private PersonaDao personaDao;

    private CocheDao cocheDao;

    private ConsesionariaDao consesionariaDao;

    private AlquilerDao alquilerDao;

    @Override
    public PersonaDao getPersonaDao(){
        if (this.personaDao == null) {
            this.personaDao = new PersonaDaoMemory();
        }
        return this.personaDao;

    }

    @Override
    public CocheDao getCocheDao() {
        if (this.cocheDao == null) {
            this.cocheDao = new CocheDaoMemory();
        }
        return this.cocheDao;
    }

    @Override
    public ConsesionariaDao getConsesionariaDao() {
        if (this.consesionariaDao == null) {
            this.consesionariaDao = new ConsesionariaDaoMemory();
        }
        return this.consesionariaDao;
    }

    @Override
    public AlquilerDao getAlquilerDao() {
        if (this.alquilerDao == null) {
            this.alquilerDao = new AlquilerDaoMemory();
        }
        return this.alquilerDao;
    }
}
