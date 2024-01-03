package asset;

import java.awt.Graphics;

import asset.draw.CustomDrawing;
import asset.draw.Dot;

public class Bird {
 public void drawBird(Graphics g, Dot startPoint, int size){
  CustomDrawing customDrawing = new CustomDrawing();

  customDrawing.drawCurve(g, new Dot[]{
   startPoint,
   new Dot(startPoint.getX() + (size / 2), startPoint.getY()),
   new Dot(startPoint.getX() + 10, startPoint.getY())
  });
 }
}
