/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 *
 * @author Rayhana
 */
public class Telechargement extends javax.swing.JFrame {
  //   String filePath;   
  //   String fileName;
     
    //  File file = new File(filePath);
      String selectedFileName;
      File uploadDir = new File("c:\\Uploads");
    public Telechargement() {
        
       // this.fileName = null;
        initComponents();
        
        String files[] = uploadDir.list();
        for (String f : files) {
        list1.add(f);
        }
        
        
        this.setResizable(false);
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
        jPanel1 = new javax.swing.JPanel();
        list1 = new java.awt.List();
        btnParcourir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        jLabel1.setText("Télécharger la solution");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Choisissez un fichier"));

        btnParcourir.setText("Enregistrer sous ...");
        btnParcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParcourirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btnParcourir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnParcourir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParcourirActionPerformed
                selectedFileName=list1.getSelectedItem();
                File selectedFile = new File(selectedFileName);
        	JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
                fileChooser.setSelectedFile(selectedFile);
		int userSelection = fileChooser.showSaveDialog(this);
                
		if (userSelection == JFileChooser.APPROVE_OPTION) {
                    
                    InputStream inputStream = null;
	BufferedReader br = null;
        OutputStream outputStream = null;
                    String filePath=uploadDir.getAbsolutePath()+File.separator+selectedFileName;
        File file = new File(filePath);
      
        try {
		// read this file into InputStream
		inputStream = new FileInputStream(file);

		// write the inputStream to a FileOutputStream
                
		outputStream =  new FileOutputStream(new File(fileChooser.getCurrentDirectory()+File.separator+selectedFileName));

		int length;
		byte[] bytes = new byte[1024];

		while ((length = inputStream.read(bytes))>0) {
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
        
        
			
			System.out.println("Save as file: " + fileChooser.getCurrentDirectory()+File.separator+selectedFileName);
		}

    }//GEN-LAST:event_btnParcourirActionPerformed
    
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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
                  
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Telechargement().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnParcourir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables

	
	
}
