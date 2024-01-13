package dades;
//Illya Kunakh

import java.io.Serializable;
import java.time.LocalDate;

public class LlistaActivitats implements Serializable {
    
    private Activitats[] llista;
    private int numActivitats;
    
    /**
     * Constructor LlistaActivitats
     * @param n
     * Si n <= 0, llavors la llista tindra 10 posicions
     * Sino s'assigna el valor introduit per parametre
     */
    public LlistaActivitats(int n) {
        if (n <= 0) {
            llista = new Activitats[10];
            numActivitats = 0;
        }
        else {
            llista = new Activitats[n];
            numActivitats = 0;
        }
        
    }
    
    /**
     * Metode per afegir una activitat a la llista
     * @param activitat
     * @return 1 si s'ha afegit, 0 si no s'ha afegit
     */
    public int afegirActivitat(Activitats activitat) {
        if (numActivitats < llista.length) {
            llista[numActivitats] = activitat.copia();
            numActivitats++;
            return 1;//S'ha afegit
        } else {
            return 0;//No s'ha afegit
        }
    }
    
    /**
     * Metode per eliminar una activitat de la llista
     * @param codi
     */
    public void eliminarActivitat(String codi) {
        int pos = 0;
        boolean trobat = false;
        while (pos < numActivitats && !trobat) {
            if (llista[pos].getCodi() == codi) {
                trobat = true;
            } else {
                pos++;
            }
        }
        if (trobat) {
            for (int i = pos; i < numActivitats - 1; i++) {
                llista[i] = llista[i + 1];
            }
            numActivitats--;
        }
    }
    
    /**
     * Getter llista
     * @return llista
     */
    public Activitats[] getLlista() {
        return llista;
    }

    /**
     * Getter numActivitats
     * @return numActivitats
     */
    public int getNumActivitats() {
        return numActivitats;
    }

    /**
     * Cerca una activitat a partir del codi
     * @param codi
     * @return llista[pos] si trobat, null si no trobat
     */
    public Activitats cercarActivitat(String codi) {
        int pos = 0;
        boolean trobat = false;
        while (pos < numActivitats && !trobat) {
            if (llista[pos].getCodi().equalsIgnoreCase(codi)) {
                trobat = true;
            } else {
                pos++;
            }
        }
        if (trobat) {
            return llista[pos];
        } else {
            return null;
        }
    }
    
    /**
     * Modifica una activitat
     * @param codi
     * @param llista2
     */
    public void modificarActivitat(String codi, Activitats llista2) {
        int pos = 0;
        boolean trobat = false;
        while (pos < numActivitats && !trobat) {
            if (llista[pos].getCodi().equalsIgnoreCase(codi)) {
                trobat = true;
            } else {
                pos++;
            }
        }
        if (trobat) {
            llista[pos] = llista2;
        }
    }
    
    /**
     * toString
     */
    public String toString() {
        String llistaActivitats = "";
        for (int i = 0; i < numActivitats; i++) {
            llistaActivitats += llista[i].toString() + "\n\n";
            
        }
        return llistaActivitats;
    }

    /**
     * Getter data
     * @param posicio
     * @return llista[posicio].getData()
     */
    public LocalDate getData (int posicio){
        return (llista[posicio].getData());
    }
    
    /**
     * Getter activitat
     * @param posicio
     * @return llista[posicio].copia()
     */
    public Activitats getActivitat (int posicio){
        return (llista[posicio].copia());
    }

    /**
     * Metode copia
     * @return llistaActivitats
     */
    public LlistaActivitats copia() {
        LlistaActivitats copia = new LlistaActivitats(this.llista.length);
        for (int i = 0; i < numActivitats; i++) {
            copia.afegirActivitat(llista[i]);
        }
        return copia;
    }

    /**
     * Retorna les xerrades de la llistaActivitats
     * @return llistaXerrades
     */
    public LlistaActivitats llistaXerrades(){
        LlistaActivitats alpha = new LlistaActivitats(numActivitats);
        for (int i = 0; i < numActivitats; i++) {
            if (llista[i].copia() instanceof Xerrades) {
                alpha.afegirActivitat(llista[i].copia());
            }
        }
        return alpha;
    }
    /**
     * Retorna les xerrades de la llistaActivitats segons el nom de la persona
     * @param nom
     * @return llistaXerrades
     */
    public LlistaActivitats llistaXerradesPersona(String nom){
        LlistaActivitats alpha = new LlistaActivitats(numActivitats);
        for (int i = 0; i < numActivitats; i++) {
            if ((llista[i] instanceof Xerrades) && (llista[i].getNom().equalsIgnoreCase(nom))) {
                alpha.afegirActivitat(llista[i].copia());
            }
        }
        return alpha;
    }

