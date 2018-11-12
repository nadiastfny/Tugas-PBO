/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class model_transaksi_simpanan {
    Statement st;
    ResultSet rs;
    
     public void hapus (String nosimpan ) 
    {
            java.sql.Connection con;
            con = new Koneksi().getKoneksi();
             String sql="DELETE FROM `trans_simpanan` WHERE `No_Simpan`='"+nosimpan+"'";
            String sql1="DELETE FROM `detail_simpanan` WHERE `No_Simpan`='"+nosimpan+"'";
            
            Statement s;
        try
        {  
            s = con.createStatement();
            s.executeUpdate(sql);
            st.executeUpdate(sql1);

            JOptionPane.showMessageDialog(null,"Database Berhasil Terhapus","Koneksi Sukses",JOptionPane.INFORMATION_MESSAGE);
            con.close();
       // awal();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        JOptionPane.showMessageDialog(null,"<Error> Koneksikan Xampp Terlebih Dahulu : "+e,"Koneksi Gagal",JOptionPane.WARNING_MESSAGE);
        }   
    }
   
   
    public void simpan(String nosimpan,String tgl,String nomor,String simpanan,String penarikan, String saldo) 
    {
                    java.sql.Connection con;
                    con = new Koneksi().getKoneksi();
                    String sql =" INSERT INTO `trans_simpanan`(`No_Simpan`, `Tgl`, `No_Anggota`, `Saldo`) VALUES  (?,?,?,?) ";
                     String sql1 =" INSERT INTO `detail_simpanan`(`No_Simpan`,`No_Anggota`, `Simpan`, `Penarikan`, `Saldo`) VALUES  (?,?,?,?,?) ";
                    PreparedStatement pstmt;
                    PreparedStatement pstmt1;
            try {
                          
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, nosimpan);
                            pstmt.setString(2, tgl);
                            pstmt.setString(3, nomor);
                            pstmt.setString(4, saldo); 
                            
                            pstmt1 = con.prepareStatement(sql1);
                            pstmt1.setString(1, nosimpan);
                            pstmt1.setString(2, nomor);
                            pstmt1.setString(3, simpanan);
                            pstmt1.setString(4, penarikan); 
                            pstmt1.setString(5, saldo); 
  
                            pstmt.executeUpdate();
                            pstmt1.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Berhasil menyimpan", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                           JOptionPane.showMessageDialog(null, "Gagal Menyimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
    }   
    
    public void update (String nosimpan,String nomor,String simpanan,String penarikan, String saldo )
    {
        java.sql.Connection con;
        con = new Koneksi().getKoneksi();
        String sql = "UPDATE `trans_simpanan` SET `Saldo`='"+ saldo +"' WHERE `No_Simpan`='"+nosimpan+"'";
        String sql1="UPDATE `detail_simpanan` SET `No_Anggota` ='" +nomor +"', `Simpan`='"+ simpanan +"', `Penarikan`='"+ penarikan +"', `Saldo`='"+ saldo +"' WHERE No_Simpan='"+ nosimpan +"'";
        Statement s;  
    try {
                            s = con.createStatement();
                            s.executeUpdate(sql);
                            s.executeUpdate(sql1);
                            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    }
    }
}
