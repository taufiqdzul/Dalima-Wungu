/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoSequenceKelompok3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author naintu
 */
public class Koneksi {
    static Connection con;
    public static Connection getConnection(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/sewa","root","");
            return con;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Database Not Connected");
            return null;
        }
    }
}
