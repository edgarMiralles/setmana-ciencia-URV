public class LlistaActivitats {
    
    private Activitats[] llista;
    private int numActivitats;
    
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
        llista[numActivitats] = activitat;
        numActivitats++;
    }
    
    public void eliminarActivitat(int codi) {
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
    
    public Activitats cercarActivitat(int codi) {
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
            return llista[pos];
        } else {
            return null;
        }
    }
    
    public void modificarActivitat(int codi, Activitats a) {
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
    

}
