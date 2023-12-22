package asset;

import java.awt.Graphics;

import javax.swing.JPanel;

import asset.draw.CustomDrawing;
import asset.draw.Dot;

public class Cloud extends JPanel {

    void draw(Graphics g) {
        CustomDrawing cd = new CustomDrawing();
        Dot[] dots = new Dot[] {
                new Dot(100, 100),
                new Dot(180, 250),
                new Dot(250, 100)
        };
        // cd.drawCurve(g, dots);
        cd.drawOval(g, new Dot(100, 100), 50, 100);
    }
}
