import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private String empresa;

    public Cliente(String nombre, String empresa) {
        super(nombre,"SinEmail");
        this.empresa = empresa;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("👤 Cliente: " + nombre + " - Empresa: " + empresa);
    }
}
