/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.Koneksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class lap_pinjaman extends JFrame {
    
    public DefaultTableModel model;
    JTable tabel;
    JScrollPane scrollPane;
    
    JLabel judul = new JLabel("Laporan Transaksi Pinjaman");
    String[][] data = new String[100][11];
    Statement st;
    ResultSet rs;
    JButton bkembali = new JButton("Kembali");
    
    public lap_pinjaman(){

        tampilData();
        tabel = new JTable();
        
        
        model = new DefaultTableModel(data,new String[] {"No. Pinjam", "Tanggal", "No Anggota", "Keterangan", "Pinjaman", "Waktu", "Bunga(%)", "Admin(%)", "Jumlah Bunga", "Total", "Angsuran" });
        tabel.setModel(model);
        scrollPane = new JScrollPane(tabel);
        
        
       
        setTitle("Laporan");
        setSize(1000,800);
        setDefaultCloseOperation(3);
        
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        add(scrollPane);
        add(judul);
        add(bkembali);
        
        judul.setBounds(380,15,200,20);
        scrollPane.setBounds(20,45,950,750);
        bkembali.setBounds(800,15,80,25);
         
        bkembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
              //  new GUIMENU().setVisible(true);
              dispose();
              new viewUtama();
        
            }
        });
        
   
    }
    
    public void tampilData(){
        try{
                java.sql.Connection con;
             con = new Koneksi().getKoneksi();
            st = con.createStatement();
           String sql = "SELECT `No_Pinjam`, `Tgl`, `No_Anggota`, `Keterangan`, `Pinjaman`, `Waktu`, `PersenBunga`, `PersenAdmin`, `JumlahBunga`, `Total`, `Angsuran` FROM `trans_pinjaman` ";
            
            rs = st.executeQuery(sql);
            int p=0;
            while(rs.next()){
                data[p][0]=rs.getString("No_Pinjam");
                data[p][1]=rs.getString("Tgl");
                data[p][2]=rs.getString("No_Anggota");
                data[p][3]=rs.getString("Keterangan");
                data[p][4]=rs.getString("Pinjaman");
                data[p][5]=rs.getString("Waktu");
                data[p][6]=rs.getString("PersenBunga");
                data[p][7]=rs.getString("PersenAdmin");
                data[p][8]=rs.getString("JumlahBunga");
                data[p][9]=rs.getString("Total");
                data[p][10]=rs.getString("Angsuran");
                p++;
            }
            
            st.close();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!","Hasil", JOptionPane.ERROR_MESSAGE);
        }
        
    
}
    

}
