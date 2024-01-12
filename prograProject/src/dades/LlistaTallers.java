/*package dades;
//Kevin Sánchez Ramírez
public class LlistaTallers extends LlistaActivitats{
    public LlistaTallers(int elements){
        super(elements);
    }

    public Tallers getTaller(String codi){
            for(int i=0; i<super.getNumActivitats(); i++){
                Tallers taller = (Tallers)super.getActivitat(i);
                if(taller.getCodi().equalsIgnoreCase(codi)){
                    return taller;
                }
            }
            return null;
    }

    public Tallers getPTallers(int posicio){
        if (posicio < super.getNumActivitats()) {
            return ((Tallers)super.getActivitat(posicio));
        }
        else{
            return null;
        }
    }
    public void afegirTaller(Tallers t){
        if (numActivitats < llista.length) {
            llista[numActivitats] = t.copia();
            numActivitats++;
        } else {
            System.out.println("No es poden afegir mes activitats");
        }
    }
    public LlistaTallers copia() {
        LlistaTallers copia = new LlistaTallers(numActivitats);
        for (int i = 0; i < numActivitats; i++) {
            copia.afegirTaller(getPTallers(i));
        }
        return copia;
    }
     public void eliminarTaller(String codi) {
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
    public String toString() {
        StringBuilder llistaTallers = new StringBuilder();
        for (int i = 0; i < numActivitats; i++) {
            llistaTallers.append(llista[i].toString()).append("\n\n");
        }
        return llistaTallers.toString();
    }
    public String getCodiT(int pos) {
        if (pos < numActivitats) {
            return llista[pos].getCodi();
        } else {
            return null;
        }
    }

    public Tallers getTallerExit(){
        Tallers tallerExit=null; //Taller amb més èxit d'ocupació
        Tallers aux;
        float max = 0; //Indica el percentatge d'ocupació en relació a la capacitat
        for (int i = 0; i < numActivitats; i++) {
            aux = (Tallers)llista[i];
            if ((aux.getCapacitat()/aux.getPlacesOcupades()) > max) {
                max = aux.getCapacitat()/aux.getPlacesOcupades();
                tallerExit = (Tallers)aux.copia();
            }
        }
        return tallerExit;
    }

    public LlistaTallers llistaTallersDisponibles(LlistaReserves llistaReserves){
        LlistaTallers llistaTallersDisponibles = new LlistaTallers(numActivitats);
        for ( int i = 0; i < numActivitats; i++){
            String codi = llista[i].getCodi();
            if (llistaReserves.getPlacesOcupadesTaller(codi) < (((Tallers)llista[i]).getCapacitat())) {
                llistaTallersDisponibles.afegirTaller((Tallers)llista[i].copia());
            }
        }
        return llistaTallersDisponibles;
    }
    
}*/
