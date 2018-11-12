//Kelas untuk koneksi ke database
package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Koneksi {
    
 private  Connection con;
 public Statement st;
public ResultSet rs; 

    public Connection getKoneksi() {
//        return koneksi;
// }
 
   // public void koneksiDatabase() { //<-- untuk koneksi ke database
        // Cek Driver
        try {// untuk koneksi ke driver
                                    // untuk mencari library
                                    Class.forName("com.mysql.jdbc.Driver"); //LOAD DRIVER
                                    System.out.println("berhasil load driver");
                        } catch (ClassNotFoundException no) {
                                    System.out.println("Tidak ada Driver " + no);
                        }
                        try {// untuk koneksi ke database
                                    String url = "jdbc:mysql://localhost:3306/koperasi"; //driver yg akan dpakai dan nama basis datanya
                                    con = DriverManager.getConnection(url, "root", "");
                                    System.out.println("Berhasil koneksi ke database");
                        } catch (SQLException e) {
                                    System.out.println("Gagal koneksi " + e);
                                    JOptionPane.showMessageDialog(null, "Gagal Mengoneksikan ke Database", "Peringatan", JOptionPane.WARNING_MESSAGE);
                        }
                        return con;
    }
}