import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArxiuNormal{

    String nom;

    public ArxiuNormal(String nom){
        this.nom = nom;
    }

    public String[] LlegirArxiu() throws IOException{
        String[] dades = new String[99];
        BufferedReader lectura = new BufferedReader(new FileReader(nom));
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
}
