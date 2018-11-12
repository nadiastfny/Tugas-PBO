/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Koneksi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class model_jenis_simpanan {
     public void simpan (String kode, String nama) {
                    java.sql.Connection con;
                    con = new Koneksi().getKoneksi();
                    String sql = "INSERT INTO `jenis_simpanan` (`Kode`, `Nama` ) VALUES (?,?) ";
                    PreparedStatement pstmt;
            try {
                          
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, kode);
                            pstmt.setString(2, nama);
                            pstmt.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Berhasil menyimpan", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                           JOptionPane.showMessageDialog(null, "Gagal Menyimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
                }

            public void hapus(String kode) {
                    java.sql.Connection con;
                    con = new Koneksi().getKoneksi();
                    String sql = "DELETE FROM `jenis_simpanan` WHERE `Kode`='" + kode + "' ";
                    Statement s;
            try {
                            s = con.createStatement();
                            s.executeUpdate(sql);
                            JOptionPane.showMessageDialog(null, "Data Terhapus", "sukses", JOptionPane.INFORMATION_MESSAGE);                                             
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    }
                }

            public void update (String kode, String nama)
            {
                    java.sql.Connection con;
                    con = new Koneksi().getKoneksi();
                    String sql = "UPDATE `jenis_simpanan` SET `Kode`='" + kode + "',`Nama`='" + nama  + "' WHERE `Kode`='" + kode + "' ";
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
