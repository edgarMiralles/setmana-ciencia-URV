import java.io.*;

public class ArxiusSerialitzats {
    
    private String NomArxiu;

    public ArxiusSerialitzats(String NomArxiu){
        this.NomArxiu = "prograProject/src/arxius/" + NomArxiu;
    }

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
