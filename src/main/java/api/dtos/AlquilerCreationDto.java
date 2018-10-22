package api.dtos;

import java.time.LocalDateTime;

public class AlquilerCreationDto {

    private LocalDateTime fechaAlquiler;

    private LocalDateTime fechaEntrega;

    private String paisFabricacion;

    private String personaId;

    private String cocheId;

    public AlquilerCreationDto(LocalDateTime fechaAlquiler, LocalDateTime fechaEntrega, String paisFabricacion, String personaId, String cocheId) {
        this.fechaAlquiler = fechaAlquiler;
        this.fechaEntrega = fechaEntrega;
        this.paisFabricacion = paisFabricacion;
        this.personaId=personaId;
        this.cocheId=cocheId;
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

    public String getPersonaId() {
        return personaId;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

    public String getCocheId() {
        return cocheId;
    }

    public void setCocheId(String cocheId) {
        this.cocheId = cocheId;
    }

    @Override
    public String toString() {
        return "AlquilerCreationDto{" +
                "fechaAlquiler=" + fechaAlquiler +
                ", fechaEntrega=" + fechaEntrega +
                ", paisFabricacion='" + paisFabricacion + '\'' +
                ", personaId='" + personaId + '\'' +
                ", cocheId='" + cocheId + '\'' +
                '}';
    }




}