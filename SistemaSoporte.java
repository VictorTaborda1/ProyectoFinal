import java.util.ArrayList;
import java.util.List;

public class SistemaSoporte {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();
    public void registrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public void crearTicket(String titulo, String descripcion, Usuario creador) {
        Ticket t=new Ticket(titulo, descripcion, creador);
        tickets.add(t);
        System.out.println("✅ Ticket creado con éxito. ID asignado: " + t.getId());
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return u;
            }
        }
        return null;
    }

    public Ticket buscarTicketPorId(int id) {
        for (Ticket t : tickets) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void asignarTicket(int idTicket, Usuario tecnico) {
        Ticket t = buscarTicketPorId(idTicket);
        if (t != null) {
            t.asignarTecnico(tecnico);
            System.out.println("✅ Ticket asignado correctamente.");
        } else {
            System.out.println("⚠️ Ticket no encontrado.");
        }
    }

    public void mostrarTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets registrados.");
        } else {
            for (Ticket t : tickets) {
                System.out.println("\n" + t + "\n---------------------");
            }
        }
    }

    public void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario u : usuarios) {
                System.out.println("- " + u);
            }
        }
    }
}
