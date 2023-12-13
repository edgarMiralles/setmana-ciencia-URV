public class LlistaReserves {
    private int nElem;
    private Reserves[] LlistaReserva;

    public LlistaReserves(int num){
        if (num > 0) {
            LlistaReserva = new Reserves[num];
            nElem = 0;
        }
    }
    
    public void afegirReserva(Reserves reserva){
        if (nElem < LlistaReserva.length) {
            LlistaReserva[nElem] = reserva.copia();
            nElem++;
        }
    }
    public int getCodiReserva (int pos){
        if(pos < nElem){
            return LlistaReserva[pos].getCodi_reserva();
        }
        return 0;
    }
    public int getPlacesOcupades (int pos){
        if(pos < nElem){
            return LlistaReserva[pos].getPlaces_ocupades();
        }
        return 0;
    }
    public String getUsuari (int pos){
        if(pos < nElem){
            return LlistaReserva[pos].getUsuari();
        }
        return ("Posicion incorrecta");
    }
    public int getCodiTaller(int pos){
        if(pos < nElem){
            return LlistaReserva[pos].getCodi_taller();
        }
        return 0;
    }
    public int getSatisfaccio(int pos){
        if(pos < nElem){
            return LlistaReserva[pos].getSatisfaccio();
        }
        return 0;
    }
    public void setPlaces_ocupades(int pos,int places){
        LlistaReserva[pos].setPlaces_ocupades(places);
    }
    public void setCodiReserva(int pos,int codi){
        LlistaReserva[pos].setCodi_reserva(codi);
    }
    public void setUsuari(int pos,String usuari){
        LlistaReserva[pos].setUsuari(usuari);
    }
    public void setCodiTaller(int pos,int codi){
        LlistaReserva[pos].setCodi_taller(codi);
    }
    public void setSatisfaccio(int pos,int satisfaccio){
        LlistaReserva[pos].setSatisfaccio(satisfaccio);
    }
    public LlistaReserves copiaLlista(){
        LlistaReserves aux = new LlistaReserves(nElem);
        for (int i = 0; i < nElem; i++) {
            aux.afegirReserva(LlistaReserva[i].copia());
        }
        return aux;
    }

}

