package asset;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import asset.draw.CustomDrawing;
import asset.draw.Dot;
import asset.draw.Fill;

public class Cloud extends JLabel {

    private Dot center;
    private int size_x, size_y, circle1Radius, circle2Radius;
    private Dot circle1;
    private Dot circle2;
    private Color color;

    public Cloud(Dot center, int size_x, int size_y, Color color) {
        this.center = center;
        this.size_x = size_x;
        this.size_y = size_y;
        this.color = color;
        this.circle1Radius = size_x / 2;
        this.circle2Radius = size_x * 4 / 7;
        this.circle1 = new Dot(center.getX() + size_x * 1 / 10, center.getY() - size_y * 4 / 5);
        this.circle2 = new Dot(center.getX() + size_x * 2 / 3, center.getY() - size_y * 4 / 5);
    }

    public void drawCloud(Graphics g) {
        CustomDrawing cd = new CustomDrawing();
        g.setColor(color);

        cd.drawCircle(g, circle1, circle1Radius);
        fill(g, circle1, Color.WHITE);

        cd.drawCircle(g, circle2, circle2Radius);
        fill(g, circle2, Color.WHITE);

        cd.drawOval(g, center, size_x, size_y);
        fill(g, new Dot(center.getX() - size_x / 3, center.getY()), Color.WHITE);
    }

    public void fill(Graphics g, Dot center, Color targetColor) {
        Picture.bf = Fill.FloodFill(g, center, targetColor, color);
    }

    public Dot getCenter() {
        return center;
    }
}