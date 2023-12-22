import javax.swing.JFrame;

import asset.Cloud;
import asset.Picture;
import asset.Sun;

public class App extends JFrame {
    static final int WIDTH = 800, HEIGHT = 600;

    public App(String title) {
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void draw() {
        Picture p = new Picture();
        this.getContentPane().add(p);
    }
}
