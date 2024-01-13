//Iulian Sebastian Oprea --> iuliansebastian.oprea@estudiants.urv.cat
package interficie;

import javax.swing.*;

import dades.LlistaActivitats;
/**
 * La classe MostraLlista és una finestra que mostra una llista d'activitats.
 */
public class MostraLlista extends JFrame {

     /**
     * Constructor de la classe MostraLlista.
     * 
     * @param llista La llista d'activitats que es mostrarà en la finestra.
     */
    
    public MostraLlista(LlistaActivitats llista) {
        super("Mostra llista");
        setSize(400, 300);
        setLocation(200, 200);
        // Crear un JTextArea
        JTextArea textArea = new JTextArea();
        // Deshabilità la edició
        textArea.setEditable(false);

        // Agregar cada activitat a textArea
        for (int i = 0; i < llista.getNumActivitats(); i++){
            textArea.append(llista.getActivitat(i).toString() + "\n");
        }
        add(new JScrollPane(textArea));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
