/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Idao.IDAO;
import entities.Membre;
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
 * @author kouki
 */
public class MembreDao implements IDAO<Membre> {

    private final Connection connection;
    private PreparedStatement pst;

    public MembreDao() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Membre p) {
        String req = "insert into Membre (nom,prenom,username,password,roles,email,etat) values (?,?,?,?,?,?,1)";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getUsername());
            pst.setString(4, p.getPassword());
            pst.setString(5, p.getRoles());
            pst.setString(6, p.getEmail());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Membre p) {
        String req = "UPDATE Projet SET nom = ? , prenom= ? , username= ? , password= ? , roles= ? , email = ?  WHERE id =? ";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getUsername());
            pst.setString(4, p.getPassword());
            pst.setString(5, p.getRoles());
            pst.setString(6, p.getEmail());
            pst.setInt(7, p.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int id) {
        String requete = "delete from Membre where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public List<Membre> findAll() {
        List<Membre> projetList = new ArrayList<Membre>();

        String req = "SELECT id,username,password,roles,prenom,nom,email,etat FROM  Membre ";

        ResultSet rs;

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery(req);

            Membre m;

            while (rs.next()) {
                m = new Membre(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("roles"),
                        rs.getString("email"),
                        rs.getInt("etat")
                );
                projetList.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return projetList;
    }

    @Override
    public Membre findById(int id) {
        Membre m = new Membre();
        String requete = "select id,username,password,roles,prenom,nom,email,etat FROM  Membre where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                m.setId(resultat.getInt(1));
                m.setUsername(resultat.getString(2));
                m.setPassword(resultat.getString(3));
                m.setRoles(resultat.getString(4));
                m.setPrenom(resultat.getString(5));
                m.setNom(resultat.getString(6));
                m.setEmail(resultat.getString(7));
                m.setEtat(resultat.getInt(8));

            }
            return m;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'un Membre " + ex.getMessage());
            return null;
        }

    }

    public boolean verifLogin(Membre user) {

        String query = "select * from Membre where username=? and password=?";

        ResultSet res;
        try {
            pst = connection.prepareStatement(query);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            res = pst.executeQuery();
            if (res.next()) {
                return true;
            }
            pst.close();
            res.close();

        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    public void updateEtat(Membre p) {
        String req = "UPDATE Membre SET etat = ?  WHERE id =? ";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1, p.getEtat());
            pst.setInt(2, p.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Membre findBylogs(Membre user) {
        Membre m = new Membre();
        String requete = "select id,username,password,roles,prenom,nom,email,etat FROM  Membre where username=? and password=?";
        try {
            pst = connection.prepareStatement(requete);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                m.setId(resultat.getInt(1));
                m.setUsername(resultat.getString(2));
                m.setPassword(resultat.getString(3));
                m.setRoles(resultat.getString(4));
                m.setPrenom(resultat.getString(5));
                m.setNom(resultat.getString(6));
                m.setEmail(resultat.getString(7));
                m.setEtat(resultat.getInt(8));
            }
            return m;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'un Membre " + ex.getMessage());
            return null;
        }

    }
}
