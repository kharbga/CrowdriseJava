/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import DAO.SolutionDao;
import entities.Solution;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rayhana
 */
public class OffreModels extends AbstractTableModel {

    List<Solution> listSolutions;
    String[] colonnes = {"ID", "Offre", "Description"};

    public OffreModels() {
        SolutionDao sDao = new SolutionDao();
        listSolutions = sDao.getAllAcceptedProblems();

               

        

    }

    @Override
    public String getColumnName(int column) {
        return colonnes[column];
    }

    @Override
    public int getRowCount() {
        return listSolutions.size();
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listSolutions.get(rowIndex).getIdSolution();
            case 1:
                return listSolutions.get(rowIndex).getTitre();
            case 2:
                
                return listSolutions.get(rowIndex).getDescription();
        }
        return null;
    }

}
