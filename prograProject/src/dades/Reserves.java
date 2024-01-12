package dades;
//Kevin Sánchez Ramírez
public class Reserves implements java.io.Serializable{
    private String usuari, codi_taller;
    private int satisfaccio, codi_reserva;
    public static int codiGeneral = 1;
    private Tallers taller;

    public Reserves (String usuari, Tallers taller){
            codi_reserva = codiGeneral;
            codi_taller = taller.getCodi();
            this.usuari = usuari;
            codiGeneral++;
            this.taller = taller;
            satisfaccio = -1;      //Indica que encara no s'avaluat
    }
    
    public Reserves copia(){         
        return (new Reserves(usuari, taller));
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }


    public int getCodi_reserva() {
        return codi_reserva;
    }

    public Tallers getTaller(){
        return taller;
    }

    public String getCodi_taller() {
        return codi_taller;
    }

    public int getSatisfaccio() {
        return satisfaccio;
    }

    public void setSatisfaccio(int valoracio) {
        if (valoracio >= 0 && valoracio <= 10) {
            satisfaccio = valoracio;
            taller.actualizarPuntuacion(valoracio);
        } else {
            System.out.println("La valoració ha d'estar en el rang de 0 a 10.");
        }
    }
    public String toString(){
        String aux;
            aux = "Usuari: "+usuari+" Codi Reserva: "+codi_reserva+" Taller: "+taller.getNom()+ " Satisfaccio: "+satisfaccio;
        return aux;
    }
    
}
