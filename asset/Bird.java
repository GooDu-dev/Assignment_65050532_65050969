package asset;

import java.awt.Graphics;

import asset.draw.CustomDrawing;
import asset.draw.Dot;

public class Bird {
 public void drawBird(Graphics g, Dot startPoint, int size){
  CustomDrawing customDrawing = new CustomDrawing();

  customDrawing.drawCurve(g, new Dot[]{
   startPoint,
   new Dot(startPoint.getX() + (size / 4), startPoint.getY() - (size / 6)),
   new Dot(startPoint.getX() + (size / 2), startPoint.getY())
  });

  customDrawing.drawCurve(g, new Dot[]{
   new Dot(startPoint.getX() + (size / 2), startPoint.getY()),
   new Dot((startPoint.getX() / 2) + size, startPoint.getY() - (size / 6)),
   new Dot(startPoint.getX() + ((size * 2) / 2), startPoint.getY())
  });

  customDrawing.drawLine(g, new Dot(startPoint.getX() + (size / 2) - (size / 4), startPoint.getY()), new Dot(startPoint.getX() + (size / 2) + (size / 4), startPoint.getY()), 1);
 }
}
