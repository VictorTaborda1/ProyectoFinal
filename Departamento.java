import java.io.Serializable;

public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarInfo() {
        System.out.println("🏢 Departamento: " + nombre);
    }
}

