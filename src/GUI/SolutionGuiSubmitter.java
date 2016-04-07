/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.SolutionDao;
import Utils.DemandeAccepteeModel;
import Utils.DemandeEnvoyerModel;
import Utils.OffreModels;
import entities.Solution;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Utils.DemandeEnvoyerModel;
import Utils.ProblemeModel;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.User;
import entities.Probleme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.DataSource;

/**
 *
 * @author Rayhana
 */
public class SolutionGuiSubmitter extends javax.swing.JFrame {

    String selectedFileName;
    File uploadDir;
    SolutionDao sDao = new SolutionDao();

    /**
     * Creates new form SolutionGui
     */
    public SolutionGuiSubmitter() {
        initComponents();
        this.setResizable(false);
        idProb.setVisible(false);
        idSolution.setVisible(false);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        loadProblemsSubmitter();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tp3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        list1 = new java.awt.List();
        btnParcourir = new javax.swing.JButton();
        idProb = new javax.swing.JLabel();
        fbBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProblemes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tp4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabSolutions = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cbProblem = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnRefuser = new javax.swing.JButton();
        btnAccepter = new javax.swing.JButton();
        idSolution = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Espace Submitter");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Choisissez un fichier"));

        list1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                list1InputMethodTextChanged(evt);
            }
        });
        list1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list1ActionPerformed(evt);
            }
        });

        btnParcourir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rayhana\\Desktop\\3A18\\PIDEV\\java\\1457831052_BT_save.png")); // NOI18N
        btnParcourir.setText("Enregistrer sous ...");
        btnParcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParcourirActionPerformed(evt);
            }
        });

        idProb.setText("idProb");

        fbBtn.setBackground(new java.awt.Color(51, 102, 255));
        fbBtn.setText("Partager");
        fbBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnParcourir)
                                .addGap(77, 77, 77))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(idProb)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fbBtn)
                .addGap(116, 116, 116))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(idProb)
                .addGap(29, 29, 29)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnParcourir)
                .addGap(18, 18, 18)
                .addComponent(fbBtn)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tableProblemes.setModel(new ProblemeModel());
        tableProblemes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProblemesMouseClicked(evt);
                tableProblemesActionPerformed(evt);
            }
        });
        jScrollPane1.setViewportView(tableProblemes);

        javax.swing.GroupLayout tp3Layout = new javax.swing.GroupLayout(tp3);
        tp3.setLayout(tp3Layout);
        tp3Layout.setHorizontalGroup(
            tp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        tp3Layout.setVerticalGroup(
            tp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(tp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Touts les offres", tp3);

        tabSolutions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabSolutionsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabSolutions);

        jLabel7.setText("Problème:");

        cbProblem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProblemItemStateChanged(evt);
            }
        });
        cbProblem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProblemActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Choisissez une action"));

        btnRefuser.setText("Refuser");
        btnRefuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefuserActionPerformed(evt);
            }
        });

        btnAccepter.setText("Accepter");
        btnAccepter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccepterActionPerformed(evt);
            }
        });

        idSolution.setText("idSolution");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAccepter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefuser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(idSolution)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(idSolution)
                .addGap(18, 18, 18)
                .addComponent(btnAccepter)
                .addGap(18, 18, 18)
                .addComponent(btnRefuser)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tp4Layout = new javax.swing.GroupLayout(tp4);
        tp4.setLayout(tp4Layout);
        tp4Layout.setHorizontalGroup(
            tp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp4Layout.createSequentialGroup()
                .addGroup(tp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tp4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbProblem, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        tp4Layout.setVerticalGroup(
            tp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tp4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(tp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbProblem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulter offres", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParcourirActionPerformed
        File uploadDir2 = new File("C:\\wamp\\www\\Uploads\\Solutions\\" + idProb.getText());
        selectedFileName = list1.getSelectedItem();
        File selectedFile = new File(selectedFileName);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        fileChooser.setSelectedFile(selectedFile);
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {

            InputStream inputStream = null;
            BufferedReader br = null;
            OutputStream outputStream = null;
            String filePath2 = uploadDir2.getAbsolutePath() + File.separator + selectedFileName;
            File file = new File(filePath2);

            try {
                // read this file into InputStream
                inputStream = new FileInputStream(file);

                // write the inputStream to a FileOutputStream
                outputStream = new FileOutputStream(new File(fileChooser.getCurrentDirectory() + File.separator + selectedFileName));

                int length;
                byte[] bytes = new byte[1024];

                while ((length = inputStream.read(bytes)) > 0) {
                    outputStream.write(bytes, 0, length);
                }

                System.out.println("Done!");

            } catch (IOException e) {

            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                if (outputStream != null) {
                    try {
                        // outputStream.flush();
                        outputStream.close();
                    } catch (IOException e) {
                    }

                }
            }
        }
    }//GEN-LAST:event_btnParcourirActionPerformed

    private void tableProblemesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProblemesMouseClicked
        int elementselectionner = tableProblemes.getSelectedRow();
        idProb.setText("" + tableProblemes.getValueAt(elementselectionner, 1));

//        telechargement(uploadDir);

    }//GEN-LAST:event_tableProblemesMouseClicked
    public String prob() {
        return idProb.getText();
    }


    private void list1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_list1InputMethodTextChanged

    }//GEN-LAST:event_list1InputMethodTextChanged

    private void tabSolutionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabSolutionsMouseClicked
        int elementselectionner = tabSolutions.getSelectedRow();
        idSolution.setText("" + tabSolutions.getValueAt(elementselectionner, 0));
    }//GEN-LAST:event_tabSolutionsMouseClicked

    private void cbProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProblemActionPerformed
        SolutionDao mq = new SolutionDao();
        ArrayList<Solution> list = mq.getDataSolutionSubmitter((String) cbProblem.getSelectedItem().toString(), 2);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID", "Offre", "Description"});
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getIdSolution();
            row[1] = list.get(i).getTitre();
            row[2] = list.get(i).getDescription();
            model.addRow(row);

        }
        tabSolutions.setModel(model);
    }//GEN-LAST:event_cbProblemActionPerformed

    private void cbProblemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProblemItemStateChanged
