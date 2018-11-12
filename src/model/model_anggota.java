/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Koneksi;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class model_anggota {
    ResultSet rs;
 
    
    public void simpan (String nomor, String nama, String alamat, String kota, String notelp, String pekerjaan) {
                    java.sql.Connection con;
                    con = new Koneksi().getKoneksi();
                    String sql = "INSERT INTO `anggota`(`No_Anggota`, `Nama`, `Alamat`, `Kota`, `No_Telp`, `Pekerjaan` ) VALUES (?,?,?,?,?,?) ";
                    PreparedStatement pstmt;
            try {
                          
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, nomor);
                            pstmt.setString(2, nama);
                            pstmt.setString(3, alamat);
                            pstmt.setString(4, kota);
                            pstmt.setString(5, notelp);
                            pstmt.setString(6, pekerjaan);
                            pstmt.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Berhasil menyimpan", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                           JOptionPane.showMessageDialog(null, "Gagal Menyimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
                }

            public void hapus(String nomor) {
                    java.sql.Connection con;
                    con = new Koneksi().getKoneksi();
                    String sql = "DELETE FROM `anggota` WHERE `No_Anggota`='" + nomor + "' ";
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

            public void update (String nomor, String nama, String alamat, String kota, String notelp, String pekerjaan)
            {
                    java.sql.Connection con;
                    con = new Koneksi().getKoneksi();
                    String sql = "UPDATE `anggota` SET `No_Anggota`='" + nomor + "',`Nama`='" + nama + "',`Alamat`='" + alamat + "',`Kota`='" + kota + "',`No_Telp`='" + notelp + "',`Pekerjaan`='" + pekerjaan + "' WHERE `No_Anggota`='" + nomor + "' ";
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
