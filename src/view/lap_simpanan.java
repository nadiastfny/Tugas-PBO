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
public class lap_simpanan extends JFrame {
    
    public DefaultTableModel model;
    JTable tabel;
    JScrollPane scrollPane;
    
    JLabel judul = new JLabel("Laporan Transaksi Simpanan");
    String[][] data = new String[100][4];
    Statement st;
    ResultSet rs;
    JButton bkembali = new JButton("Kembali");
    
    public lap_simpanan(){

        tampilData();
        tabel = new JTable();
        
        
        model = new DefaultTableModel(data,new String[] {"No. Transaksi", "Tanggal", "No Anggota", "Saldo" });
        tabel.setModel(model);
        scrollPane = new JScrollPane(tabel);
        
        
       
        setTitle("Laporan");
        setSize(800,700);
        setDefaultCloseOperation(3);
        
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        add(scrollPane);
        add(judul);
        add(bkembali);
        
        judul.setBounds(300,15,200,20);
        scrollPane.setBounds(20,45,750,650);    //posisi tabel
        bkembali.setBounds(700,15,80,25);
                
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
           String sql = "SELECT `No_Simpan`, `Tgl`, `No_Anggota`, `Saldo` FROM `trans_simpanan`";
            
            rs = st.executeQuery(sql);
            int p=0;
            while(rs.next()){
                data[p][0]=rs.getString("No_Simpan");
                data[p][1]=rs.getString("Tgl");
                data[p][2]=rs.getString("No_Anggota");
                data[p][3]=rs.getString("Saldo");
                p++;
            }
            
            st.close();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!","Hasil", JOptionPane.ERROR_MESSAGE);
        }
        
    
}
    

}
