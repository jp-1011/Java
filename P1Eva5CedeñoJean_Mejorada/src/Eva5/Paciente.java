package Eva5;
import java.io.*;
import java.io.PrintWriter;
public class Paciente extends Personal{
	public String diag;
	public Paciente(String nombreApellido, String ci, String diag) {
		super(nombreApellido,ci);
		this.diag = diag;
	}
	public void diagnostico() {
		System.out.println("El diagnostico del paciente es:");
		diag = cin.nextLine();
	}
	public void archivoDiag(String archivo) {
		try(PrintWriter writer = new PrintWriter(new FileWriter(archivo,true))){
			writer.println(diag);
			System.out.println("Su archivo se guardo" + archivo);
		}catch (IOException e) {
			System.out.println("Error al guardar el archivo" + e.getMessage());
		}
	}
}
