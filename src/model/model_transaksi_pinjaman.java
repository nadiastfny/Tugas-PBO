/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Koneksi;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class model_transaksi_pinjaman {
    Statement st;
    ResultSet rs;
    
    public void hapus (String nopinjam )
    {
            java.sql.Connection con;
            con = new Koneksi().getKoneksi();
            String sql="delete from trans_pinjaman where nopinjam='"+nopinjam +"'";
            Statement s;
        try
        {  
            s = con.createStatement();
            s.executeUpdate(sql);

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
   
   
    public void simpan(String nopinjam,String tgl, String nomor,String ket, String pinjam, String lama, String persenbunga, String persenadmin, String jumlahbunga, String total, String angsuran)
    {
                    java.sql.Connection con;
                    con = new Koneksi().getKoneksi();
                    String sql =" INSERT INTO `trans_pinjaman`(`No_Pinjam`, `Tgl`, `No_Anggota`, `Keterangan`, `Pinjaman`, `Waktu`, `PersenBunga`, `PersenAdmin`, `JumlahBunga`, `Total`, `Angsuran`) VALUES  (?,?,?,?,?,?,?,?,?,?,?) ";
                    PreparedStatement pstmt;
            try {
                          
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, nopinjam);
                            pstmt.setString(2, tgl);
                            pstmt.setString(3, nomor);
                            pstmt.setString(4, ket);
                            pstmt.setString(5, pinjam);
                            pstmt.setString(6, lama);
                            pstmt.setString(7, persenbunga);
                            pstmt.setString(8, persenadmin);
                            pstmt.setString(9, jumlahbunga);
                            pstmt.setString(10, total);
                            pstmt.setString(11, angsuran);
   
                            pstmt.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Berhasil menyimpan", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                           JOptionPane.showMessageDialog(null, "Gagal Menyimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
                }
    
    public void update (String nomor, String ket, String tgl, String pinjam, String lama, String persenbunga, String persenadmin, String jumlahbunga,String total, String angsuran, String nopinjam )
    {
        java.sql.Connection con;
        con = new Koneksi().getKoneksi();
        String sql = "UPDATE `trans_pinjaman` SET `No_Pinjam`='"+ nopinjam +"', `Tanggal`='"+ tgl +"', `No_Anggota`='"+nomor+"', `Keterangan`='"+ket+"',`Pinjaman`='"+pinjam+"',`Waktu`='"+lama+"',`PersenBunga`='"+persenbunga+"', `PersenAdmin`='"+persenadmin+"',`JumlahBunga`='"+jumlahbunga+"'+`Total`='"+total+"',`Angsuran`='"+angsuran+"' WHERE `No_Pinjam`='"+nopinjam+"'";
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
         
    
    

