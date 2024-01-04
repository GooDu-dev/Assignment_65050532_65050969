package asset.draw;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.Queue;

import asset.Picture;

public class Fill {
    // public void floodFill(Graphics g, int x, int y, Color newColor, Color
    // boundColor) {
    // int canvasWidth = ((Graphics2D)
    // g).getDeviceConfiguration().getBounds().width;
    // int canvasHeight = ((Graphics2D)
    // g).getDeviceConfiguration().getBounds().height;
    // Queue<Point> queue = new LinkedList<>();
    // CustomDrawing cd = new CustomDrawing();
    // queue.add(new Point(x, y));

    // g.setColor(newColor);

    // while (!queue.isEmpty()) {
    // Point current = queue.poll();
    // int currentX = current.x;
    // int currentY = current.y;

    // if (currentX < 0 || currentX >= canvasWidth || currentY < 0 || currentY >=
    // canvasHeight) {
    // continue;
    // }

    // Color pixelColor = null;

    // try {
    // Robot r = new Robot();

    // pixelColor = r.getPixelColor(currentX, currentY);
    // } catch (Exception evt) {
    // System.err.println(evt.getMessage());
    // }

    // if (!pixelColor.equals(boundColor)) {
    // continue;
    // }

    // cd.plot(g, currentX, currentY, 20);

    // queue.add(new Point(currentX + 20, currentY));
    // queue.add(new Point(currentX - 20, currentY));
    // queue.add(new Point(currentX, currentY + 20));
    // queue.add(new Point(currentX, currentY - 20));

    // System.err.println("Still working");
    // }
    // }

    public BufferedImage FloodFill(Graphics g2d, Dot center, Color targetColor, Color replacementColor) {
        // targetColor = Color before fill
        // replacementColor = Color after fill
        Queue<Dot> queue = new LinkedList<Dot>();
        int x = center.getX(), y = center.getY();
        CustomDrawing cd = new CustomDrawing();
        System.out.println("current : " + Picture.bf.getRGB(x, y));
        System.out.println("target : " + targetColor.getRGB() + " Color : " + targetColor);
        System.out.println("replacementColor : " + replacementColor.getRGB() + " Color : " + replacementColor);
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
            System.out.println(queue.size() + " | " + current);
        }
        return Picture.bf;
    }
}