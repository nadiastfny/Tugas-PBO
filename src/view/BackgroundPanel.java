/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{

     Image bgimage = null;
 
      BackgroundPanel() {
        MediaTracker mt = new MediaTracker(this);
        bgimage = Toolkit.getDefaultToolkit().getImage("view/gambar/background.jpg");
        mt.addImage(bgimage, 0);
        try {
          mt.waitForAll();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
 
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setOpaque(false);
        int imwidth = bgimage.getWidth(null);
        int imheight = bgimage.getHeight(null);
        g.drawImage(bgimage, 1, 1, null);
      }
}

