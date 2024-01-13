package dades;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * La classe ArxiuNormal proporciona funcionalitats per llegir i escriure en un
 * arxiu de text.
 */

public class ArxiuNormal{

    String ruta;

     /**
     * Constructor de la classe ArxiuNormal.
     * @param nom El nom de l'arxiu amb el qual es treballarà.
     */
    
    public ArxiuNormal(String nom){
        ruta = "prograProject/src/arxius/"+nom;
    }

     /**
     * Llegeix les dades de l'arxiu i les retorna com un array de cadenes.
     * @return Un array de cadenes que conté les dades llegides de l'arxiu.
     * @throws IOException Si hi ha problemes durant la lectura de l'arxiu.
     */

    public String[] LlegirArxiu() throws IOException{
        String[] dades = new String[99];
        BufferedReader lectura = new BufferedReader(new FileReader(ruta));
        String frase = "";
        frase = lectura.readLine();
        int i = 0;
        while(frase != null){
            dades[i] = frase;
            frase = lectura.readLine();
            i++;
        }
        lectura.close();
        return dades;
    }
     /**
     * Escriu les dades proporcionades a l'arxiu.
     * @param dades Un array de cadenes que conté les dades a escriure a l'arxiu.
     * @throws IOException Si hi ha problemes durant l'escriptura de l'arxiu.
     */
    public void EscriureArxiu(String[] dades) throws IOException{

        BufferedWriter escritura = new BufferedWriter (new FileWriter(ruta));

        boolean seguir = true;
        int i = 0;
        while (seguir){
            try{
                if (dades[i] != null){
                    int j = i;
                    while(dades[j] != "//"){
                        escritura.write(dades[j]);
                        if((dades[j+1] != "//")){
                            escritura.write(";");
                        }
                        j++;
                    }
                    i = j + 1;
                    if (dades[i] != null){
                        escritura.newLine();
                    }
                }else{
                    seguir = false;
                }  
            }catch(NullPointerException e){
                seguir = false;
            }catch(ArrayIndexOutOfBoundsException e){
                seguir = false;
            }
        }
        escritura.close();
    }
}

