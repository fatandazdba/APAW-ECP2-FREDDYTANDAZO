package api.dtos;

import org.apache.logging.log4j.LogManager;

public class CocheDto {

    private String noMatricula;

    private String marca;

    private Boolean cocheActivo;

    private String accesorios;

    public CocheDto(String noMatricula, String marca, Boolean cocheActivo, String accesorios) {
        this.noMatricula = noMatricula;
        this.marca = marca;
        this.cocheActivo = cocheActivo;
        this.accesorios=accesorios;
    }

    public String getNoMatricula() {
        return noMatricula;
    }

    public void setNoMatricula(String noMatricula) {
        this.noMatricula = noMatricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean getCocheActivo() {
        return cocheActivo;
    }

    public void setCocheActivo(Boolean cocheActivo) {
        this.cocheActivo = cocheActivo;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    @Override
    public String toString() {
        return "CocheDto{" +
                "noMatricula='" + noMatricula + '\'' +
                ", marca='" + marca + '\'' +
                ", cocheActivo=" + cocheActivo +
                ", accesorios='" + accesorios + '\'' +
                '}';
    }
}
