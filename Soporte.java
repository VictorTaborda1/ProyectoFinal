public class Soporte extends Empleado {
    private String area;

    public Soporte(String nombre, String idEmpleado, String area) {
        super(nombre, idEmpleado);
        this.area = area;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Soporte: " + getNombre() + " | Área: " + area);
    }
}