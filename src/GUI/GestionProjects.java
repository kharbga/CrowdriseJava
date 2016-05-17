/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ProjetDao;
import Utils.JtableListeProjet;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import Utils.DataSource;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

import entities.Categorie;
import entities.Projet;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author kouki
 */
public class GestionProjects extends javax.swing.JFrame {

    private final Connection con;
    private PreparedStatement pst;

    /**
     * Creates new form GestionProjects
     */
    public GestionProjects() throws ParseException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
        initComponents();
        con = DataSource.getInstance().getConnection();

        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);

        lblname.setText(Login.session.getUsername().toString());
        tbProjet.getColumnModel().getColumn(0).setMinWidth(0);
        tbProjet.getColumnModel().getColumn(0).setMaxWidth(0);
        Fill(combo_Cat);
        lblPathImage.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbProjet = new javax.swing.JTable();
        lblimg = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label4 = new java.awt.Label();
        ComboFinnancementProjet = new javax.swing.JComboBox();
        label1 = new java.awt.Label();
        label5 = new java.awt.Label();
        btParcourir = new java.awt.Button();
        lblPathImage = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        txtTitreProjet = new java.awt.TextField();
        txtDescriptionProjet = new java.awt.TextArea();
        combo_Cat = new javax.swing.JComboBox();
        label6 = new java.awt.Label();
        jdateDeadLine = new com.toedter.calendar.JDateChooser();
        button4 = new java.awt.Button();
        btSupprimer = new java.awt.Button();
        Modifier = new java.awt.Button();
        label7 = new java.awt.Label();
        lblname = new java.awt.Label();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbProjet.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tbProjet.setModel(new JtableListeProjet());
        tbProjet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProjetMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProjet);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label4.setText("DeadLine  Projet");
        jPanel1.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        ComboFinnancementProjet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Donnation", "Partenaire", "Produit", "Crédit" }));
        ComboFinnancementProjet.setName(""); // NOI18N
        jPanel1.add(ComboFinnancementProjet, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 190, 210, -1));

        label1.setText("Titre");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 42, -1));

        label5.setText("Ajouter un image");
        jPanel1.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        btParcourir.setLabel("Parcourir");
        btParcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btParcourirActionPerformed(evt);
            }
        });
        jPanel1.add(btParcourir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 156, 31));
        jPanel1.add(lblPathImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 320, -1));

        label2.setText("Description");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        label3.setText("Categorie");
        jPanel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtTitreProjet.setName(""); // NOI18N
        jPanel1.add(txtTitreProjet, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 10, 210, -1));

        txtDescriptionProjet.setName(""); // NOI18N
        jPanel1.add(txtDescriptionProjet, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 40, 210, 70));

        combo_Cat.setName("cbCategorieProjet"); // NOI18N
        combo_Cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_CatActionPerformed(evt);
            }
        });
        jPanel1.add(combo_Cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 159, 210, -1));

        label6.setText("Type de Finnancement");
        jPanel1.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        jPanel1.add(jdateDeadLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        button4.setLabel("Ajouter Projet");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        btSupprimer.setLabel("Supprimer");
        btSupprimer.setName(""); // NOI18N
        btSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSupprimerActionPerformed(evt);
            }
        });

        Modifier.setLabel("Modifier Projet");
        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });

        label7.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        label7.setText("GESTION DES PROJETS");

        lblname.setText("test1");

        button1.setLabel("Print");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setLabel("<==");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblimg, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Modifier, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btSupprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblimg, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btParcourirActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        File f = fc.getSelectedFile();
        try {
            Image img = ImageIO.read(f);
            lblimg.setIcon(new ImageIcon(getScaledImage(img, 290, 214)));
            lblPathImage.setText(f.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(GestionProjects.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btParcourirActionPerformed

    private void combo_CatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_CatActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        Projet p = new Projet();

        p.setTitre(txtTitreProjet.getText());
        p.setDescription(txtDescriptionProjet.getText());
        p.setTypeFinancement(ComboFinnancementProjet.getSelectedItem().toString());
        /////////////////////////CONVERTION DE DATE A SQL DATE//////////////////////
        java.util.Date utilStartDate = jdateDeadLine.getDate();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        ////////////////////////////////////////////////
        p.setDeadlineProjet(sqlStartDate);
        p.setImageProjet(lblPathImage.getText());
        p.setFichierProjet("test");
        ///////////////CATEGORIE ID /////////////////////////////////
        Categorie comboItem = (Categorie) combo_Cat.getSelectedItem();
        ////////////////////////////////////////////////
        p.setIdcat(comboItem.getId());
        p.setVideoProjet(lblPathImage.getText());
        p.setMembreId(1);
        p.setDateProjet(sqlStartDate);

        ProjetDao proDAO = new ProjetDao();
        proDAO.add(p);
        tbProjet.setModel(new JtableListeProjet());
    }//GEN-LAST:event_button4ActionPerformed

    private void btSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSupprimerActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(null, "êtes vous sure?", "supprimer Projet", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

                ProjetDao proDAO = new ProjetDao();
                proDAO.removeById((int) tbProjet.getValueAt(tbProjet.getSelectedRow(), 0));
                tbProjet.setModel(new JtableListeProjet());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erreur de supprimer \n" + e.getMessage());
        }

    }//GEN-LAST:event_btSupprimerActionPerformed

    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierActionPerformed
        Projet p = new Projet();
        p.setIdProjet((int) tbProjet.getValueAt(tbProjet.getSelectedRow(), 0));
        p.setTitre(txtTitreProjet.getText());
        p.setDescription(txtDescriptionProjet.getText());
        p.setTypeFinancement(ComboFinnancementProjet.getSelectedItem().toString());
        /////////////////////////CONVERTION DE DATE A SQL DATE//////////////////////
        java.util.Date utilStartDate = jdateDeadLine.getDate();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        ////////////////////////////////////////////////
        p.setDeadlineProjet(sqlStartDate);
        p.setImageProjet(lblPathImage.getText());
        p.setFichierProjet("test");
        ///////////////CATEGORIE ID /////////////////////////////////
        Categorie comboItem = (Categorie) combo_Cat.getSelectedItem();
        ////////////////////////////////////////////////
        p.setIdcat(comboItem.getId());
        p.setVideoProjet(lblPathImage.getText());
        p.setMembreId(1);
        p.setDateProjet(sqlStartDate);

        ProjetDao proDAO = new ProjetDao();
        proDAO.update(p);
        tbProjet.setModel(new JtableListeProjet());
    }//GEN-LAST:event_ModifierActionPerformed

    private void tbProjetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProjetMouseClicked
        ProjetDao proDAO = new ProjetDao();
        Projet p;
        p = proDAO.findById((int) tbProjet.getValueAt(tbProjet.getSelectedRow(), 0));
        lblPathImage.setText(p.getImageProjet());
        txtTitreProjet.setText(p.getTitre());
        txtDescriptionProjet.setText(p.getDescription());
        combo_Cat.setSelectedIndex(p.getIdcat() - 1);
        ComboFinnancementProjet.setSelectedItem(p.getTypeFinancement());
        ImageIcon image = new ImageIcon(p.getImageProjet());
        image = new ImageIcon(image.getImage().getScaledInstance(290, 214, BufferedImage.SCALE_SMOOTH));
        lblimg.setIcon(image);
        jdateDeadLine.setDate(p.getDeadlineProjet());
    }//GEN-LAST:event_tbProjetMouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        String IMAGE1 = lblPathImage.getText();
        Font red = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.RED);
        Chunk redText = new Chunk("Les information relatif au Projet : ", red);
        Font blue = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE);

        Document document = new Document();
        java.util.Date utilStartDate = jdateDeadLine.getDate();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Report.pdf"));
            document.open();

            Paragraph p1 = new Paragraph();
            p1.add(redText);
            p1.add(txtTitreProjet.getText());

            Chunk txtdesc = new Chunk("Decription du Projet: ", red);
            Paragraph p2 = new Paragraph();
            p2.add(txtdesc);
            p2.add(txtDescriptionProjet.getText());

            Chunk txtcat = new Chunk("Catégorie du Projet: ", red);
            Paragraph p3 = new Paragraph();
            p3.add(txtcat);
            p3.add(combo_Cat.getSelectedItem().toString());

            Chunk txtfin = new Chunk("Mode de finnancement du Projet: ", red);
            Paragraph p4 = new Paragraph();
            p4.add(txtfin);
            p4.add(ComboFinnancementProjet.getSelectedItem().toString());

            Chunk txtdate = new Chunk("Date DeadLine Projet: ", red);
            Paragraph p5 = new Paragraph();
            p5.add(txtdate);
            p5.add(sqlStartDate.toString());

            p1.setSpacingAfter(25);
            p1.setSpacingBefore(25);
            p1.setAlignment(Element.ALIGN_CENTER);
            p1.setIndentationLeft(50);
            p1.setIndentationRight(50);

            document.add(p1);
            document.add(p2);
            document.add(p3);
            document.add(p4);
            document.add(p5);

            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("Report.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    // no application registered for PDFs
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        document.close();
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        this.dispose();

        try {
            new AcceuilSubmitter().setVisible(true);
            // TODO add your handling code here:
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GestionProjects.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GestionProjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button2ActionPerformed

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
            java.util.logging.Logger.getLogger(GestionProjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionProjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionProjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionProjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GestionProjects().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(GestionProjects.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(GestionProjects.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboFinnancementProjet;
    private java.awt.Button Modifier;
    private java.awt.Button btParcourir;
    private java.awt.Button btSupprimer;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button4;
    private javax.swing.JComboBox combo_Cat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdateDeadLine;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label lblPathImage;
    private javax.swing.JLabel lblimg;
    private java.awt.Label lblname;
    private javax.swing.JTable tbProjet;
    private java.awt.TextArea txtDescriptionProjet;
    private java.awt.TextField txtTitreProjet;
    // End of variables declaration//GEN-END:variables

    public String getCatName(int id) {
        String cat = null;
        try {
            String req = "select nom from Categorie where id=" + id;
            pst = con.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                cat = rs.getString("nom");

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionProjects.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    public void Fill(JComboBox combo) {
        try {
            String req = "select * from Categorie";
            pst = con.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idcat = rs.getInt("id_categorie");
                String cat = rs.getString("nom");
                Categorie comboItem = new Categorie(idcat, cat);

                combo.addItem(comboItem);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionProjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
///////////////////////////// redimmensionner l'image pour affichage ////////////////////

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

}
