//Iulian Sebastian Oprea --> iuliansebastian.oprea@estudiants.urv.cat
package dades;

/**
 * La classe LlistaUsuaris gestiona una llista d'usuaris i proporciona diverses
 * funcions per a manipular i obtenir informació sobre aquests usuaris.
 */

public class LlistaUsuaris {
    
    private int nElem = 0;
    private Usuaris[] LlistaUsuari;

    /**
     * Constructor de la classe LlistaUsuaris
     * @param mida La mida inicial de la llista d'usuaris.
     */
    
    public LlistaUsuaris(int mida){
        if ( mida > 0 ){
            LlistaUsuari = new Usuaris[mida];
            nElem = 0;
        }
    }
    
    /**
     * Afegir un usuari a la llista.
     * @param alpha L'usuari a afegir.
     */
    
    public void afegirUsuari(Usuaris alpha){
        if( nElem < LlistaUsuari.length){
            LlistaUsuari[nElem] = alpha.copia();
            nElem++;
        }
    }
    /**
     * Obté l'alies de l'usuari a la posició especificada de la llista.
     * @param pos La posició de l'usuari a la llista.
     * @return L'alies de l'usuari o un missatge d'error si la posició és incorrecta.
     */
    public String getAliesLlista(int pos){
        if ( pos < nElem) {
        return LlistaUsuari[pos].getAlies();
        }else{
            return ("Posicio Incorrecta");
        }
    } 

    /**
     * Obté el correu electrònic de l'usuari a la posició especificada de la llista.
     * @param pos La posició de l'usuari a la llista.
     * @return El correu electrònic de l'usuari o un missatge d'error si la posició és incorrecta.
     */
    
    public String getCorreuLlista(int pos){
        if ( pos < nElem) {
        return LlistaUsuari[pos].getCorreu();
        }else{
            return ("Posicio Incorrecta");
        }
    }

    /**
     * Obté el codi postal de l'usuari a la posició especificada de la llista.
     * @param pos La posició de l'usuari a la llista.
     * @return El codi postal de l'usuari o 0 si la posició és incorrecta.
     */

    public int getCodiPostalLlista(int pos ){
        if ( pos < nElem) {
        return LlistaUsuari[pos].getCodiPostal();
        }else{
            return 0;
        }
    }
     /**
     * Estableix un nou alies per a l'usuari a la posició especificada de la llista. 
     * @param pos   La posició de l'usuari a la llista.
     * @param alies El nou alies de l'usuari.
     */
    public void setAliesLlista(int pos,String alies){
        if ( pos < nElem){
            LlistaUsuari[pos].setAlies(alies);
        }
    }

    /**
     * Estableix un nou correu electrònic per a l'usuari a la posició especificada de la llista.
     * @param pos    La posició de l'usuari a la llista.
     * @param correu El nou correu electrònic de l'usuari.
     */
    public void setCorreuLlista(int pos,String correu){
        if ( pos < nElem){
            LlistaUsuari[pos].setCorreu(correu);
        }
    }
     /**
     * Estableix un nou codi postal per a l'usuari a la posició especificada de la
     * llista.
     * @param pos         La posició de l'usuari a la llista.
     * @param codiPostal El nou codi postal de l'usuari.
     */
    public void setCodiPostalLlista(int pos,int codiPostal){
        if ( pos < nElem){
            LlistaUsuari[pos].setCodiPostal(codiPostal);
        }
    }
     /**
     * Afegir un apuntat a un usuari a partir del seu alies.
     * 
     * @param nomUsuari L'alies de l'usuari.
     */
    public void afegirApuntat(String nomUsuari){
        for (int i = 0; i < nElem; i++) {
         if (LlistaUsuari[i].getAlies().equalsIgnoreCase(nomUsuari)) {
            LlistaUsuari[i].afegirApuntat();            
         }   
        }
    }
     /**
     * Obtenir el nombre de tallers als quals un usuari està apuntat a partir del seu alies.
     * @param nomUsuari L'alies de l'usuari.
     * @return El nombre de tallers als quals l'usuari està apuntat.
     */
    public int getNTallers(String nomUsuari){
        for (int i = 0; i < nElem; i++) {
            if (LlistaUsuari[i].getAlies().equalsIgnoreCase(nomUsuari)) {
               return (LlistaUsuari[i].getTallersapuntats());
            }
        }
        return 0;
    }
     /**
     * Obtenir el nombre d'usuaris a la llista.
     * @return El nombre d'usuaris a la llista.
     */
    public int getNumUsuaris(){
        return nElem;
    }
    /**
     * Obtenir un usuari a partir del seu alies. 
     * @param nomUsuari L'alies de l'usuari.
     * @return Una còpia de l'usuari o null si no es troba.
     */
    public Usuaris getUsuari(String nomUsuari){
        for (int i = 0; i < nElem; i++) {
            if (LlistaUsuari[i].getAlies().equalsIgnoreCase(nomUsuari)) {
                return LlistaUsuari[i].copia();
            }
        }
        return null;
    }
     /**
     * Obtenir una còpia de la llista d'usuaris.
     * @return Una nova instància de LlistaUsuaris amb la mateixa informació.
     */
    public LlistaUsuaris copiaLlista(){
        LlistaUsuaris aux = new LlistaUsuaris(nElem);
        for (int i = 0; i < nElem; i++) {
            aux.afegirUsuari(LlistaUsuari[i].copia());
        }
        return aux;
    }

    /**
     * Obtenir un usuari de la llista a partir de la seva posició.
     * @param pos La posició de l'usuari a la llista.
     * @return Una còpia de l'usuari o null si la posició és incorrecta.
     */ 
    
    public Usuaris getUsuari(int pos){
        if ( pos < nElem) {
            return LlistaUsuari[pos].copia();
        }else{
            return null;
        }
    }
    /**
     * Obtenir una llista d'usuaris que estan apuntats a algún taller.
     * @return Una nova instància de LlistaUsuaris amb els usuaris apuntats a tallers.
     */

    public LlistaUsuaris usuarisApuntatsTallers(){
        LlistaUsuaris aux = new LlistaUsuaris(nElem);
        for (int i = 0; i < nElem; i++) {
            if (LlistaUsuari[i].getTallersapuntats() > 0) {
                aux.afegirUsuari(LlistaUsuari[i].copia());
            }
        }
        return aux;
    }

     /**
     * Retorna una representació en cadena de la llista d'usuaris.
     * @return Una cadena que representa la llista d'usuaris.
     */
    
    public String toString(){
        String s = "";
        for (int i = 0; i < nElem; i++) {
            s += LlistaUsuari[i].toString() + "\n";
        }
        return s;
    }

}
