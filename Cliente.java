import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    public Cliente(String nombre, String email) {
        super(nombre, email);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("👤 Cliente  " + nombre + " - Correo: " + email);
    }

    
}
