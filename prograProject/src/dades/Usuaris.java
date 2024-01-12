package dades;
public class Usuaris {

    String alies,correu;
    int codiPostal, tallersApuntats;
    
    public Usuaris(String alies,String correu,int codiPostal){
        this.alies = alies;
        this.correu = correu;
        this.codiPostal = codiPostal;
        tallersApuntats = 0;
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
    public void afegirApuntat(){
        tallersApuntats++;
    }
    public int getTallersapuntats(){
        return tallersApuntats;
    }

    public String toString(){
        return ("Alies: "+alies+"\nCorreu: "+correu+"\nCodi Postal: "+codiPostal+"\nTallers apuntats: "+tallersApuntats);
    }
}
