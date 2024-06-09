package Eva5;
import java.io.*;
public class Doctor extends Personal{
	private double valorh;
	private int canth;
	private int codigo;
	private double prom;
	private int cantip;
	public Doctor(String nombreApellido, String ci, double valorh, 
			int canth,int cantip,int codigo, double prom) {
		super(nombreApellido,ci);
		this.valorh = valorh;
		this.canth = canth;
		this.codigo = codigo;
		this.prom = prom;
		this.cantip = cantip;
	}
	public void datosDoc() {
		System.out.println("Ingresar su codigo");
		codigo = cin.nextInt();
		System.out.println("Ingresar el valor por horas");
		valorh = cin.nextDouble();
		System.out.println("Ingresar la cantidad de horas");
		canth = cin.nextInt();
		System.out.println("Ingresar la cantidad de pacientes");
		cantip = cin.nextInt();
	}
	public void calSaldo() {
		prom = (valorh*canth);
		System.out.println("Su sueldo es:" + prom);
	}
	public void archivoDoc(String archivo) {
		try(PrintWriter writer = new PrintWriter(new FileWriter(archivo,true))){
			writer.println(codigo + "," + valorh + "," + canth + "," + cantip + "," + prom);
			System.out.println("Su archivo se guardo" + archivo);
		}catch (IOException e) {
			System.out.println("Error al guardar el archivo" + e.getMessage());
		}
	}

}
