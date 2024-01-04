package asset.draw;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.Queue;

import asset.Picture;

public class Fill {
    public static BufferedImage FloodFill(Graphics g2d, Dot center, Color targetColor, Color replacementColor) {
        // targetColor = Color before fill
        // replacementColor = Color after fill
        Queue<Dot> queue = new LinkedList<Dot>();
        int x = center.getX(), y = center.getY();
        CustomDrawing cd = new CustomDrawing();
        if (Picture.bf.getRGB(x, y) == targetColor.getRGB()) {
            g2d.setColor(replacementColor);
            cd.plot(g2d, x, y, 1);
            queue.add(center);
        }
        while (!queue.isEmpty()) {
            Dot current = queue.poll();
            // South
            if (current.getY() < 600 && Picture.bf.getRGB(current.getX(), current.getY() + 1) == targetColor.getRGB()) {
                cd.plot(g2d, current.getX(), current.getY() + 1, 1);
                queue.add(new Dot(current.getX(), current.getY() + 1));
            }
            // North
            if (current.getY() > 0 && Picture.bf.getRGB(current.getX(), current.getY() - 1) == targetColor.getRGB()) {
                cd.plot(g2d, current.getX(), current.getY() - 1, 1);
                queue.add(new Dot(current.getX(), current.getY() - 1));
            }
            // East
            if (current.getX() < 600 && Picture.bf.getRGB(current.getX() + 1, current.getY()) == targetColor.getRGB()) {
                cd.plot(g2d, current.getX() + 1, current.getY(), 1);
                queue.add(new Dot(current.getX() + 1, current.getY()));
            }
            // West
            if (current.getX() > 0 && Picture.bf.getRGB(current.getX() - 1, current.getY()) == targetColor.getRGB()) {
                cd.plot(g2d, current.getX() - 1, current.getY(), 1);
                queue.add(new Dot(current.getX() - 1, current.getY()));
            }
        }
        return Picture.bf;
    }
}