/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import DAO.ProjetDao;
import GUI.GestionProjects;
import entities.Projet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kouki
 */
public class JtableListeProjet extends AbstractTableModel {

    List<Projet> listeProjet;
    String[] colnames = {"id","Titre Projet", "Description", "Financement", "date_projet","deadLine", "Categorie"};
    private  Connection c;
    private PreparedStatement pst;

    public JtableListeProjet() {
        //récupération des données
         c = DataSource.getInstance().getConnection();
        ProjetDao pdao = new ProjetDao();
        listeProjet = pdao.findAll();
    }

    @Override
    public int getRowCount() {
        return listeProjet.size();
    }

    @Override
    public int getColumnCount() {
        return colnames.length;
    }

    @Override
    public Object getValueAt(int rowI, int colI) {
        switch (colI) {
            case 0: {
                return listeProjet.get(rowI).getIdProjet();
            }
            case 1: {
                return listeProjet.get(rowI).getTitre();
            }
            case 2: {
                return listeProjet.get(rowI).getDescription();
            }
            case 3: {
                return listeProjet.get(rowI).getTypeFinancement();
            }
            case 4: {
                return listeProjet.get(rowI).getDateProjet();
            }
            case 5: {
                return listeProjet.get(rowI).getDeadlineProjet();
            }case 6: {
                return getCatName(listeProjet.get(rowI).getIdcat());
            }

        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return colnames[i];
    }

     public String getCatName(int id) {
        String cat = null;
        try {
            String req = "select nom from Categorie where id=" + id;
            
            pst = c.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                cat = rs.getString("nom");

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionProjects.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
}
