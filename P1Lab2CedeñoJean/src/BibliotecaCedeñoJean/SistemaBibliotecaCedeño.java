package BibliotecaCedeñoJean;
import java.io.*;
import java.util.*;
public class SistemaBibliotecaCedeño {
    private List<BibliotecaCedeño> libros;
    private Map<String, BibliotecaCedeño> librosPedidos;
    public SistemaBibliotecaCedeño() {
        libros = new ArrayList<>();
        librosPedidos = new HashMap<>();
        inicializarLibros();
    }
    // Método para inicializar la lista de libros
    private void inicializarLibros() {
        libros.add(new BibliotecaCedeño("Programación en Java", "Alfaomega", 2021, "Luis Joyanes", true));
        libros.add(new BibliotecaCedeño("Algoritmos y Programación", "McGraw-Hill", 2018, "Juan Garza", true));
        libros.add(new BibliotecaCedeño("Código Limpio", "Prentice Hall", 2015, "Robert C. Martin", true));
        libros.add(new BibliotecaCedeño("Introducción a la Programación", "Pearson", 2019, "Tony Gaddis", true));
    }
    // Métodos para gestionar libros
    public void pedirLibro(String nombreLibro) {
        for (BibliotecaCedeño libro : libros) {
            if (libro.getNombreLibro().equalsIgnoreCase(nombreLibro) && libro.isDisponible()) {
                libro.setDisponible(false);
                librosPedidos.put(nombreLibro, libro);
                System.out.println("Has pedido el libro: " + nombreLibro);
                return;
            }
        }
        System.out.println("El libro no está disponible o no existe.");
    }
    public void devolverLibro(String nombreLibro) {
        if (librosPedidos.containsKey(nombreLibro)) {
            BibliotecaCedeño libroDevuelto = librosPedidos.remove(nombreLibro);
            libroDevuelto.setDisponible(true);
            System.out.println("Has devuelto el libro: " + nombreLibro);
        } else {
            System.out.println("El libro no fue encontrado o no lo has pedido.");
        }
    }
    public void mostrarLibrosPedidos() {
        if (librosPedidos.isEmpty()) {
            System.out.println("No has pedido ningún libro.");
        } else {
            System.out.println("Libros pedidos:");
            for (BibliotecaCedeño libro : librosPedidos.values()) {
                System.out.println(libro);
            }
        }
    }
    public void consultarLibro(String nombreLibro) {
        for (BibliotecaCedeño libro : libros) {
            if (libro.getNombreLibro().equalsIgnoreCase(nombreLibro)) {
                System.out.println(libro);
                return;
            }
        }
        System.out.println("El libro no fue encontrado.");
    }
    public void mostrarLibrosDisponibles() {
        for (BibliotecaCedeño libro : libros) {
            if (libro.isDisponible()) {
                System.out.println(libro);
            }
        }
    }
    // Métodos para guardar y cargar libros pedidos desde un archivo CSV
    public void guardarLibrosPedidosEnCSV(String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (BibliotecaCedeño libro : librosPedidos.values()) {
                writer.println(libro.getNombreLibro() + "," + libro.getEditorialLibro() + "," +
                               libro.getAñoLibro() + "," + libro.getAutorLibro() + "," + libro.isDisponible());
            }
            System.out.println("Libros pedidos guardados en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los libros pedidos en CSV: " + e.getMessage());
        }
    }
    // Métodos para guardar y cargar libros pedidos desde un archivo JSON
    public void guardarLibrosPedidosEnJSON(String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            writer.println("[");
            int size = librosPedidos.size();
            int count = 0;
            for (BibliotecaCedeño libro : librosPedidos.values()) {
                writer.println("  {");
                writer.println("    \"nombreLibro\": \"" + libro.getNombreLibro() + "\",");
                writer.println("    \"editorialLibro\": \"" + libro.getEditorialLibro() + "\",");
                writer.println("    \"añoLibro\": " + libro.getAñoLibro() + ",");
                writer.println("    \"autorLibro\": \"" + libro.getAutorLibro() + "\",");
                writer.println("    \"disponible\": " + libro.isDisponible());
                writer.println("  }" + (++count < size ? "," : ""));
            }
            writer.println("]");
            System.out.println("Libros pedidos guardados en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los libros pedidos en JSON: " + e.getMessage());
        }
    }
}