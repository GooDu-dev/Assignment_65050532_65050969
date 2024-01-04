package asset.draw;

import javax.swing.JLabel;
import java.awt.Graphics;

public class CustomDrawing extends JLabel {
    public void drawLine(Graphics g, Dot start, Dot dest, int size) {
        int dx = Math.abs(dest.x - start.x);
        int dy = Math.abs(dest.y - start.y);
        int sx = (start.x < dest.x) ? 1 : -1;
        int sy = (start.y < dest.y) ? 1 : -1;

        int err = dx - dy;

        while (!(start.x == dest.x && start.y == dest.y)) {
            plot(g, start.x, start.y, size);

            int err2 = 2 * err;
            if (err2 > -dy) {
                err -= dy;
                start.x += sx;
            }
            if (err2 < dx) {
                err += dx;
                start.y += sy;
            }
        }
    }

    public void drawTriangle(Graphics g, Dot d1, Dot d2, Dot d3) {
        g.fillPolygon(
                new int[] { d1.x, d2.x, d3.x },
                new int[] { d1.y, d2.y, d3.y },
                3);
    }

    public void drawCurve(Graphics g, Dot[] dots) {
        int n = dots.length - 1;

        for (double t = 0.0; t <= 1.0; t += 0.00001) {
            double x = 0.0, y = 0.0;
            for (int i = 0; i <= n; i++) {
                // Calculate Bernstein polynomial directly within the loop
                double b = choose(n, i) * Math.pow(t, i) * Math.pow(1 - t, n - i);
                x += dots[i].x * b;
                y += dots[i].y * b;
            }

            g.drawLine((int) x, (int) y, (int) x, (int) y);
        }
    }

    // Binomial coefficient calculation
    private int choose(int n, int i) {
        // Factorial calculation within choose
        int nFact = 1;
        for (int j = 2; j <= n; j++) {
            nFact *= j;
        }
        int iFact = 1;
        for (int j = 2; j <= i; j++) {
            iFact *= j;
        }
        int niFact = 1;
        for (int j = 2; j <= n - i; j++) {
            niFact *= j;
        }
        return nFact / (iFact * niFact);
    }

    public void drawCircle(Graphics g, Dot center, int radius) {
        int x = 0;
        int y = radius;
        int d = 3 - 2 * radius;
        while (y >= x) {
            plotCircle(g, center, x, y);
            x++;
            if (d > 0) {
                y--;
                d = d + 4 * (x - y) + 10;
            } else {
                d = d + 4 * x + 6;
            }
            plotCircle(g, center, x, y);
        }
    }

    private void plotCircle(Graphics g, Dot center, int x, int y) {
        plot(g, center.getX() + x, center.getY() + y, 1);
        plot(g, center.getX() + x, center.getY() - y, 1);
        plot(g, center.getX() - x, center.getY() + y, 1);
        plot(g, center.getX() - x, center.getY() - y, 1);
        plot(g, center.getX() + y, center.getY() + x, 1);
        plot(g, center.getX() + y, center.getY() - x, 1);
        plot(g, center.getX() - y, center.getY() + x, 1);
        plot(g, center.getX() - y, center.getY() - x, 1);
    }

    public void drawOval(Graphics g, Dot center, int rx, int ry) {

        float dx, dy, d1, d2;
        int x, y;
        x = 0;
        y = ry;

        d1 = (ry * ry) - (rx * rx * ry) +
                (0.25f * rx * rx);
        dx = 2 * ry * ry * x;
        dy = 2 * rx * rx * y;

        while (dx < dy) {
            plotOval(g, center, x, y);
            if (d1 < 0) {
                x++;
                dx = dx + (2 * ry * ry);
                d1 = d1 + dx + (ry * ry);
            } else {
                x++;
                y--;
                dx = dx + (2 * ry * ry);
                dy = dy - (2 * rx * rx);
                d1 = d1 + dx - dy + (ry * ry);
            }
        }

        d2 = ((ry * ry) * ((x + 0.5f) * (x + 0.5f)))
                + ((rx * rx) * ((y - 1) * (y - 1)))
                - (rx * rx * ry * ry);

        while (y >= 0) {
            plotOval(g, center, x, y);
            if (d2 > 0) {
                y--;
                dy = dy - (2 * rx * rx);
                d2 = d2 + (rx * rx) - dy;
            } else {
                y--;
                x++;
                dx = dx + (2 * ry * ry);
                dy = dy - (2 * rx * rx);
                d2 = d2 + dx - dy + (rx * rx);
            }
        }
    }

    private void plotOval(Graphics g, Dot center, int x, int y) {
        plot(g, center.getX() + x, center.getY() + y, 1);
        plot(g, center.getX() + x, center.getY() - y, 1);
        plot(g, center.getX() - x, center.getY() + y, 1);
        plot(g, center.getX() - x, center.getY() - y, 1);
    }

    public void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}
