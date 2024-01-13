package dades;
//Illya Kunakh
public class Entitats {

    private String nom;
    private String telefon;
    private String correu;

    /**
     * Constructor Entitats
     * @param nom
     * @param telefon
     * @param correu
     */
    public Entitats(String nom, String telefon, String correu) {
        this.nom = nom;
        this.telefon = telefon;
        this.correu = correu;
    }

    /**
     * Getter nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter telefon
     * @return telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Getter correu
     * @return correu
     */
    public String getCorreu() {
        return correu;
    }

    /**
     * Setter nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Setter telefon
     * @param telefon
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * Setter correu
     * @param correu
     */
    public void setCorreu(String correu) {
        this.correu = correu;
    }

    /**
     * toString 
     * @return super + nom, telefon, correu
     */
    public String toString() {
        return "Entitat{" + "nom=" + nom + ", telefon=" + telefon + ", correu=" + correu + '}';
    }

    /**
     * Copia Entitats
     * @return new Entitats(nom, telefon, correu)
     */
    public Entitats copia() {
        return new Entitats(nom, telefon, correu);
    }
    
}