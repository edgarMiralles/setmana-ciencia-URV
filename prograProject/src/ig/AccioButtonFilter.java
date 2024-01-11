package ig;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class AccioButtonFilter implements ActionListener {

    public void actionPerformed(ActionEvent evt) {
        JButton b = (JButton) evt.getSource();
        System.out.println("Has pitjat el button " + b.getText());
    }
}
