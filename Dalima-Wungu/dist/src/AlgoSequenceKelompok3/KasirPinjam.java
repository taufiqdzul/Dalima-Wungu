/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoSequenceKelompok3;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author naintu
 */
public class KasirPinjam extends javax.swing.JPanel {

    /**
     * Creates new form KasirPinjam
     */
    
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    Statement stm;
    String ImgPath = null;
    DefaultTableModel tabelmodel;
    String kode_barang;
    
    public KasirPinjam() {
        initComponents();
        String []tabelHeader = {"Kode Barang","Nama Barang","Jenis Barang","Stok","Harga Sewa","Gambar"};
        tabelmodel = new DefaultTableModel(tabelHeader, 0);
        jTableSewa.setModel(tabelmodel);
        showTabel();
        hitungKeranjang();
    }
    
    private void showTabel(){
        int row = jTableSewa.getRowCount();
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
    
    private void hitungKeranjang(){
        try{
            con = Koneksi.getConnection();
            stm = con.createStatement();
            String SQL = ("select count(id_keranjang) from keranjang");
            rs = stm.executeQuery(SQL);
            while(rs.next()){
                jLabelNotif.setText(rs.getString("count(id_keranjang)"));
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
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

        pinjamPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcari = new javax.swing.JTextField();
        jLabelNotif = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSewa = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelkode_barang = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jJumlah = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        pinjamPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 165, 186));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Data Barang yang Disewakan");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon search blue.png"))); // NOI18N
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 17, 20, 20));

        jcari.setBackground(new java.awt.Color(0, 165, 186));
        jcari.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jcari.setForeground(new java.awt.Color(255, 255, 255));
        jcari.setBorder(null);
        jcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcariKeyReleased(evt);
            }
        });
        jPanel4.add(jcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 12, 250, 25));

        jLabelNotif.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        jLabelNotif.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNotif.setText("0");
        jPanel4.add(jLabelNotif, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 17, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon notifikasi keranjang.png"))); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 15, 60, 30));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 37, 250, 1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button refresh.png"))); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 15, 60, 30));

        pinjamPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1026, 60));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableSewa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTableSewa.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableSewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSewaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSewa);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 986, 410));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel2.setText("Kode Barang");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel3.setText(":");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        jLabelkode_barang.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jPanel5.add(jLabelkode_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel9.setText("Jumlah");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 478, -1, 20));

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

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 528, 500, 1));

        jJumlah.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jJumlah.setBorder(null);
        jPanel5.add(jJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 498, 500, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button add.png"))); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 548, 100, 30));

        pinjamPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1026, 598));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pinjamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pinjamPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        KasirKeranjang keranjang = new KasirKeranjang();
        keranjang.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int jumlah_barang = 0;
        try{
            con = Koneksi.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery("select * from barang where kode_barang = '"+jLabelkode_barang.getText()+"'");
            while(rs.next()){
                jumlah_barang = rs.getInt("jumlah");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        if(jLabelkode_barang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Barang Belum Terpilih!!!", "Failure", JOptionPane.ERROR_MESSAGE);
        }
        else if(jJumlah.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Form Jumlah Tidak Boleh Kosong!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            jJumlah.requestFocus();
        }
        else if(!jJumlah.getText().matches("[0-9]*")){
            JOptionPane.showMessageDialog(null, "Form Jumlah Tidak Boleh Karakter!!!", "Failure", JOptionPane.ERROR_MESSAGE);
            jJumlah.requestFocus();
        }
        else if(jJumlah.getText().matches("[0-9]*")){
            int jumlah_validasi = Integer.parseInt(jJumlah.getText());
            if(jumlah_validasi > jumlah_barang){
                JOptionPane.showMessageDialog(null, "Jumlah Barang Tidak Cukup!!!", "Failure", JOptionPane.ERROR_MESSAGE);
                jJumlah.requestFocus();
            }
            else{
                try{
                    con = Koneksi.getConnection();
                    stm = con.createStatement();
                    String SQL = ("select * from barang where kode_barang = '"+jLabelkode_barang.getText()+"'");
                    rs = stm.executeQuery(SQL);
                    String nama_barang = null;
                    String jenis_barang = null;
                    int jumlah = 0;
                    float harga_sewa = 0;
                    while(rs.next()){
                        nama_barang = rs.getString("nama_barang");
                        jenis_barang = rs.getString("jenis_barang");
                        jumlah = rs.getInt("jumlah");
                        harga_sewa = rs.getFloat("harga_sewa");
                    }
                    System.out.println(nama_barang);
                    System.out.println(jenis_barang);
                    System.out.println(harga_sewa);
                    pst = con.prepareStatement("insert into keranjang values(null,?,?,?,?,?,?)");
                    pst.setString(1, jLabelkode_barang.getText());
                    pst.setString(2, nama_barang);
                    pst.setString(3, jenis_barang);
                    pst.setFloat(4, harga_sewa);
                    pst.setString(5, jJumlah.getText());
                    float total = harga_sewa*Integer.parseInt(jJumlah.getText());
                    pst.setFloat(6, total);
                    pst.executeUpdate();

                    pst2 = con.prepareStatement("update barang set jumlah = ? where kode_barang = '"+jLabelkode_barang.getText()+"'");
                    int jumlah_update = jumlah-Integer.parseInt(jJumlah.getText());
                    pst2.setInt(1, jumlah_update);
                    pst2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan ke Keranjang");
                    jLabelkode_barang.setText(null);
                    jJumlah.setText(null);
                    showTabel();
                    hitungKeranjang();
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
        System.out.println(jumlah_barang);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTableSewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSewaMouseClicked
        // TODO add your handling code here:
        int i = jTableSewa.getSelectedRow();
        jLabelkode_barang.setText(jTableSewa.getValueAt(i, 0).toString());
        jJumlah.requestFocus();
    }//GEN-LAST:event_jTableSewaMouseClicked

    private void jcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcariKeyReleased
        // TODO add your handling code here:
        String cari = jcari.getText().trim();
        while(jTableSewa.getRowCount() > 0){
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        showTabel();
        hitungKeranjang();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JTextField jJumlah;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNotif;
    private javax.swing.JLabel jLabelkode_barang;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableSewa;
    private javax.swing.JTextField jcari;
    private javax.swing.JPanel pinjamPanel;
    // End of variables declaration//GEN-END:variables
}