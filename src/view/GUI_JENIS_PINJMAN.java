// kalau simpan data, tdk langsung muncul di tabel, harus di back dulu baru muncul
package view;

import model.model_jenis_pinjaman;
import database.Koneksi;
import java.awt.Container;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

/**
 *
 * @author User
 */


public class GUI_JENIS_PINJMAN extends JFrame{ 
    
   // Container konten = getContentPane();
    public DefaultTableModel modeltabel;
    JScrollPane scrollPane = new JScrollPane();
                        
     String[][] data = new String[100][5];                    
        ResultSet rs;
        Statement st;
    JPanel konten;
    JTable tabel;
    //JLabel background = new JLabel(); 
   
    
    JLabel ljudul = new JLabel("Formulir Jenis Pinjaman Koperasi ");
    JLabel lkode = new JLabel("Kode Pinjaman ");
    JLabel ljenis = new JLabel("Jenis Pinjaman");
    JLabel lmax_pinjam = new JLabel("Max Pinjaman");
    JLabel lmax_angsur = new JLabel("Max Angsuran");
    JLabel lbunga = new JLabel("Bunga");
    
    JTextField tkode  = new JTextField("");
    JTextField tjenis  = new JTextField("");
    JTextField tmaxpinj = new JTextField("");
    JTextField tmaxang= new JTextField("");
    JTextField tbunga = new JTextField("");
    
    JButton bupdate = new JButton("Update");
    JButton bsimpan = new JButton("Simpan");
    JButton bedit = new JButton("Edit");
    JButton bhapus = new JButton("Hapus");
    JButton bkembali = new JButton("Kembali"); 
    
    public GUI_JENIS_PINJMAN()
    {
        dispose();
        tampilData();
        tabel = new JTable();
        modeltabel = new DefaultTableModel(data, new String[] {"Kode","Jenis Pinjaman","Max Pinjaman","Max Angsuran", "Bunga"});
        tabel.setModel(modeltabel);
        scrollPane = new JScrollPane(tabel);
        //tabel();
        
         model_jenis_pinjaman mdl = new model_jenis_pinjaman();

        setTitle ("Formulir");
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
        konten.add(ljenis); 
        konten.add(lmax_pinjam); 
        konten.add(lmax_angsur); 
        konten.add(lbunga); 
        konten.add(tkode);  
        konten.add(tjenis);  
        konten.add(tmaxpinj);  
        konten.add(tmaxang);  
        konten.add(tbunga);  
        konten.add(bsimpan);  
        konten.add(bupdate);  
        konten.add(bedit);  
        konten.add(bhapus);  
        konten.add(bkembali);
        konten.add(scrollPane);
       // konten.add(background);
         
        ljudul.setBounds(20, 10, 250, 25);
        
       lkode.setBounds(30, 60, 110, 20);
       ljenis.setBounds(30, 90, 110, 20);
       lmax_pinjam.setBounds(30, 120, 110, 20);
       lmax_angsur.setBounds(30, 150, 110, 20);
       lbunga.setBounds(30, 180, 110, 20);
              
       tkode.setBounds(130, 60, 100, 20);
       tjenis.setBounds(130, 90, 180, 20);
       tmaxpinj.setBounds(130, 120, 100, 20);
       tmaxang.setBounds(130, 150, 100, 20);
       tbunga.setBounds(130, 180, 100, 20);
       
       bsimpan.setBounds(350, 50, 80, 20);
       bupdate.setBounds(350, 80, 80, 20);
       bedit.setBounds(350, 110, 80, 20);
       bhapus.setBounds(350, 140, 80, 20);
       bkembali.setBounds(350, 170, 80, 20);
       
//       tkode.setColumns(10);
//       tjenis.setColumns(30);
//       tmaxpinj.setColumns(10);
//       tmaxang.setColumns(2);
//       tbunga.setColumns(5);
       
       scrollPane.setBounds(20, 220, 560, 460);
 
       tabel.addMouseListener(new java.awt.event.MouseAdapter(){ // menambahkan MouseListener pada jTabel
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                 if (e.getClickCount() == 2||e.getClickCount() == 1) {
                     
                tabel = (JTable)e.getSource();
                int row = tabel.getSelectedRow();
                
                tkode.setEditable(false);
                
                tkode.setText(data[row][0]);
                tjenis.setText(data[row][1]);
                tmaxpinj.setText(data[row][2]);
                tmaxang.setText(data[row][3]);
                tbunga.setText(data[row][4]);
                }  
            }
        });
     
            
        bsimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
 
