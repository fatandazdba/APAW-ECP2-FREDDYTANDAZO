package api.dtos;

import api.entities.Alquiler;

import java.time.LocalDateTime;

public class AlquilerIdReferenceDto {

    private LocalDateTime fechaAlquiler;

    private LocalDateTime fechaEntrega;

    private String paisFabricacion;

    public AlquilerIdReferenceDto(Alquiler alquiler) {
        this.fechaAlquiler = alquiler.getFechaAlquiler();
        this.fechaEntrega = alquiler.getFechaEntrega();
        this.paisFabricacion = alquiler.getPaisFabricacion();
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
}
