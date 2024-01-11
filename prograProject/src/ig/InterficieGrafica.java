package ig;

import java.awt.*;
import javax.swing.*;
import dades.*;

public class InterficieGrafica extends JFrame {

    public InterficieGrafica() {
        super("Interficie gràfica");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(2,5));
        add(panel, BorderLayout.CENTER);
        panel2.setLayout(new GridLayout(1,3));
        add(panel2, BorderLayout.SOUTH);

        AccioButton accio = new AccioButton();
        AccioButtonFilter accio2 = new AccioButtonFilter();


        for (int i = 0; i < 10; i++) {
            //int numActDia = llistaActivitatsDia(i).length;
            JButton button = new JButton("Botó " + i);
            button.setSize(5,15);
            panel.add(button);
            button.addActionListener(accio);
        }

        for (int i = 0; i < 3; i++) {
            String[] tipus = new String[] {"Xerrades", "Visites", "Tallers"};
            JButton button = new JButton(tipus[i]);
            panel2.add(button);
            button.addActionListener(accio2);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        InterficieGrafica finestra = new InterficieGrafica();

    }



}