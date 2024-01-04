package asset;

import java.awt.Graphics;

import asset.draw.CustomDrawing;
import asset.draw.Dot;

public class Mountain {
 public void drawMountain(Graphics g, Dot startPoint, Dot endPoint, Dot curvePoint, int height) {
  CustomDrawing customDrawing = new CustomDrawing();

  customDrawing.drawCurve(g, new Dot[] {
    startPoint, curvePoint, endPoint
  });
  customDrawing.drawLine(g, startPoint, new Dot(startPoint.getX(), startPoint.getY() + height), 1);
  customDrawing.drawLine(g, endPoint, new Dot(endPoint.getX(), endPoint.getY() + (startPoint.getY() - endPoint.getY())),
    1);
  customDrawing.drawLine(g, startPoint,
    new Dot(endPoint.getX(), endPoint.getY() + (startPoint.getY() - endPoint.getY())), 1);
 }
}
