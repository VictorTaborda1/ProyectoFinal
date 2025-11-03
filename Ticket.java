import java.io.Serializable;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int contador = 1;
    private int id;
    private String descripcion;
    private String estado;
    private String prioridad;
    private Cliente cliente;  // agregacion
    private String solucion;
    private Tecnico tecnicoAsignado;


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
        this.tecnicoAsignado = tecnico; // Agregación (el técnico existe independientemente)
    }
    public void mostrarInfo() {
        System.out.println("Ticket #" + id + " - " + descripcion +
                           "\nPrioridad: " + prioridad +
                           "\nEstado: " + estado );
    if (cliente != null) {
        System.out.println("👤 Cliente: " + cliente.getNombre());
    }
    if (tecnicoAsignado != null) {
        System.out.println("🧑‍💻 Técnico asignado: " + tecnicoAsignado.getNombre());
    }
    if (solucion != null && !solucion.isEmpty()) {
        System.out.println("✅ Solución: " + solucion);
    }
    System.out.println("----------------------------------");
}


    // Getters y setters
    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }
    public String getPrioridad() { return prioridad; }
    public Cliente getCliente() { return cliente; }
    public Tecnico getTecnicoAsignado() {return tecnicoAsignado;}
    public String getSolucion() {return solucion;}

    public void setSolucion(String solucion) {this.solucion = solucion;}
    public void setTecnicoAsignado(Tecnico tecnicoAsignado) {this.tecnicoAsignado = tecnicoAsignado;}
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
