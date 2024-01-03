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
        if (dots.length < 2)
            return;
    
        int n = dots.length - 1;
        int[] x = new int[dots.length];
        int[] y = new int[dots.length];
    
        for (double t = 0.0; t <= 1.0; t += 0.00000001) {
            for (int i = 0; i < dots.length; i++) {
                x[i] = dots[i].getX();
                y[i] = dots[i].getY();
            }
    
            for (int k = 1; k <= n; k++) {
                for (int i = 0; i <= n - k; i++) {
                    x[i] = (int) ((1 - t) * x[i] + t * x[i + 1]);
                    y[i] = (int) ((1 - t) * y[i] + t * y[i + 1]);
                }
            }
    
            g.drawLine(x[0], y[0], x[0], y[0]);
        }
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

    // public void drawOval(Graphics g, Dot center, int radiusA, int radiusB) {
    // int x = 0;
    // int y = radiusB;
    // long radiusASquare = radiusA * radiusB;
    // long radiusBSquare = radiusA * radiusB;
    // long twoASquare = 2 * radiusASquare;
    // long twoBSquare = 2 * radiusBSquare;
    // long xChange = radiusBSquare * (1 - 2 * radiusA) + radiusASquare;
    // long yChange = radiusBSquare - radiusBSquare * (2 * radiusB + 1);
    // while (radiusASquare * y >= radiusBSquare * x) {
    // plotOval(g, center, x, y);

    // x++;
    // if (xChange < 0) {
    // xChange += twoBSquare * x + radiusBSquare;
    // } else {
    // y--;
    // xChange += twoBSquare * x + radiusBSquare - twoASquare * y;
    // yChange -= twoASquare * y - radiusASquare;
    // }
    // }
    // x = radiusA;
    // y = 0;
    // xChange = radiusBSquare - radiusASquare * (2 * radiusB + 1);
    // yChange = radiusASquare * (1 - 2 * radiusB) + radiusBSquare;

    // while (radiusASquare * y <= radiusBSquare * x) {
    // plotOval(g, center, x, y);

    // y++;
    // if (yChange < 0) {
    // yChange += twoASquare * y + radiusASquare;
    // } else {
    // x--;
    // yChange += twoASquare * y + radiusASquare - twoBSquare * x;
    // xChange -= twoBSquare * x - radiusBSquare;
    // }
    // }
    // }

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
