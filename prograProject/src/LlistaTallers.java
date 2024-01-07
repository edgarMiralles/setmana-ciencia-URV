//Kevin Sánchez Ramírez
public class LlistaTallers extends LlistaActivitats{
    public LlistaTallers(int elements){
        super(elements);
    }
    public Tallers getTaller(String codi){
            for(int i=0; i<super.getNumActivitats(); i++){
                Tallers taller = (Tallers)super.getActivitat(i);
                if(taller.getCodi().equalsIgnoreCase(codi)){
                    return taller;
                }
            }
            return null;
        }
}