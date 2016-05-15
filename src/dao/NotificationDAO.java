/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Idao.IDAO;
import entities.Notification;
import entities.Profil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.DataSource;
import java.util.Date;

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
        String req = "insert into notification (Producer, Receiver, Message) values (?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, t.getProducer());
            pst.setString(2, t.getReceiver());
            pst.setString(3, t.getMessage());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Notification p) {
        String req = "UPDATE notification SET Producer = ?, Receiver = ?, Message = ? WHERE id = ? ";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, p.getProducer());
            pst.setString(2, p.getReceiver());
            pst.setString(3, p.getMessage());
            pst.setInt(4, p.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int id) {
        String requete = "delete from notification where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Notification supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
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
        Notification p = new Notification();
        String requete = "select id, Producer, Receiver, Message from notification where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                p.setId(resultat.getInt(1));
                p.setProducer(resultat.getString(2));
                p.setReceiver(resultat.getString(3));
                p.setMessage(resultat.getString(4));
            }
            return p;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'une notification " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Notification> findByTitre(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Notification> findByCriteria(String titre, Date deadLine, String categ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
