package dades;

/**
 * La classe Usuaris representa els usuaris que poden participar en tallers.
 */
public class Usuaris {

    String alies, correu;
    int codiPostal, tallersApuntats;

    /**
     * Constructor de la classe Usuaris.
     * 
     * @param alies      L'alies de l'usuari.
     * @param correu     El correu electrònic de l'usuari.
     * @param codiPostal El codi postal de l'usuari.
     */
    public Usuaris(String alies, String correu, int codiPostal) {
        this.alies = alies;
        this.correu = correu;
        this.codiPostal = codiPostal;
        tallersApuntats = 0;
    }

    /**
     * Obté l'alies de l'usuari.
     * @return L'alies de l'usuari.
     */
    public String getAlies() {
        return alies;
    }

    /**
     * Obté el correu electrònic de l'usuari.
     * @return El correu electrònic de l'usuari.
     */
    public String getCorreu() {
        return correu;
    }

    /**
     * Obté el codi postal de l'usuari.
     * @return El codi postal de l'usuari.
     */
    public int getCodiPostal() {
        return codiPostal;
    }

    /**
     * Estableix un nou alies per l'usuari.
     * @param alies El nou alies de l'usuari.
     */
    public void setAlies(String alies) {
        this.alies = alies;
    }

    /**
     * Estableix un nou correu electrònic per l'usuari.
     * @param correu El nou correu electrònic de l'usuari.
     */
    public void setCorreu(String correu) {
        this.correu = correu;
    }

    /**
     * Estableix un nou codi postal per l'usuari.
     * 
     * @param codiPostal El nou codi postal de l'usuari.
     */
    public void setCodiPostal(int codiPostal) {
        this.codiPostal = codiPostal;
    }

    /**
     * Crea una còpia de l'usuari.
     * @return Una còpia de l'usuari.
     */
    public Usuaris copia() {
        return (new Usuaris(alies, correu, codiPostal));
    }

    /**
     * Incrementa el nombre de tallers als quals l'usuari està apuntat.
     */
    public void afegirApuntat() {
        tallersApuntats++;
    }

    /**
     * Obté el nombre de tallers als quals l'usuari està apuntat.
     * @return El nombre de tallers als quals l'usuari està apuntat.
     */
    public int getTallersapuntats() {
        return tallersApuntats;
    }

    /**
     * Retorna una representació en cadena de l'objecte Usuaris.
     * @return Una cadena que representa l'objecte Usuaris.
     */
    public String toString() {
        return ("Alies: " + alies + "\nCorreu: " + correu + "\nCodi Postal: " + codiPostal + "\nTallers apuntats: "+ tallersApuntats);
    }
}
