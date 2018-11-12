/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.model_transaksi_simpanan;
import database.Koneksi;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author User
 */
public class GUI_TRANSAKSI_SIMPANAN extends JFrame{
    
     boolean x;
   //  Container konten = getContentPane();
   Container konten = getContentPane();
   // Koneksi con = new Koneksi();
    Date tgl=new Date();
    SimpleDateFormat noformat=new SimpleDateFormat("yyMM");
    SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
        
    //public DefaultTableModel modeltabel;
        JScrollPane scrollPane = new JScrollPane();
       // String[][]  data= new String[100][6];                    
        ResultSet rs;
        Statement st;
       // JPanel konten;
        JTable tabel;

        JLabel judul = new JLabel("Transaksi Simpanan Koperasi");
 
        JLabel lnomortrans = new JLabel("No. Trans");
        JLabel ltgl = new JLabel("Tgl Trans");
        JTextField tnomortrans= new JTextField();
        JTextField ttgl = new JTextField();
        
        JLabel ldata= new JLabel("---Data Anggota---");
        JLabel lnomor = new JLabel("No Anggota");    //diambil dari tabel anggota
        JLabel lnama= new JLabel("Nama");
        JLabel lalamat= new JLabel("Alamat");
        JLabel lpekerjaan= new JLabel("Pekerjaan");
        
        JTextField tnomor = new JTextField();
        JTextField tnama= new JTextField();
        JTextField talamat = new JTextField();
        JTextField tpekerjaan = new JTextField();
        
        JLabel lsimpanan = new JLabel("Simpan ");
        JLabel lpenarikan= new JLabel("Penarikan ");
        JLabel lsaldolama= new JLabel("Saldo lama ");
        JLabel lsaldo= new JLabel("Saldo ");
        JTextField tsimpanan = new JTextField();
        JTextField tpenarikan = new JTextField();
        JTextField tsaldolama = new JTextField();
        JTextField tsaldo = new JTextField();
        
        JButton bsimpan= new JButton("Simpan");
        JButton bhapus = new JButton("Hapus");
        JButton breset = new JButton("Reset");
        JButton bedit = new JButton("Edit");
        JButton bkembali = new JButton("Kembali");
        JButton bcari = new JButton("Cari");
        JButton bhitung = new JButton("Hitung");
        
