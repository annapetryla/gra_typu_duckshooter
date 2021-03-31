package pl.pla;

import javax.swing.*;

public class JOptionPaneFrame {

    String input;
    public JOptionPaneFrame() {
        JOptionPane.showMessageDialog(null, "Podaj nick gracza do rankingu", "Title", JOptionPane.QUESTION_MESSAGE);
        input = JOptionPane.showInputDialog(null,"","",JOptionPane.PLAIN_MESSAGE);
    }
}