package asset;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import asset.draw.CustomDrawing;
import asset.draw.Dot;

public class Cloud extends JPanel {

    private Dot center;
    private int size_x, size_y;
    private Dot circle1;
    private Dot circle2;
    private Color color;

    public Cloud(Dot center, int size_x, int size_y, Color color) {
        this.center = center;
        this.size_x = size_x;
        this.size_y = size_y;
        this.color = color;
        this.circle1 = new Dot(center.getX() + size_x * 1 / 10, center.getY() - size_y * 4 / 5);
        this.circle2 = new Dot(center.getX() + size_x * 2 / 3, center.getY() - size_y * 4 / 5);
    }

    void draw(Graphics g) {
        CustomDrawing cd = new CustomDrawing();
        g.setColor(color);
        cd.drawCircle(g, circle1, size_x / 2);
        cd.drawCircle(g, circle2, size_x * 4 / 7);
        cd.drawOval(g, center, size_x, size_y);
    }
}
