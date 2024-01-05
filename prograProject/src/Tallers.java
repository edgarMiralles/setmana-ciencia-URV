//Kevin Sánchez Ramírez
import java.time.LocalDate;

public class Tallers extends Activitats {
    private int durada,capacitat, puntuacio;
    private LlistaReserves reserves;

    public Tallers(String nom, String lloc, int codiPostal, LocalDate data, String nomEntitat, int durada, int capacitat){
        super(nom, lloc, codiPostal, data, nomEntitat);
        this.durada = durada;
        this.capacitat = capacitat;
        puntuacio = 0;
        reserves = new LlistaReserves(capacitat);
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

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }
    public void actualizarPuntuacion(int valoracio){
        puntuacio += valoracio;
    }
    public void afegirReserva(String usuari){
        reserves.afegirReserva(usuari, super.getCodi(), this);
    }
}
