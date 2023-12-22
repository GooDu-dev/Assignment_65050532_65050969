package asset;

import java.awt.Graphics;

import javax.swing.JLabel;

import asset.drawer.CustomDrawing;
import asset.drawer.Dot;

public class Sun extends JLabel {
    Dot[][] sun;

    public Sun() {
        sun = new Dot[][] {
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
    }

    public void drawSun(Graphics g) {
        CustomDrawing customDrawing = new CustomDrawing();
        for (int i = 0; i < sun.length; i++) {
            customDrawing.drawCurve(g, sun[i]);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        drawSun(g);
        super.paintComponent(g);
    }
}
