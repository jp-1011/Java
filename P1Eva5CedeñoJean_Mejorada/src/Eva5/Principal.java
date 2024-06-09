package Eva5;
public class Principal {
	public static void main(String[] args) {
		Paciente paci = new Paciente (" ", " "," ");
		Doctor doc = new Doctor (" ", " ",0,0,0,0,0);
		System.out.println("Datos Doctor");
		doc.ingresarDatos();
		doc.mostrarDatos();
		doc.archivosCSV ("archivo.csv");
		doc.datosDoc();
		doc.calSaldo();
		doc.archivoDoc("archivo.csv");
		System.out.println("Datos Paciente");
		paci.ingresarDatos();
		paci.mostrarDatos();
		paci.archivosCSV ("archivo.csv");
		paci.diagnostico();
		paci.archivoDiag("archivo.csv");

	}

}
