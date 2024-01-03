package asset;

import java.awt.Graphics;

import javax.swing.JPanel;

import asset.draw.CustomDrawing;
import asset.draw.Dot;

public class Sun extends JPanel {

    public void drawSun(Graphics g, Dot center, int radius, int margin, int count) {
        CustomDrawing customDrawing = new CustomDrawing();
        double angle = 360 / count;
        Dot[] vertexs = new Dot[count];
        int centerX = center.getX();
        int centerY = center.getY();

        for(int i = 0; i < count; i++){
            int x = (int) (centerX + (radius * Math.cos(Math.toRadians(angle) * i)));
            int y = (int) (centerY + (radius * Math.sin(Math.toRadians(angle) * i)));
            vertexs[i] = new Dot(x, y);
            // customDrawing.plot(g, x, y, 2);
        }

        for(int i = 0; i < count; i++){
            customDrawing.drawCurve(g, new Dot[] {
                new Dot(vertexs[i].getX(), vertexs[i].getY()),
                new Dot(centerX, centerY),
                new Dot(vertexs[i != count - 1 ? i + 1 : 0].getX(), vertexs[i != count - 1 ? i + 1 : 0].getY()),
            });
        }
    }
}
