/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.model_transaksi_pinjaman;
    import database.Koneksi;
    import java.awt.Container;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
    import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
    import java.util.Date;
    import java.sql.*;
import java.text.SimpleDateFormat;
    import javax.swing.*;
    import static javax.swing.JFrame.EXIT_ON_CLOSE;
    import javax.swing.border.EmptyBorder;
    import javax.swing.table.DefaultTableModel;;
/**
 *
 * @author User
 */
public class GUI_TRANSAKSI_PINJAMAN extends JFrame  {
   
    boolean x;
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

        JLabel judul = new JLabel("Transaksi Pinjaman Koperasi");
 
        JLabel lnomorpinjam = new JLabel("No. Pinjam");
        JLabel ltgl = new JLabel("Tgl Pinjam");
        JTextField tnomorpinjam = new JTextField();
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
        
        JLabel lketerangan= new JLabel("--Keterangan Pinjaman---");
        JLabel lket= new JLabel("Keterangan");
        JLabel lpinjaman = new JLabel("Pinjaman Pokok");
        JLabel langsuran = new JLabel("Lama Angsuran ");
        JLabel lbulan = new JLabel("Bulan");
        JTextField tket = new JTextField();
        JTextField tpinjaman = new JTextField();
        JTextField tangsuran = new JTextField();
        
        JLabel lbunga = new JLabel("Bunga [%] : ");
        JLabel ladmin= new JLabel("Admin [%] : ");
        JTextField tbunga = new JTextField();
        JTextField tadmin = new JTextField();
        JTextField tpersenadmin = new JTextField();
        JTextField tpersenbunga = new JTextField();
        
        JLabel lket1 = new JLabel("---Keterangan---");
        JLabel lbiaya = new JLabel("Biaya Administrasi 3% ");
        
        JLabel ljumlah = new JLabel("Jumlah Bunga ");
        JLabel ltotal = new JLabel("Total Pinjaman ");
        JLabel langsur = new JLabel("Angsuran /bulan");
        JTextField tjumlah = new JTextField();
        JTextField ttotal = new JTextField();
        JTextField tangsur = new JTextField();
           
