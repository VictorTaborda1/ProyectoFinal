import java.io.Serializable;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int contador = 1;
    private int id;
    private String descripcion;
    private String estado;
    private String prioridad;
    private Cliente cliente;  // Asociación
    private Tecnico tecnico;  // Agregación
    private String solucion;

    public Ticket(String descripcion, String prioridad, Cliente cliente) {
        this.id = contador++;
        this.descripcion = descripcion;
        this.estado = "Abierto";
        this.prioridad = prioridad;
        this.cliente = cliente;
    }
      public void registrarSolucion(String solucion) {
        this.solucion = solucion;
        this.estado = "Cerrado";
    }

    public void asignarTecnico(Tecnico tecnico) {
        this.tecnico = tecnico; // Agregación (el técnico existe independientemente)
    }
    public void mostrarInfo() {
        System.out.println("Ticket #" + id + " - " + descripcion +
                           "\nPrioridad: " + prioridad +
                           "\nEstado: " + estado +
                           "\nCliente: " + cliente.getNombre() +
                           "\nTécnico: " + (tecnico != null ? tecnico.getNombre() : "No asignado") +
                           "\nSolución: " + (solucion != null ? solucion : "Pendiente"));
    }


    // Getters y setters
    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }
    public String getPrioridad() { return prioridad; }
    public Cliente getCliente() { return cliente; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setEstado(String estado) { 
    this.estado = estado; }
    public void setId(int id) {
        this.id = id;
        // Asegurar que contador siempre sea mayor que cualquier id existente
        if (id >= contador) {
            contador = id + 1;
        }
    }


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
