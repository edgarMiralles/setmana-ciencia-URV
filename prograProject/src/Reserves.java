public class Reserves {
    private String usuari;
    private int codi_reserva, codi_taller,satisfaccio;

    public Reserves (int c_reserva,String usuari, int c_taller){
            codi_reserva = c_reserva;
            codi_taller = c_taller;
            this.usuari = usuari;
    }
    
    public Reserves copia(){         
        return (new Reserves(codi_reserva, usuari, codi_taller));
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


    public void setCodi_reserva(int codi_reserva) {
        this.codi_reserva = codi_reserva;
    }


    public int getCodi_taller() {
        return codi_taller;
    }


    public void setCodi_taller(int codi_taller) {
        this.codi_taller = codi_taller;
    }

    public int getSatisfaccio() {
        return satisfaccio;
    }

    public void setSatisfaccio(int satisfaccio) {
        this.satisfaccio = satisfaccio;
    }
}
