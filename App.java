import javax.swing.JFrame;

import asset.Picture;

public class App extends JFrame {
    static final int WIDTH = 600, HEIGHT = 600;
    static Picture p = new Picture();

    public App(String title) {
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        p.setPreferredSize(getPreferredSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void draw() {
        this.getContentPane().add(p);
    }
}
