//Kevin Sánchez Ramírez
public class Reserves {
    private String usuari, codi_taller;
    private int satisfaccio, codi_reserva;
    public static int codiGeneral = 1;
    private Tallers taller;

    public Reserves (String usuari, String c_taller, Tallers taller){
            codi_reserva = codiGeneral;
            codi_taller = c_taller;
            this.usuari = usuari;
            codiGeneral++;
            this.taller = taller;
    }
    
    public Reserves copia(){         
        return (new Reserves(usuari, codi_taller, taller));
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

    public void setCodi_reserva(int codi_reserva) {
        this.codi_reserva = codi_reserva;
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
}
