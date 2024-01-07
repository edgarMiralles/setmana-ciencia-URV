//Illya Kunakh

import java.time.LocalDate;

public class LlistaActivitats {
    
    protected Activitats[] llista;
    protected int numActivitats;
    
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
    
    public void afegirActivitat(Activitats activitat) {
        if (numActivitats < llista.length) {
            llista[numActivitats] = activitat.copia();
            numActivitats++;
        } else {
            System.out.println("No es pogen afegir mes activitats");
        }
    }
    
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

    public int getNumActivitats() {
        return numActivitats;
    }
    
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
    
    public void modificarActivitat(String codi, Activitats a) {
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
    
    public String mostraActivitats() {
        String llistaActivitats = "";
        for (int i = 0; i < numActivitats; i++) {
            llistaActivitats += llista[i].toString() + "\n";
        }
        return llistaActivitats;
    }

    public LocalDate getData (int posicio){
        return (llista[posicio].getData());
    }
    
    public Activitats getActivitat (int posicio){
        return (llista[posicio].copia());
    }

    public LlistaActivitats copia() {
        LlistaActivitats copia = new LlistaActivitats(this.llista.length);
        for (int i = 0; i < numActivitats; i++) {
            copia.afegirActivitat(llista[i]);
        }
        return copia;
    }
    

}
