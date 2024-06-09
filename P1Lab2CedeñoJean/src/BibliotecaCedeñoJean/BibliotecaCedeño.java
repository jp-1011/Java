package BibliotecaCedeñoJean;
public class BibliotecaCedeño {
    // Atributos
    private String nombreLibro;
    private String editorialLibro;
    private int añoLibro;
    private String autorLibro;
    private boolean disponible;
    // Constructor
    public BibliotecaCedeño(String nombreLibro, String editorialLibro, int añoLibro, String autorLibro, boolean disponible) {
        this.nombreLibro = nombreLibro;
        this.editorialLibro = editorialLibro;
        this.añoLibro = añoLibro;
        this.autorLibro = autorLibro;
        this.disponible = disponible;
    }
    // Getters y Setters
    public String getNombreLibro() {
        return nombreLibro;
    }
    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }
    public String getEditorialLibro() {
        return editorialLibro;
    }
    public void setEditorialLibro(String editorialLibro) {
        this.editorialLibro = editorialLibro;
    }
    public int getAñoLibro() {
        return añoLibro;
    }
    public void setAñoLibro(int añoLibro) {
        this.añoLibro = añoLibro;
    }
    public String getAutorLibro() {
        return autorLibro;
    }
    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    @Override
    public String toString() {
        return "BibliotecaCedeño [nombreLibro=" + nombreLibro + ", editorialLibro=" + editorialLibro + ", añoLibro=" + añoLibro
                + ", autorLibro=" + autorLibro + ", disponible=" + disponible + "]";
    }
}