package Utils;

import entities.Probleme;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author asalhi
 */
public class ProbModel extends AbstractTableModel {

    List< Probleme> listProb;

    public ProbModel() {
        dao.Problemedao probDao = new dao.Problemedao();
        listProb = probDao.findAll();
    }

    String[] colonnes = {"ID", "Titre", "Categorie"};

    @Override
    public int getRowCount() {
        return listProb.size();
    }

    @Override
    public String getColumnName(int i) {
        return colonnes[i];
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0: //id
                return listProb.get(rowIndex).getIdProbleme();
            case 1: //titre
                return listProb.get(rowIndex).getTitre();
            case 2: //categorie
                return listProb.get(rowIndex).getCategorie();
 
        }

        return null;

    }

}
