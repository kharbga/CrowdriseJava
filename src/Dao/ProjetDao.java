/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Idao.IDAO;
import entities.Projet;
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
 * @author kouki
 */
public class ProjetDao implements IDAO<Projet> {
    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    private final Connection connection;
    private PreparedStatement pst;

    public ProjetDao() {
        //initialiser la connection
        connection = DataSource.getInstance().getConnection();

    }

    @Override
    public void add(Projet p) {
        String req = "insert into Projet (titre,description,type_financement,date_projet,deadline_projet,idcat_id,membre_id) values (?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, p.getTitre());
            pst.setString(2, p.getDescription());
            pst.setString(3, p.getTypeFinancement());
            pst.setDate(4, p.getDateProjet());
            pst.setDate(5, p.getDeadlineProjet());
//            pst.setString(6, p.getFichierProjet());
//            pst.setString(7, p.getImageProjet());
//            pst.setString(8, p.getVideoProjet());
            pst.setInt(9, p.getIdcat());
            pst.setInt(10, p.getMembreId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Projet p) {
        String req = "UPDATE Projet SET titre = ? , description= ? , type_financement= ? , date_projet= ? , deadline_projet= ? , fichierProjet= ? ,imageProjet= ? , Video_Projet= ? ,idcat_id= ? , membre_id= ? WHERE id_projet =? ";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, p.getTitre());
            pst.setString(2, p.getDescription());
            pst.setString(3, p.getTypeFinancement());
            pst.setDate(4, p.getDateProjet());
            pst.setDate(5, p.getDeadlineProjet());
            pst.setString(6, p.getFichierProjet());
            pst.setString(7, p.getImageProjet());
            pst.setString(8, p.getVideoProjet());
            pst.setInt(9, p.getIdcat());
            pst.setInt(10, p.getMembreId());
            pst.setInt(11, p.getIdProjet());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int id) {
        String requete = "delete from Projet where id_projet=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public List<Projet> findAll() {
        List<Projet> projetList = new ArrayList<Projet>();

        String req = "SELECT * FROM  Projet ";

        ResultSet rs;

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery(req);

            Projet pr;

            while (rs.next()) {
                pr = new Projet(
                        rs.getInt("id_projet"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getString("type_financement"),
                        rs.getDate("date_projet"),
                        rs.getDate("deadline_projet"),
                        rs.getString("fichierProjet"),
                        rs.getInt("Membre_id"),
                        rs.getString("imageProjet"),
                        rs.getString("video_projet"),
                        rs.getInt("idcat_id")
                );
                projetList.add(pr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return projetList;
    }

    @Override
    public Projet findById(int id) {
        Projet p = new Projet();
        String requete = "select titre,description,type_financement,date_projet,deadline_projet,fichierProjet,imageProjet,Video_Projet,idcat_id,membre_id from Projet where id_projet=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {

                p.setTitre(resultat.getString(1));
                p.setDescription(resultat.getString(2));
                p.setTypeFinancement(resultat.getString(3));
                
                p.setDateProjet(resultat.getDate(4));
                p.setDeadlineProjet(resultat.getDate(5));
                p.setFichierProjet(resultat.getString(6));
                p.setImageProjet(resultat.getString(7));
                p.setVideoProjet(resultat.getString(8));
                p.setIdcat(resultat.getInt(9));
                p.setMembreId(resultat.getInt(10));
                
            
            
            }
            return p;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'un Projet " + ex.getMessage());
            return null;
        }
        
    }

    @Override
    public List<Projet> findByTitre(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Projet> findByCriteria(String titre, Date deadLine, String categ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}