        String kode = tkode.getText();
        String jenispinjaman= tjenis.getText();
        String maxpinjaman = tmaxpinj.getText();
        String maxangsuran = tmaxang.getText();
        String bunga = tbunga.getText();
       if (!tkode.getText().isEmpty() && !tjenis.getText().isEmpty() && !tmaxpinj.getText().isEmpty() && !tmaxang.getText().isEmpty() && !tbunga.getText().isEmpty()) 
       {
            mdl.simpanpinjaman(kode, jenispinjaman, maxpinjaman, maxangsuran, bunga);
//            tkode.setText("");
//            tjenis.setText("");
//            tmaxpinj.setText("");
//            tmaxang.setText("");
//            tbunga.setText("");
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
            String jenispinjaman= tjenis.getText();
            String maxpinjaman = tmaxpinj.getText();
            String maxangsuran = tmaxang.getText();
            String bunga = tbunga.getText();
            if (!tkode.getText().isEmpty() && !tjenis.getText().isEmpty() && !tmaxpinj.getText().isEmpty() && !tmaxang.getText().isEmpty() && !tbunga.getText().isEmpty()) 
       {
            mdl.updatepinjaman(kode,jenispinjaman,maxpinjaman,maxangsuran, bunga);
            tkode.setText("");
            tjenis.setText("");
            tmaxpinj.setText("");
            tmaxang.setText("");
            tbunga.setText("");
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
            aktif();
            tkode.setEnabled(false);
            bupdate.setEnabled(true);
            bedit.setEnabled(false);
            bhapus.setEnabled(false);
        }

        });
          
           bhapus.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent aa){
            try {
             if (!tkode.getText().isEmpty()) {
                 String kode = tkode.getText();
            if (JOptionPane.showConfirmDialog(rootPane, "Yakin Menghapus?", "Hapus", 1) == 0) {
            mdl.hapuspinjaman(kode);
            tkode.setText("");
            tjenis.setText("");
            tmaxpinj.setText("");
            tmaxang.setText("");
            tbunga.setText("");
            tampilData();
            } } else {
            JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
         }
            catch(Exception e)
            {
                e.printStackTrace();
            }   }
});
           
            bkembali.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent aa){
//            GUIMENU c = new GUIMENU();
//            c.setVisible(true);
            dispose();
            new viewUtama();
            //dispose();
        }
        });
    tampilData();        
    setVisible(true);  
    dispose();
}
   
      public void tampilData(){

        try{
            java.sql.Connection con;
            con = new Koneksi().getKoneksi();
            st=con.createStatement();
            st = con.createStatement();
            String sql = "SELECT * FROM `jenis_pinjaman` ";
            rs = st.executeQuery(sql);
            int p=0;
            while(rs.next()){
                data[p][0]=rs.getString("kode");
                data[p][1]=rs.getString("jenispinjaman");
                data[p][2]=rs.getString("maxpinjaman");
                data[p][3]=rs.getString("maxangsuran");
                data[p][4]=rs.getString("bunga");
                p++;
            }
            st.close();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!","Hasil", JOptionPane.ERROR_MESSAGE);
        }
}

      
    private void aktif()
{
tkode.setEnabled(true);
tjenis.setEnabled(true);
tmaxpinj.setEnabled(true);
tmaxang.setEnabled(true);
tbunga.setEnabled(true);
}

private void bersih()
{
tkode.setText("");
tjenis.setText("");
tmaxpinj.setText("");
tmaxang.setText("");
tbunga.setText("");
}

private void pasif()
{
tjenis.setEnabled(false);
tmaxpinj.setEnabled(false);
tmaxang.setEnabled(false);
tbunga.setEnabled(false);
}

private void awal()
{
tampilData();
bersih();
pasif();
tkode.requestFocus();
bupdate.setEnabled(false);
bedit.setEnabled(false);
bhapus.setEnabled(false);
bsimpan.setEnabled(true);
}

//private void tabel() {
//                        modeltabel.getDataVector().removeAllElements();
//                        modeltabel.fireTableDataChanged();
//                        try {
//                                    java.sql.Connection con;
//                                    con = new Koneksi().getKoneksi();
//                                    String sql = "SELECT * FROM `jenis_pinjaman`";
//                                    Statement s = con.createStatement();
//                                    ResultSet rs = s.executeQuery(sql);
//                                    while (rs.next()) {
//                                     modeltabel.addRow(new Object[] { rs.getString("kode"), rs.getString("jenispinjaman"), rs.getString("maxpinjaman"), rs.getString("maxangsuran"), rs.getString("bunga") });
//                                    }
//                        } catch (Exception s) {
//                        }
//
//            }

    
}