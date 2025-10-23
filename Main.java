import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaSoporte sistema = new SistemaSoporte();

        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE SOPORTE ===");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Crear ticket");
            System.out.println("3. Asignar ticket a técnico");
            System.out.println("4. Mostrar todos los tickets");
            System.out.println("5. Mostrar usuarios");                          
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    System.out.print("Rol (cliente/tecnico): ");
                    String rol = sc.nextLine();
                    sistema.registrarUsuario(new Usuario(nombre, correo, rol));
                    System.out.println("✅ Usuario registrado correctamente.");
                    break;

                case 2:
                    System.out.print("Nombre del creador: ");
                    String creadorNombre = sc.nextLine();
                    Usuario creador = sistema.buscarUsuarioPorNombre(creadorNombre);
                    if (creador == null) {
                        System.out.println("⚠️ Usuario no encontrado.");
                    } else {
                        System.out.print("Título del ticket: ");
                        String titulo = sc.nextLine();
                        System.out.print("Descripción: ");
                        String descripcion = sc.nextLine();
                        sistema.crearTicket(titulo, descripcion, creador);
                    }
                    break;

                case 3:
                    System.out.print("ID del ticket: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre del técnico: ");
                    String tecnicoNombre = sc.nextLine();
                    Usuario tecnico = sistema.buscarUsuarioPorNombre(tecnicoNombre);
                    if (tecnico != null && tecnico.getRol().equalsIgnoreCase("tecnico")) {
                        sistema.asignarTicket(id, tecnico);
                    } else {
                        System.out.println("⚠️ Técnico no encontrado o no válido.");
                    }
                    break;

                case 4:
                    sistema.mostrarTickets();
                    break;

                case 5:
                    sistema.mostrarUsuarios();
                    break;

                case 0:
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println("❌ Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