        JButton bsimpan= new JButton("Simpan");
        JButton bhapus = new JButton("Hapus");
        JButton breset = new JButton("Reset");
        JButton bkembali = new JButton("Kembali");
        JButton bcari = new JButton("Cari");
        JButton bhitung = new JButton("Hitung");
        
        
    public GUI_TRANSAKSI_PINJAMAN()
    {
        dispose();
       awal();
       //aktif();
        model_transaksi_pinjaman model = new model_transaksi_pinjaman();

        setTitle ("Transaksi Pinjaman");
        setVisible(true);
        setResizable(false);
        setSize (800,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 685, 620);
        
        konten.setLayout(null);

        konten.add(judul);
        konten.add(lnomorpinjam); 
        konten.add(ltgl); 
        konten.add(tnomorpinjam); 
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
        
        konten.add(lketerangan);  
        konten.add(lket);  
        konten.add(lpinjaman);  
        konten.add(langsuran);  
        konten.add(lbulan); 
        konten.add(tket); 
        konten.add(tpinjaman); 
        konten.add(tangsuran); 
        
        konten.add(lbunga);  
        konten.add(ladmin);  
        konten.add(tbunga);  
        konten.add(tadmin);
        konten.add(tpersenadmin);
        konten.add(tpersenbunga);
        
        konten.add(lket1);
        konten.add(lbiaya);
        konten.add(ljumlah);
        konten.add(ltotal);
        konten.add(langsur);
        konten.add(tjumlah);
        konten.add(ttotal);
        konten.add(tangsur);
       // konten.add(background);
        
        konten.add(bsimpan);
        konten.add(breset);
        konten.add(bhapus);
        konten.add(bkembali);
        konten.add(bcari);
        konten.add(bhitung);

        judul.setBounds(5, 20, 200, 20);
        lnomorpinjam.setBounds(20, 40, 80, 20);
        tnomorpinjam.setBounds(120, 40, 130, 20);
        ltgl.setBounds(20, 70, 80, 20);
        ttgl.setBounds(120, 70, 130, 20);
        
        ldata.setBounds(20, 100, 150, 20);
        lnomor.setBounds(20, 120, 80, 20);
        tnomor.setBounds(120, 120, 100, 20);
        lnama.setBounds(20, 150, 80, 20);
        tnama.setBounds(120, 150, 100, 20);
        lalamat.setBounds(20, 180, 80, 20);
        talamat.setBounds(120, 180, 100, 20);
        lpekerjaan.setBounds(20, 210, 80, 20);
        tpekerjaan.setBounds(120, 210, 100, 20);
        
        lketerangan.setBounds(20, 240, 200, 20);
        lket.setBounds(20, 270, 100, 20);
        tket.setBounds(130, 270, 100, 20);
        lpinjaman.setBounds(20, 300, 100, 20);
        tpinjaman.setBounds(130, 300, 100, 20);
        langsuran.setBounds(20, 330, 100, 20);
        tangsuran.setBounds(130, 330, 100, 20);
        lbulan.setBounds(240, 330, 60, 20);
        bsimpan.setBounds(20,370,90,25);
        
        lbunga.setBounds(320, 100, 80, 20);
        tbunga.setBounds(475, 100, 100, 20);
        ladmin.setBounds(320, 130, 80, 20);
        tadmin.setBounds(475, 130, 100, 20);
        tpersenadmin.setBounds(410, 130, 50, 20);
        tpersenbunga.setBounds(410, 100, 50, 20);
        bhitung.setBounds(540, 160, 90, 25);
        
        lket1.setBounds(320, 210, 200, 15);
        lbiaya.setBounds(320, 230, 200, 20);
        ljumlah.setBounds(320, 260, 100, 20);
        tjumlah.setBounds(430, 260, 100, 20);
        ltotal.setBounds(320, 290, 100, 20);
        ttotal.setBounds(430, 290, 100, 20);
        langsur.setBounds(320, 320, 100, 20);
        tangsur.setBounds(430, 320, 100, 20);
        
        bcari.setBounds(320, 370, 70, 25);
        bhapus.setBounds(480, 370, 70, 25);
        breset.setBounds(400, 370, 70, 25);
        bkembali.setBounds(560, 370, 100, 25);
        
      //  addKeyListener(this);
        
        bsimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
                
                java.sql.Connection con;
                con = new Koneksi().getKoneksi();
            String nopinjam = tnomorpinjam.getText();
            String tgl = ttgl.getText();
            String nomor = tnomor.getText();
            String ket = tket.getText();
            String pinjam = tpinjaman.getText();
            String angsuran = tangsur.getText();
            String lama= tangsuran.getText();
            String persenbunga = tpersenbunga.getText();
            String persenadmin = tpersenadmin.getText();
            String jumlahbunga = tjumlah.getText();
            String total = ttotal.getText();

                try
        {
            if (x!=true)
            {
            model.simpan( nopinjam,tgl, nomor,ket,pinjam,lama,persenbunga,persenadmin,jumlahbunga,total, angsuran);
            bersih();
            }
            else
            {
            model.update(nomor,ket,tgl, pinjam,lama,persenbunga,persenadmin,jumlahbunga,total,angsuran,nopinjam );  
            bersih();
            }
//            awal();
//            aktif();
            rs.close();
         //   JOptionPane.showMessageDialog(null,"Database Berhasil Tersimpan","Koneksi Sukses",JOptionPane.INFORMATION_MESSAGE);
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
                    rs=st.executeQuery("SELECT * FROM `trans_pinjaman` WHERE `No_Pinjam` like '"+ cari +"'");
                    if (rs.next())
                    {
                        tnomorpinjam.setText(rs.getString(1));       ttgl.setText(rs.getString(2));
                        tnomor.setText(rs.getString(3));       tket.setText(rs.getString(4));
                        tpinjaman.setText(rs.getString(5));        tangsuran.setText(rs.getString(6));
                        tpersenbunga.setText(rs.getString(7)); tpersenadmin.setText(rs.getString(8));
                        tjumlah.setText(rs.getString(9));    ttotal.setText(rs.getString(10));
                        tangsur.setText(rs.getString(11));

                        double pinjam=Double.parseDouble(tpinjaman.getText());
                        double admin=Double.parseDouble(tpersenadmin.getText());
                        double total=(admin/100)*pinjam;
                        tadmin.setText(Double.toString(total));

                        double pinjam1=Double.parseDouble(tpinjaman.getText());
                        double bunga1=Double.parseDouble(tpersenbunga.getText());
                        double total1=(bunga1/100)*pinjam1;
                        tbunga.setText(Double.toString(total1));

                        rs=st.executeQuery("SELECT * FROM `anggota` WHERE `No_Anggota` ='"+tnomor.getText()+"'");
                        if (rs.next())
                        {    
                        tnama.setText(rs.getString(2));    talamat.setText(rs.getString(3));
                        tpekerjaan.setText(rs.getString(6));
                        }
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
                tjumlah.setText(Double.toString(Double.parseDouble(tbunga.getText())+Double.parseDouble(tadmin.getText())));
                ttotal.setText(Double.toString(Double.parseDouble(tpinjaman.getText())+Double.parseDouble(tjumlah.getText())));
                tangsur.setText(Double.toString(Double.parseDouble(ttotal.getText())/Double.parseDouble(tangsuran.getText()))); 
            }
         });
        
        bhapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
            try {
            java.sql.Connection con;
            con = new Koneksi().getKoneksi();
        String sql="DELETE FROM `trans_pinjaman` WHERE `No_Pinjam`='"+tnomorpinjam.getText()+"'";
        st.executeUpdate(sql);
        rs.close();
        JOptionPane.showMessageDialog(null,"Database Berhasil Terhapus","Koneksi Sukses",JOptionPane.INFORMATION_MESSAGE);
        con.close();
        awal();
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,"<Error> Koneksikan Xampp Terlebih Dahulu : "+e,"Koneksi Gagal",JOptionPane.WARNING_MESSAGE);
        }
            }
         });
        
        bkembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aa){
                //new GUIMENU().setVisible(true);
                dispose();
                new viewUtama();
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
                    tket.requestFocus();
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
        
        tangsuran.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            try
            {
                int lama=Integer.parseInt(tangsuran.getText());
                if(lama>=37)
                {
                    JOptionPane.showMessageDialog(null,"Lama angsuran tidak boleh lebih dari 36 bulan");
                    tangsuran.setText("");
                    tangsuran.requestFocus();
                }    
                else
                {
                    tbunga.requestFocus();
                }
            }
            catch(Exception e)
            {  }
        }
            }

           @Override
           public void keyTyped(KeyEvent e) {
    //           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public void keyReleased(KeyEvent e) {
    //           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
        });

         tpersenbunga.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
        double pinjam=Double.parseDouble(tpinjaman.getText());
        double bunga=Double.parseDouble(tpersenbunga.getText());
        double total=(bunga/100)*pinjam;
        tbunga.setText(Double.toString(total));
        tpersenadmin.requestFocus();
        }
            }    

           @Override
           public void keyTyped(KeyEvent e) {
  //             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public void keyReleased(KeyEvent e) {
    //           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
    });
         
         tpersenadmin.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent evt) {
               if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
        double pinjam=Double.parseDouble(tpinjaman.getText());
        double admin=Double.parseDouble(tpersenadmin.getText());
        double total=(admin/100)*pinjam;
        tadmin.setText(Double.toString(total));
        bhitung.setEnabled(true);
        bhitung.requestFocus();
        }
    }    

           @Override
           public void keyTyped(KeyEvent e) {
   //            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public void keyReleased(KeyEvent e) {
    //           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
            
         });
        
         
         
    }  
    
    
    public void bersih()
 {
 ttgl.setText("");           tket.setText("");           tjumlah.setText("");       
 tnomorpinjam.setText("");   tangsuran.setText("");      ttotal.setText("");
 tpersenbunga.setText("");   tpersenadmin.setText("");   tangsur.setText("");
 tnomor.setText("");         tnama.setText("");          talamat.setText("");
 tpekerjaan.setText("");     tpinjaman.setText("");
 tadmin.setText("");         tbunga.setText("");
 }
  
    public void nonaktif()
 {
 ttgl.setEnabled(false);           tket.setEnabled(false);              tjumlah.setEnabled(false);       
 tpinjaman.setEnabled(false);      tangsuran.setEnabled(false);          ttotal.setEnabled(false); 
 tpersenbunga.setEnabled(false);   tpersenadmin.setEnabled(false);      tangsur.setEnabled(false);
 tnama.setEnabled(false);          talamat.setEnabled(false);           tpekerjaan.setEnabled(false);
 tbunga.setEnabled(false);         tadmin.setEnabled(false);            tnomorpinjam.setEnabled(false);
 }
   
    public void aktif()
 {
 tket.setEnabled(true);           tnomor.setEnabled(true);               tpersenbunga.setEnabled(true);               
 tpinjaman.setEnabled(true);      tangsuran.setEnabled(true);           tpersenadmin.setEnabled(true);        
 }
  
    public void nopinjam() 
 {
    try
    {
        java.sql.Connection con;
        con = new Koneksi().getKoneksi();
        st = con.createStatement();
        String nomor=null;
        rs=st.executeQuery("SELECT right(`No_Pinjam`,3)+1 as  `No` from  `trans_pinjaman` order by `No_Pinjam` desc");
        if(rs.next()) 
        {
            nomor=rs.getString("No");
            while(nomor.length()<2)
            nomor="0"+nomor; 
            nomor="PJ-"+noformat.format(tgl)+nomor;
        }
        else
            nomor="PJ-"+noformat.format(tgl)+"0"; 
            tnomorpinjam.setText(nomor);
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
 nopinjam();
 ttgl.setEnabled(false); 
 ttgl.setText(format.format(tgl));
 tnomor.requestFocus();

 } 
   
  
    
}
