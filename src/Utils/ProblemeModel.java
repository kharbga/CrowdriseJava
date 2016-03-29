/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import DAO.SolutionDao;
import entities.Probleme;
import entities.Solution;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rayhana
 */
public class ProblemeModel extends AbstractTableModel {

    List<Probleme> listSolutions;
    String[] colonnes = {"ID", "Demande", "Description", "Date mise", "DeadLine"};

    public ProblemeModel() {
        SolutionDao sDao = new SolutionDao();
        listSolutions = sDao.getAllProblems(2);   

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
                return listSolutions.get(rowIndex).getIdProbleme();
            case 1:
                return listSolutions.get(rowIndex).getTitre();
            case 2:
                
                return listSolutions.get(rowIndex).getDescription();
            case 3:
                
                return listSolutions.get(rowIndex).getDateProbleme();
            case 4:
                
                return listSolutions.get(rowIndex).getDeadlineProbleme();
        }
        return null;
    }
    
    public void telechargement(File uploadFile){
    
    }

}
