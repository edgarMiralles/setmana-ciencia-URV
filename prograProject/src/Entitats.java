//Illya Kunakh
public class Entitats {

    private String nom;
    private String telefon;
    private String correu;

    public Entitats(String nom, String telefon, String correu) {
        this.nom = nom;
        this.telefon = telefon;
        this.correu = correu;
    }

    public String getNom() {
        return nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getCorreu() {
        return correu;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    @Override
    public String toString() {
        return "Entitat{" + "nom=" + nom + ", telefon=" + telefon + ", correu=" + correu + '}';
    }
    
}