public class Usuaris {

    String alies,correu;
    int codiPostal;
    
    public Usuaris(String alies,String correu,int codiPostal){
        this.alies = alies;
        this.correu = correu;
        this.codiPostal = codiPostal;
    }

    public String getAlies() {
        return alies;
    }

    public String getCorreu() {
        return correu;
    }

    public int getCodiPostal(){
        return codiPostal;
    }

    public void setAlies(String alies){
        this.alies = alies;
    }

    public void setCorreu(String correu){
        this.correu = correu;
    }

    public void setCodiPostal( int codiPostal){
        this.codiPostal = codiPostal;
    }

    public Usuaris copia(){
        return (new Usuaris(alies, correu, codiPostal));
    }

}
