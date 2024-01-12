package dades;
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
    public void afegirEntitat(String nom, String telefon, String correu){
        if (nElem < LlistaEntitats.length) {
            LlistaEntitats[nElem] = new Entitats(nom, telefon, correu);
            nElem++;
        }
    }

    public int getNumEntitats() {
        return nElem;
    }
    
    public String getNom(int pos) {
        if (pos < nElem) {
            return LlistaEntitats[pos].getNom();
        }
        return ("Posició fora del rang de la llista\n");
    }

    public String getTelefon(int pos) {
        if (pos < nElem) {
            return LlistaEntitats[pos].getTelefon();
        }
        return ("Posició fora del rang de la llista\n");
    }

    public String getCorreu(int pos) {
        if (pos < nElem) {
            return LlistaEntitats[pos].getCorreu();
        }
        return ("Posició fora del rang de la llista\n");
    }

    public Entitats getEntitat(int pos){
        return LlistaEntitats[pos].copia();
    }

    public void setNom(int pos, String nom){
        LlistaEntitats[pos].setNom(nom);
    }
    public void setCorreu(int pos, String Correu){
        LlistaEntitats[pos].setCorreu(Correu);
    }
    public void setTelefon(int pos, String Telefon){
        LlistaEntitats[pos].setTelefon(Telefon);
    } 

    public String toString() {
        String llistaEntitats = "";
        for (int i = 0; i < nElem; i++) {
            llistaEntitats += LlistaEntitats[i].toString() + "\n";
        }
        return llistaEntitats;
    }
    public LlistaEntitats llistaCopia(){
        LlistaEntitats llistaaux = new LlistaEntitats(nElem);
        for (int i = 0; i < nElem; i++) {
            llistaaux.afegirEntitat(LlistaEntitats[i].copia());
        }
        return llistaaux;

    }
}
