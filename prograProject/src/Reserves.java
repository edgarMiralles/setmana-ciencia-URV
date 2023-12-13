public class Reserves {
    private String usuari;
    private int codi_reserva, codi_taller,satisfaccio, places_ocupades=1;
    private Tallers taller = null;


    public Reserves (int c_reserva,String usuari, int c_taller, LlistaActivitats llistaActiv){
        taller = llistaActiv.getTaller(c_taller);
        if (places_ocupades < taller.getCapacitat()) {
            codi_reserva = c_reserva;
            codi_taller = c_taller;
            this.usuari = usuari;
            places_ocupades++;
        }
    }
    
    public Reserves copia(){         
        return (new Reserves(codi_reserva, usuari, codi_taller, taller));
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


    public int getPlaces_ocupades() {
        return places_ocupades;
    }


    public void setPlaces_ocupades(int places_ocupades) {
        this.places_ocupades = places_ocupades;
    }


    public int getPuntuacio() {
        return taller.getPuntuacio();
    }


    public void setPuntuacio(int puntuacio) {
        taller.setPuntuacio(puntuacio);
        taller.setNPersones(places_ocupades);
    }


    public Tallers getTaller() {
        return taller;
    }


    public void setTaller(Tallers taller) {
        this.taller = taller;
    }

}
