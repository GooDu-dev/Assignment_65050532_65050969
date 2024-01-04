import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import asset.Picture;

public class App extends JFrame {
    static final int WIDTH = 600, HEIGHT = 600;
    static Picture picture;
    static BufferedImage buffer;

    public App(String title) {
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        buffer = new BufferedImage(WIDTH + 1, HEIGHT + 1, BufferedImage.TYPE_INT_ARGB);
        picture = new Picture(buffer);
        picture.setPreferredSize(getPreferredSize());
    }

    public void draw() {
        this.getContentPane().add(picture);
    }
}
