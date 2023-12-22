import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Graphics2D;

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

    private void drawTriangle(Graphics g, Dot d1, Dot d2, Dot d3) {
        g.fillPolygon(
            new int[] { d1.x, d2.x, d3.x },
            new int[] { d1.y, d2.y, d3.y },
        3);
    }

    private void drawCurve(Graphics g, Dot[] dots){
        if (dots.length < 2) return;
        int n = dots.length - 1;
        for (double t = 0.0; t <= 1.0; t += 0.0001) {
            int[] x = new int[dots.length];
            int[] y = new int[dots.length];

            for (int i = 0; i < dots.length; i++) {
                x[i] = dots[i].getX();
                y[i] = dots[i].getY();
            }

            for (int r = 1; r <= n; r++) {
                for (int i = 0; i <= n - r; i++) {
                    x[i] = (int) ((1 - t) * x[i] + t * x[i + 1]);
                    y[i] = (int) ((1 - t) * y[i] + t * y[i + 1]);
                }
            }

            g.drawLine(x[0], y[0], x[0], y[0]);
        }
    }

    private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // drawLine(g, new Dot(5, 10), new Dot(600, 500), 10);
        drawTriangle(g,
                new Dot(10, 200),
                new Dot(60, 100),
                new Dot(110, 100));
        drawCurve(g,
            new Dot[]{
                new Dot(50, 200),
                new Dot(150, 100),
                new Dot(250, 300),
                new Dot(350, 200)
            }
            
        );
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
