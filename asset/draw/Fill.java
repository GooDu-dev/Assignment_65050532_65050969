package asset.draw;

import java.awt.*;
import java.util.*;
import java.util.Queue;

public class Fill {
 public void floodFill(Graphics g, int x, int y, Color newColor, Color boundColor) {
        System.err.println(newColor);
        System.err.println(boundColor);


        int canvasWidth = ((Graphics2D) g).getDeviceConfiguration().getBounds().width;
        int canvasHeight = ((Graphics2D) g).getDeviceConfiguration().getBounds().height;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;

            if (currentX < 0 || currentX >= canvasWidth || currentY < 0 || currentY >= canvasHeight) {
                continue;
            }

            Color pixelColor = null;
            
            try {
                Robot r = new Robot();
 
                pixelColor = r.getPixelColor(x, y);
            }
            catch (Exception evt) {
                System.err.println(evt.getMessage());
            }

            if (!pixelColor.equals(boundColor)) {
                continue;
            }

            g.setColor(newColor);
            g.fillRect(currentX, currentY, 1, 1);

            queue.add(new Point(currentX + 1, currentY));
            queue.add(new Point(currentX - 1, currentY));
            queue.add(new Point(currentX, currentY + 1));
            queue.add(new Point(currentX, currentY - 1));

            System.err.println("Still working");
        }
    }
}
