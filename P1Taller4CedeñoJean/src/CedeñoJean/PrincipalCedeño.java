package CedeñoJean;
public class PrincipalCedeño {
    public static void main(String[] args) {
        EstudianteCedeño student = new EstudianteCedeño("", "", "", "", "", 0, 0, 0);
        ProfesoresCedeño teacher = new ProfesoresCedeño("", "", "", "", "", 0, 0, 0);

        System.out.println("Datos del Estudiante");
        student.getDataPeople();
        student.getDataStudents();
        student.printData();
        student.guardarEstudianteEnCSV("estudiantes.csv"); // Guardar estudiante en CSV
        student.guardarEstudianteEnJSON("estudiantes.json"); // Guardar estudiante en JSON

        System.out.println("Datos del Profesor");
        teacher.getDataPeople();
        teacher.getDataTeacher();
        teacher.printData();
        teacher.guardarProfesorEnCSV("profesores.csv"); // Guardar profesor en CSV
        teacher.guardarProfesorEnJSON("profesores.json"); // Guardar profesor en JSON
    }
}