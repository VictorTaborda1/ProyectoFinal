import java.time.LocalDateTime;

public class Ticket {
    private static int contador = 1;
    private int id;
    private String titulo;
    private String descripcion;
    private String estado; // abierto, en proceso, cerrado
    private Usuario creador;
    private Usuario asignado;
    private LocalDateTime fechaCreacion;

    public Ticket(String titulo, String descripcion, Usuario creador) {
        this.id = contador++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.creador = creador;
        this.estado = "abierto";
        this.fechaCreacion = LocalDateTime.now();
    }

    public int getId() { return id; }
    public void asignarTecnico(Usuario tecnico) {
        this.asignado = tecnico;
        this.estado = "en proceso";
    }


    public void cerrarTicket() {
        this.estado = "cerrado";
    }

    @Override
    public String toString() {
        return "Ticket #" + id + " - " + titulo +
               "\nDescripción: " + descripcion +
               "\nEstado: " + estado +
               "\nCreado por: " + creador +
               "\nAsignado a: " + (asignado != null ? asignado : "Nadie") +
               "\nFecha: " + fechaCreacion;
    }
}