package pl.pla;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class OknoGlowne {
    public OknoGlowne() throws IOException, InterruptedException {

        Image img1 = createImageIcon("rysunki/kaczka.gif", "").getImage();
        Image img2 = createImageIcon("rysunki/kaczka3.gif", "").getImage();
        Image img3 = createImageIcon("rysunki/kaczka2.gif", "").getImage();
        Image img4 = createImageIcon("rysunki/kaczka4.gif", "").getImage();

        Kaczka k1 = new Kaczka(randInt(0, 70), randInt(50, 80), 50.0, 30.0, Color.blue, 10, "Niebieski", 100, 10, img1);
        Kaczka k2 = new Kaczka(randInt(0, 480), randInt(100, 130), 50.0, 30.0, Color.black, 10, "Czarna", 200, 20, img2);
        Kaczka k3 = new Kaczka(randInt(550, 660), randInt(270, 300), 50.0, 30.0, Color.pink, 10, "Rozowa", 300, 30, img3);
        Kaczka k4 = new Kaczka(randInt(800, 810), randInt(150, 200), 50.0, 30.0, Color.green, 10, "Zielona", 400, 40, img4);
        Kaczka k5 = new Kaczka(randInt(100, 270), randInt(100, 600), 50.0, 30.0, Color.black, 10, "Czarna", 200, 20, img2);
        Kaczka k6 = new Kaczka(randInt(780, 1000), randInt(570, 580), 50.0, 30.0, Color.pink, 10, "Rozowa", 300, 30, img3);
        Kaczka k7 = new Kaczka(randInt(0, 270), randInt(100, 130), 50.0, 30.0, Color.black, 10, "Czarna", 200, 20, img2);
        Kaczka k8 = new Kaczka(randInt(0, 70), randInt(390, 490), 50.0, 30.0, Color.blue, 10, "Niebieski", 100, 10, img1);
        Kaczka k9 = new Kaczka(randInt(240, 900), randInt(670, 700), 50.0, 30.0, Color.blue, 10, "Niebieski", 100, 10, img1);
        Kaczka k10 = new Kaczka(randInt(180, 210), randInt(100, 580), 50.0, 30.0, Color.pink, 10, "Rozowa", 300, 30, img3);
        Kaczka k11 = new Kaczka(randInt(270, 360), randInt(570, 580), 50.0, 30.0, Color.pink, 10, "Rozowa", 300, 30, img3);
        Kaczka k12 = new Kaczka(randInt(800, 810), randInt(400, 500), 50.0, 30.0, Color.green, 10, "Zielona", 400, 40, img4);
        Kaczka k13 = new Kaczka(randInt(900, 1000), randInt(800, 900), 50.0, 30.0, Color.green, 10, "Zielona", 400, 40, img4);
        Kaczka k14 = new Kaczka(randInt(460, 700), randInt(50, 200), 50.0, 30.0, Color.green, 10, "Zielona", 400, 40, img4);
        Kaczka k15 = new Kaczka(randInt(250, 780), randInt(0, 130), 50.0, 30.0, Color.black, 10, "Czarna", 200, 20, img2);
        ArrayList<Kaczka> listaKaczek = new ArrayList<>();

        listaKaczek.add(k1);
        listaKaczek.add(k2);
        listaKaczek.add(k3);
        listaKaczek.add(k4);
        listaKaczek.add(k5);
        listaKaczek.add(k6);
        listaKaczek.add(k7);
        listaKaczek.add(k8);
        listaKaczek.add(k9);
        listaKaczek.add(k10);
        listaKaczek.add(k11);
        listaKaczek.add(k12);
        listaKaczek.add(k13);
        listaKaczek.add(k14);
        listaKaczek.add(k15);

        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q , KeyEvent.VK_CONTROL & KeyEvent.VK_SHIFT); // mój skrót klawiszowy - naciśnij q

        DrawPanel PanelRysowania = new DrawPanel(listaKaczek);
        JFrame PlanszaFrame = new JFrame("Game");
        PlanszaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlanszaFrame.getContentPane().add(PanelRysowania);
        PlanszaFrame.setLocationRelativeTo(null);
        PlanszaFrame.setLocation(200, 200);

        JFrame ResultsFrame = new JFrame("Results");
        ResultsFrame.setLocation(1265, 193);
        ResultsFrame.setSize(50, 150);
        ResultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSliderFrame GamelevelSlider = new JSliderFrame();
        GamelevelSlider.setLocation(1265, 350);

        JLabel l1, l2, l3;
        l1 = new JLabel("Liczba żyć:");
        l2 = new JLabel("Wynik:");
        l3 = new JLabel("Czas:");

        JPanel jp = new JPanel(new GridLayout(3, 1, 1, 1));
        jp.setPreferredSize(new Dimension(10, 10));
        jp.setVisible(true);
        jp.add(l1);
        jp.add(l2);
        jp.add(l3);
        ResultsFrame.getContentPane().add(jp);

        PanelRysowania.setVisible(true);
        PlanszaFrame.setVisible(true);
        ResultsFrame.setVisible(true);

        TimerLicznik timer = new TimerLicznik(PanelRysowania);
        PlanszaFrame.pack();

        Thread thread = new Thread(new Runnable() {
            boolean isPressed = false;
            @Override
            public void run() {
                timer.start();
                while (!PanelRysowania.isGameFinished() && !isPressed) {
                    for (Kaczka k : listaKaczek) {
                        k.ruszKaczka(PanelRysowania);
                    }
                    PanelRysowania.checkBoundKaczka();
                    try {
                        Thread.sleep(GamelevelSlider.input);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    l1.setText("Liczba żyć : " + PanelRysowania.liveCount);
                    l2.setText("Wynik : " + PanelRysowania.score);
                    l3.setText("Czas : " + timer.ileMinut + ":" + timer.ileSekund);
                    PanelRysowania.repaint();
                    PlanszaFrame.getRootPane().registerKeyboardAction(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            isPressed = true;
                            timer.quit();
                            zakonczGre(timer,PanelRysowania,GamelevelSlider,PlanszaFrame,ResultsFrame);
                        }
                    }, escapeKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
                }
                if (PanelRysowania.isGameFinished() && !isPressed ) {
                    timer.quit();
                    zakonczGre(timer,PanelRysowania,GamelevelSlider,PlanszaFrame,ResultsFrame);
                }
            }

        });
        thread.start();
    }

    public static void zakonczGre(TimerLicznik timer,DrawPanel PanelRysowania,JSliderFrame GamelevelSlider,JFrame PlanszaFrame,JFrame ResultsFrame  ) {
        JOptionPane.showMessageDialog(PlanszaFrame, "Koncze gre i zapisuje wynik");
        JOptionPaneFrame paneFrame = new JOptionPaneFrame();
        int finalMinutes = (int) timer.ileMinut;
        int finalSeconds = (int) timer.ileSekund;
        FileWriter fw = null;
        try {
            fw = new FileWriter("wyniki.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PanelRysowania.score = PanelRysowania.score - GamelevelSlider.input + finalMinutes + finalSeconds ;
        if(paneFrame.input!="") {
            writeToFile(fw, paneFrame.input, PanelRysowania.score);
        }
        else {
            writeToFile(fw, "anonim", PanelRysowania.score);
        }
        PlanszaFrame.dispose();
        ResultsFrame.dispose();
        GamelevelSlider.dispose();
    }

    public static void writeToFile(FileWriter fw, String input, int wynik) {
        try {
            fw.write(input + " " + wynik + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    protected static ImageIcon createImageIcon(String path, String description) {
        if (OknoGlowne.class.getResource(path) != null) {
            return new ImageIcon(OknoGlowne.class.getResource(path), description);
        } else {
            System.err.println("Couldn't find file:" + path);
            return null;
        }
    }
}

