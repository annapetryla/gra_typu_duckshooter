package pl.pla;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class MainMenu extends JFrame {

    public MainMenu() {

        JButton nowaGraButton = new JButton("NOWA GRA");
        JButton highScoresButton = new JButton("HIGH SCORES");
        JButton exitButton = new JButton("EXIT");

        setLayout(new FlowLayout());
        this.add(nowaGraButton);
        this.add(highScoresButton);
        this.add(exitButton);


        nowaGraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(()-> {
                    try {
                        new OknoGlowne();
                    } catch (IOException | InterruptedException ioException) {
                        ioException.printStackTrace();
                    }
                });
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        highScoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(()-> {
                    try {
                        new OknoRankingowe();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                });
            }
        });
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(new Dimension(200, 200));
    }

}
