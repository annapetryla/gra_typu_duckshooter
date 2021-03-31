package pl.pla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {

    private List<Kaczka> listaKaczek;
    private List<Rectangle> listaChmurek = new ArrayList<>();
    public int score = 50;
    public int liveCount = 10;
    public static Image chmurka = createImageIcon("rysunki/chmurka.gif", "").getImage();
    public static Image backgroundImage = createImageIcon("rysunki/background.jpg", "").getImage();
    int xBorder = 1000;
    int xChm1 = 0;
    int xChm2 = 500;
    int xChm3 = 600;
    int xChm4 = 800;
    int yChm1 = 0;
    int yChm2 = 50;
    int yChm3 = 20;
    int yChm4 = 70;
    Rectangle rect1 = new Rectangle(xChm1+44,yChm1+33,124,81);
    Rectangle rect2 = new Rectangle(xChm2+44,yChm2+33,124,81);
    Rectangle rect3 = new Rectangle(xChm3+44,yChm3+33,124,81);
    Rectangle rect4 = new Rectangle(xChm4+44,yChm4+33,124,81);

    public DrawPanel(List<Kaczka> kaczki) {
        this.listaKaczek = kaczki;
        listaChmurek.add(rect1);
        listaChmurek.add(rect2);
        listaChmurek.add(rect3);
        listaChmurek.add(rect4);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //repaint();
                if (!checkChmurka(e.getPoint()))
                {
                    checkKaczka(e.getPoint());
                    System.out.println(e.getX()+" "+e.getY());
                }
                //System.out.println(e.getX()+" "+e.getY());
            }

        });

    }
    protected static ImageIcon createImageIcon(String path, String description) {
        if (DrawPanel.class.getResource(path) != null) {
            return new ImageIcon(DrawPanel.class.getResource(path), description);
        } else {
            System.err.println("Couldn't find file:" + path);
            return null;
        }
    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(1000, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.RED);
        g2d.drawImage(backgroundImage,0,0,null);
        for (Kaczka kaczka : listaKaczek) {
            g2d.setColor(kaczka.color);
            //g2d.fill(kaczka);
            g2d.drawImage(kaczka.kaczkaImage,(int)kaczka.x,(int)kaczka.y-40,null);
            // g2d.drawRect(kaczka.x,kaczka.y,kaczka.width,kaczka.height);
            // g2d.fillRect(kaczka.x,kaczka.y,kaczka.width,kaczka.height);
        }
        g2d.setColor(Color.BLUE);
        g2d.drawImage(chmurka,xChm1,yChm1,null);
        g2d.drawImage(chmurka,xChm2,yChm2,null);
        g2d.drawImage(chmurka,xChm3,yChm3,null);
        g2d.drawImage(chmurka,xChm4,yChm4,null);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(xBorder,1000,xBorder,0);
        g2d.dispose();
    }
    public void checkKaczka(Point p)
    {
        for(Kaczka k: listaKaczek)
        {
            if(k.contains(p)) {
                k.decreaseHealth();
                System.out.println("You clicked kaczka:" + k.getName() + " Current health:" + k.health + " Decreasing health to:" + (k.health - 1));
                if (k.health == 0) {
                    this.score = this.score + k.points;
                }
            }
        }
        listaKaczek.removeIf((kaczka)->kaczka.getHealth()==0);
    }
    public void checkBoundKaczka() {
        for(Kaczka k : listaKaczek) {
            if(k.x == xBorder && liveCount>0 ) {
                decreaseLive();
            }
        }
    }
    void decreaseLive() {

        this.liveCount--;
    }

    public void setLiveCount(int liveCount) {

        this.liveCount = liveCount;
    }

    public int getLiveCount() {

        return liveCount;
    }
    public boolean checkChmurka(Point point) {
        for(Rectangle rectangle: listaChmurek) {
            if(rectangle.contains(point)){
                return true;
            }
        }
        return false;
    }

    public boolean isGameFinished() {
        if(liveCount==0){
            return true;
        }
        else {
            return false;
        }
    }

}


