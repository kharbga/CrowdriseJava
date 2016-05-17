package DAO;

import entities.Probleme;
import entities.Solution;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author asalhi
 */
public class ProblemeDao implements Idao.IDAO<Probleme> {

    private Connection connection;
    private PreparedStatement pst;

    public ProblemeDao() {
        //initialiser la connection
        connection = DataSource.getInstance().getConnection();

    }

    public void uploadFile(String source, String destination) {
        InputStream inStream = null;
        OutputStream outStream = null;

        try {

            File sourceFile = new File(source);
            File destinationFile = new File(destination);

            inStream = new FileInputStream(sourceFile);
            outStream = new FileOutputStream(destinationFile);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes 
            while ((length = inStream.read(buffer)) > 0) {

                outStream.write(buffer, 0, length);

            }

            inStream.close();
            outStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addToMedia(int id, String nom, String path) {

        String req = "insert into media (id,updated_at, name,path) values (?,CURDATE(),?,?)";
        try {
            pst = connection.prepareStatement(req);

            pst.setInt(1, id);
            pst.setString(2, nom);
            pst.setString(3, path);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add(Probleme p) {

        String req = "insert into probleme (fichier,titre, description,categorie,deadline_probleme,date_probleme) values (?,?,?,?,?,CURDATE())";
        try {
            pst = connection.prepareStatement(req);

            pst.setString(1, p.getFichierProbleme());
            pst.setString(2, p.getTitre());
            pst.setString(3, p.getDescription());
            pst.setString(4, p.getCategorie());
            pst.setDate(5, new java.sql.Date(p.getDeadlineProbleme().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Probleme p) {
        String req = "Update probleme p set p.fichier = ?, p.titre = ? ,p.description = ? ,p.deadline_probleme = ?, p.categorie= ?  where p.id_probleme = ? ";
        try {
            pst = connection.prepareStatement(req);

            pst.setString(1, p.getFichierProbleme());
            pst.setString(2, p.getTitre());
            pst.setString(3, p.getDescription());
            pst.setDate(4, new java.sql.Date(p.getDeadlineProbleme().getTime()));
            pst.setString(5, p.getCategorie());
            pst.setInt(6, p.getIdProbleme());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int id) {
        String req = "Delete from probleme where id_probleme=" + id;
        try {
            pst = connection.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeByIdSol(int id) {
        String req = "Delete from solution where id_solution=" + id;
        try {
            pst = connection.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Probleme> findAll() {
        List<Probleme> listeProblemes = new ArrayList<>();
        Probleme p;

        try {
            String req = "Select p.id_probleme,m.name ,p.titre, p.date_probleme,p.description,p.categorie,p.deadline_probleme,p.membre_id"
                    + " from probleme p , media m where p.fichier = m.id ";

            pst = connection.prepareStatement(req);

            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {

                p = new Probleme();
                p.setIdProbleme(resultat.getInt(1));
                p.setFichierProbleme(resultat.getString(2));
                p.setTitre(resultat.getString(3));
                p.setDateProbleme(resultat.getDate(4));
                p.setDescription(resultat.getString(5));
                p.setCategorie(resultat.getString(6));
                p.setDeadlineProbleme(resultat.getDate(7));
                p.setMembreId(resultat.getInt(8));
                listeProblemes.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeProblemes;
    }

    @Override
    public Probleme findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Probleme> findByTitre(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Probleme> findByCriteria(String titre, Date deadLine, String categ) {
        List<Probleme> listeProblemes = new ArrayList<>();
        Probleme p;

        try {
            String req = "Select p.id_probleme,m.name ,p.titre, p.date_probleme,p.description,p.categorie,p.deadline_probleme,p.membre_id"
                    + " from probleme p , media m where p.fichier = m.id ";
            if (deadLine != null) {
                req += " and p.deadline_probleme = ?";
            }
            if (titre != null && !titre.equals("")) {
                req += " and p.titre like'%" + titre + "%'";
            }

            if (categ != null && !categ.equals("")) {
                req += " and p.categorie='" + categ + "'";
            }
            pst = connection.prepareStatement(req);

            if (deadLine != null) {
                pst.setDate(1, new java.sql.Date(deadLine.getTime()));
            }

            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {

                p = new Probleme();
                p.setIdProbleme(resultat.getInt(1));
                p.setFichierProbleme(resultat.getString(2));
                p.setTitre(resultat.getString(3));
                p.setDateProbleme(resultat.getDate(4));
                p.setDescription(resultat.getString(5));
                p.setCategorie(resultat.getString(6));
                p.setDeadlineProbleme(resultat.getDate(7));
                p.setMembreId(resultat.getInt(8));
                listeProblemes.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeProblemes;
    }

    public List<Solution> findSolByProb(int idProb) {
        List<Solution> listeSol = new ArrayList<>();
        Solution s;

        try {
            String req = "Select * from solution where (etat is null or etat = 'en attente') and id_probleme = " + idProb;

            pst = connection.prepareStatement(req);

            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {

                s = new Solution();
                s.setIdSolution(resultat.getInt(1));
                s.setProblemeId(resultat.getInt(2));
                s.setTitre(resultat.getString(3));
                s.setDescription(resultat.getString(4));
                s.setFichierSolution(resultat.getString(5));
                s.setEtat(resultat.getString(6));
                s.setMembreId(resultat.getInt(7));
                listeSol.add(s);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeSol;
    }

    public List<Solution> findAllSol() {
        List<Solution> listeSol = new ArrayList<>();
        Solution s;

        try {
            String req = "Select * from solution where 1 = 2";

            pst = connection.prepareStatement(req);

            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {

                s = new Solution();
                s.setIdSolution(resultat.getInt(1));
                s.setProblemeId(resultat.getInt(2));
                s.setTitre(resultat.getString(3));

                s.setDescription(resultat.getString(4));
                s.setFichierSolution(resultat.getString(5));
                s.setEtat(resultat.getString(6));
                s.setMembreId(resultat.getInt(7));
                listeSol.add(s);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeSol;
    }

    public List<Solution> findSolByEtat(String etat) {
        List<Solution> listeSol = new ArrayList<>();
        Solution s;

        try {
            String req = "Select * from solution where etat ='" + etat + "'";

            pst = connection.prepareStatement(req);

            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {

                s = new Solution();
                s.setIdSolution(resultat.getInt(1));
                s.setProblemeId(resultat.getInt(2));
                s.setTitre(resultat.getString(3));
                s.setDescription(resultat.getString(4));
                s.setFichierSolution(resultat.getString(5));
                s.setEtat(resultat.getString(6));
                s.setMembreId(resultat.getInt(7));
                listeSol.add(s);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeSol;
    }

    public void updateSolAccepte(String etat, int idsol) {
        String req = "Update solution set etat ='" + etat + "'where id_solution = " + idsol;
        try {
            pst = connection.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getFileNumber() {
        int number = 0;
        String req = "select max(id) from media";
        try {
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                number = resultat.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;
    }

    public List<Probleme> getAllProblems() {

        List<Probleme> listeProbleme = new ArrayList<Probleme>();
        Probleme p = new Probleme();

        try {
            String req = "SELECT `id_probleme`, `titre`, `description`, `date_probleme`, `deadline_probleme` FROM `probleme`";
            PreparedStatement pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {
                p.setIdProbleme(resultat.getInt(1));
                p.setTitre(resultat.getString(2));
                p.setDescription(resultat.getString(3));               
                p.setDateProbleme(resultat.getDate(4));
                p.setDeadlineProbleme(resultat.getDate(5));               
                listeProbleme.add(p);
                p = new Probleme();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolutionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeProbleme;
    }
}
