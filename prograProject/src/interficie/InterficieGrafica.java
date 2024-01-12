package interficie;

import java.time.LocalDate;
import java.awt.*;
import javax.swing.*;
import dades.*;
import expeciones.*;

public class InterficieGrafica extends JFrame{

    private JButton[] LlistaButton10 = new JButton[10];
    private JButton[] LlistaButton3 = new JButton[3];

    public InterficieGrafica(LlistaActivitats llistaActivitats) {

        super("Interficie gràfica");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        boolean repetir = true;

        while (repetir){
        try {
            String data = JOptionPane.showInputDialog(this, "¿Que data vols començar? (AAAA-MM-DD)");
            String[] dataInici = data.split("-");
            int any = Integer.parseInt(dataInici[0]);
            int mes = Integer.parseInt(dataInici[1]);
            validarMes(mes);
            int dia = Integer.parseInt(dataInici[2]);
            validarDia(dia);
            repetir = false;
            JPanel panel = new JPanel();
            JPanel panel2 = new JPanel();
            setLayout(new BorderLayout());
            panel.setLayout(new GridLayout(2,5));
            add(panel, BorderLayout.CENTER);
            panel2.setLayout(new GridLayout(1,3));
            add(panel2, BorderLayout.SOUTH);

            AccioButtonFilter accio2 = new AccioButtonFilter(LlistaButton10,llistaActivitats,LlistaButton3,dia,mes,any);
            AccioButton accio = new AccioButton(LlistaButton10,llistaActivitats,LlistaButton3,dia,mes,any);

            for (int i = 0; i < 10; i++) {
                int num = (llistaActivitats.llistaDia(LocalDate.of(any, mes, (i + dia))).getNumActivitats());
                LlistaButton10[i] = new JButton(String.valueOf(num));
                LlistaButton10[i].setBackground(num == 0 ? Color.RED : Color.WHITE);
                LlistaButton10[i].setName(String.valueOf(i));
                panel.add(LlistaButton10[i]);
                LlistaButton10[i].addActionListener(accio);
            }

            for (int i = 0; i < 3; i++) {
                String[] tipus = new String[] {"Xerrades", "Visites", "Tallers"};
                LlistaButton3[i] = new JButton(tipus[i]);
                LlistaButton3[i].setName("0");
                LlistaButton3[i].setBackground(Color.WHITE);
                panel2.add(LlistaButton3[i]);
                LlistaButton3[i].addActionListener(accio2);
            }
            setVisible(true);
        } catch (DiaExepcion e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            repetir = true;
        }catch (MesExepcion e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            repetir = true;
        }

        }
        
    }

    public static void validarDia(int dia) throws DiaExepcion {
        if (dia < 1 || dia > 31) {
            throw new DiaExepcion();
        }
    }

    public static void validarMes(int mes) throws MesExepcion {
        if (mes < 1 || mes > 12) {
            throw new MesExepcion();
        }
    }
}