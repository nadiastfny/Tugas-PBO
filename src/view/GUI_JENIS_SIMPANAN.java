/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.model_jenis_simpanan;
import database.Koneksi;
import java.awt.Container;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

public class GUI_JENIS_SIMPANAN extends JFrame {
    
    public DefaultTableModel modeltabel;
    JScrollPane scrollPane = new JScrollPane();
                        
     String[][] data = new String[100][2];                    
        ResultSet rs;
        Statement st;
    JPanel konten;
    JTable tabel;
    //JLabel background = new JLabel(); 
   
    
    JLabel ljudul = new JLabel("Formulir Simpanan Koperasi ");
    JLabel lkode = new JLabel("Kode Simpanan ");
    JLabel lnama = new JLabel("Nama Simpanan ");
    
    JTextField tkode  = new JTextField("");
    JTextField tnama  = new JTextField("");
    
    JButton bupdate = new JButton("Update");
    JButton bsimpan = new JButton("Simpan");
    JButton bedit = new JButton("Edit");
    JButton bhapus = new JButton("Hapus");
    JButton bkembali = new JButton("Kembali");
    
    public GUI_JENIS_SIMPANAN()
    {
        dispose();
        tampilData();
        tabel = new JTable();
        modeltabel = new DefaultTableModel(data, new String[] {"Kode Simpanan","Nama Simpanan"});
        tabel.setModel(modeltabel);
        scrollPane = new JScrollPane(tabel);
        //tabel();
        
         model_jenis_simpanan mdl = new model_jenis_simpanan();

        setTitle ("Formulir Simpanan");
        setVisible(true);
        setResizable(false);
        setSize (600,485);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 685, 620);
        konten= new JPanel();
        konten.setBorder(new EmptyBorder(5,5,5,5)); 
        setContentPane(konten);
        konten.setLayout(null);
        //modeltabel = new DefaultTableModel(null, judul);
        //setLayout(null);    // menggunakan Layout null
        konten.add(ljudul);
        konten.add(lkode);
        konten.add(lnama); 
        
        konten.add(tkode);  
        konten.add(tnama); 
        
        konten.add(bsimpan);  
        konten.add(bupdate);  
        konten.add(bedit);  
        konten.add(bhapus);  
        konten.add(bkembali);
        konten.add(scrollPane);
       // konten.add(background);
         
        ljudul.setBounds(20, 10, 250, 25);
        
       lkode.setBounds(30, 60, 100, 20);
       lnama.setBounds(280, 60, 100, 20);
       tkode.setBounds(140, 60, 120, 20);
       tnama.setBounds(390, 60, 200, 20);
       
       bsimpan.setBounds(30, 100, 80, 20);
       bupdate.setBounds(130, 100, 80, 20);
       bedit.setBounds(230, 100, 80, 20);
       bhapus.setBounds(330, 100, 80, 20);
       bkembali.setBounds(430, 100, 80, 20);
       
//       tkode.setColumns(10);
//       tjenis.setColumns(30);
//       tmaxpinj.setColumns(10);
//       tmaxang.setColumns(2);
//       tbunga.setColumns(5);
       
       scrollPane.setBounds(20, 140 , 520, 450);
 
       tabel.addMouseListener(new java.awt.event.MouseAdapter(){ // menambahkan MouseListener pada jTabel
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                 if (e.getClickCount() == 2||e.getClickCount() == 1) {
                     
                tabel = (JTable)e.getSource();
                int row = tabel.getSelectedRow();
                
                tkode.setEditable(false);
                
                tkode.setText(data[row][0]);
                tnama.setText(data[row][1]);

                }  
            }
        });
     
            
        bsimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
 
        String kode = tkode.getText();
        String nama = tnama.getText();

       if (!tkode.getText().isEmpty() && !tnama.getText().isEmpty() ) 
       {
            mdl.simpan(kode,nama);
            tkode.setText("");
            tnama.setText("");

         tampilData();
         //awal();
        }
        else {
        JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan" ,JOptionPane.INFORMATION_MESSAGE );
       }
}   
    });
                  
         bupdate.addActionListener(new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent aa){ 
  
            String kode = tkode.getText();
            String nama= tnama.getText();
            if (!tkode.getText().isEmpty() && !tnama.getText().isEmpty() ) 
       {
            mdl.update(kode,nama);
            tkode.setText("");
            tnama.setText("");
            tampilData();
       JOptionPane.showMessageDialog(null,"Data Berhasil diubah","Koneksi Sukses",JOptionPane.INFORMATION_MESSAGE);
        }
            else {
       JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan" ,JOptionPane.INFORMATION_MESSAGE );
       }
        } });
         
         
          bedit.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent aa){
            //aktif();
            tkode.setEnabled(false);
            bupdate.setEnabled(true);
            bedit.setEnabled(false);
            bhapus.setEnabled(false);
        }

        });
          
           bhapus.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent aa){

             if (!tkode.getText().isEmpty()) {
                 String kode = tkode.getText();
            if (JOptionPane.showConfirmDialog(rootPane, "Yakin Menghapus?", "Hapus", 1) == 0) {
            mdl.hapus(kode);
            tkode.setText("");
            tnama.setText("");
            tampilData();
            } } else {
            JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
});
           
            bkembali.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent aa){
//            GUIMENU c = new GUIMENU();
//            c.setVisible(true);
            dispose(); 
            new viewUtama();
        }
        });
    tampilData();        
    setVisible(true);   
}
   
      public void tampilData(){

        try{
            java.sql.Connection con;
            con = new Koneksi().getKoneksi();
            st=con.createStatement();
            String sql = "SELECT * FROM `jenis_simpanan` ";
            rs = st.executeQuery(sql);
            int p=0;
            while(rs.next()){
                data[p][0]=rs.getString("Kode");
                data[p][1]=rs.getString("Nama");
                p++;
            }
            st.close();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!","Hasil", JOptionPane.ERROR_MESSAGE);
        }
        
    }
            
       
            
    
}
