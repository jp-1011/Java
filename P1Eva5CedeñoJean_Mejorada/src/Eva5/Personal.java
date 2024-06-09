package Eva5;
import java.io.PrintWriter;
import java.io.*;
import java.util.Scanner;
public class Personal {
	Scanner cin = new Scanner(System.in);
	public String nombreApellido;
	public String ci;
	public Personal (String nombreApellido,String ci) {
		this.nombreApellido = nombreApellido;
	}
	public void ingresarDatos() {
		System.out.println("Ingresar su nombre y apellido");
		nombreApellido = cin.nextLine();
		System.out.println("Ingresar su cedula de identidad");
		ci = cin.nextLine();
	}
	public void mostrarDatos() {
		System.out.println("Su nombre y apellido es:" + nombreApellido);
		System.out.println("Su cedula de identidad es:" + ci);
	}
	public void archivosCSV(String archivo) {
		try(PrintWriter writer = new PrintWriter(new FileWriter(archivo,true))){
			writer.println(nombreApellido + "," + ci);
			System.out.println("Su archivo se guardo" + archivo);
		}catch (IOException e) {
			System.out.println("Error al guardar el archivo" + e.getMessage());
		}
	}
}
