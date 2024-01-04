package asset;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.function.BiFunction;

import javax.swing.JPanel;

import asset.draw.Dot;

public class Picture extends JPanel {
    // private Sun sun;
    // private Cloud cloud;
    // private Mountain mountain;
    // private Bird bird;
    private Sun sun = new Sun();
    private Cloud cloud = new Cloud(new Dot(400, 500), 100, 50, Color.blue);
    private Mountain mountain = new Mountain();
    private Bird bird = new Bird();

    public static BufferedImage bf;

    // public Picture(BufferedImage buffer) {
    // bf = buffer;
    // this.sun = new Sun();
    // this.cloud = new Cloud(new Dot(400, 500), 100, 50, Color.blue);
    // this.mountain = new Mountain();
    // this.bird = new Bird();
    // setBackground(Color.white);
    // // draw();
    // }
    public Picture(BufferedImage bf) {
        Picture.bf = bf;
        setBackground(Color.white);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) bf.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getParent().getWidth(), getParent().getHeight());
        cloud.drawCloud(g2d);
        g.drawImage(bf, 0, 0, null);
        // cloud.draw(g);
        // sun.drawSun(g, new Dot(300, 300), 200, 50, 14, 0);
        // sun.drawSun(g, new Dot(300, 300), 50, 10, 14, 0);
        // cloud.draw(g);
        // fill.FloodFill(cloud.getCenter(), Color.blue, Color.white)
        // mountain.drawMountain(g, new Dot(50, 400), new Dot(200, 450), new
        // Dot(125,250), 100);
        // bird.drawBird(g, new Dot(50, 50), 100);
    }

}
