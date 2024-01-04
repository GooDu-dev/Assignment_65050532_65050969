package asset;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MomoFace {
    private static final int WIDTH = 100, HEIGHT = 100;

    public static ImageIcon HelloAjMo() {
        try {
            File file = new File("./public/MomoFace.png");
            if (!file.exists()) {
                return null;
            }

            BufferedImage originalImage = ImageIO.read(file);
            Image resized = originalImage.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
            BufferedImage newImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d = newImage.createGraphics();
            g2d.drawImage(resized, 0, 0, null);

            return new ImageIcon(newImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}