    /**
     * Retorna les visites de la llistaActivitats segons la entitat i si es adaptat o no als cegos
     * @param entitat
     * @param adaptat
     * @return llistaVisitesEntitat
     */
    public LlistaActivitats llistaVisitesEntitat(String entitat,boolean adaptat){
        LlistaActivitats alpha = new LlistaActivitats(numActivitats);
        for (int i = 0; i < numActivitats; i++) {
            if ((llista[i] instanceof Visites) && (llista[i].getNomEntitat().equalsIgnoreCase(entitat))&&(((Visites)llista[i]).isAdaptatCegos() == adaptat)) {
                alpha.afegirActivitat(llista[i].copia());
            }
        }
        return alpha;
    }
   
    /**
     * Retorna les visites de la llistaActivitats 
     * @return llistaVisitesEntitat
     */
    public LlistaActivitats llistaVisites(){
        LlistaActivitats alpha = new LlistaActivitats(numActivitats);
        for (int i = 0; i < numActivitats; i++) {
            if (llista[i].copia() instanceof Visites) {
                alpha.afegirActivitat(llista[i].copia());
            }
        }
        return alpha;
    }

    /**
     * Retorna els tallers de la llistaActivitats
     * @return llistaTallers
     */
    public LlistaActivitats llistaTallers(){
        LlistaActivitats alpha = new LlistaActivitats(numActivitats);
        for (int i = 0; i < numActivitats; i++) {
            if (llista[i].copia() instanceof Tallers) {
                alpha.afegirActivitat(llista[i].copia());
            }
        }
        return alpha;
    }

    /**
     * Retorna les activitats realitzades en un dia
     * @param dia
     * @return llistaActivitats
     */
    public LlistaActivitats llistaDia(LocalDate dia){
        LlistaActivitats aux = new LlistaActivitats(numActivitats);
        for (int i = 0; i < numActivitats; i++) {
            if ((dia.compareTo(llista[i].getData())) == 0) {
                aux.afegirActivitat(llista[i].copia());
            }
        }
        return aux;
    }

    // Funcions per a Tallers

    public Tallers getTaller(String codi){
        for(int i = 0 ; i < numActivitats; i++){
            Tallers taller = (Tallers)llista[i].copia();
            if(taller.getCodi().equalsIgnoreCase(codi)){
                return taller;
            }
        }
        return null;
    }

    public Tallers getPTallers(int posicio){
        if (posicio < numActivitats) {
            return ((Tallers)llista[posicio].copia());
        }
        else{
            return null;
        }
    }

    //Comprovar si esta ben fet
    public void eliminarTaller(String codi){
        int pos = 0;
        boolean trobat = false;
        while (pos < numActivitats && !trobat) {
            if (llista[pos].getCodi().equalsIgnoreCase(codi)) {
                trobat = true;
            } else {
                pos++;
            }
        }
        if (trobat) {
            for (int i = pos; i < numActivitats - 1; i++) {
                llista[i] = llista[i + 1];
            }
            numActivitats--;
        }
    }

    public void modificarTaller(String codi, Tallers a) {
        int pos = 0;
        boolean trobat = false;
        while (pos < numActivitats && !trobat) {
            if (llista[pos].getCodi().equalsIgnoreCase(codi)) {
                trobat = true;
            } else {
                pos++;
            }
        }
        if (trobat) {
            llista[pos] = a;
        }
    }

    /**
     * Getter codi
     * @param posicio
     * @return llista[posicio].getCodi()
     */
    public String getCodiT(int posicio){
        return (llista[posicio].getCodi());
    }

    public Tallers getTallerExit(){
        Tallers tallerExit = null;
        Tallers aux;
        float max = 0;
        for (int i = 0; i < numActivitats; i++) {
            if(llista[i].copia() instanceof Tallers){
                aux = (Tallers)llista[i].copia();
                if (aux.getCapacitat() != 0) {
                    if ((aux.getPlacesOcupades()/aux.getCapacitat()) > max) {
                        max = (aux.getPlacesOcupades()/aux.getCapacitat());
                        tallerExit = (Tallers)aux.copia();
                    }
                }
            }
        }
        return tallerExit;
    }

    public LlistaActivitats llistaTallersDisponibles(LlistaReserves llistaReserves){
        LlistaActivitats llistaTallersDisponibles = new LlistaActivitats(numActivitats);
        for ( int i = 0; i < numActivitats; i++){
            String codi = llista[i].getCodi();
            if (llistaReserves.getPlacesOcupadesTaller(codi) < (((Tallers)llista[i]).getCapacitat())) {
                llistaTallersDisponibles.afegirActivitat((Tallers)llista[i].copia());
            }
        }
        return llistaTallersDisponibles;
    }

}
