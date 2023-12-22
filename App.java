import javax.swing.JFrame;

public class App extends JFrame {
    static final int WIDTH = 600, HEIGHT = 600;

    public App(String title) {
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void draw() {
        Sun s = new Sun();
        add(s);
        Cloud c = new Cloud();
        add(c);
    }
}
