import javax.swing.JLabel;
import java.awt.Graphics;

public class CustomDrawing extends JLabel {
    private void drawLine(Graphics g, Dot start, Dot dest, int size) {
        int m = 2 * (dest.y - start.y);
        int slope_error = m - (dest.x - start.x);
        for (int x = start.x, y = start.y; x <= dest.x; x++) {
            plot(g, x, y, size);
            slope_error += m;
            if (slope_error >= 0) {
                y++;
                slope_error -= 2 * (dest.x - start.x);
            }
        }
    }

    private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }

    @Override
    protected void paintComponent(Graphics g) {
        drawLine(g, new Dot(5, 10), new Dot(600, 500), 10);
        super.paintComponent(g);
    }
}

class Dot {
    int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
