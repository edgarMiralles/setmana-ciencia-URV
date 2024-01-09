public class LlistaEntitats {
   
    private int nElem;
    private Entitats[] LlistaEntitats;

    public LlistaEntitats(int num) {
        LlistaEntitats = new Entitats[num];
        nElem = 0;
    }

    public void afegirEntitat(Entitats e) {
        if (nElem < LlistaEntitats.length) {
            LlistaEntitats[nElem] = e.copia();
            nElem++;
        }
    }

    public int getNumEntitats() {
        return nElem;
    }
    
    public String toString() {
        String llistaEntitats = "";
        for (int i = 0; i < nElem; i++) {
            llistaEntitats += LlistaEntitats[i].toString() + "\n";
        }
        return llistaEntitats;
    }
}
