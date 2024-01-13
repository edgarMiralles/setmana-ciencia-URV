//Iulian Sebastian Oprea --> iuliansebastian.oprea@estudiants.urv.cat
package dades;
import java.io.*;

/**
 * La classe ArxiusSerialitzats ofereix funcionalitats per llegir i escriure objectes serialitzats a un fitxer.
 */

public class ArxiusSerialitzats {
    
    private String NomArxiu;

    /**
     * Constructor de la classe ArxiusSerialitzats.
     * @param NomArxiu El nom de l'arxiu amb el qual es treballarà.
     */
    
    public ArxiusSerialitzats(String NomArxiu){
        this.NomArxiu = "prograProject/src/arxius/" + NomArxiu;
    }

    /**
     * Llegeix les reserves serialitzades de l'arxiu i les afegeix a la llista
     * proporcionada.
     * @param llista La llista de reserves on s'afegiran les reserves llegides.
     */
    
    public void LlegirArxiu(LlistaReserves llista) {
        try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(NomArxiu))) {
            boolean continua = true;
    
            while (continua) {
                try {
                    Reserves beta = (Reserves) lectura.readObject();
                    llista.afegirReserva(beta);
                } catch (EOFException e) {
                    continua = false;  // Fin del archivo
                } catch (ClassNotFoundException e) {
                    System.out.println("Error al llegir la classe el fitxer (reserves.ser)");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al llegir el fitxer (reserves.ser)");
        }
    }

    /**
     * Escriu les reserves de la llista a l'arxiu en format serialitzat.
     * @param alpha La llista de reserves que es vol escriure a l'arxiu.
     */
    
    public void EscriuArxiu(LlistaReserves alpha){
        try{
            ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(NomArxiu));
            int nElem = alpha.getPlacesOcupades();
            for (int i = 0; i < nElem; i++) {
                try{
                    Reserves beta = alpha.getReserves(i);
                    escritura.writeObject(beta);
                }catch(IOException e){
                    System.out.println("Error al escriure el fitxer (reserves.ser)");
                }
            }
            escritura.close();
        }catch(IOException e){
            System.out.println("Error al escriure el fitxer (reserves.ser)");
        }
    }

}
