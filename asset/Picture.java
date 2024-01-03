package asset;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import asset.draw.Dot;

public class Picture extends JLabel {
    Sun sun = new Sun();
    Cloud cloud = new Cloud(new Dot(400, 500), 100, 50, Color.blue);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        sun.drawSun(g, new Dot(300, 300), 200, 10, 16);
        sun.drawSun(g, new Dot(300, 300), 100, 10, 16);
        cloud.draw(g);
    }
}
