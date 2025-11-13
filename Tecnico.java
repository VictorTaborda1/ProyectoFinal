import java.io.Serializable;

public class Tecnico extends Persona implements Serializable {
    private String especialidad;

    public Tecnico(String nombre, String email, String especialidad) {
        super(nombre, email);
        this.especialidad = especialidad;
    }
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    @Override
    public void mostrarInfo() {
        System.out.println("👨‍🔧 Técnico: " + nombre + " - Especialidad: " + especialidad);
    }
}
