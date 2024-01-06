public class LlistaTallers extends LlistaActivitats{
    public LlistaTallers(int elements){
        super(elements);
    }
    public Tallers getTaller(String codiTaller) {
        for (int i = 0; i < super.getNumActivitats(); i++) {
            Activitats activitat = super.getActivitat(i);
            if (activitat instanceof Tallers) {
                Tallers taller = (Tallers) activitat;
                if (taller.getTaller(codiTaller) != null) {
                    return taller.getTaller(codiTaller);
                }
            }
        }
        return null;
    }
}