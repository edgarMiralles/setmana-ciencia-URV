package dades;
//Kevin Sánchez Ramírez
import java.time.LocalDate;

public class Tallers extends Activitats {
    private int durada,capacitat, puntuacio, n_votants;
    private LlistaReserves reserves;


    public Tallers(String nom, String lloc, int codiPostal, LocalDate data, String nomEntitat, int durada, int capacitat){
        super(nom, lloc, codiPostal, data, nomEntitat);
        this.durada = durada;
        this.capacitat = capacitat;
        puntuacio = 0;
        reserves = new LlistaReserves(capacitat);
        n_votants = 0;
    }
    public int getPuntuacio(){
        return (puntuacio/n_votants);   //Mitjana de puntuacio del taller
    }
    public int getDurada(){
        return durada;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public int getPlaces_disponibles() {
        return (capacitat - (reserves.getPlacesOcupades()));
    }

    public int getPlacesOcupades(){
        return reserves.getPlacesOcupades();
    }
    public void setDurada(int durada) {
        this.durada = durada;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }
    public void actualizarPuntuacion(int valoracio){
        puntuacio += valoracio;
        n_votants++;
    }
    public void afegirReserva(String usuari){
        reserves.afegirReserva(usuari, super.getCodi(), this);
    }
    public Tallers getTaller(String codiTaller){
        if (codiTaller.equalsIgnoreCase(super.getCodi())) {
            return this;
        }else return null;   
    }
    public Tallers copia() {
        return new Tallers(nom, lloc, codiPostal, data, nomEntitat, durada, capacitat);
    }
    
    public String toString() {
        return "Nom: " + nom +" Lloc: " + lloc +" Codi Postal: " + codiPostal +" Data: " + data +" Nom Entitat: " + nomEntitat +" Durada: " + durada +" Capacitat: " + capacitat +" Puntuacio: " + puntuacio +" Codi Taller: "+codi+"\nReserves:\n" + reserves;
    }
}
