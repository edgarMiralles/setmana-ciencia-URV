//Iulian Sebastian Oprea --> iuliansebastian.oprea@estudiants.urv.cat
package interficie;
import java.awt.Color;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;
import dades.LlistaActivitats;

/**
 * La classe AccioButtonFilter implementa l'interfície ActionListener per gestionar
 * les accions dels botons de filtre d'activitats.
 */

public class AccioButtonFilter implements ActionListener {

    private JButton[] Llistabutton;
    private LlistaActivitats llistaActivitats;
    private JButton[] LlistaButton3 ;
    private int dia,mes,any;

    /**
     * Constructor de la classe AccioButtonFilter.
     * @param LlistaButton  Array de botons que representen els dies.
     * @param llistaActivitats  Llista d'activitats.
     * @param LlistaButton2 Array de botons que representa els tipus d'activitats.
     * @param dia Dia seleccionat.
     * @param mes Mes seleccionat.
     * @param any Any seleccionat.
     */
    
    public AccioButtonFilter(JButton[] LlistaButton,LlistaActivitats llistaActivitats,JButton[] LlistaButton2,int dia,int mes,int any) {
        this.Llistabutton = LlistaButton;
        this.llistaActivitats = llistaActivitats;
        this.LlistaButton3 = LlistaButton2;
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    
    /**
     * Mètode que es crida quan es fa clic en un botó de filtre d'activitats.
     * 
     * @param evt Event de l'acció.
     */
    public void actionPerformed(ActionEvent evt) {
        JButton b = (JButton) evt.getSource();
        if (b.getText().equals("Xerrades")){
            for (int i = 0; i < 10; i++) {
                int num = (llistaActivitats.llistaXerrades().llistaDia(LocalDate.of(any, mes, (i + dia))).getNumActivitats());
                Llistabutton[i].setText(String.valueOf(num));
                Llistabutton[i].setBackground(num == 0 ? Color.RED : Color.WHITE);
            }
            LlistaButton3[0].setName("1");
            LlistaButton3[1].setName("0");
            LlistaButton3[2].setName("0");
        }else if (b.getText().equals("Visites")){
            for (int i = 0; i < 10; i++){
                int num = (llistaActivitats.llistaVisites().llistaDia(LocalDate.of(any, mes, (i + dia))).getNumActivitats());
                Llistabutton[i].setText(String.valueOf(num));
                Llistabutton[i].setBackground(num == 0 ? Color.RED : Color.WHITE);
            }
            LlistaButton3[0].setName("0");
            LlistaButton3[1].setName("1");
            LlistaButton3[2].setName("0");
        }else if (b.getText().equals("Tallers")){
            for (int i = 0; i < 10; i++){
                int num = (llistaActivitats.llistaTallers().llistaDia(LocalDate.of(any, mes, (i + dia))).getNumActivitats());
                Llistabutton[i].setText(String.valueOf(num));
                Llistabutton[i].setBackground(num == 0 ? Color.RED : Color.WHITE);
            }
            LlistaButton3[0].setName("0");
            LlistaButton3[1].setName("0");
            LlistaButton3[2].setName("1"); 
        }
    }
}
