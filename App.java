import javax.swing.JFrame;

public class App extends JFrame {
    static final int WIDTH = 800, HEIGHT = 600;

    public App(String title) {
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void draw() {
        Sun s = new Sun();
        Cloud c = new Cloud();

        add(s);
        add(c);
    }
}
