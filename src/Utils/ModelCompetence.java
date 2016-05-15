/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import DAO.CompetenceDAO;
import entities.Competence;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sedki
 */
public class ModelCompetence extends AbstractTableModel{

    String[] Colnames = {"id","nom","description"};
    List<Competence> liste ;
    
    public ModelCompetence(int id) {
        CompetenceDAO cdao = new CompetenceDAO();
        liste = new ArrayList<>();
        liste = cdao.findAllById(id);
    }
    

    @Override
    public int getRowCount() {
        return liste.size() ;
    }

    @Override
    public int getColumnCount() {
        return Colnames.length ;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0 : 
                return liste.get(row).getId() ;
            case 1 : 
                return liste.get(row).getNom();
            case 2 :  
                return liste.get(row).getDescription();
        }
        return null ;
    }

    @Override
    public String getColumnName(int i) {
        return Colnames[i] ;
    }
    
}
