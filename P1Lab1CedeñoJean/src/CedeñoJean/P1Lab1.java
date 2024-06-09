package CedeñoJean;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class P1Lab1 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
            int option;
            do {
                System.out.println("Menu:");
                System.out.println("1. Calcular total de compra");
                System.out.println("2. Ordenar nombres");
                System.out.println("3. Salir");
                System.out.print("Ingrese su opcion: ");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        calcularTotalCompra(scanner);
                        break;
                    case 2:
                        ordenarNombres(scanner);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente nuevamente.");
                }
            } while (option != 3);
        }
    }
    public static void calcularTotalCompra(Scanner scanner) {
        int cantidad;
        double precio;
        final double IVA = 0.12;
        System.out.print("Ingrese la cantidad de productos: ");
        cantidad = scanner.nextInt();
        while (cantidad < 0 ||cantidad > 100) {
            System.out.print("La cantidad de productos no puede ser negativa o mayor a 100. Ingrese nuevamente: ");
            cantidad = scanner.nextInt();
        }
        System.out.print("Ingrese el precio: ");
        precio = scanner.nextDouble();
        while (precio < 0 ||precio > 100) {
            System.out.print("El precio no puede ser negativo o mayor a 100. Ingrese nuevamente: ");
            precio = scanner.nextDouble();
        }
        double subtotal = cantidad * precio;
        double montoIVA = subtotal * IVA;
        double total = subtotal + montoIVA;
        System.out.println("El total de la compra es: " + total);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("registro.txt", true))) {
            writer.write("El total de la compra es: " + total + "\n");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    public static void ordenarNombres(Scanner scanner) {
        String[] nombres = new String[5];
        int numNombres;
        System.out.print("Ingrese el numero de nombres que desea ingresar (1-5): ");
        numNombres = scanner.nextInt();
        while (numNombres < 1 || numNombres > 5) {
            System.out.print("Ingrese un numero entre 1 y 5: ");
            numNombres = scanner.nextInt();
        }
        for (int i = 0; i < numNombres; ++i) {
            System.out.print("Ingrese el nombre " + (i + 1) + ": ");
            nombres[i] = scanner.next();
        }
        System.out.println("\nLos nombres ingresados son:");
        for (int i = 0; i < numNombres; ++i) {
            System.out.println((i + 1) + ". " + nombres[i]);
        }
        Arrays.sort(nombres, 0, numNombres);
        System.out.println("\nLos nombres ordenados son:");
        for (int i = 0; i < numNombres; ++i) {
            System.out.println((i + 1) + ". " + nombres[i]);
        }  
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("registro.txt", true))) {
            writer.write("Los nombres ordenados son:\n");
            for (int i = 0; i < numNombres; ++i) {
                writer.write((i + 1) + ". " + nombres[i] + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
	}
}
