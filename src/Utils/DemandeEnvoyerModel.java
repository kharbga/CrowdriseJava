/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import DAO.SolutionDao;
import entities.Solution;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rayhana
 */
public class DemandeEnvoyerModel extends AbstractTableModel {

    List<Solution> listDemande;
    String[] colonnes = {"Id","Titre", "Rénumération", "Description", "Etat"};

    public DemandeEnvoyerModel() {
        SolutionDao sDao = new SolutionDao();
        listDemande = sDao.findAll();
    }

    @Override
    public String getColumnName(int column) {
        return colonnes[column];
    }

    @Override
    public int getRowCount() {
        return listDemande.size();
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listDemande.get(rowIndex).getIdSolution();
            case 1:
                return listDemande.get(rowIndex).getTitre();
            case 2:
                return listDemande.get(rowIndex).getSalaire();
            case 3:
                return listDemande.get(rowIndex).getDescription();
            case 4:
                return listDemande.get(rowIndex).getEtat();
        }
        return null;
    }

}