        public GUI_TRANSAKSI_SIMPANAN()
    {
       dispose();
       awal();
       aktif();
        model_transaksi_simpanan model = new model_transaksi_simpanan();

        setTitle ("Transaksi Simpanan");
        setVisible(true);
        setResizable(false);
        setSize (900,530);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setBounds(100, 100, 685, 620);
        
        konten.setLayout(null);

        konten.add(judul);
        konten.add(lnomortrans); 
        konten.add(ltgl); 
        konten.add(tnomortrans); 
        konten.add(ttgl); 
        
        konten.add(ldata);  
        konten.add(lnomor);  
        konten.add(lnama);  
        konten.add(lalamat);  
        konten.add(lpekerjaan);  
        konten.add(tnomor);  
        konten.add(tnama);  
        konten.add(talamat);  
        konten.add(tpekerjaan); 
        
        konten.add(lsimpanan);  
        konten.add(lpenarikan);  
        konten.add(lsaldolama);  
        konten.add(lsaldo);  
        konten.add(tsimpanan);
        konten.add(tpenarikan);
        konten.add(tsaldolama);
        konten.add(tsaldo);
        
        konten.add(bsimpan);
        konten.add(breset);
        konten.add(bhapus);
        konten.add(bkembali);
        konten.add(bcari);
        konten.add(bhitung);
        konten.add(bedit);
        
        judul.setBounds(5, 20, 200, 20);
        lnomortrans.setBounds(20, 40, 80, 20);
        tnomortrans.setBounds(120, 40, 130, 20);
        ltgl.setBounds(20, 70, 80, 20);
        ttgl.setBounds(120, 70, 130, 20);
        
        ldata.setBounds(20, 100, 150, 20);
        lnomor.setBounds(20, 120, 80, 20);
        tnomor.setBounds(120, 120, 150, 20);
        lnama.setBounds(20, 150, 80, 20);
        tnama.setBounds(120, 150, 150, 20);
        lalamat.setBounds(20, 180, 80, 20);
        talamat.setBounds(120, 180, 150, 20);
        lpekerjaan.setBounds(20, 210, 80, 20);
        tpekerjaan.setBounds(120, 210, 150, 20);
   
        lsimpanan.setBounds(320, 120, 80, 20);
        lpenarikan.setBounds(320, 150, 100, 20);
        lsaldolama.setBounds(320, 180, 80, 20);
        lsaldo.setBounds(380, 250, 40, 20);
        tsimpanan.setBounds(410, 120, 120, 20);
        tpenarikan.setBounds(410, 150, 120, 20);
        tsaldolama.setBounds(410, 180, 120, 20);
        tsaldo.setBounds(430, 250, 120, 20);
        bhitung.setBounds(500, 210, 70, 25);
        
        bsimpan.setBounds(20, 290, 100, 25);
        bcari.setBounds(240, 290, 90, 25);
        bhapus.setBounds(550, 290, 90, 25);
        breset.setBounds(450, 290, 90, 25);
        bedit.setBounds(350, 290, 90, 25);
        bkembali.setBounds(650, 290, 100, 25);
        
        
         bsimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
                
                java.sql.Connection con;
                con = new Koneksi().getKoneksi();
            String nosimpan = tnomortrans.getText();
            String tgl = ttgl.getText();
            String nomor = tnomor.getText();
            String simpanan = tsimpanan.getText();
            String penarikan = tpenarikan.getText();
            //String lama= tsaldolama.getText();
            String saldo= tsaldo.getText();

                try
        {
            if (x!=true)
            {
            model.simpan( nosimpan,tgl, nomor,simpanan, penarikan, saldo);
            bersih();
            }
            else
            {
            model.update(nosimpan, nomor,simpanan, penarikan, saldo ); 
            bersih();
            }
            awal();
            aktif();
            rs.close();
           JOptionPane.showMessageDialog(null,"Database Berhasil Tersimpan","Koneksi Sukses",JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"<Error> Koneksikan Xampp Terlebih Dahulu : "+e,"Koneksi Gagal",JOptionPane.WARNING_MESSAGE);
        } 
            }
         });
        

        breset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
               bersih(); 
            }
         });
        
        bcari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
             String cari = JOptionPane.showInputDialog(null, "Pencarian Data berdasarkan Nomor Pinjam", "Harus diisi", JOptionPane.QUESTION_MESSAGE);
                try
                {
                    java.sql.Connection con;
                    con = new Koneksi().getKoneksi();
                    rs=st.executeQuery("SELECT * FROM `trans_simpanan` WHERE `No_Simpan` like '"+ cari +"'");
                    if (rs.next())
                    {
                        tnomortrans.setText(rs.getString(1));       ttgl.setText(rs.getString(2));
                        tnomor.setText(rs.getString(3));            tsaldo.setText(rs.getString(4));
       
                        rs=st.executeQuery("SELECT * FROM `anggota` WHERE `No_Anggota` ='"+tnomor.getText()+"'");
                        if (rs.next())
                        {    
                        tnama.setText(rs.getString(2));    talamat.setText(rs.getString(3));
                        tpekerjaan.setText(rs.getString(6));
                        }
                        
                        rs=st.executeQuery("SELECT * FROM `detail_simpanan` WHERE `No_Simpan`='"+tnomortrans.getText()+"'");
                        if (rs.next())
                        {    
                        tsimpanan.setText(rs.getString(3));       
                        tpenarikan.setText(rs.getString(4));
                        tsaldolama.setText(rs.getString(5));
                        }
                        
                       // bedit.setEnabled(true);
                        bhapus.setEnabled(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Data Tidak Ditemukan","Gagal",JOptionPane.WARNING_MESSAGE);
                    }
                    rs.close();
                    con.close();     
                }
                catch(Exception e){}

                        }
                     });

        bhitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa) throws NumberFormatException{
           double saldo = Double.parseDouble(tsaldolama.getText())+Double.parseDouble(tsimpanan.getText())-Double.parseDouble(tpenarikan.getText());
           tsaldo.setText(Double.toString(saldo));
            }
         });
        
        bhapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
                
            java.sql.Connection con;
            con = new Koneksi().getKoneksi();
            
            if (!tnomortrans.getText().isEmpty()) {
                
                 String nosimpan = tnomortrans.getText();
            if (JOptionPane.showConfirmDialog(rootPane, "Yakin Menghapus?", "Hapus", 1) == 0) {
                model.hapus(nosimpan);
                      JOptionPane.showMessageDialog(null,"Data Berhasil Terhapus","Koneksi Sukses",JOptionPane.INFORMATION_MESSAGE); 
       
                     try {
                         rs.close();
                     } catch (SQLException ex) {
                         Logger.getLogger(GUI_TRANSAKSI_SIMPANAN.class.getName()).log(Level.SEVERE, null, ex);
                     }
            awal();
            } }
            }   
    });
        
        bkembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
              //  new GUIMENU().setVisible(true);
              dispose();
              new viewUtama();
        
            }
        });
        
        bedit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
               aktif();
               x=true;
            }
        });
        
        tnomor.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent evt) {                
            if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {  
            try
            {
                java.sql.Connection con;
                 con = new Koneksi().getKoneksi();
                 st = con.createStatement();
                String sql = "SELECT * FROM `anggota` WHERE `No_Anggota` like '"+ tnomor.getText() +"'";
                rs = st.executeQuery(sql);
                if (rs.next())
                {
                    tnama.setText(rs.getString(2));
                    talamat.setText(rs.getString(3));
                    tpekerjaan.setText(rs.getString(6));
                    tsimpanan.requestFocus();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Nomor Anggota Tidak Tersedia");
                    tnomor.setText("");
                    tnomor.requestFocus();
                }
            }
            catch(Exception e)
            {   }
        }    
            }

           @Override
           public void keyTyped(KeyEvent e) {
//               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public void keyReleased(KeyEvent e) {
        //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }

         
    });   
         
    }  
    
    
    public void bersih()
 {
 ttgl.setText("");               tpenarikan.setText("");                 
 tnomortrans.setText("");        tsaldolama.setText("");     
 tsimpanan.setText("");          tsaldo.setText("");  
 tnomor.setText("");             tnama.setText("");          
 tpekerjaan.setText("");         talamat.setText("");
 }
  
    public void nonaktif()
 {
 ttgl.setEnabled(false);           tpenarikan.setEnabled(false);                    
 tsimpanan.setEnabled(false);      tsaldolama.setEnabled(false);         
 tnomor.setEnabled(false);         tsaldo.setEnabled(false);      
 tnama.setEnabled(false);          talamat.setEnabled(false);           tpekerjaan.setEnabled(false);
 }
   
    public void aktif()
 {
 tsimpanan.setEnabled(true);           tnomor.setEnabled(true);               tsaldo.setEnabled(true);               
tpenarikan.setEnabled(true);           tsaldolama.setEnabled(true);          
 }
  
    public void nosimpan() 
 {
    try
    {
        java.sql.Connection con;
        con = new Koneksi().getKoneksi();
        st = con.createStatement();
        String nomor=null;
        rs=st.executeQuery("SELECT right(`No_Simpan`,3)+1 as  `No` from  `trans_simpanan` order by `No_Simpan` desc");
        if(rs.next()) 
        {
            nomor=rs.getString("No");
            while(nomor.length()<2)
            nomor="0"+nomor; 
            nomor="PJ-"+noformat.format(tgl)+nomor;
        }
        else
            nomor="PJ-"+noformat.format(tgl)+"0"; 
            tnomortrans.setText(nomor);
        }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(rootPane, e);
    }
}
    
    public void awal()
 {
 bersih();
 //nonaktif();
 nosimpan();
 ttgl.setEnabled(false); 
 ttgl.setText(format.format(tgl));
 tnomor.requestFocus();

 } 
   
}

