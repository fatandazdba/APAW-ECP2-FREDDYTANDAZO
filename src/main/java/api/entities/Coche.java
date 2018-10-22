package api.entities;

public class Coche {

    private String id;

    private String noMatricula;

    private String marca;

    private Boolean cocheActivo;

    private String accesorio;

    public Coche(String noMatricula, String marca, Boolean cocheActivo, String accesorio) {
        this.noMatricula = noMatricula;
        this.marca = marca;
        this.cocheActivo = cocheActivo;
        this.accesorio=accesorio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(String accesorio) {
        this.accesorio = accesorio;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id='" + id + '\'' +
                ", noMatricula='" + noMatricula + '\'' +
                ", marca='" + marca + '\'' +
                ", cocheActivo=" + cocheActivo +
                ", accesorio='" + accesorio + '\'' +
                '}';
    }
}
