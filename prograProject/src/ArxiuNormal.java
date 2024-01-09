import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArxiuNormal{

    String ruta;

    public ArxiuNormal(String nom){
        ruta = "prograProject/src/arxius/"+nom;
    }

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

    public void EscriureArxiu(String[] dades,int numDades) throws IOException{

        BufferedWriter escritura = new BufferedWriter (new FileWriter(ruta));

        boolean seguir = true;
        int i = 0;
        while (seguir){
            try{
                if (dades[i] != null){
                for(int j = i; j < (numDades+i); j++) {
                    escritura.write(dades[j]);
                    if (j != (numDades+i - 1)) {
                        escritura.write(";");
                    }else{
                        escritura.write("\n");
                    }    
                }
                i+=numDades;  
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

