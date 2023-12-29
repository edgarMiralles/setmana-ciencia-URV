import java.util.Date;

public class Tallers extends Activitats {
    private int durada,capacitat, puntuacio, Nvotants;

    public Tallers(int codi, String nom, String lloc, int codiPostal, Date data, String nomEntitat, int durada, int capacitat){
        super(nom, lloc, codiPostal, data, nomEntitat);
        this.durada = durada;
        this.capacitat = capacitat;
        puntuacio = 0;
        Nvotants = 0;
    }

    public int getPuntuacio(){
        return puntuacio;
    }

    public int getDurada(){
        return durada;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public int getNvotants() {
        return Nvotants;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public void setNvotants(int nvotants) {
        Nvotants = nvotants;
    }
}
