package asset;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import asset.draw.Dot;

public class Picture extends JLabel {
    Sun sun = new Sun();
    Cloud cloud = new Cloud(new Dot(400, 500), 100, 50, Color.blue);
    Mountain mountain = new Mountain();
    Bird bird = new Bird();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        sun.drawSun(g, new Dot(300, 300), 200, 50, 14, 0);
        sun.drawSun(g, new Dot(300, 300), 50, 10, 14, 0);
        cloud.draw(g);
        mountain.drawMountain(g, new Dot(50, 400), new Dot(200, 450), new Dot(125, 250), 100);
        bird.drawBird(g, new Dot(50, 50), 20);
    }
}
