package dades;
//Illya Kunakh
import java.time.LocalDate;

public class Visites extends Activitats{
    
    private String tipusEdifici;
    private String serveis;
    private boolean adaptatCegos;

    /**
     * Constructor Visites
     * @param nom
     * @param lloc
     * @param codiPostal
     * @param data
     * @param nomEntitat
     * @param tipusEdifici
     * @param serveis
     * @param adaptatCegos
     */
    public Visites(String nom, String lloc, int codiPostal, LocalDate data, String nomEntitat, String tipusEdifici, String serveis, boolean adaptatCegos) {
        super(nom, lloc, codiPostal, data, nomEntitat);
        this.tipusEdifici = tipusEdifici;
        this.serveis = serveis;
        this.adaptatCegos = adaptatCegos;
    }

    /**
     * Getter tipusEdifici
     * @return tipusEdifici
     */
    public String getTipusEdifici() {
        return tipusEdifici;
    }

    /**
     * Getter serveis
     * @return serveis
     */
    public String getServeis() {
        return serveis;
    }

    /**
     * Getter adaptatCegos
     * @return adaptatCegos 
     */
    public boolean isAdaptatCegos() {
        return adaptatCegos;
    }

    /**
     * Setter tipusEdifici
     * @param tipusEdifici
     */
    public void setTipusEdifici(String tipusEdifici) {
        this.tipusEdifici = tipusEdifici;
    }

    /**
     * Setter serveis
     * @param serveis
     */
    public void setServeis(String serveis) {
        this.serveis = serveis;
    }

    /**
     * Setter adaptatCegos
     * @param adaptatCegos
     */
    public void setAdaptatCegos(boolean adaptatCegos) {
        this.adaptatCegos = adaptatCegos;
    }

    /**
     * Copia 
     * @return Visita
     */
    public Visites copia() {
        Visites v = new Visites(this.getNom(), this.getLloc(), this.getCodiPostal(), this.getData(), this.getNomEntitat(), this.tipusEdifici, this.serveis, this.adaptatCegos);
        v.setCodi(this.getCodi());
        return v;
    }

    /**
     * toString
     * @return super + tipusEdifici, serveis, adaptatCegos
     */
    public String toString() {
        return super.toString() + ", Tipus Edifici: " + tipusEdifici + ", Serveis: " + serveis + ", Adaptat Cegos: " + adaptatCegos;
    }
}
