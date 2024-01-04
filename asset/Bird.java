package asset;

import java.awt.Color;
import java.awt.Graphics;

import asset.draw.CustomDrawing;
import asset.draw.Dot;
import asset.draw.Fill;

public class Bird {

    private Color color;

    public Bird(Color color) {
        this.color = color;
    }

    public void drawBird(Graphics g, Dot startPoint, int size) {
        CustomDrawing customDrawing = new CustomDrawing();
        g.setColor(color);

        customDrawing.drawCurve(g, new Dot[] {
                startPoint,
                new Dot(startPoint.getX() - (size / 4), startPoint.getY() - (size / 6)),
                new Dot(startPoint.getX() - (size / 2), startPoint.getY())
        });
        customDrawing.drawCurve(g, new Dot[] {
                startPoint,
                new Dot(startPoint.getX() + (size / 4), startPoint.getY() - (size / 6)),
                new Dot(startPoint.getX() + (size / 2), startPoint.getY())
        });

        customDrawing.drawLine(g,
                new Dot(startPoint.getX() - (size / 4), startPoint.getY()),
                new Dot(startPoint.getX() + (size / 4), startPoint.getY()),
                1);
    }

    public void fill(Graphics g, Dot center, Color targetColor) {
        Picture.bf = Fill.FloodFill(g, center, targetColor, color);
    }
}
