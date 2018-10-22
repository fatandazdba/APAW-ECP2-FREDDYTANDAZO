package api.dtos;

public class ConsesionariaDto {

    private String nombre;

    public ConsesionariaDto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Consesionaria{" +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
