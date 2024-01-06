//Kevin Sánchez Ramírez
public class LlistaReserves {
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
    
    public void afegirReserva(String usuari, String codi_taller, Tallers taller){
        if (nElem < LlistaReserva.length) {
            LlistaReserva[nElem] = new Reserves(usuari, codi_taller, taller);
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
    public LlistaReserves copiaLlista(){
        LlistaReserves aux = new LlistaReserves(nElem);
        for (int i = 0; i < nElem; i++) {
            aux.afegirReserva(LlistaReserva[i].getUsuari(), LlistaReserva[i].getCodi_taller(), LlistaReserva[i].getTaller());
        }
        return aux;
    }

}

