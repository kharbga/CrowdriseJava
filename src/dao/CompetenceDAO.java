package DAO;

import entities.Competence;
import Idao.IDAO;
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
public class CompetenceDAO  implements IDAO<Competence>{
    
    private Connection connection;
    private PreparedStatement pst ;
    private List<Competence> listeCompetence ;

    public CompetenceDAO() {
        connection = DataSource.getInstance().getConnection();
        listeCompetence = new ArrayList<>();
    }
    
    public List<Competence> getListeCompetence() {
        return listeCompetence;
    }
    
    @Override
    public void add(Competence  c) {
        String req = "insert into competence (idProfil, description,"
                + " nom) values (?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1, c.getIdProfil());
            pst.setString(2, c.getDescription());
            pst.setString(3, c.getNom());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompetenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Competence c) {
        String req = "UPDATE competence SET id = ?, idProfil = ?, "
                 + "description = ?, nom = ? "
                 + "WHERE id =? ";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1, c.getId());
            pst.setInt(2, c.getIdProfil());
            pst.setString(3, c.getDescription());
            pst.setString(4, c.getNom());
            pst.setInt(5, c.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompetenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int id) {
        String requete = "delete from competence where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Competence supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public List findAll() {
        try {
            String req = "select * from competence";
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Competence c = new Competence();
                c.setId(rs.getInt(1));
                c.setIdProfil(rs.getInt(2));
                c.setDescription(rs.getString(3));
                c.setNom(rs.getString(4));
                listeCompetence.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeCompetence ;
    }

    @Override
    public Competence findById(int id) {
        Competence c = new Competence();
        String requete = "select id, idProfil, description"
                + " nom  from competence where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                c.setId(resultat.getInt(1));
                c.setIdProfil(resultat.getInt(2));
                c.setDescription(resultat.getString(3));
                c.setNom(resultat.getString(4));
            }
            return c;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'une profil " + ex.getMessage());
            return null;
        }
    }    
    
    public List findAllById(int id) {
        String req = "select * from competence where idProfil = "+id;
        try {
            pst = connection.prepareStatement(req);
//          pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Competence c = new Competence();
                c.setId(rs.getInt(1));
                c.setIdProfil(rs.getInt(2));
                c.setDescription(rs.getString(3));
                c.setNom(rs.getString(4));
                listeCompetence.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompetenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeCompetence ;
    }

    @Override
    public List<Competence> findByTitre(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Competence> findByCriteria(String titre, Date deadLine, String categ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
