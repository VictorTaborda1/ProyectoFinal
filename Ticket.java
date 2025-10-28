
public class Ticket implements Gestionable {
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
    // Métodos para gestionar el contador estático (útiles tras deserializar)
    public static int getContador() {
        return contador;
    }

    public static void setContador(int nuevo) {
        if (nuevo > contador) {
            contador = nuevo;
        }
    }
    public void cerrarTicket() { this.estado = "Cerrado"; }

    @Override
    public String toString() {
        return "ID: " + id + " | Cliente: " + cliente + 
               " | Estado: " + estado + " | Prioridad: " + prioridad +
               " | Descripción: " + descripcion;
    }
    public int getId() {
        return this.id;              // devuelve el id de la instancia (CORRECTO)
    }

}
