//Iulian Sebastian Oprea --> iuliansebastian.oprea@estudiants.urv.cat
package interficie;

import javax.swing.*;

import dades.LlistaActivitats;

import java.awt.event.*;
import java.time.LocalDate;

/**
 * La classe AccioButton implementa l'interfície ActionListener per gestionar les accions dels botons associats a la visualització de les activitats.
 */

public class AccioButton implements ActionListener {

    private JButton[] llistaBoto;
    private LlistaActivitats llistaActivitats;
    private JButton[] llistaButton3;
    private int dia,mes,any;

    /**
     * Constructor de la classe AccioButton.
     * @param LlistaButton  Array de botons que representen els dies.
     * @param llistaActivitats  Llista d'activitats.
     * @param LlistaButton2 Array de botons que representa els tipus d'activitats.
     * @param dia Dia seleccionat.
     * @param mes Mes seleccionat.
     * @param any Any seleccionat.
     */
    
    public AccioButton(JButton[] LlistaButton,LlistaActivitats llistaActivitats,JButton[] LlistaButton2,int dia,int mes,int any) {
        llistaBoto = LlistaButton;
        this.llistaActivitats = llistaActivitats;
        llistaButton3 = LlistaButton2;
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }
    /**
     * Mètode que es crida quan es fa clic en un botó de dia.
     * 
     * @param evt Event de l'acció.
     */
    public void actionPerformed(ActionEvent evt) {
        JButton b = (JButton) evt.getSource();
        for (int i = 0; i < 10; i++) {
            if ((b.getName().equals(llistaBoto[i].getName()))&&(!llistaBoto[i].getText().equals("0"))){
                LlistaActivitats llista = llistaActivitats.llistaDia(LocalDate.of(any,mes,(Integer.parseInt(b.getName())+dia)));
                LlistaActivitats mostra;
                if (llistaButton3[0].getName().equalsIgnoreCase("1")) {
                    System.out.println("Mostra de Xarrades");
                    mostra = llista.llistaXerrades();
                    new MostraLlista(mostra);
                    System.out.println(mostra);
                }else if(llistaButton3[1].getName().equalsIgnoreCase("1")){
                    mostra = llista.llistaVisites();
                    System.out.println("Mostra de Visites");
                    new MostraLlista(mostra);
                    System.out.println(mostra);
                }else if(llistaButton3[2].getName().equalsIgnoreCase("1")){
                    System.out.println("Mostra de Tallers");
                    mostra = llista.llistaTallers();
                    new MostraLlista(mostra);
                    System.out.println(mostra);
                }else{
                    new MostraLlista(llista);
                    System.out.println(llista);
                }
            }
        }
    }
}
