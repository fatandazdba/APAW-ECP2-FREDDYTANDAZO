package api.entities;

import java.time.LocalDateTime;

public class Alquiler{

    private String id;

    private LocalDateTime fechaAlquiler;

    private LocalDateTime fechaEntrega;

    private String paisFabricacion;

    private Persona persona;

    private Coche coche;

    private Alquiler alquiler;

    public Alquiler(String paisFabricacion, Persona persona, Coche coche) {
        this.fechaAlquiler = LocalDateTime.now();
        this.fechaEntrega = LocalDateTime.now();
        this.paisFabricacion = paisFabricacion;
        this.persona = persona;
        this.coche = coche;
    }

    public static Builder builder(String paisFabricacion, Persona persona, Coche coche){
        return new Builder(paisFabricacion, persona, coche);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getPaisFabricacion() {
        return paisFabricacion;
    }

    public void setPaisFabricacion(String paisFabricacion) {
        this.paisFabricacion = paisFabricacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "id='" + id + '\'' +
                ", fechaAlquiler=" + fechaAlquiler +
                ", fechaEntrega=" + fechaEntrega +
                ", paisFabricacion='" + paisFabricacion + '\'' +
                ", persona=" + persona +
                ", coche=" + coche +
                ", alquiler=" + alquiler +
                '}';
    }

    public static class Builder {
        private Alquiler alquiler;

        private Builder(String paisFabricacion, Persona persona, Coche coche) {
            this.alquiler = new Alquiler(paisFabricacion,persona,coche);
        }

        public Builder id(String id) {
            this.alquiler.setId(id);
            return this;
        }

        public Builder fechaAlquiler(LocalDateTime fechaAlquiler) {
            this.alquiler.setFechaAlquiler(fechaAlquiler);
            return this;
        }

        public Builder fechaEntrega(LocalDateTime fechaEntrega) {
            this.alquiler.setFechaEntrega(fechaEntrega);
            return this;
        }

        public Builder paisfabricacion(String paisfabricacion) {
            this.alquiler.setPaisFabricacion(paisfabricacion);
            return this;
        }

        public Builder persona(Persona persona) {
            this.alquiler.persona = persona;
            return this;
        }

        public Builder coche(Coche coche) {
            this.alquiler.coche=coche;
            return this;
        }

        public Alquiler build() {
            return this.alquiler;
        }
    }
}
