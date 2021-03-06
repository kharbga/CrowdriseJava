package DAO;

import Idao.IDAO;
import entities.Probleme;
import entities.Solution;
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
 * @author Rayhana
 */
public class SolutionDao implements IDAO<Solution> {

    private Connection connection;
    private PreparedStatement pst;

    public SolutionDao() {
        connection = DataSource.getInstance().getConnection();
    }

   
    public void addDemande(Solution t, int idProb,int idSolver) {
        String req = "insert into solution (id_probleme,titre,salaire,description,membre_id,etat) values (" + idProb + ",?,?,?," + idSolver + ",?)";
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

    public void updateFichierSolution(String file, int id) {
        String req = "UPDATE solution SET fichierSolution = ? WHERE id_solution=?";
        try {

            pst = connection.prepareStatement(req);
            pst.setString(1, file);
            pst.setInt(2, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Rayhana");
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
                p.setIdSolution(resultat.getInt(3));
                list.add(p);
                p = new Solution();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Solution> getDataSolutionSubmitter(String i, int id) {
        ArrayList<Solution> list = new ArrayList<Solution>();
        Solution p = new Solution();

        try {
            String req = "SELECT s.titre,s.description,s.id_solution,s.Membre_id FROM solution s, probleme p where s.id_probleme = p.id_probleme and s.etat='En attente' and p.titre=? and p.membre_id=?";
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setString(1, i);
            pst.setInt(2, id);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                p.setTitre(resultat.getString(1));
                p.setDescription(resultat.getString(2));
                p.setIdSolution(resultat.getInt(3));
                p.setMembreId(resultat.getInt(4));
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

    public List<Probleme> getAllProblems(int id) {
        
        List<Probleme> listeProbleme = new ArrayList<Probleme>();
        Probleme p = new Probleme();

        try {
            String req = "SELECT `id_probleme`, `titre`, `description`, `date_probleme`, `deadline_probleme` FROM `probleme` WHERE membre_id=?";
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {
                p.setIdProbleme(resultat.getInt(1));
                p.setTitre(resultat.getString(2));
                p.setDescription(resultat.getString(3));
                System.out.println("HHHHHHHHHHHHHHHHHH");
                System.out.println(resultat.getDate(4));
//                p.setDateProbleme(String.format(resultat.getDate(4), "yyyy-mm-dd"));
//                p.setDeadlineProbleme(resultat.getDate(5));               
                listeProbleme.add(p);
                p = new Probleme();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeProbleme;
    }

    public ResultSet getAcceptedProblems(int id) {
        try {
            String req =("SELECT s.titre,s.description,s.id_solution,s.id_probleme,s.Membre_id,p.titre FROM solution s, probleme p where s.id_probleme = p.id_probleme and s.etat='Acceptee' and s.Membre_id=? ");
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet allProb = pst.executeQuery();
            return allProb;
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public ResultSet getProblemsSubmitter(int id) {
        try {
            
            String req = "SELECT titre FROM  probleme where membre_id=?";
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1, id);
     
            ResultSet allProb = pst.executeQuery();
            return allProb;
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public ResultSet getProblems() {
//        try {
//            pst = connection.prepareStatement("SELECT DISTINCT s.titre,s.description,s.id_solution,s.id_probleme,s.Membre_id,p.titre FROM solution s, probleme p where s.id_probleme = p.id_probleme and s.etat='En attente' ");
//
//            ResultSet allProb = pst.executeQuery();
//            return allProb;
//        } catch (SQLException ex) {
//            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

//    public List<Solution> getAllSolution(int id) {
//        List<Solution> listePersonne = new ArrayList<>();
//        Solution p = new Solution();
//
//        try {
//            String req = "SELECT id_probleme,id_solution,Membre_id,titre,description FROM solution where id_probleme=?";
//            PreparedStatement pst = connection.prepareStatement(req);
//            pst.setInt(1, id);
//            ResultSet resultat = pst.executeQuery();
//
//            while (resultat.next()) {
//                p.setTitre(resultat.getString(1));
//                p.setDescription(resultat.getString(2));
//                p.setSalaire(resultat.getDouble(3));
//                p.setEtat(resultat.getString(4));
//                p.setIdSolution(resultat.getInt(5));
//                listePersonne.add(p);
//                p = new Solution();
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return listePersonne;
//    }

//    public String getTitleProblemByID(int i) {
//
//        String s = "";
//        try {
//            String req = ("SELECT titre FROM probleme p where id_probleme=?");
//            PreparedStatement pst = connection.prepareStatement(req);
//            pst.setInt(1, i);
//            ResultSet resultat = pst.executeQuery();
//            s = resultat.getString(1);
//        } catch (SQLException ex) {
//            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return s;
//    }
    
    public void accepterSolution(int id){
     String req = "UPDATE solution SET etat = 'Acceptee' WHERE id_solution=?";
        try {

            pst = connection.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void refuserSolution(int id){
     String req = "UPDATE solution SET etat = 'Refuser' WHERE id_solution=?";
        try {

            pst = connection.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add(Solution t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Solution> findByTitre(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Solution> findByCriteria(String titre, Date deadLine, String categ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
