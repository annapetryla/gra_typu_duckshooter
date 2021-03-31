package pl.pla;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class JSliderFrame extends JFrame {

    int input = 50;

    public JSliderFrame() {

        JSlider jSlider = new JSlider();

        jSlider.setMajorTickSpacing(20);
        jSlider.setMinorTickSpacing(50);

        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                input = slider.getValue();
            }
        });

        setLayout(new FlowLayout());
        this.add(jSlider);
        this.add(new JTextField("Wybierz poziom trudności"));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(200,100);
        setVisible(true);

    }
}

