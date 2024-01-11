package ig;

import java.awt.*;
import javax.swing.*;

public class MostraLlista extends JFrame {
    
    public MostraLlista() {
        super("Mostra llista");
        setSize(400, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2,5));
        setVisible(true);
    }
}
