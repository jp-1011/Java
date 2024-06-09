package BibliotecaCedeñoJean;
import java.util.Scanner;
public class CedeñoJean {
    public static void main(String[] args) {
        SistemaBibliotecaCedeño sistema = new SistemaBibliotecaCedeño();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú de Biblioteca ---");
            System.out.println("1. Mostrar libros disponibles");
            System.out.println("2. Consultar un libro");
            System.out.println("3. Pedir un libro");
            System.out.println("4. Devolver un libro");          
            System.out.println("5. Mostrar libros pedidos");
            System.out.println("6. Guardar libros pedidos en CSV");
            System.out.println("7. Guardar libros pedidos en JSON");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                	System.out.println("Libros disponibles:");
                	sistema.mostrarLibrosDisponibles();
                break;
                case 2:
                    System.out.print("Ingrese el nombre del libro a consultar: ");
                    String nombreConsulta = scanner.nextLine();
                    sistema.consultarLibro(nombreConsulta);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del libro a pedir: ");
                    String nombrePedir = scanner.nextLine();
                    sistema.pedirLibro(nombrePedir);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del libro a devolver: ");
                    String nombreDevolver = scanner.nextLine();
                    sistema.devolverLibro(nombreDevolver);
                    break;           
                case 5:
                    System.out.println("Libros pedidos:");
                    sistema.mostrarLibrosPedidos();
                    break;
                case 6:
                    sistema.guardarLibrosPedidosEnCSV("libros_pedidos.csv");
                    break;
                case 7:
                    sistema.guardarLibrosPedidosEnJSON("libros_pedidos.json");
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 8);
        scanner.close();
    }
}