package asset;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import asset.draw.Dot;
<<<<<<< HEAD

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
=======

public class Picture extends JLabel {
    Sun sun = new Sun();
    Cloud cloud = new Cloud(new Dot(400, 500), 100, 50, Color.blue);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        sun.drawSun(g);
        cloud.draw(g);
    }
>>>>>>> cbe1039a7643335da9718c80bebe965655b1e1ce
}
