package CedeñoJean;
import java.util.Scanner;
public class CajeroCedeñoJean {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al cajero automático");
        boolean tarjetaBloqueada = false;
        int intentosTarjeta = 0;
        while (intentosTarjeta < 3) {
            System.out.print("Ingrese el número de tarjeta: ");
            String numeroTarjetaIngresada = scanner.nextLine();

            if (numeroTarjetaIngresada.equals(UsuarioCedeñoJean.numeroTarjeta)) {
                break;
            } else {
                intentosTarjeta++;
                System.out.println("Número de tarjeta incorrecto. Intentos restantes: " + (3 - intentosTarjeta));
            }

            if (intentosTarjeta == 3) {
                System.out.println("Tarjeta Bloqueada");
                tarjetaBloqueada = true;
            }
        }
        if (tarjetaBloqueada) {
            scanner.close();
            return;
        }
        boolean accesoPermitido = false;
        int intentosContrasena = 0;
        while (intentosContrasena < 3) {
            System.out.print("Ingrese la contraseña: ");
            String contrasenaIngresada = scanner.nextLine();
            if (contrasenaIngresada.equals(UsuarioCedeñoJean.contrasena)) {
                accesoPermitido = true;
                break;
            } else {
                intentosContrasena++;
                System.out.println("Contraseña incorrecta. Intentos restantes: " + (3 - intentosContrasena));
            }
            if (intentosContrasena == 3) {
                System.out.println("Contraseña Incorrecta. Acceso Denegado.");
                accesoPermitido = false;
            }
        }
        if (!accesoPermitido) {
            scanner.close();
            return;
        }
        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Generar Recibo");
            System.out.println("5. Retirar Tarjeta");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Su saldo es: $" + SistemaCedeñoJean.consultarSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese el monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    SistemaCedeñoJean.depositar(deposito);
                    System.out.println("Depósito realizado. Su saldo es: $" + SistemaCedeñoJean.consultarSaldo());
                    break;
                case 3:
                    System.out.print("Ingrese el monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    if (SistemaCedeñoJean.retirar(retiro)) {
                        System.out.println("Retiro realizado. Su saldo es: $" + SistemaCedeñoJean.consultarSaldo());
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 4:
                    System.out.println(SistemaCedeñoJean.generarRecibo());
                    break;
                case 5:
                    System.out.println("Gracias por usar este servicio. ¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}