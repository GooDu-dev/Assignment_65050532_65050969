import java.awt.Graphics;

import javax.swing.JLabel;

public class Sun extends JLabel{
 CustomDrawing customDrawing = new CustomDrawing();
 Dot[][] sun = {
  new Dot[]{
   new Dot(50, 200),
   new Dot(250, 100),
   new Dot(50, 400),
  },
  new Dot[]{
   new Dot(50, 400),
   new Dot(500, 200),
   new Dot(50, 600),
  },
 };
 
 public void drawSun(Graphics g){
  for(int i = 0; i < sun.length; i++){
   customDrawing.drawCurve(g, sun[i]);
  }
 }

 @Override
 public void paintComponent(Graphics g){
  drawSun(g);
 }
}
