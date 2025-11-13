import java.io.Serializable;

public class Empleado extends Persona  implements Serializable{
    private static final long serialVersionUID = 1L;
    private String departamento;

    public Empleado(String nombre, String email, String departamento) {
        super(nombre, email);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("👨‍💼 Empleado: " + nombre + " - Departamento: " + departamento);
    }
}
