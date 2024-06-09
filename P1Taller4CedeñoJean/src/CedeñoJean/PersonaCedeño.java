package CedeñoJean;
import java.util.Scanner;
public class PersonaCedeño {
    protected String name, lastname, dni, date;
    protected Scanner scanner = new Scanner(System.in);
    public PersonaCedeño(String name, String lastname, String dni, String date) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.date = date;
    }
    public void getDataPeople() {
        System.out.println("Ingresa el nombre: ");
        name = scanner.nextLine();
        System.out.println("Ingresa el apellido: ");
        lastname = scanner.nextLine();
        System.out.println("Ingresa cedula: ");
        dni = scanner.nextLine();
        System.out.println("Ingresa fecha de nacimiento: ");
        date = scanner.nextLine();
    }
    public void printData() {
        System.out.println("Nombre: " + name);
        System.out.println("Apellido: " + lastname);
        System.out.println("Cedula: " + dni);
        System.out.println("Fecha de nacimiento: " + date);
    }
}