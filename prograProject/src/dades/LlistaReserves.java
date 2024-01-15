//Kevin Sánchez Ramírez

package dades;
import java.io.Serializable;

public class LlistaReserves implements Serializable{
    private int nElem;
    private Reserves[] LlistaReserva;

    public LlistaReserves(int num){
        if (num > 0) {
            LlistaReserva = new Reserves[num];
            nElem = 0;
        }else{
            System.out.println("Llongitud de llista incorrecta");
        }
    }
    
    public void afegirReserva(Reserves r){
        if (nElem < LlistaReserva.length) {
            LlistaReserva[nElem] = r.copia();
            nElem++;
        }
    }
    public void afegirReserva(String usuari, String codi_taller, Tallers taller){
        if (nElem < LlistaReserva.length) {
            LlistaReserva[nElem] = new Reserves(usuari, taller);
            nElem++;
        }
    }
    public int getCodiReserva (int pos){
        if(pos < nElem){
            return LlistaReserva[pos].getCodi_reserva();
        }
        return 0;
    }
    public int getPlacesOcupades (){
            return nElem;
    }
    public String getUsuari (int pos){
        if(pos < nElem){
            return LlistaReserva[pos].getUsuari();
        }
        return ("Posicion incorrecta");
    }
    public String getCodiTaller(int pos){
        if(pos < nElem){
            return LlistaReserva[pos].getCodi_taller();
        }
        return ("Posició fora del rang de la llista\n");
    }
    public int getSatisfaccio(int pos){
        if(pos < nElem){
            return LlistaReserva[pos].getSatisfaccio();
        }
        return 0;
    }
    public void setUsuari(int pos,String usuari){
        LlistaReserva[pos].setUsuari(usuari);
    }

    public void setSatisfaccio(int pos,int satisfaccio){
        LlistaReserva[pos].setSatisfaccio(satisfaccio);
    }

    public void setSatisfaccio(String nomUsuari,int satisfaccio,String codiTaller){
        for (int i = 0; i < nElem; i++) {
            if (LlistaReserva[i].getUsuari().equalsIgnoreCase(nomUsuari) && LlistaReserva[i].getCodi_taller().equalsIgnoreCase(codiTaller)) {
                LlistaReserva[i].setSatisfaccio(satisfaccio);
            }
        }
    }
    public Reserves getReserves(String usuari){
        for (int i = 0; i < nElem; i++) {
            if (LlistaReserva[i].getUsuari().equalsIgnoreCase(usuari)) {
                return LlistaReserva[i];
            }
        }
        return null;
    }
    public LlistaReserves copiaLlista(){
        LlistaReserves aux = new LlistaReserves(nElem);
        for (int i = 0; i < nElem; i++) {
            aux.afegirReserva(LlistaReserva[i].copia());
        }
        return aux;
    }
    public String toString(){
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < nElem; i++) {
        s.append(LlistaReserva[i].toString()).append("\n");
    }
    return s.toString();
    }

    public Reserves getReserves(int pos) {
        if(pos < nElem){
            return LlistaReserva[pos].copia();
        }
        return null;
    }

    public int getPlacesOcupadesTaller(String codi){
        int places = 0;
        for (int i = 0; i < nElem; i++) {
            if(LlistaReserva[i].getCodi_taller().equals(codi)){
                places++;
            }
        }
        return places;
    }
    
    /*public String[] nomUsuariReserva(){
        String[] noms = new String[nElem];
        for (int i = 0; i < nElem; i++) {
            if (!repetit(LlistaReserva[i].getUsuari(),i)) {
                noms[i] = LlistaReserva[i].getUsuari();
            }
        }
        return noms;
    }

    private boolean repetit(String nom,int pos){
        for (int i = 0; i < pos; i++) {
            if (LlistaReserva[i].getUsuari().equalsIgnoreCase(nom)){
                return true;
            }
        }
        return false;
    }*/

}

