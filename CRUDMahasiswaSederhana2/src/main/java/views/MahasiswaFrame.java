/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import Controller.MahasiswaController;
import interfc.MahasiswaInterface;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import models.Mahasiswa;

/**
 *
 * @author Putri
 */
public class MahasiswaFrame extends javax.swing.JFrame {
List<Mahasiswa> record=new ArrayList<Mahasiswa>();
MahasiswaInterface mhsServis;
int row;
   
    public MahasiswaFrame() {
        initComponents();
        nimValidasiLabel.setVisible(false);
        namaValidasiLabel.setVisible(false);
        alamatValidasiLabel.setVisible(false);
        mhsServis = new MahasiswaController();
        
        mahasiswaTabel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                row = mahasiswaTabel.getSelectedRow();
                if(row != -1){
                    isiText();
                }
            }
        });
        this.statusAwal();
    }
    
     void validasiInput(Mahasiswa o){
        if (NIMText.getText().equals("")){
            nimValidasiLabel.setText("NIM belum diisi");
            nimValidasiLabel.setVisible(true);
        }else if(!NIMText.getText().matches("[0-9]*")){
            nimValidasiLabel.setText("NIM harus berisi angka");
            nimValidasiLabel.setVisible(true);
        }else if (NIMText.getText().length() < 5){
            nimValidasiLabel.setText("NIM minimal berisi 5 angka");
            nimValidasiLabel.setVisible(true);
        }else if (NIMText.getText().length() > 12){
            nimValidasiLabel.setText("NIM maksimal berisi 12 angka");
            nimValidasiLabel.setVisible(true);
        }else{
            o.setNim(NIMText.getText());
            nimValidasiLabel.setVisible(false);
        }
        
        if(NamaText.getText().equals("")){
            namaValidasiLabel.setText("Nama belum diisi");
            namaValidasiLabel.setVisible(true);
        }else{
            o.setNama(NamaText.getText());
            namaValidasiLabel.setVisible(false);
        }
        
        if (AlamatText.getText().equals("")){
            alamatValidasiLabel.setText("Alamat belum diisi");
            alamatValidasiLabel.setVisible(true);
        }else{
            o.setAlamat(AlamatText.getText());
            alamatValidasiLabel.setVisible(false);
        }
    }
    void loadData(){
        try{
            record = mhsServis.getAll();
        } catch (SQLException ex){
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null , ex);
        }
    }
    
    void isiTabel(){
        Object data[][]=new Object[record.size()][3];
        int x=0;
        for(Mahasiswa mhs:record){
            data[x][0]=mhs.getNim();
            data[x][1]=mhs.getNama();
            data[x][2]=mhs.getAlamat();
            x++;
        }
        String judul[]={"nim", "nama", "alamat"};
        mahasiswaTabel.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(mahasiswaTabel);
    }
    
    void isiText(){
        Mahasiswa mhs=record.get(row);
        NIMText.setText(mhs.getNim());
        NamaText.setText(mhs.getNama());
        AlamatText.setText(mhs.getAlamat());    
    }
    
    void kosongkanText(){
        NIMText.setText("");
        NamaText.setText("");
        AlamatText.setText("");
    }
    
    void statusAwal(){
        kosongkanText();
        loadData();
        isiTabel();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPanel = new javax.swing.JPanel();
        NIMLabel = new javax.swing.JLabel();
        NamaLabel = new javax.swing.JLabel();
        AlamatLabel = new javax.swing.JLabel();
        NamaText = new javax.swing.JTextField();
        AlamatText = new javax.swing.JTextField();
        NIMText = new javax.swing.JTextField();
        TambahButton = new javax.swing.JButton();
        UbahButton = new javax.swing.JButton();
        HapusButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mahasiswaTabel = new javax.swing.JTable();
        nimValidasiLabel = new javax.swing.JLabel();
        namaValidasiLabel = new javax.swing.JLabel();
        alamatValidasiLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPanel.setBackground(new java.awt.Color(102, 0, 0));
        jScrollPanel.setForeground(new java.awt.Color(204, 153, 0));

        NIMLabel.setBackground(new java.awt.Color(255, 255, 255));
        NIMLabel.setForeground(new java.awt.Color(255, 255, 255));
        NIMLabel.setText("NIM");

        NamaLabel.setForeground(new java.awt.Color(255, 255, 255));
        NamaLabel.setText("Nama");

        AlamatLabel.setForeground(new java.awt.Color(255, 255, 255));
        AlamatLabel.setText("Alamat");

        AlamatText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlamatTextActionPerformed(evt);
            }
        });

        NIMText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIMTextActionPerformed(evt);
            }
        });

        TambahButton.setBackground(new java.awt.Color(255, 255, 255));
        TambahButton.setForeground(new java.awt.Color(0, 0, 0));
        TambahButton.setText("Tambah");
        TambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahButtonActionPerformed(evt);
            }
        });

        UbahButton.setBackground(new java.awt.Color(255, 255, 255));
        UbahButton.setForeground(new java.awt.Color(0, 0, 0));
        UbahButton.setText("Ubah");
        UbahButton.setVerifyInputWhenFocusTarget(false);
        UbahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbahButtonActionPerformed(evt);
            }
        });

        HapusButton.setBackground(new java.awt.Color(255, 255, 255));
        HapusButton.setForeground(new java.awt.Color(0, 0, 0));
        HapusButton.setText("Hapus");
        HapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusButtonActionPerformed(evt);
            }
        });

        mahasiswaTabel.setBackground(new java.awt.Color(255, 255, 255));
        mahasiswaTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "nim", "nama", "alamat"
            }
        ));
        mahasiswaTabel.setSelectionBackground(new java.awt.Color(153, 153, 153));
        mahasiswaTabel.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(mahasiswaTabel);

        nimValidasiLabel.setBackground(new java.awt.Color(255, 255, 255));
        nimValidasiLabel.setForeground(new java.awt.Color(255, 255, 255));
        nimValidasiLabel.setText("jLabel1");

        namaValidasiLabel.setBackground(new java.awt.Color(255, 255, 255));
        namaValidasiLabel.setForeground(new java.awt.Color(255, 255, 255));
        namaValidasiLabel.setText("jLabel1");

        alamatValidasiLabel.setBackground(new java.awt.Color(255, 255, 255));
        alamatValidasiLabel.setForeground(new java.awt.Color(255, 255, 255));
        alamatValidasiLabel.setText("jLabel1");

        javax.swing.GroupLayout jScrollPanelLayout = new javax.swing.GroupLayout(jScrollPanel);
        jScrollPanel.setLayout(jScrollPanelLayout);
        jScrollPanelLayout.setHorizontalGroup(
            jScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jScrollPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jScrollPanelLayout.createSequentialGroup()
                        .addGroup(jScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NamaLabel)
                            .addComponent(NIMLabel)
                            .addComponent(AlamatLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(AlamatText, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                                .addComponent(NamaText, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(NIMText, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jScrollPanelLayout.createSequentialGroup()
                                .addComponent(TambahButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UbahButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HapusButton))
                            .addComponent(nimValidasiLabel)
                            .addComponent(namaValidasiLabel)
                            .addComponent(alamatValidasiLabel))))
                .addContainerGap())
        );
        jScrollPanelLayout.setVerticalGroup(
            jScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jScrollPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIMLabel)
                    .addComponent(NIMText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nimValidasiLabel)
                .addGap(3, 3, 3)
                .addGroup(jScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NamaLabel)
                    .addComponent(NamaText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(namaValidasiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlamatLabel)
                    .addComponent(AlamatText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(alamatValidasiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HapusButton)
                    .addComponent(TambahButton)
                    .addComponent(UbahButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    private void NIMTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIMTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NIMTextActionPerformed

    private void AlamatTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlamatTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlamatTextActionPerformed

    private void UbahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbahButtonActionPerformed
        // TODO add your handling code here:
        try{
         Mahasiswa mhs = new Mahasiswa();
            validasiInput(mhs);
            mhs.setNim(NIMText.getText());
            mhs.setNama(NamaText.getText());
            mhs.setAlamat(AlamatText.getText());
            mhsServis.update(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data berhasil diubah");
        }catch (SQLException ex){
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_UbahButtonActionPerformed

    private void TambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahButtonActionPerformed
        // TODO add your handling code here:
        try {
            Mahasiswa mhs = new Mahasiswa();
            validasiInput(mhs);
            mhs.setNim(NIMText.getText());
            mhs.setNama(NamaText.getText());
            mhs.setAlamat(AlamatText.getText());
            mhsServis.insert(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data tersimpan");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Data Tidak Berhasil Tersimpan");
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_TambahButtonActionPerformed

    private void HapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusButtonActionPerformed
        // TODO add your handling code here:
        try{
            String nim = NIMText.getText();
            mhsServis.delete(nim);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data berhasil diubah");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data Tidak Berhasil Diubah");
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_HapusButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlamatLabel;
    private javax.swing.JTextField AlamatText;
    private javax.swing.JButton HapusButton;
    private javax.swing.JLabel NIMLabel;
    private javax.swing.JTextField NIMText;
    private javax.swing.JLabel NamaLabel;
    private javax.swing.JTextField NamaText;
    private javax.swing.JButton TambahButton;
    private javax.swing.JButton UbahButton;
    private javax.swing.JLabel alamatValidasiLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jScrollPanel;
    private javax.swing.JTable mahasiswaTabel;
    private javax.swing.JLabel namaValidasiLabel;
    private javax.swing.JLabel nimValidasiLabel;
    // End of variables declaration//GEN-END:variables

    
    private static class jScrollPanel {

        public jScrollPanel() {
        }
    }
}
