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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.DataSource;


/**
 *
 * @author Sedki
 */
public class ProfilDAO implements IDAO<Profil>{

    private Connection connection;
    private PreparedStatement pst ;
    private List<Profil> listeProfil ;

    public ProfilDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    
    @Override
    public void add(Profil t) {
        String req = "insert into profil (Nom, Prenom, Date_de_naissance,"
                + " Pseudo, Image, Adresse, Profession) values (?,?,?,?,?,?,?)";
        try {
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
    public void update(Profil p) {
         String req = "UPDATE profil SET Nom = ?, Prenom = ?, "
                 + "Date_de_naissance = ?, Pseudo = ?, Image = ?, "
                 + "Adresse = ?, Profession = ?"
                 + "WHERE id =? ";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setDate(3, new java.sql.Date(p.getDateNaissance().getTime()));
            pst.setString(4, p.getPseudo());
            pst.setString(5, p.getImage());
            pst.setString(6, p.getAdresse());
            pst.setString(7, p.getProfession());
            pst.setInt(8, p.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int id) {
        String requete = "delete from profil where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Profil supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public List<Profil> findAll() {
        try {
            String req = "select * from profil";
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Profil p = new Profil();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrenom(rs.getString(3));
                p.setDateNaissance(rs.getDate(4));
                p.setPseudo(rs.getString(5));
                p.setImage(rs.getString(6));
                p.setAdresse(rs.getString(7));
                p.setProfession(rs.getString(8));
                listeProfil.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeProfil ;
    }

    @Override
    public Profil findById(int id) {
        Profil p = new Profil();
        String requete = "select id, Nom, Prenom, Date_de_naissance, Pseudo,"
                + " Image, Adresse, Profession  from profil where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                p.setId(resultat.getInt(1));
                p.setNom(resultat.getString(2));
                p.setPrenom(resultat.getString(3));
                p.setDateNaissance(resultat.getDate(4));
                p.setPseudo(resultat.getString(5));
                p.setImage(resultat.getString(6));
                p.setAdresse(resultat.getString(7));
                p.setProfession(resultat.getString(8));
            }
            return p;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'une profil " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Profil> findByTitre(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profil> findByCriteria(String titre, Date deadLine, String categ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
