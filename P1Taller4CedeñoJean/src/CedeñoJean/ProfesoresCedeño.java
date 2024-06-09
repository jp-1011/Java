package CedeñoJean;
import java.io.*;
public class ProfesoresCedeño extends PersonaCedeño {
	private String job;
	private int hours;
	private double priceHours, salary;
	public ProfesoresCedeño(String name, String lastname, String dni, String date, String job, int hours,
			double priceHours, double salary) {
		super(name, lastname, dni, date);
		this.job = job;
		this.hours = hours;
		this.priceHours = priceHours;
		this.salary = salary;
	}
	public void getDataTeacher() {
		System.out.println("Ingresa la especialidad: ");
		job = scanner.nextLine();
		System.out.println("Ingresa la horas de trabajo: ");
		hours = scanner.nextInt();
		System.out.println("Ingresa el valor de la horas de trabajo: ");
		priceHours = scanner.nextDouble();
		salary = hours * priceHours;
		System.out.println("La especialidad es: " + job);
		System.out.println("El salario es: " + salary);
	}
	public void guardarProfesorEnCSV(String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, true))) {
            writer.println(name + "," + lastname + "," + dni + "," + date + "," + job + "," + hours + "," + priceHours + "," + salary);
            System.out.println("Profesor guardado en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el profesor en CSV: " + e.getMessage());
        }
    }
    public void guardarProfesorEnJSON(String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, true))) {
            writer.println("{");
            writer.println("  \"nombre\": \"" + name + "\",");
            writer.println("  \"apellido\": \"" + lastname + "\",");
            writer.println("  \"dni\": \"" + dni + "\",");
            writer.println("  \"fecha_nacimiento\": \"" + date + "\",");
            writer.println("  \"especialidad\": \"" + job + "\",");
            writer.println("  \"horas_trabajo\": " + hours + ",");
            writer.println("  \"precio_hora\": " + priceHours + ",");
            writer.println("  \"salario\": " + salary);
            writer.println("}");
            System.out.println("Profesor guardado en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el profesor en JSON: " + e.getMessage());
        }
    }
}