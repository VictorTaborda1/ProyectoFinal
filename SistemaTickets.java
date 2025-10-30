    import java.util.*;
import java.io.*;
public class SistemaTickets implements Gestionable {
    private ArrayList<Ticket> tickets = new ArrayList<>();// composicion//
    private Scanner sc = new Scanner(System.in);

    public SistemaTickets() {
    // Si más adelante necesitas inicializar algo extra, lo haces aquí
    System.out.println("Sistema de tickets iniciado correctamente");
    }   

    @Override
    public void crear() {
        System.out.print("Descripción: ");
        String desc = sc.nextLine();
        System.out.print("Prioridad (Alta/Media/Baja): ");
        String prio = sc.nextLine();
        System.out.print("Nombre del cliente: ");
        String nombreCliente = sc.nextLine();
        // Crear el objeto Cliente
        Cliente cliente = new Cliente(nombreCliente,"");

        Ticket t = new Ticket(desc, prio, cliente);
        tickets.add(t);
        System.out.println("Ticket creado con ID: " + t.getId());
    }
    // =============================
    // MÉTODOS DE PERSISTENCIA
    // =============================

    public void guardarArchivoTxt() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("tickets.txt"))) {
            for (Ticket t : tickets) {
                pw.println(t.getId() + ";" +
                           t.getDescripcion() + ";" +
                           t.getPrioridad() + ";" +
                           t.getEstado());
            }
            System.out.println("📄 Datos guardados en tickets.txt");
        } catch (IOException e) {
            System.out.println("⚠️ Error al guardar archivo: " + e.getMessage());
        }
    }

    public void cargarArchivoTxt() {
        try (BufferedReader br = new BufferedReader(new FileReader("tickets.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                Ticket t = new Ticket(datos[1], datos[2], new Cliente("Desconocido", ""));
                t.setId(Integer.parseInt(datos[0]));
                t.setEstado(datos[3]);
                tickets.add(t);
            }
            System.out.println("📂 Datos cargados desde tickets.txt");
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ No existe el archivo tickets.txt");
        } catch (IOException e) {
            System.out.println("⚠️ Error de lectura: " + e.getMessage());
        }
    }


    @Override
    public void listar() {
        if (tickets.isEmpty()) System.out.println("No hay tickets.");
        else tickets.forEach(System.out::println);
    }

    @Override
    public void cerrar() {
        System.out.print("Ingrese ID del ticket: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Ticket t : tickets) {
            if (t.getId() == id) {
                t.cerrarTicket();
                System.out.println("Ticket cerrado.");
                return;
            }
        }
        System.out.println("Ticket no encontrado.");
    }

    @Override
    public void guardarArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tickets.dat"))) {
            oos.writeObject(tickets);
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }
@Override
public void cargarArchivo() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tickets.dat"))) {
        @SuppressWarnings("unchecked")
        ArrayList<Ticket> lista = (ArrayList<Ticket>) ois.readObject();
        if (lista != null) {
            tickets = lista;
            // recalcular el siguiente id disponible
            int maxId = 0;
            for (Ticket t : tickets) {
                if (t.getId() > maxId) maxId = t.getId();
            }
            Ticket.setContador(maxId + 1);
        }
        System.out.println("Datos cargados correctamente. Siguiente ID: " + Ticket.getContador());
    } catch (FileNotFoundException fnf) {
        System.out.println("No se encontró el archivo 'tickets.dat'. Se inicia con lista vacía.");
    } catch (EOFException eof) {
        // archivo vacío, se ignora
        System.out.println("Archivo encontrado pero vacío. Se inicia con lista vacía.");
    } catch (ClassNotFoundException cnf) {
        System.out.println("Error: clase no encontrada al leer el archivo: " + cnf.getMessage());
        cnf.printStackTrace();
    } catch (InvalidClassException ice) {
        System.out.println("Error de serialización (serialVersionUID): " + ice.getMessage());
        ice.printStackTrace();
    } catch (IOException ioe) {
        System.out.println("Error de E/S al cargar archivo: " + ioe.getMessage());
        ioe.printStackTrace();
    } catch (Exception e) {
        System.out.println("Error inesperado al cargar archivo: " + e.getMessage());
        e.printStackTrace();
    }
}


    // Menú principal (fuera de la interfaz)
    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n=== SISTEMA DE TICKETS ===");
            System.out.println("1. Crear ticket");
            System.out.println("2. Listar tickets");
            System.out.println("3. Cerrar ticket");
            System.out.println("4. Guardar en archivo");
            System.out.println("5. Cargar desde archivo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> crear();
                    case 2 -> listar();
                    case 3 -> cerrar();
                    case 4 -> guardarArchivo();
                    case 5 -> cargarArchivo();
                    case 6 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 6);
    }
}
