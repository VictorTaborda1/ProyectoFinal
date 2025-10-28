import java.io.Serializable;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int contador = 1;
    private int id;
    private String descripcion;
    private String estado;
    private String prioridad;
    private String cliente;

    public Ticket(String descripcion, String prioridad, String cliente) {
        this.id = contador++;
        this.descripcion = descripcion;
        this.estado = "Abierto";
        this.prioridad = prioridad;
        this.cliente = cliente;
    }

    // Getters y setters
    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }
    public String getPrioridad() { return prioridad; }
    public String getCliente() { return cliente; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public void cerrarTicket() { this.estado = "Cerrado"; }

    // Métodos para el contador estático
    public static int getContador() { return contador; }
    public static void setContador(int nuevo) {
        if (nuevo > contador) contador = nuevo;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Cliente: " + cliente +
               " | Estado: " + estado +
               " | Prioridad: " + prioridad +
               " | Descripción: " + descripcion;
    }
}
