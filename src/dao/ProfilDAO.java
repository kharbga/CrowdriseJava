/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Idao.IDAO;
import entities.Profil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;


/**
 *
 * @author Sedki
 */
public class ProfilDAO implements IDAO<Profil>{

    private Connection connection;
    private PreparedStatement pst ;

    public ProfilDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    
    @Override
    public void add(Profil t) {
        try {
            String req = "insert into profil (Nom, Prenom, Date_de_naissance, Pseudo, Image, Adresse, Profession) values (?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setDate(3, new java.sql.Date(t.getDateNaissance().getTime()));
            pst.setString(4, t.getPseudo());
            pst.setString(5, t.getImage());
            pst.setString(6, t.getAdresse());
            pst.setString(7, t.getProfession());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

            
        
    }

    @Override
    public void update(Profil t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profil> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profil findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
