import java.util.Date;

public class Xerrades extends Activitats{
    
    private String nomPersona;
    
    public Xerrades(int codi, String nom, String lloc, int codiPostal, Date data, String nomEntitat, String nomPersona) {
        super(codi, nomPersona, nomPersona, codi, data, nomPersona); // Llama al constructor de Activitat
        this.nomPersona = nomPersona;
    }
    
    public String getNomPersona() {
        return nomPersona;
    }
    
    public void setNomPersona(String nomPersona) {
        this.nomPersona = nomPersona;
    }
    
    public String toString() {
        return "Xerrada{" + "nomPersona=" + nomPersona + '}';
    }
}
