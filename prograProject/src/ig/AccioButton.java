package ig;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ig.InterficieGrafica;

// Aquest classe serà responsable de tractar els esdeveniments de botons.
public class AccioButton implements ActionListener {
	
	public void actionPerformed(ActionEvent evt) {
		JButton b = (JButton) evt.getSource();
        System.out.println("Has pitjat el botó " + b.getText());

		boto1.setbackground(Color.RED);

	}
	
}
