package Utils;

import entities.Probleme;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author asalhi
 */
public class ProblemesModel extends AbstractTableModel {

    List< Probleme> listProb;

    public ProblemesModel() {
        DAO.ProblemeDao probDao = new DAO.ProblemeDao();
        listProb = probDao.findAll();
    }
    public ProblemesModel(String titre,Date deadLine,String categ) {
        DAO.ProblemeDao probDao = new DAO.ProblemeDao();
        listProb = probDao.findByCriteria(titre,deadLine,categ);
    }

    String[] colonnes = {"ID", "Titre", "Categorie", "DeadLine", "Description", "Fichier"};

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

            case 3: //deadline
                return listProb.get(rowIndex).getDeadlineProbleme();

            case 4: //Description
                return listProb.get(rowIndex).getDescription();

            case 5: //Fichier
                return listProb.get(rowIndex).getFichierProbleme();
        }

        return null;

    }

}
