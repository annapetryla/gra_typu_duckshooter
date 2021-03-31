package pl.pla;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Kaczka extends Rectangle2D {

    public double x;
    public double y;
    public double width;
    public double height;
    public Color color;
    public int health;
    public String name;
    public int ID;
    public int points;
    int dx = 1;
    int dy = 1;
    double xKaczka = getWidth();
    double yKaczka = getHeight();
    public Image kaczkaImage;

    public Kaczka(double x, double y, double width, double height, Color color, int health, String name, int ID, int points, Image image)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.health = health;
        this.name = name;
        this.ID = ID;
        this.points = points;
        this.kaczkaImage = image;
    }


    public void decreaseHealth()
    {
        this.health--;
    }

    public int getID() {
        return ID;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void setRect(double x, double y, double w, double h) {

    }

    @Override
    public int outcode(double x, double y) {
        return 0;
    }

    @Override
    public Rectangle2D createIntersection(Rectangle2D r) {
        return null;
    }

    @Override
    public Rectangle2D createUnion(Rectangle2D r) {
        return null;
    }
    public void ruszKaczka(JPanel panel) {

        x += dx;
        y += dy;

        Rectangle granicePanelu = panel.getBounds();

        if (y + yKaczka >= granicePanelu.getMaxY()) {
            y = (int) (granicePanelu.getMaxY() - yKaczka);
            dy = -dy;
        }
        if (x + xKaczka >= granicePanelu.getMaxX()) {
            x = (int) (granicePanelu.getMaxX() - xKaczka);
            dx = -dx;
        }
        if (x  < granicePanelu.getMinX()) {
            x = (int) (granicePanelu.getMinX() + xKaczka);
            dx = -dx;
        }
        if (y  < granicePanelu.getMinY()) {
            y = (int) (granicePanelu.getMinY() + yKaczka);
            dy = -dy;
        }

    }
}

