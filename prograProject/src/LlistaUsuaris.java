public class LlistaUsuaris {
    
    private int nElem = 0;
    private Usuaris[] LlistaUsuari;

    public LlistaUsuaris(int mida){
        if ( mida > 0 ){
            LlistaUsuari = new Usuaris[mida];
            nElem = 0;
        }
    }

    public void afegirUsuari(Usuaris alpha){
        if( nElem < LlistaUsuari.length){
            LlistaUsuari[nElem] = alpha.copia();
            nElem++;
        }
    }

    public String getAliesLlista(int pos){
        if ( pos < nElem) {
        return LlistaUsuari[pos].getAlies();
        }else{
            return ("Posicio Incorrecta");
        }
    } 

    public String getCorreuLlista(int pos){
        if ( pos < nElem) {
        return LlistaUsuari[pos].getCorreu();
        }else{
            return ("Posicio Incorrecta");
        }
    }

    public int getCodiPostalLlista(int pos ){
        if ( pos < nElem) {
        return LlistaUsuari[pos].getCodiPostal();
        }else{
            return 0;
        }
    }

    public void setAliesLlista(int pos,String alies){
        if ( pos < nElem){
            LlistaUsuari[pos].setAlies(alies);
        }
    }

    public void setCorreuLlista(int pos,String correu){
        if ( pos < nElem){
            LlistaUsuari[pos].setCorreu(correu);
        }
    }

    public void setCodiPostalllista(int pos,int codiPostal){
        if ( pos < nElem){
            LlistaUsuari[pos].setCodiPostal(codiPostal);
        }
    }
    public void afegirApuntat(String nomUsuari){
        for (int i = 0; i < nElem; i++) {
         if (LlistaUsuari[i].getAlies().equalsIgnoreCase(nomUsuari)) {
            LlistaUsuari[i].afegirApuntat();            
         }   
        }
    }
    public int getNTallers(String nomUsuari){
        for (int i = 0; i < nElem; i++) {
            if (LlistaUsuari[i].getAlies().equalsIgnoreCase(nomUsuari)) {
               return (LlistaUsuari[i].getTallersapuntats());
            }
        }
        return 0;
    }
    public int getNumUsuaris(){
        return nElem;
    }
    public Usuaris getUsuari(String nomUsuari){
        for (int i = 0; i < nElem; i++) {
            if (LlistaUsuari[i].getAlies().equalsIgnoreCase(nomUsuari)) {
                return LlistaUsuari[i].copia();
            }
        }
        return null;
    }
    public LlistaUsuaris copiaLlista(){
        LlistaUsuaris aux = new LlistaUsuaris(nElem);
        for (int i = 0; i < nElem; i++) {
            aux.afegirUsuari(LlistaUsuari[i].copia());
        }
        return aux;
    }

}
