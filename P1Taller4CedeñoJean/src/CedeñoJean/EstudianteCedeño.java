package CedeñoJean;
import java.io.*;     
public class EstudianteCedeño extends PersonaCedeño {
	private String career;
	private double note1, note2, prom;
	public EstudianteCedeño(String name, String lastname, String dni, String date, String career, double note1,double note2, double prom) {
		super(name, lastname, dni, date);
		this.career = career;
		this.note1 = note1;
		this.note2 = note2;
		this.prom = prom;
	}
	public void getDataStudents() {
		System.out.println("Ingresa la carrera: ");
		career = scanner.nextLine();
		System.out.println("Ingresa la nota 1: ");
		note1 = scanner.nextDouble();
		System.out.println("Ingresa la nota 2: ");
		note2 = scanner.nextDouble();
		prom = (note1 + note2) / 2;
		System.out.println("El estudiante que estudia la carrera de " + career + " ha logrado un promedio de: " + prom);
	}
	public void guardarEstudianteEnCSV(String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, true))) {
            writer.println(name + "," + lastname + "," + dni + "," + date + "," + career + "," + note1 + "," + note2 + "," + prom);
            System.out.println("Estudiante guardado en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el estudiante en CSV: " + e.getMessage());
        }
    }
    public void guardarEstudianteEnJSON(String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, true))) {
            writer.println("{");
            writer.println("  \"nombre\": \"" + name + "\",");
            writer.println("  \"apellido\": \"" + lastname + "\",");
            writer.println("  \"dni\": \"" + dni + "\",");
            writer.println("  \"fecha_nacimiento\": \"" + date + "\",");
            writer.println("  \"carrera\": \"" + career + "\",");
            writer.println("  \"nota1\": " + note1 + ",");
            writer.println("  \"nota2\": " + note2 + ",");
            writer.println("  \"promedio\": " + prom);
            writer.println("}");
            System.out.println("Estudiante guardado en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el estudiante en JSON: " + e.getMessage());
        }
    }
}