////        int i = 0;
////        try {
////
////            ResultSet resultat = sDao.getProblems();
////            while (resultat.next()) {
////                i = resultat.getInt(1);
////            }
////
//////            tabDemandeEnvoye.setModel(new DemandeAccepteeModel());
////        } catch (SQLException ex) {
////            Logger.getLogger(SolutionGui.class.getName()).log(Level.SEVERE, null, ex);
////        }
    }//GEN-LAST:event_cbProblemItemStateChanged

    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed

    }//GEN-LAST:event_list1ActionPerformed

    private void tableProblemesActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProblemesActionPerformed
        File uploadDir = new File("C:\\wamp\\www\\Uploads\\Solutions\\" + idProb.getText());
        list1.removeAll();
        list1.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        String files[] = uploadDir.list();
        for (String f : files) {
            list1.add(f);
        }
    }//GEN-LAST:event_tableProblemesActionPerformed

    private void btnRefuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefuserActionPerformed
        int id = Integer.parseInt(idSolution.getText());
        SolutionDao sDao = new SolutionDao();
        try {
            sDao.refuserSolution(id);
            JOptionPane.showMessageDialog(null, "Solution Refusée");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur");
        }    }//GEN-LAST:event_btnRefuserActionPerformed

    private void fbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbBtnActionPerformed
        int ligneSelectionne = tableProblemes.getSelectedRow();
        Object l = tableProblemes.getValueAt(ligneSelectionne, 0);

        String accessToken = "CAACEdEose0cBAFv7KSZAZAjGC2uDZCpycZBAaWKVY7B0B4cLbNegxb3TMZC1DZCcazM0bq8NIQiZBUJLjOZArrZCyzAFXZAZC5ZBATZC1Y79LKu5hMwE9saPlXZCtdZAuuSOmOcfpdFI6VfzeOQiqMd0SDs5E2iXyd7W4suQIexWgiLQzKL4nUCyZAlIxo5qU9M9tIoxONlMZAneD6MhszAZDZD";
        FacebookClient fbClient = new DefaultFacebookClient(accessToken);
        User me = fbClient.fetchObject("me", User.class);
        Page userPgae = fbClient.fetchObject("213885155652908", Page.class);

        System.out.println(me.getName());
        System.out.println(me.getBirthday());

        String demande = (String) tableProblemes.getValueAt(ligneSelectionne, 1);
        String description = (String) tableProblemes.getValueAt(ligneSelectionne, 2);
        String dateMise = (String) tableProblemes.getValueAt(ligneSelectionne, 3);
        String dateDeadLine = (String) tableProblemes.getValueAt(ligneSelectionne, 4);

        fbClient.publish("213885155652908" + "/feed", FacebookType.class,
                Parameter.with("message", "Demande postée le : " + dateMise
                        + "\nPour le : " + dateDeadLine
                        + "\nDu problème: " + demande
                        + "\nA propos de : " + description));

        JOptionPane.showMessageDialog(null, "Publier avec succé sur Facebook!");
    }//GEN-LAST:event_fbBtnActionPerformed

    private void btnAccepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccepterActionPerformed
        int id = Integer.parseInt(idSolution.getText());
        SolutionDao sDao = new SolutionDao();
        try {
            sDao.accepterSolution(id);
            JOptionPane.showMessageDialog(null, "Solution Acceptée");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur");
        }
    }//GEN-LAST:event_btnAccepterActionPerformed

    private void loadProblemsSubmitter() {

        try {
            ResultSet res = sDao.getProblemsSubmitter(2);
            while (res.next()) {
                cbProblem.addItem(res.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolutionGui.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    String filePath;
    String fileName;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SolutionGuiSubmitter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolutionGuiSubmitter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolutionGuiSubmitter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolutionGuiSubmitter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolutionGuiSubmitter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccepter;
    private javax.swing.JButton btnParcourir;
    private javax.swing.JButton btnRefuser;
    private javax.swing.JComboBox cbProblem;
    private javax.swing.JButton fbBtn;
    private javax.swing.JLabel idProb;
    private javax.swing.JLabel idSolution;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.List list1;
    private javax.swing.JTable tabSolutions;
    private javax.swing.JTable tableProblemes;
    private javax.swing.JPanel tp3;
    private javax.swing.JPanel tp4;
    // End of variables declaration//GEN-END:variables

}
