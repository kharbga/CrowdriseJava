package DAO;

import Idao.IDAO;
import entities.Solution;
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
 * @author Rayhana
 */
public class SolutionDao implements IDAO<Solution> {

    private Connection connection;
    private PreparedStatement pst;

    public SolutionDao() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Solution t) {
        String req = "insert into solution (id_probleme,titre,salaire,description,membre_id,etat) values (" + 1 + ",?,?,?," + 2 + ",?)";
        try {
            pst = connection.prepareStatement(req);

            pst.setString(1, t.getTitre());
            pst.setDouble(2, t.getSalaire());
            pst.setString(3, t.getDescription());
            pst.setString(4, t.getEtat());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateFichierSolution(Solution t, String file, int id) {
        String req = "UPDATE solution SET fichier_solution = ? WHERE id_solution=" + id;
        try {
            pst = connection.prepareStatement(req);

            pst.setString(1, t.getFichierSolution());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Solution t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(int id) {
        String req = "delete from solution WHERE id_solution=?";
        try {
            pst = connection.prepareStatement(req);

            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erreur de suppression " + ex.getMessage());
        }
    }

    public List<Solution> getAllAcceptedProblems() {

        List<Solution> listeProblems = new ArrayList<>();
        Solution p = new Solution();
        try {
            pst = connection.prepareStatement("SELECT s.titre,s.description,s.id_solution,s.id_probleme,s.Membre_id,p.titre FROM solution s, probleme p where s.id_probleme = p.id_probleme and s.etat='Acceptee' ");
            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {
                p.setTitre(resultat.getString(1));
                p.setDescription(resultat.getString(2));
                p.setIdSolution(resultat.getInt(3));

                listeProblems.add(p);
                p = new Solution();
            }

        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeProblems;
    }

    public ArrayList<Solution> getDataSolution(String i) {
        ArrayList<Solution> list = new ArrayList<Solution>();
        Solution p = new Solution();

        try {
            String req = "SELECT s.titre,s.description,s.id_solution,s.id_probleme,s.Membre_id,p.titre FROM solution s, probleme p where s.id_probleme = p.id_probleme and s.etat='Acceptee' and p.titre=?";
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setString(1, i);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                p.setTitre(resultat.getString(1));
                p.setDescription(resultat.getString(2));
                p.setSalaire(resultat.getDouble(3));
                p.setEtat(resultat.getString(4));
                p.setIdSolution(resultat.getInt(5));
                list.add(p);
                p = new Solution();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Solution> findAll() {
        List<Solution> listePersonne = new ArrayList<>();
        Solution p = new Solution();

        try {
            String req = "select titre,description,salaire,etat,id_solution from solution";
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                p.setTitre(resultat.getString(1));
                p.setDescription(resultat.getString(2));
                p.setSalaire(resultat.getDouble(3));
                p.setEtat(resultat.getString(4));
                p.setIdSolution(resultat.getInt(5));
                listePersonne.add(p);
                p = new Solution();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listePersonne;
    }

    @Override
    public Solution findById(int id) {
        Solution p = new Solution();
        String req = "select titre,description,salaire,etat,id_solution from solution where id_solution=?";
        try {

            PreparedStatement pst = connection.prepareStatement(req);

            pst.setInt(1, id);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                p.setTitre(resultat.getString(1));
                p.setDescription(resultat.getString(2));
                p.setSalaire(resultat.getDouble(3));
                p.setEtat(resultat.getString(4));
                p.setIdSolution(resultat.getInt(5));

            }
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public void updateSolution(int id, Solution t) {
        String req = "UPDATE solution SET titre = ?,description = ? WHERE id_solution =?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(3, id);

            pst.setString(1, t.getTitre());
            pst.setString(2, t.getDescription());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getAllProbleme() {
        try {
            pst = connection.prepareStatement("SELECT id_probleme,titre FROM probleme");

            ResultSet allProb = pst.executeQuery();
            return allProb;
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getAcceptedProblems() {
        try {
            pst = connection.prepareStatement("SELECT s.titre,s.description,s.id_solution,s.id_probleme,s.Membre_id,p.titre FROM solution s, probleme p where s.id_probleme = p.id_probleme and s.etat='Acceptee' ");

            ResultSet allProb = pst.executeQuery();
            return allProb;
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Solution> getAllSolution(int id) {
        List<Solution> listePersonne = new ArrayList<>();
        Solution p = new Solution();

        try {
            String req = "SELECT id_probleme,id_solution,Membre_id,titre,description FROM solution where id_probleme=?";
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {
                p.setTitre(resultat.getString(1));
                p.setDescription(resultat.getString(2));
                p.setSalaire(resultat.getDouble(3));
                p.setEtat(resultat.getString(4));
                p.setIdSolution(resultat.getInt(5));
                listePersonne.add(p);
                p = new Solution();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listePersonne;
    }

    public String getTitleProblemByID(int i) {
        
        String s ="";
        try {
            String req = ("SELECT titre FROM probleme p where id_probleme=?");
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1, i);
            ResultSet resultat = pst.executeQuery();
            s = resultat.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}
