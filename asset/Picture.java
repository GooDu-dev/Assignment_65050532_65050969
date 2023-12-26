package asset;

import java.awt.Graphics;

import javax.swing.JLabel;

public class Picture extends JLabel {
    Sun sun = new Sun();
    Cloud cloud = new Cloud();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        sun.drawSun(g);
        cloud.draw(g);
    }
}
