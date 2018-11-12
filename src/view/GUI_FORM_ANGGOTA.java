/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import model.model_anggota;
    import database.Koneksi;
    import java.awt.Container;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
    import java.sql.*;
    import javax.swing.*;
    import static javax.swing.JFrame.EXIT_ON_CLOSE;
    import javax.swing.border.EmptyBorder;
    import javax.swing.table.DefaultTableModel;
    
/**
 *
 * @author User
 */
public class GUI_FORM_ANGGOTA extends JFrame{

   // Container konten = getContentPane();
        public DefaultTableModel modeltabel;
        JScrollPane scrollPane = new JScrollPane();
        String[][]  dataanggota= new String[100][6];                    
        ResultSet rs;
        Statement st;
        JPanel konten;
        JTable tabel;

        JLabel judul = new JLabel("Formulir Anggota Koperasi");
 
        JLabel lNomor= new JLabel("No. Anggota");
        JLabel lNama= new JLabel("Nama");
        JLabel lAlamat= new JLabel("Alamat");
        JLabel lKota= new JLabel("Kota");
        JLabel lNoTelp= new JLabel("No. Telp");
        JLabel lPekerjaan= new JLabel("Pekerjaan");
        
        JLabel lCari= new JLabel("Cari Berdasarkan");
        JLabel cariNo= new JLabel("Nomor Anggota");
        JLabel cariNama= new JLabel("Nama Anggota");
        
        JTextField tNomor = new JTextField();
        JTextField tNama = new JTextField();
        JTextField tAlamat = new JTextField();
        JTextField tKota = new JTextField();
        JTextField tNoTelp = new JTextField();
        JTextField tPekerjaan = new JTextField();
        
        JTextField tCariNo = new JTextField();
        JTextField tCariNama = new JTextField();
         
        JButton bUpdate = new JButton("Update");
        JButton bSave = new JButton("Simpan");
        JButton bReset = new JButton("Reset");
        JButton bDelete = new JButton("Hapus");
        JButton bBack = new JButton("Kembali");
        
        
    public GUI_FORM_ANGGOTA()
    {
        dispose();
        tampilData();
        tabel = new JTable();
        modeltabel = new DefaultTableModel(dataanggota, new String[] {"No Anggota","Nama","Alamat","Kota", "No Telp", "Pekerjaan"});
        tabel.setModel(modeltabel);
        scrollPane = new JScrollPane(tabel);
        //tabel();
        
        model_anggota mdlagg = new model_anggota();

        setTitle ("Formulir Anggota");
        setVisible(true);
        setResizable(false);
        setSize (8000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 685, 620);
        konten= new JPanel();
        konten.setBorder(new EmptyBorder(10,10, 10, 10)); 
        setContentPane(konten);
        setLayout(null);
        //modeltabel = new DefaultTableModel(null, judul);
        //setLayout(null);    // menggunakan Layout null
        konten.add(judul);
        
        konten.add(lNomor);
        konten.add(lNama); 
        konten.add(lAlamat); 
        konten.add(lKota); 
        konten.add(lNoTelp); 
        konten.add(lPekerjaan);  
        
        konten.add(tNomor);  
        konten.add(tNama);  
        konten.add(tAlamat);  
        konten.add(tKota);  
        konten.add(tNoTelp);  
        konten.add(tPekerjaan);  
        
        konten.add(bSave);  
        konten.add(bUpdate);  
        konten.add(bDelete);
        konten.add(bReset);
        konten.add(bBack);
        konten.add(scrollPane);
       // konten.add(background);
        
        konten.add(lCari);
        konten.add(cariNo);
        konten.add(cariNama);
        konten.add(tCariNo);
        konten.add(tCariNama);

        judul.setBounds(20, 20, 200, 20);
        
        lNomor.setBounds(20, 50, 100, 20);
        lNama.setBounds(20, 80, 100, 20);
        lAlamat.setBounds(20, 110, 100, 20);
        lKota.setBounds(20, 140, 100, 20);
        lNoTelp.setBounds(20, 170, 100, 20);
        lPekerjaan.setBounds(20, 200, 100, 20);
        
        tNomor.setBounds(120, 50, 120, 20);
        tNama.setBounds(120, 80, 120, 20);
        tAlamat.setBounds(120, 110, 120, 20);
        tKota.setBounds(120, 140, 120, 20);
        tNoTelp.setBounds(120, 170, 120, 20);
        tPekerjaan.setBounds(120, 200, 120, 20);
        
        bUpdate.setBounds(300, 50, 90, 20);
        bSave.setBounds(300, 80, 90, 20);
        bReset.setBounds(300, 110, 90, 20);
        bDelete.setBounds(300, 140, 90, 20);
        bBack.setBounds(300, 170, 90, 20);
        
        lCari.setBounds(20, 240, 150, 20);
        cariNo.setBounds(20, 270, 110, 20);
        cariNama.setBounds(260, 270, 110, 20);
        tCariNo.setBounds(130, 270, 120, 20);
        tCariNama.setBounds(390, 270, 120, 20);
      
        scrollPane.setBounds(20, 320, 670, 650);
        
        tabel.addMouseListener(new java.awt.event.MouseAdapter(){ // menambahkan MouseListener pada jTabel
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                 if (e.getClickCount() == 2||e.getClickCount() == 1) {
                     
                tabel = (JTable)e.getSource();
                int row = tabel.getSelectedRow();
                
                tNomor.setEditable(false);
     
                tNomor.setText(dataanggota[row][0]);
                tNama.setText(dataanggota[row][1]);
                tAlamat.setText(dataanggota[row][2]);
                tKota.setText(dataanggota[row][3]);
                tNoTelp.setText(dataanggota[row][4]);
                tPekerjaan.setText(dataanggota[row][5]);
                }  
            }
        });
     
         bSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
 
        String nomor = tNomor.getText();
        String nama= tNama.getText();
        String alamat = tAlamat.getText();
        String kota = tKota.getText();
        String notelp = tNoTelp.getText();
        String pekerjaan = tPekerjaan.getText();
       if (!tNomor.getText().isEmpty() && !tNama.getText().isEmpty() && !tAlamat.getText().isEmpty() && !tKota.getText().isEmpty() && !tNoTelp.getText().isEmpty() && !tPekerjaan.getText().isEmpty()) 
       {
            mdlagg.simpan(nomor, nama, alamat, kota, notelp, pekerjaan);
            tNomor.setText("");
            tNama.setText("");
            tAlamat.setText("");
            tKota.setText("");
            tNoTelp.setText("");
            tPekerjaan.setText("");
            tampilData();
        //awal();
        }
        else {
        JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan" ,JOptionPane.INFORMATION_MESSAGE );
       }
    }   
});

      bUpdate.addActionListener(new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent aa){ 
  
             String nomor = tNomor.getText();
        String nama= tNama.getText();
        String alamat = tAlamat.getText();
        String kota = tKota.getText();
        String notelp = tNoTelp.getText();
        String pekerjaan = tPekerjaan.getText();
       if (!tNomor.getText().isEmpty() && !tNama.getText().isEmpty() && !tAlamat.getText().isEmpty() && !tKota.getText().isEmpty() && !tNoTelp.getText().isEmpty() && !tPekerjaan.getText().isEmpty()) 
       {
            mdlagg.update(nomor, nama, alamat, kota, notelp, pekerjaan);
            tNomor.setText("");
            tNama.setText("");
            tAlamat.setText("");
            tKota.setText("");
            tNoTelp.setText("");
            tPekerjaan.setText("");
             tampilData();
       JOptionPane.showMessageDialog(null,"Data Berhasil diubah","Koneksi Sukses",JOptionPane.INFORMATION_MESSAGE);
        }
            else {
       JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan" ,JOptionPane.INFORMATION_MESSAGE );
       }
  } });
            
         bReset.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent aa){
            
            tNomor.setText("");
            tNama.setText("");
            tAlamat.setText("");
            tKota.setText("");
            tNoTelp.setText("");
            tPekerjaan.setText("");
        }

 });
         
         
         bDelete.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent aa){
             if (!tNomor.getText().isEmpty()) {
            String nomor = tNomor.getText();
            mdlagg.hapus(nomor);
            tNomor.setText("");
            tNama.setText("");
            tAlamat.setText("");
            tKota.setText("");
            tNoTelp.setText("");
            tPekerjaan.setText("");
            
            tampilData();
            } else {
            JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
}); 
         
          bBack.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent aa){
//            GUIMENU c = new GUIMENU();
//            c.setVisible(true);
                dispose();
            new viewUtama();
            //dispose();
        }
        });
          
          tCariNama.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent evt) {         
            if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
                try
            {
                java.sql.Connection con;
                con = new Koneksi().getKoneksi();
                st = con.createStatement();
                String sql = "SELECT * FROM `anggota` WHERE `Nama` like'"+tCariNama.getText() +"' ";
                 rs = st.executeQuery(sql);
            if(rs.next())
                {
                tNomor.setText(rs.getString(1));
                tNama.setText(rs.getString(2));
                tAlamat.setText(rs.getString(3));
                tKota.setText(rs.getString(4));
                tNoTelp.setText(rs.getString(5));
                tPekerjaan.setText(rs.getString(6));
               // pasif();
                bReset.setEnabled(true);
                bDelete.setEnabled(true);
                bSave.setEnabled(false);
                bUpdate.setVisible(true);
                bBack.setVisible(true);
                
                //Table1.setModel(gettabel());
                }
                else
                {
                JOptionPane.showMessageDialog(null,"Nama Tidak Tersedia");
                tCariNama.setText("");
                }
            rs.close();
            con.close();
            }
            catch(Exception e)
            {
            JOptionPane.showMessageDialog(null,"<Error> Koneksikan Xampp Terlebih Dahulu : "+e,"Koneksi Gagal",JOptionPane.WARNING_MESSAGE);
            }
            }
    }

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
          
              tCariNo.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent evt) {    
    if(evt.getKeyCode()==KeyEvent.VK_ENTER)
    {
            try
            {
            java.sql.Connection con;
                con = new Koneksi().getKoneksi();
                st = con.createStatement();
                String sql = "SELECT * FROM `anggota` WHERE `No_Anggota` like '"+tCariNo.getText() +"' ";
                 rs = st.executeQuery(sql);
            if(rs.next())
                {
                tNomor.setText(rs.getString(1));
                tNama.setText(rs.getString(2));
                tAlamat.setText(rs.getString(3));
                tKota.setText(rs.getString(4));
                tNoTelp.setText(rs.getString(5));
                tPekerjaan.setText(rs.getString(6));
               // pasif();
                bReset.setEnabled(true);
                bDelete.setEnabled(true);
                bSave.setEnabled(false);
                bUpdate.setVisible(true);
                bBack.setVisible(true);
                
                //Table1.setModel(gettabel());
                }
                else
                {
                JOptionPane.showMessageDialog(null,"Nomor Anggota Tidak Tersedia");
                tCariNo.setText("");
                }
            rs.close();
            con.close();
            }
            catch(Exception e)
            {
            JOptionPane.showMessageDialog(null,"<Error> Koneksikan Xampp Terlebih Dahulu : "+e,"Koneksi Gagal",JOptionPane.WARNING_MESSAGE);
            }
            }
        }

            @Override
            public void keyTyped(KeyEvent e) {
            //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
          //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            st = con.createStatement();
            String sql = "SELECT * FROM `anggota` ";
            rs = st.executeQuery(sql);
            int p=0;
            while(rs.next()){
                dataanggota[p][0]=rs.getString("No_Anggota");
                dataanggota[p][1]=rs.getString("Nama");
                dataanggota[p][2]=rs.getString("Alamat");
                dataanggota[p][3]=rs.getString("Kota");
                dataanggota[p][4]=rs.getString("No_Telp");
                dataanggota[p][5]=rs.getString("Pekerjaan");
                p++;
            }
            st.close();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!","Hasil", JOptionPane.ERROR_MESSAGE);
        }
}

    
    
    
    
    
}
