import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Cloud extends JLabel {

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
