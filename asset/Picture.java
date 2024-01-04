package asset;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.function.BiFunction;

import javax.swing.JPanel;

import asset.draw.Dot;

public class Picture extends JPanel {
    private Sun sun;
    private Cloud cloud;
    private Mountain mountain;
    private Bird bird;

    public static BufferedImage bf;

    public Picture(BufferedImage buffer) {
        bf = buffer;
        this.sun = new Sun(new Color(253, 184, 19));
        this.cloud = new Cloud(new Dot(400, 500), 100, 50, new Color(163, 232, 253));
        this.mountain = new Mountain(new Color(60, 37, 21));
        this.bird = new Bird(new Color(0, 0, 0));
        setBackground(Color.white);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) bf.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getParent().getWidth(), getParent().getHeight());

        cloud.drawCloud(g2d);

        sun.drawSun(g2d, new Dot(300, 300), 200, 50, 14, 0);
        sun.drawSun(g2d, new Dot(300, 300), 50, 10, 14, 0);

        mountain.drawMountain(g2d,
                new Dot(50, 400), new Dot(200, 450), new Dot(125, 250), 100);

        bird.drawBird(g2d, new Dot(50, 50), 100);

        g.drawImage(bf, 0, 0, null);
    }

}
