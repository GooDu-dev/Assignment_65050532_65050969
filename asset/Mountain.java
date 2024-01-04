package asset;

import java.awt.Color;
import java.awt.Graphics;

import asset.draw.CustomDrawing;
import asset.draw.Dot;

import asset.draw.Fill;

public class Mountain {

  private Color color;

  public Mountain(Color color) {
    this.color = color;
  }

  public void drawMountain(Graphics g, Dot startPoint, Dot endPoint, Dot curvePoint, int height) {
    CustomDrawing customDrawing = new CustomDrawing();

    g.setColor(color);

    customDrawing.drawCurve(g, new Dot[] {
        startPoint, curvePoint, endPoint
    });
    customDrawing.drawLine(g, startPoint, new Dot(startPoint.getX(), startPoint.getY() + height), 1);
    customDrawing.drawLine(g, endPoint,
        new Dot(endPoint.getX(), endPoint.getY() + (startPoint.getY() - endPoint.getY())),
        1);
    customDrawing.drawLine(g, startPoint,
        new Dot(endPoint.getX(), endPoint.getY() + (startPoint.getY() - endPoint.getY())), 1);
    fill(g, new Dot(startPoint.getX(), startPoint.getY() - 1), Color.white);
  }

  public void fill(Graphics g, Dot center, Color targetrColor) {
    Picture.bf = Fill.FloodFill(g, center, targetrColor, color);
  }
}
