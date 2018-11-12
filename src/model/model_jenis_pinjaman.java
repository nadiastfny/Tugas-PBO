/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Koneksi;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class model_jenis_pinjaman {
 
  
  //  Statement st;
public void simpanpinjaman (String kode, String jenispinjaman, String maxpinjaman, String maxangsuran, String bunga) {
                    java.sql.Connection con;
                    con = new Koneksi().getKoneksi();
                    String sql = "INSERT INTO `jenis_pinjaman`(`kode`, `jenispinjaman`, `maxpinjaman`, `maxangsuran`, `bunga`) VALUES (?,?,?,?,?) ";
                    PreparedStatement pstmt;
            try {
                         //  pstmt = (PreparedStatement) con.prepareStatement(sql);
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, kode);
                            pstmt.setString(2, jenispinjaman);
                            pstmt.setString(3, maxpinjaman);
                            pstmt.setString(4, maxangsuran);
                            pstmt.setString(5, bunga);
                            pstmt.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Berhasil menyimpan data", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                           JOptionPane.showMessageDialog(null, "Gagal Menyimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                           e.printStackTrace();
                    }
                }

            public void hapuspinjaman(String kode) {
                    java.sql.Connection con;
                    con = new Koneksi().getKoneksi();
                    String sql = "DELETE FROM `jenis_pinjaman` WHERE `kode`='" + kode + "' ";
                    Statement s;
            try {
                            s = con.createStatement();
                            s.executeUpdate(sql);
                            JOptionPane.showMessageDialog(null, "Data Terhapus", "sukses", JOptionPane.INFORMATION_MESSAGE);                                             
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            // JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!"+e, "Hasil", JOptionPane.ERROR_MESSAGE);
                    }
                }

            public void updatepinjaman(String kode, String jenispinjaman, String maxpinjaman, String maxangsuran, String bunga)
            {
                    java.sql.Connection con;
                    con = new Koneksi().getKoneksi();
                    String sql = "UPDATE `jenis_pinjaman` SET `kode`='" + kode + "',`jenispinjaman`='" + jenispinjaman + "',`maxpinjaman`='" + maxpinjaman + "',`maxangsuran`='" + maxangsuran + "',`bunga`='" + bunga + "' WHERE `kode`='" + kode + "' ";
                    Statement s;
            try {
                            s = con.createStatement();
                            s.executeUpdate(sql);
                            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    }
                }

}