package GUI;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author asalhi
 */
public class JFrameMap extends javax.swing.JFrame {

    public static final int MIN_ZOOM = 0;
    public static final int MAX_ZOOM = 21;
    public static Browser browser;
    public static JPanel toolBar;
    public static JButton setMarkerButton;
    public static JButton zoomOutButton;
    public static JButton zoomInButton;
    /**
     * In map.html file default zoom value is set to 10.
     */
    public static int zoomValue = 10;

    public JFrameMap() {
        browser = new Browser();
        BrowserView browserView = new BrowserView(browser);

         
        browser.loadURL("C:\\Users\\asalhi\\Documents\\NetBeansProjects\\JavaPidevCrowdrise\\src\\Utils\\map.html");

        zoomInButton = new JButton("Zoom In");

        zoomOutButton = new JButton("Zoom Out");

        setMarkerButton = new JButton("Set Marker");

        zoomInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zoomValue < MAX_ZOOM) {
                    browser.executeJavaScript("map.setZoom(" + ++zoomValue + ")");
                }
            }
        });

        //zoomOutButton = new JButton("Zoom Out");
        zoomOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zoomValue > MIN_ZOOM) {
                    browser.executeJavaScript("map.setZoom(" + --zoomValue + ")");
                }
            }
        });

        // setMarkerButton = new JButton("Set Marker");
        setMarkerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                browser.executeJavaScript("var myLatlng = new google.maps.LatLng(36.8984821,10.189761900000008);\n"
                        + "var marker = new google.maps.Marker({\n"
                        + "    position: myLatlng,\n"
                        + "    map: map,\n"
                        + "    title: 'Welcome to ESPRIT!'\n"
                        + "});");
            }
        });

        toolBar = new JPanel();
        toolBar.add(zoomInButton);
        toolBar.add(zoomOutButton);
        toolBar.add(setMarkerButton);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(toolBar, BorderLayout.SOUTH);
        add(browserView, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
       
        setBounds(500, 350, 500, 500);
        setTitle("Géolocalisation ESPRIT- TUNISIE");
    }

    public static void main(String[] args) {

        
        zoomInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zoomValue < MAX_ZOOM) {
                    browser.executeJavaScript("map.setZoom(" + ++zoomValue + ")");
                }
            }
        });

       
        zoomOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zoomValue > MIN_ZOOM) {
                    browser.executeJavaScript("map.setZoom(" + --zoomValue + ")");
                }
            }
        });

        
        setMarkerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                browser.executeJavaScript("var myLatlng = new google.maps.LatLng(36.8984821,10.189761900000008);\n"
                        + "var marker = new google.maps.Marker({\n"
                        + "    position: myLatlng,\n"
                        + "    map: map,\n"
                        + "    title: 'Welcome to ESPRIT!'\n"
                        + "});");
            }
        });

//        JFrame frame = new JFrame("Géolocalisation ESPRIT- TUNISIE");
//        browser.loadURL("C:\\Users\\asalhi\\Documents\\NetBeansProjects\\JavaPidevCrowdrise\\src\\Utils\\map.html");
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.add(toolBar, BorderLayout.SOUTH);
//        frame.add(browserView, BorderLayout.CENTER);
//
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
    }

}
