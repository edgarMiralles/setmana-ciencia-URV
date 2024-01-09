public class LlistaVisites extends LlistaActivitats {
    public LlistaVisites(int num) {
        super(num);
    }

    public LlistaVisites llistaVisitesEntintat(String nom){
        LlistaVisites alpha = new LlistaVisites(numActivitats);
        for (int i = 0; i < numActivitats; i++) {
            if (llista[i].getNomEntitat().equalsIgnoreCase(nom)) {
                alpha.afegirActivitat(llista[i].copia());
            }
        }
        return alpha;
    }

}
