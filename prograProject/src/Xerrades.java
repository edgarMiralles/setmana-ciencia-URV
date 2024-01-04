//Illya Kunakh
import java.time.LocalDate;

public class Xerrades extends Activitats{
    
    private String nomPersona;
    
    public Xerrades(String nom, String lloc, int codiPostal, LocalDate data, String nomEntitat, String nomPersona) {
        super(nom, lloc, codiPostal, data, nomEntitat); // Llama al constructor de Activitat
        this.nomPersona = nomPersona;
    }
    
    public String getNomPersona() {
        return nomPersona;
    }
    
    public void setNomPersona(String nomPersona) {
        this.nomPersona = nomPersona;
    }

    public String toString() {
        return super.toString() + ", NomPersona: " + nomPersona;
    }
    
}
