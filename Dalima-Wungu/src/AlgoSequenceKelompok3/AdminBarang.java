/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoSequenceKelompok3;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author naintu
 */
public class AdminBarang extends javax.swing.JPanel {

    /**
     * Creates new form AdminBarang
     */
    
    Koneksi koneksi;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Statement stm;
    String ImgPath = null;
    DefaultTableModel tabelmodel;
    String kode_barang_a = null;
    String kode_barang_b = null;
    
    public AdminBarang() {
        initComponents();
        
        koneksi = new Koneksi();
        koneksi.getConnection();
        String []tabelHeader = {"Kode Barang","Nama Barang","Jenis Barang","Stok","Harga Sewa","Gambar"};
        tabelmodel = new DefaultTableModel(tabelHeader, 0);
        jTableBarang.setModel(tabelmodel);
        showTabel();
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
    }
    
    public ImageIcon ResizeImage(String imagePath, byte[] pic){
        ImageIcon myImage = null;
        if(imagePath != null){
            myImage = new ImageIcon(imagePath);
        }
        else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
    
    private void showTabel(){
        int row = jTableBarang.getRowCount();
        for(int i=0; i<row; i++){
            tabelmodel.removeRow(0);
        }
        try{
            con = Koneksi.getConnection();
            stm = con.createStatement();
            String SQL = ("select * from barang");
            rs = stm.executeQuery(SQL);
            while(rs.next()){
                String data[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                tabelmodel.addRow(data);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public boolean validasi(){
        if(nama_barangTF.getText().isEmpty() && jenis_barangCB.getSelectedItem() == "-- Pilih Jenis Barang --" && jumlahTF.getText().isEmpty() && harga_sewaTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Form Masih Kosong!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            nama_barangTF.requestFocus();
            return false;
        }
        else if(nama_barangTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Form Nama Tidak Boleh Kosong!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            nama_barangTF.requestFocus();
            return false;
        }
        else if(jenis_barangCB.getSelectedItem() == "-- Pilih Jenis Barang --"){
            JOptionPane.showMessageDialog(null, "Form Jenis Barang Belum Dipilih!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            jenis_barangCB.requestFocus();
            return false;
        }
        else if(jumlahTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Form Jumlah Tidak Boleh Kosong!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            jumlahTF.requestFocus();
            return false;
        }
        else if(harga_sewaTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Form Harga Sewa Tidak Boleh Kosong!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            harga_sewaTF.requestFocus();
            return false;
        }
        else if(! nama_barangTF.getText().matches("[ a-zA-Z]*")){
            JOptionPane.showMessageDialog(null, "Form Nama Barang Tidak Boleh Angka!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            nama_barangTF.requestFocus();
            return false;
        }
        else if(! jumlahTF.getText().matches("[0-9]*")){
            JOptionPane.showMessageDialog(null, "Form Jumlah Tidak Boleh Karakter!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            jumlahTF.requestFocus();
            return false;
        }
        else if(! harga_sewaTF.getText().matches("[0-9]*")){
            JOptionPane.showMessageDialog(null, "Form Harga Sewa Tidak Boleh Karakter!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            harga_sewaTF.requestFocus();
            return false;
        }
        else{
            return true;
        }
    }
    
    private void reset(){
        jLabelkode_barang.setText(null);
        nama_barangTF.setText(null);
        jenis_barangCB.setSelectedItem("-- Pilih Jenis Barang --");
        jenis_barangCB.setEnabled(true);
        jumlahTF.setText(null);
        harga_sewaTF.setText(null);
        imgLabel.setIcon(null);
        jButton7.setEnabled(true);
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
    }
    
    private void auto_a(){
        try {
            con = Koneksi.getConnection();
            stm = con.createStatement();
            String SQL = "select * from barang where kode_barang like 'A%' order by kode_barang desc";
            rs = stm.executeQuery(SQL);
            if(rs.next()){
                String kode_barang = rs.getString("kode_barang").substring(2);
                String AN = ""+(Integer.parseInt(kode_barang)+1);
                String nol = "";
                
                if(AN.length()==1){
                    nol="0000";
                }
                else if(AN.length()==2){
                    nol="000";
                }
                else if(AN.length()==3){
                    nol="00";
                }
                else if(AN.length()==4){
                    nol="0";
                }
                else if(AN.length()==5){
                    nol="";
                }
                kode_barang_a = "A-"+nol+AN;
            }
            else{
                kode_barang_a = "A-00001";
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: \n" +ex.toString(), "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }   
    }
    
    private void auto_b(){
        try {
            con = Koneksi.getConnection();
            stm = con.createStatement();
            String SQL = "select * from barang where kode_barang like 'B%' order by kode_barang desc";
            rs = stm.executeQuery(SQL);
            if(rs.next()){
                String kode_barang = rs.getString("kode_barang").substring(2);
                String AN = ""+(Integer.parseInt(kode_barang)+1);
                String nol = "";
                
                if(AN.length()==1){
                    nol="0000";
                }
                else if(AN.length()==2){
                    nol="000";
                }
                else if(AN.length()==3){
                    nol="00";
                }
                else if(AN.length()==4){
                    nol="0";
                }
                else if(AN.length()==5){
                    nol="";
                }
                kode_barang_b = "B-"+nol+AN;
            }
            else{
                kode_barang_b = "B-00001";
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: \n" +ex.toString(), "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barangScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        barangPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        nama_barangTF = new javax.swing.JTextField();
        jLabelkode_barang = new javax.swing.JLabel();
        jenis_barangCB = new javax.swing.JComboBox();
        jumlahTF = new javax.swing.JTextField();
        harga_sewaTF = new javax.swing.JTextField();
        imgLabel = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcari = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBarang = new javax.swing.JTable();

        barangScrollPane.setBorder(null);
        barangScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        barangPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 165, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Input Data Barang");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, -1, -1));

        barangPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1014, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel9.setText("Harga Sewa");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 20));

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel10.setText("Nama Barang");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel11.setText("Jenis Barang");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jLabel12.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel12.setText("Jumlah");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 500, 1));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 500, 1));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 500, 1));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 500, 1));

        nama_barangTF.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nama_barangTF.setBorder(null);
        jPanel3.add(nama_barangTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 500, 30));
        jPanel3.add(jLabelkode_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 55, -1, -1));

        jenis_barangCB.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jenis_barangCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Jenis Barang --", "Set", "Satuan" }));
        jenis_barangCB.setBorder(null);
        jPanel3.add(jenis_barangCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 500, 30));

