package dades;
//Illya Kunakh
import java.time.LocalDate;

public class Xerrades extends Activitats{
    
    private String nomPersona;
    
    /**
     * Constructor Xerrades
     * @param nom
     * @param lloc
     * @param codiPostal
     * @param data
     * @param nomEntitat
     * @param nomPersona
     */
    public Xerrades(String nom, String lloc, int codiPostal, LocalDate data, String nomEntitat, String nomPersona) {
        super(nom, lloc, codiPostal, data, nomEntitat); // Llama al constructor de Activitat
        this.nomPersona = nomPersona;
    }
    
    /**
     * Getter nomPersona
     * @return nomPersona
     */
    public String getNomPersona() {
        return nomPersona;
    }
    
    /**
     * Setter nomPersona
     * @param nomPersona
     */
    public void setNomPersona(String nomPersona) {
        this.nomPersona = nomPersona;
    }

    /**
     * Copia 
     * @return Xerrada
     */
    public Xerrades copia() {
        Xerrades x = new Xerrades(this.getNom(), this.getLloc(), this.getCodiPostal(), this.getData(), this.getNomEntitat(), this.getNomPersona());
        x.setCodi(this.getCodi());
        return x;
    }

    /**
     * toString
     * @return super + nomPersona
     */
    public String toString() {
        return super.toString() + ", NomPersona: " + nomPersona;
    }
    
}
