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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author naintu
 */
public class AdminPengguna extends javax.swing.JPanel {

    /**
     * Creates new form AdminPengguna
     */
    
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    Statement stm;
    String ImgPath = null;
    DefaultTableModel tabelmodel;
    
    public AdminPengguna() {
        initComponents();
        String []tabelHeader = {"Id Pengguna","Nama","Alamat","Jabatan","Username","Password","Foto"};
        tabelmodel = new DefaultTableModel(tabelHeader, 0);
        jTablePengguna.setModel(tabelmodel);
        showTabel();
        jButton12.setEnabled(false);
        jButton13.setEnabled(false);
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
        int row = jTablePengguna.getRowCount();
        for(int i=0; i<row; i++){
            tabelmodel.removeRow(0);
        }
        try{
            con = Koneksi.getConnection();
            stm = con.createStatement();
            String SQL = ("select pengguna.id_pengguna, pengguna.nama_pengguna, pengguna.alamat_pengguna, pengguna.jabatan, akun.username, akun.password, pengguna.foto from pengguna, akun where pengguna.id_pengguna = akun.id_pengguna");
            rs = stm.executeQuery(SQL);
            while(rs.next()){
                String data[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7)};
                tabelmodel.addRow(data);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public boolean validasi(){
        if(jNama.getText().isEmpty() && jAlamat.getText().isEmpty() && jJabatan.getSelectedItem() == "-- Pilih Jabatan --" && jUsername.getText().isEmpty() && jPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Form Masih Kosong!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            jNama.requestFocus();
            return false;
        }
        else if(jNama.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Form Nama Barang Belum Dipilih!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            jNama.requestFocus();
            return false;
        }
        else if(jAlamat.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Form Alamat Tidak Boleh Kosong!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            jAlamat.requestFocus();
            return false;
        }
        else if(jJabatan.getSelectedItem() == "-- Pilih Jabatan --"){
            JOptionPane.showMessageDialog(null, "Form Jenis Barang Belum Dipilih!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            jJabatan.requestFocus();
            return false;
        }
        else if(jUsername.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Form Username Tidak Boleh Kosong!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            jUsername.requestFocus();
            return false;
        }
        else if(jPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Form Password Sewa Tidak Boleh Kosong!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            jPassword.requestFocus();
            return false;
        }
        else if(! jNama.getText().matches("[ a-zA-Z]*")){
            JOptionPane.showMessageDialog(null, "Form Nama Tidak Boleh Angka!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            jNama.requestFocus();
            return false;
        }
        else{
            return true;
        }
    }
    
    private void reset(){
        jIdPengguna.setText(null);
        jNama.setText(null);
        jAlamat.setText(null);
        jUsername.setText(null);
        jPassword.setText(null);
        imgLabel.setIcon(null);
        jButton11.setEnabled(true);
        jButton12.setEnabled(false);
        jButton13.setEnabled(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        penggunaScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        penggunaPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jNama = new javax.swing.JTextField();
        jAlamat = new javax.swing.JTextField();
        jJabatan = new javax.swing.JComboBox();
        jUsername = new javax.swing.JTextField();
        jPassword = new javax.swing.JTextField();
        imgLabel = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jIdPengguna = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jcari = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePengguna = new javax.swing.JTable();

        penggunaScrollPane.setBorder(null);
        penggunaScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        penggunaPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(0, 165, 186));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Input Data Pengguna");
        jPanel12.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, -1, -1));

        penggunaPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1014, 60));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel17.setText("Username");
        jPanel13.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 20));

        jLabel18.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel18.setText("Nama");
        jPanel13.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jLabel19.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel19.setText("Alamat");
        jPanel13.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jLabel20.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel20.setText("Jabatan");
        jPanel13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));

        jLabel21.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel21.setText("Password");
        jPanel13.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 20));

        jPanel14.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 500, 1));

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 500, 1));

        jPanel16.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 500, 1));

        jPanel17.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 500, 1));

        jPanel18.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 500, 1));

        jNama.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jNama.setBorder(null);
        jPanel13.add(jNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 500, 30));

        jAlamat.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jAlamat.setBorder(null);
        jPanel13.add(jAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 500, 30));

        jJabatan.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jJabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Jabatan --", "Admin", "Kasir" }));
        jJabatan.setBorder(null);
        jPanel13.add(jJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 500, 30));

        jUsername.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jUsername.setBorder(null);
        jPanel13.add(jUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 500, 30));

        jPassword.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPassword.setBorder(null);
        jPanel13.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 500, 30));

        imgLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.add(imgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 180, 180));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button img.png"))); // NOI18N
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 100, 30));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button insert.png"))); // NOI18N
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 30));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button update.png"))); // NOI18N
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 330, 100, 30));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button delete.png"))); // NOI18N
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 330, 100, 30));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button reset.png"))); // NOI18N
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 100, 30));
        jPanel13.add(jIdPengguna, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 55, -1, -1));

        penggunaPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1014, 380));

        jPanel19.setBackground(new java.awt.Color(122, 171, 65));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Data Pengguna");
        jPanel19.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon search.png"))); // NOI18N
        jPanel19.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 17, 20, 20));

        jcari.setBackground(new java.awt.Color(122, 171, 65));
        jcari.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jcari.setForeground(new java.awt.Color(255, 255, 255));
        jcari.setBorder(null);
        jcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcariKeyReleased(evt);
            }
        });
        jPanel19.add(jcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 12, 250, 25));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 37, 250, 1));

        penggunaPanel1.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 1014, 60));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablePengguna.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTablePengguna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Pengguna", "Nama", "Alamat", "Jabatan", "Username", "Password", "Foto"
            }
        ));
        jTablePengguna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePenggunaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePengguna);

        jPanel21.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 974, 360));

        penggunaPanel1.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1014, 400));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(penggunaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 621, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(penggunaPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );

        penggunaScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(penggunaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(penggunaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 342, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        if(validasi() == false){
            
        }
        else if(ImgPath == null){
            JOptionPane.showMessageDialog(null, "Gambar Belum Dipilih!!!", "Failure", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try{
                con = Koneksi.getConnection();
                pst = con.prepareStatement("insert into pengguna values(null,?,?,?,?)");
                pst.setString(1, jNama.getText());
                pst.setString(2, jAlamat.getText());
                pst.setString(3, jJabatan.getSelectedItem().toString());
                InputStream img = new FileInputStream(new File(ImgPath));
                pst.setBlob(4, img);
                pst.executeUpdate();

                pst2 = con.prepareStatement("insert into akun values(?,?,?,?)");
                pst2.setString(1, jUsername.getText());
                pst2.setString(2, jPassword.getText());
                int jabatan = 0;
                if(jJabatan.getSelectedItem() == "Admin"){
                    jabatan = 0;
                }
                else{
                    jabatan = 1;
                }
                pst2.setInt(3, jabatan);

                stm = con.createStatement();
                String SQL = ("select id_pengguna from pengguna order by id_pengguna desc limit 1");
                rs = stm.executeQuery(SQL);
                String id_pengguna = null;
                while(rs.next()){
                    id_pengguna = rs.getString("id_pengguna");
                }

                pst2.setString(4, id_pengguna);
                pst2.executeUpdate();

                showTabel();
                reset();
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
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
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTablePenggunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePenggunaMouseClicked
        // TODO add your handling code here:
        jButton11.setEnabled(false);
        jButton12.setEnabled(true);
        jButton13.setEnabled(true);
        int i = jTablePengguna.getSelectedRow();
        jIdPengguna.setText(jTablePengguna.getValueAt(i, 0).toString());
        jNama.setText(jTablePengguna.getValueAt(i, 1).toString());
        jAlamat.setText(jTablePengguna.getValueAt(i, 2).toString());
        jJabatan.setSelectedItem(jTablePengguna.getValueAt(i, 3).toString());
        jUsername.setText(jTablePengguna.getValueAt(i, 4).toString());
        jPassword.setText(jTablePengguna.getValueAt(i, 5).toString());
        try{
            con = Koneksi.getConnection();
            stm = con.createStatement();
            String SQL = ("select * from pengguna where id_pengguna = '"+jIdPengguna.getText()+"'");
            rs = stm.executeQuery(SQL);
            while(rs.next()){
                byte[] img = rs.getBytes("foto");
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH));
                imgLabel.setIcon(imageIcon);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jTablePenggunaMouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if(jIdPengguna.getText() != null){
            int option = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Menghapusnya?");
            if(option == JOptionPane.YES_OPTION){
                try{
                    con = Koneksi.getConnection();
                    con.createStatement().executeUpdate("delete from pengguna where id_pengguna = '"+jIdPengguna.getText()+"'");
                    con.createStatement().executeUpdate("delete from akun where id_pengguna = '"+jIdPengguna.getText()+"'");
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
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        if(validasi() == false){
            
        }
        else{
            try{
                con = Koneksi.getConnection();
                if(ImgPath != null){
                    pst = con.prepareStatement("update pengguna set nama_pengguna = ?, alamat_pengguna = ?, jabatan = ?, foto=? where id_pengguna = '"+jIdPengguna.getText()+"'");
                    pst.setString(1, jNama.getText());
                    pst.setString(2, jAlamat.getText());
                    pst.setString(3, jJabatan.getSelectedItem().toString());
                    InputStream img = new FileInputStream(new File(ImgPath));
                    pst.setBlob(4, img);
                    
                    pst2 = con.prepareStatement("update akun set username = ?, password = ?, hak_akses = ? where id_pengguna = '"+jIdPengguna.getText()+"'");
                    pst2.setString(1, jUsername.getText());
                    pst2.setString(2, jPassword.getText());
                    int jabatan = 0;
                    if(jJabatan.getSelectedItem() == "Admin"){
                        jabatan = 0;
                    }
                    else{
                        jabatan = 1;
                    }
                    pst2.setInt(3, jabatan);
                }
                else{
                    pst = con.prepareStatement("update pengguna set nama_pengguna = ?, alamat_pengguna = ?, jabatan = ? where id_pengguna = '"+jIdPengguna.getText()+"'");
                    pst.setString(1, jNama.getText());
                    pst.setString(2, jAlamat.getText());
                    pst.setString(3, jJabatan.getSelectedItem().toString());
                    
                    pst2 = con.prepareStatement("update akun set username = ?, password = ?, hak_akses = ? where id_pengguna = '"+jIdPengguna.getText()+"'");
                    pst2.setString(1, jUsername.getText());
                    pst2.setString(2, jPassword.getText());
                    int jabatan = 0;
                    if(jJabatan.getSelectedItem() == "Admin"){
                        jabatan = 0;
                    }
                    else{
                        jabatan = 1;
                    }
                    pst2.setInt(3, jabatan);
                }
                pst.executeUpdate();
                pst2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate!!!");
                showTabel();
                reset();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcariKeyReleased
        // TODO add your handling code here:
        String cari = jcari.getText().trim();
        while(jTablePengguna.getRowCount() > 0){
            tabelmodel.removeRow(0);
        }
        try{
            con = Koneksi.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery("select pengguna.id_pengguna, pengguna.nama_pengguna, pengguna.alamat_pengguna, pengguna.jabatan, akun.username, akun.password, pengguna.foto from pengguna, akun where pengguna.id_pengguna = akun.id_pengguna and pengguna.nama_pengguna like '%"+cari+"%'");
            if(rs.first()){
                String data[] = new String[7];
                do{
                    for(int i=0;i<7;i++){
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
    private javax.swing.JLabel imgLabel;
    private javax.swing.JTextField jAlamat;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jIdPengguna;
    private javax.swing.JComboBox jJabatan;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jNama;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JTextField jPassword;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePengguna;
    private javax.swing.JTextField jUsername;
    private javax.swing.JTextField jcari;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel penggunaPanel1;
    private javax.swing.JScrollPane penggunaScrollPane;
    // End of variables declaration//GEN-END:variables
}
