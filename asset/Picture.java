package asset;

import java.awt.Graphics;

import javax.swing.JLabel;

import asset.draw.Dot;

public class Picture extends JLabel{
 Sun sun = new Sun();
 Cloud cloud = new Cloud();

 @Override
 public void paintComponent(Graphics g){
  super.paintComponent(g);
  sun.drawSun(g, new Dot(10, 10));
  cloud.draw(g);
 }

 private Dot Dot(int i, int j) {
  return null;
 }
}
