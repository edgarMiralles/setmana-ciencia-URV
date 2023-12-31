//Illya Kunakh
import java.time.LocalDate;

public class Visites extends Activitats{
    
    private String tipusEdifici;
    private String serveis;
    private boolean adaptatCegos;

    public Visites(String nom, String lloc, int codiPostal, LocalDate data, String nomEntitat, String tipusEdifici, String serveis, boolean adaptatCegos) {
        super(nom, lloc, codiPostal, data, nomEntitat);
        this.tipusEdifici = tipusEdifici;
        this.serveis = serveis;
        this.adaptatCegos = adaptatCegos;
    }

    public String getTipusEdifici() {
        return tipusEdifici;
    }

    public String getServeis() {
        return serveis;
    }

    public boolean isAdaptatCegos() {
        return adaptatCegos;
    }

    public void setTipusEdifici(String tipusEdifici) {
        this.tipusEdifici = tipusEdifici;
    }

    public void setServeis(String serveis) {
        this.serveis = serveis;
    }

    public void setAdaptatCegos(boolean adaptatCegos) {
        this.adaptatCegos = adaptatCegos;
    }

    public String toString() {
        return super.toString() + ", Tipus Edifici: " + tipusEdifici + ", Serveis: " + serveis + ", Adaptat Cegos: " + adaptatCegos;
    }
}
