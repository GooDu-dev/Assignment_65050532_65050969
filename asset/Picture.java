package asset;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.BiFunction;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import asset.draw.Dot;

public class Picture extends JPanel {
    private Sun sun;
    private Cloud cloud_left, cloud_right;
    private Mountain mountain;
    private Bird bird;

    public static BufferedImage bf;

    public Picture(BufferedImage buffer) {
        bf = buffer;
        this.sun = new Sun();
        this.cloud_left = new Cloud(new Dot(100, 100), 80, 30, new Color(163, 232, 253));
        this.cloud_right = new Cloud(new Dot(500, 115), 60, 25, new Color(163, 232, 253));
        this.mountain = new Mountain();
        this.bird = new Bird(new Color(0, 0, 0));
        setBackground(Color.white);
        ImageIcon moIMg = MomoFace.HelloAjMo();
        JLabel mo = new JLabel(moIMg);
        add(mo);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) bf.createGraphics();
        Color backgroudColor = new Color(81, 128, 151, 255);

        g2d.setColor(backgroudColor);
        g2d.fillRect(0, 0, getParent().getWidth(), getParent().getHeight());

        cloud_left.drawCloud(g2d);
        cloud_right.drawCloud(g2d);

        bird.drawBird(g2d, new Dot(50, 50), 50); // left bird
        bird.drawBird(g2d, new Dot(280, 40), 100); // mid bird
        bird.drawBird(g2d, new Dot(520, 80), 50); // right bird

        mountain.drawMountain(g2d, new Dot(0, 499), new Dot(599, 499), new Dot(300, 360), 30, Color.GREEN,
                new Color(81, 128, 151, 255));
        // mountain.drawMountain(g2d, new Dot(200, 500), new Dot(500, 500), new Dot(400,
        // 480), 100, Color.GREEN,
        // Color.WHITE);
        // mountain.drawMountain(g2d, new Dot(500, 500), new Dot(600, 500), new Dot(550,
        // 460), 100, Color.GREEN,
        // Color.WHITE);

        sun.drawSun(g2d, new Dot(280, 250), 300, 0, 14, 0, new Color(253, 190, 66), new Color(81, 128, 151, 255));
        sun.drawSun(g2d, new Dot(280, 250), 250, 0, 14, 0, new Color(251, 241, 133), new Color(253, 190, 66));
        sun.drawSun(g2d, new Dot(280, 250), 200, 0, 14, 0, new Color(253, 190, 66), new Color(251, 241, 133));

        g.drawImage(bf, 0, 0, null);
        super.paintComponent(g2d);
    }
}
