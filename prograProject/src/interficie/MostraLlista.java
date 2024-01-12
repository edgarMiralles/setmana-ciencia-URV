package interficie;

import javax.swing.*;

import dades.LlistaActivitats;

public class MostraLlista extends JFrame {
    
    public MostraLlista(LlistaActivitats llista) {
        super("Mostra llista");
        setSize(400, 300);
        setLocation(200, 200);
        // Crear un JTextArea
        JTextArea textArea = new JTextArea();
        // Deshabilitar la edición
        textArea.setEditable(false);

        // Agregar cada actividad a textArea
        for (int i = 0; i < llista.getNumActivitats(); i++){
            textArea.append(llista.getActivitat(i).toString() + "\n");
        }
        add(new JScrollPane(textArea));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
