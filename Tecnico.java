public class Tecnico extends Persona {
    private String especialidad;

    public Tecnico(String nombre, String email, String especialidad) {
        super(nombre, email);
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("👨‍🔧 Técnico: " + nombre + " - Especialidad: " + especialidad);
    }
}
