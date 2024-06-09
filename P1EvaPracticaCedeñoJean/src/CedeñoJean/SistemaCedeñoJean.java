package CedeñoJean;
public class SistemaCedeñoJean {
    public static double saldo = 1000.00;
    public static double consultarSaldo() {
        return saldo;
    }
    public static void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }
    public static boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }
    public static String generarRecibo() {
        return "Recibo:\n" +
               "Nombre: " + UsuarioCedeñoJean.nombre + "\n" +
               "Apellido: " + UsuarioCedeñoJean.apellido + "\n" +
               "Número de Tarjeta: " + UsuarioCedeñoJean.numeroTarjeta + "\n" +
               "Saldo: $" + consultarSaldo() + "\n";
    }
}