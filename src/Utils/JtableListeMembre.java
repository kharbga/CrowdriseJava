/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import DAO.MembreDao;
import entities.Membre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Utils.DataSource;
/**
 *
 * @author kouki
 */
public class JtableListeMembre extends AbstractTableModel {

    List<Membre> listeMembre;
    String[] colnames = {"id", "Nom", "Prenom", "Email","Etat"};
    private Connection c;
    private PreparedStatement pst;

    public JtableListeMembre() {
        //récupération des données
        c = DataSource.getInstance().getConnection();
        MembreDao pdao = new MembreDao();
        listeMembre = pdao.findAll();
    }

    @Override
    public int getRowCount() {
        return listeMembre.size();
    }

    @Override
    public int getColumnCount() {
        return colnames.length;
    }

    @Override
    public Object getValueAt(int rowI, int colI) {
        switch (colI) {
            case 0: {
                return listeMembre.get(rowI).getId();
            }
            case 1: {
                return listeMembre.get(rowI).getNom();
            }
            case 2: {
                return listeMembre.get(rowI).getPrenom();
            }
            case 3: {
                return listeMembre.get(rowI).getEmail();
            }

            case 4: {
                if (listeMembre.get(rowI).getEtat()==1)
                    return "Activé";
                else
                    return "Desactivé";
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return colnames[i];
    }

}
