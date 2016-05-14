package Utils;

import entities.Solution;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author asalhi
 */
public class SoluModel extends AbstractTableModel {

    List< Solution> listSol;

    String[] colonnes = {"ID", "Solution", "Description", "Salaire", "Fichier", "Membre"};

    public SoluModel() {
        dao.Problemedao probDao = new dao.Problemedao();
        listSol = probDao.findAllSol();

    }

    public SoluModel(int idProb) {

        dao.Problemedao probDao = new dao.Problemedao();
        listSol = probDao.findSolByProb(idProb);

    }

    public SoluModel(String etat) {

        dao.Problemedao probDao = new dao.Problemedao();
        listSol = probDao.findSolByEtat(etat);

    }

    @Override
    public String getColumnName(int column) {
        return colonnes[column];
    }

    @Override
    public int getRowCount() {
        return listSol.size();
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listSol.get(rowIndex).getIdSolution();
            case 1:
                return listSol.get(rowIndex).getTitre();
            case 2:
                return listSol.get(rowIndex).getDescription();
            case 3:
                return listSol.get(rowIndex).getSalaire();
            case 4:
                return listSol.get(rowIndex).getFichierSolution();
            case 5:
                return listSol.get(rowIndex).getMembreId();
        }
        return null;
    }

}
