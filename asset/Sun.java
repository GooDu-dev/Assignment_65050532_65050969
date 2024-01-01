package asset;

import java.awt.Graphics;

import javax.swing.JPanel;

import asset.draw.CustomDrawing;
import asset.draw.Dot;

public class Sun extends JPanel {
    Dot[][] sun = new Dot[][] {
            new Dot[] {
                    new Dot(50, 200),
                    new Dot(250, 100),
                    new Dot(50, 400),
            },
            new Dot[] {
                    new Dot(50, 400),
                    new Dot(500, 200),
                    new Dot(50, 600),
            },
    };

    public void drawSun(Graphics g, Dot centerPoint) {
        CustomDrawing customDrawing = new CustomDrawing();
        for (int i = 0; i < sun.length; i++) {
            customDrawing.drawCurve(g, sun[i]);
        }
    }
}
