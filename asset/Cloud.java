package asset;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import asset.draw.CustomDrawing;
import asset.draw.Dot;

public class Cloud extends JPanel {

    private void draw(Graphics g) {
        CustomDrawing cd = new CustomDrawing();
        Dot[] dots = new Dot[] {
                new Dot(100, 100),
                new Dot(180, 250),
                new Dot(250, 100)
        };
        cd.drawCurve(g, dots);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

}
