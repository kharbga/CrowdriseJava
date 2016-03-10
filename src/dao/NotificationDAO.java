/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Idao.IDAO;
import entities.Notification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Sedki
 */
public class NotificationDAO implements IDAO<Notification> {

    private Connection connection;
    private PreparedStatement pst ;
    private List<Notification> listeNotification = new ArrayList<>();

    public List<Notification> getListeNotification() {
        return listeNotification;
    }

    public NotificationDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    
    

    @Override
    public void add(Notification t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Notification t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Notification> findAll() {
        
        Notification n = new Notification();

        try {
            String req = "select * from notification";
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                n = new Notification();
                n.setId(rs.getInt(1));
                n.setProducer(rs.getString(2));
                n.setReceiver(rs.getString(3));
                n.setMessage(rs.getString(4));
                listeNotification.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            


        return listeNotification;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Notification findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
