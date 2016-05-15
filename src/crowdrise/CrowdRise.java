/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdrise;


import GUI.JProfil;
import dao.NotificationDAO;
import dao.ProfilDAO;
import entities.Profil;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.DefaultFullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;


/**
 *
 * @author kouki
 */
public class CrowdRise {

    public static void main(String[] args) {

    
      JFrame f = new JFrame();
      f.setLocation(100,100);
      f.setSize(1000, 600);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setVisible(true);
       
       
       Canvas c = new Canvas();
       c.setBackground(Color.black);
       JPanel p = new JPanel();
       p.setLayout(new BorderLayout());
              p.add(c);
              f.add(p);
              
       NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"C:/Program Files/VideoLAN/VLC" );
       Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
       
       MediaPlayerFactory mdf = new MediaPlayerFactory();
       
       // control all the interactions with the user
       FullScreenStrategy fullScreenStrategy = new DefaultFullScreenStrategy(f);
        EmbeddedMediaPlayer emp = mdf.newEmbeddedMediaPlayer(fullScreenStrategy);
       emp.setVideoSurface(mdf.newVideoSurface(c));
       
      emp.toggleFullScreen();
      emp.setEnableMouseInputHandling(true);
      emp.setEnableKeyInputHandling(true);
      
      
      String file="crowdsourcing-and-crowdfunding-explained.mp4";
      
      emp.prepareMedia(file);
      emp.play();
    }

}