        jumlahTF.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jumlahTF.setBorder(null);
        jPanel3.add(jumlahTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 500, 30));

        harga_sewaTF.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        harga_sewaTF.setBorder(null);
        jPanel3.add(harga_sewaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 500, 30));

        imgLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(imgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 180, 180));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button img.png"))); // NOI18N
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 100, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button insert.png"))); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 100, 30));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button update.png"))); // NOI18N
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 270, 100, 30));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button delete.png"))); // NOI18N
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 270, 100, 30));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button reset.png"))); // NOI18N
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 100, 30));

        barangPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1014, 320));

        jPanel4.setBackground(new java.awt.Color(122, 171, 65));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Data Barang");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon search.png"))); // NOI18N
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 17, 20, 20));

        jcari.setBackground(new java.awt.Color(122, 171, 65));
        jcari.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jcari.setForeground(new java.awt.Color(255, 255, 255));
        jcari.setBorder(null);
        jcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcariKeyReleased(evt);
            }
        });
        jPanel4.add(jcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 12, 250, 25));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 37, 250, 1));

        barangPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1014, 60));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableBarang.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jenis Barang", "Stok", "Harga Sewa", "Gambar"
            }
        ));
        jTableBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBarang);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 974, 360));

        barangPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 1014, 400));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(barangPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 621, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barangPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );

        barangScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(barangScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(barangScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 274, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imgLabel.setIcon(ResizeImage(path, null));
            ImgPath = path;
        }
        else{
            System.err.println("No File Selected");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(validasi() == false){
            
        }
        else if(ImgPath == null){
            JOptionPane.showMessageDialog(null, "Gambar Belum Dipilih!!!", "Failure", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try{
                con = Koneksi.getConnection();
                pst = con.prepareStatement("insert into barang values(?,?,?,?,?,?)");
                if(jenis_barangCB.getSelectedItem() == "Set"){
                    auto_a();
                    pst.setString(1, kode_barang_a);
                }
                else if(jenis_barangCB.getSelectedItem() == "Satuan"){
                    auto_b();
                    pst.setString(1, kode_barang_b);
                }
                pst.setString(2, nama_barangTF.getText());
                pst.setString(3, jenis_barangCB.getSelectedItem().toString());
                pst.setString(4, jumlahTF.getText());
                pst.setString(5, harga_sewaTF.getText());
                InputStream img = new FileInputStream(new File(ImgPath));
                pst.setBlob(6, img);
                pst.executeUpdate();
                showTabel();
                reset();
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTableBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBarangMouseClicked
        // TODO add your handling code here:
        
        jButton7.setEnabled(false);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
        jenis_barangCB.setEnabled(false);
        int i = jTableBarang.getSelectedRow();
        jLabelkode_barang.setText(jTableBarang.getValueAt(i, 0).toString());
        nama_barangTF.setText(jTableBarang.getValueAt(i, 1).toString());
        jenis_barangCB.setSelectedItem(jTableBarang.getValueAt(i, 2).toString());
        jumlahTF.setText(jTableBarang.getValueAt(i, 3).toString());
        harga_sewaTF.setText(jTableBarang.getValueAt(i, 4).toString());
        try{
            con = Koneksi.getConnection();
            stm = con.createStatement();
            String SQL = ("select * from barang where kode_barang = '"+jLabelkode_barang.getText()+"'");
            rs = stm.executeQuery(SQL);
            while(rs.next()){
                byte[] img = rs.getBytes("img");
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH));
                imgLabel.setIcon(imageIcon);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jTableBarangMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if(jLabelkode_barang.getText() != null){
            int option = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Menghapusnya?");
            if(option == JOptionPane.YES_OPTION){
                try{
                    con = Koneksi.getConnection();
                    con.createStatement().executeUpdate("delete from barang where kode_barang = '"+jLabelkode_barang.getText()+"'");
                    JOptionPane.showMessageDialog(null, "Data Berhasil Didelete!!!");
                    showTabel();
                    reset();
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            else if(option == JOptionPane.NO_OPTION){
                reset();
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(validasi() == false){
            
        }
        else{
            try{
                con = Koneksi.getConnection();
                if(ImgPath != null){
                    pst = con.prepareStatement("update barang set nama_barang = ?, jumlah = ?, harga_sewa = ?, img = ? where kode_barang = '"+jLabelkode_barang.getText()+"'");
                    pst.setString(1, nama_barangTF.getText());
                    if(jenis_barangCB.getSelectedItem() == "Set"){
                        auto_a();
                        pst.setString(1, kode_barang_a);
                    }
                    else if(jenis_barangCB.getSelectedItem() == "Satuan"){
                        auto_b();
                        pst.setString(1, kode_barang_b);
                    }
                    pst.setString(2, jumlahTF.getText());
                    pst.setString(3, harga_sewaTF.getText());
                    InputStream img = new FileInputStream(new File(ImgPath));
                    pst.setBlob(4, img);
                }
                else{
                    pst = con.prepareStatement("update barang set nama_barang = ?, jumlah = ?, harga_sewa = ? where kode_barang = '"+jLabelkode_barang.getText()+"'");
                    pst.setString(1, nama_barangTF.getText());
                    pst.setString(2, jumlahTF.getText());
                    pst.setString(3, harga_sewaTF.getText());
                }
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate!!!");
                showTabel();
                reset();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcariKeyReleased
        // TODO add your handling code here:
        String cari = jcari.getText().trim();
        while(jTableBarang.getRowCount() > 0){
            tabelmodel.removeRow(0);
        }
        try{
            con = Koneksi.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery("select * from barang where nama_barang like '%"+cari+"%'");
            if(rs.first()){
                String data[] = new String[6];
                do{
                    for(int i=0;i<6;i++){
                        data[i] = rs.getString(i+1);
                    }
                    tabelmodel.addRow(data);
                }
                while(rs.next());
            }
            rs.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jcariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barangPanel;
    private javax.swing.JScrollPane barangScrollPane;
    private javax.swing.JTextField harga_sewaTF;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelkode_barang;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBarang;
    private javax.swing.JTextField jcari;
    private javax.swing.JComboBox jenis_barangCB;
    private javax.swing.JTextField jumlahTF;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField nama_barangTF;
    // End of variables declaration//GEN-END:variables
}
