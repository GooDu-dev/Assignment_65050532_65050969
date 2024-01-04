package asset;

import java.awt.Color;
import java.awt.Graphics;

import asset.draw.CustomDrawing;
import asset.draw.Dot;
import asset.draw.Fill;

public class Mountain {
  public void drawMountain(Graphics g, Dot startPoint, Dot endPoint, Dot curvePoint, int height, Color color,
      Color fillIn) {
    CustomDrawing customDrawing = new CustomDrawing();

    g.setColor(color);

    customDrawing.drawCurve(g, new Dot[] {
        startPoint, curvePoint, endPoint
    });
    customDrawing.drawLine(g, startPoint, new Dot(startPoint.getX(), startPoint.getY() + height), 1);
    customDrawing.drawLine(g, endPoint,
        new Dot(endPoint.getX(), startPoint.getY() + height), 1);
    customDrawing.drawLine(g,
        new Dot(startPoint.getX(), startPoint.getY() + height),
        new Dot(endPoint.getX(), startPoint.getY() + height), 1);

    fill(g,
        new Dot(startPoint.getX() + 20, startPoint.getY() + 20),
        fillIn,
        color);
  }

  public void fill(Graphics g, Dot center, Color targetColor, Color replacementColor) {
    Picture.bf = Fill.FloodFill(g, center, targetColor, replacementColor);
  }
}
