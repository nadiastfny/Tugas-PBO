// tampilan untuk menu utama
package view;

import database.Koneksi;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


//public class viewUtama {
//    public static void main(String[] args) {
//    GUImenu m = new GUImenu();
//    //m.setVisible(true);
//            }
//
//   
//}

 public class viewUtama extends JFrame implements ActionListener  {
    
   // public Image image;
   // BackgroundPanel panel;
        JLabel bg = new JLabel(new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Project_Koperasi\\src\\view\\gambar\\back.jpg"));
        Koneksi con = new Koneksi();
        JLabel back = new JLabel();
        Container kon = getContentPane();
        JPanel konten = new JPanel();
        JMenuBar menu = new JMenuBar();
        
        JMenu submnFile = new JMenu("File");
        JMenu submnData = new JMenu("Data");
        JMenu submnTransaksi = new JMenu("Transaksi");
        JMenu submnLaporan = new JMenu("Laporan");
        JMenu submnBantuan = new JMenu("Bantuan");
 
        //Menu item untuk submenu Data
        JMenuItem dNasabah = new JMenuItem ("Data Nasabah");
        JMenuItem dAdmin = new JMenuItem ("Data Admin");
        JMenuItem dRekening = new JMenuItem ("Rekening Nasabah");
        
        //Menu item untuk submenu File
        JMenuItem jPinjaman = new JMenuItem ("Jenis Pinjaman");
        JMenuItem jSimpanan = new JMenuItem ("Jenis Simpanan");
        JMenuItem exit = new JMenuItem ("Exit");
        
        //Menu item untuk submenu Transaksi
        JMenuItem tPinjaman = new JMenuItem ("Transaksi Pinjaman");
        JMenuItem tSimpanan = new JMenuItem ("Transaksi Simpanan");
        
        //Menu item untuk submenu Laporan
        JMenuItem ltpinjaman = new JMenuItem ("Laporan Pinjaman");
        JMenuItem ltsimpanan= new JMenuItem ("Laporan Simpanan");
        
        //Menu item untuk submenu Bantuan
        JMenuItem tentang = new JMenuItem ("About");
        
    public viewUtama () {

        super("Koperasi Simpan Pinjam");
       // initComponents();
        setSize(600,475);
       // setVisible(true);
        setLocationRelativeTo(null); // membuat jframe tampil di tengah layar
        this.setResizable(false);
        //konten.setLayout(null);
        konten.setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        submnFile.setMnemonic('F');
        submnData.setMnemonic('D');
        submnTransaksi.setMnemonic('T');
        submnLaporan.setMnemonic('L');
        submnBantuan.setMnemonic('B');
         
       // kon.add(back);    
        konten.add(submnFile);
        konten.add(submnData);
        konten.add(submnTransaksi);
        konten.add(submnLaporan);
        konten.add(submnBantuan);
        konten.add(menu);
        
       // back.setBounds(0, 20, 600, 450);
       
        dNasabah.addActionListener(this);
        dAdmin.addActionListener(this);
        dRekening.addActionListener(this);
        
        jPinjaman.addActionListener(this);
        jSimpanan.addActionListener(this);
        exit.addActionListener(this);
        
        tPinjaman.addActionListener(this);
        tSimpanan.addActionListener(this);
        
        ltpinjaman.addActionListener(this);
        ltsimpanan.addActionListener(this);
        
        tentang.addActionListener(this);
        
        
        menu.add(submnFile);
        submnFile.add(jPinjaman);
        submnFile.add(jSimpanan);
        submnFile.addSeparator(); //untuk batas pemisah 
        submnFile.add(exit);
        
        menu.add(submnData);
        submnData.add(dNasabah);
        submnData.add(dAdmin);
        submnData.add(dRekening);
        
        menu.add(submnTransaksi);
        submnTransaksi.add(tPinjaman);
        submnTransaksi.add(tSimpanan);
       
        menu.add(submnLaporan);
        submnLaporan.add(ltpinjaman);
        submnLaporan.add(ltsimpanan);
        
        menu.add(submnBantuan);
        submnBantuan.add(tentang);

        setJMenuBar(menu);
     
        konten = new BackgroundPanel(); //menangkap gambar di kelas backgroundpanel
        
        konten.setOpaque(false);        //mengatur transparasinya
        submnFile.setOpaque(false);
        submnData.setOpaque(false);
        submnLaporan.setOpaque(false);
        submnData.setOpaque(false);
        submnTransaksi.setOpaque(false);
        submnBantuan.setOpaque(false);
        menu.setOpaque(false);
        
        kon = new Container();
        kon = getContentPane();
        kon.add(konten);
 
        setVisible(true);
        
    } // kurung public viewUtama()
//    private void initComponents() {
//        image = new ImageIcon("gambarr/background.jpg").getImage();
//        panel = new BackgroundPanel(image);
//        add(panel);
//        setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
//        pack();
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
    
    public void actionPerformed (ActionEvent ev ) {
 
        String s = ev.getActionCommand();
        if(s=="Jenis Pinjaman") {
            new GUI_JENIS_PINJMAN().setVisible(true);
            
        }  if (s=="Jenis Simpanan") { 
             new GUI_JENIS_SIMPANAN().setVisible(true);
            
        }  if (s=="Data Nasabah" ) { 
             new GUI_FORM_ANGGOTA().setVisible(true);
   
        }  if (s=="Data Admin") {
            
        }   if (s=="Data Rekening") {
            
        }  if (s=="Transaksi Pinjaman") {
             new GUI_TRANSAKSI_PINJAMAN().setVisible(true);
            
        }   if (s=="Transaksi Simpanan") {
            new GUI_TRANSAKSI_SIMPANAN().setVisible(true);
            
        }  if (s=="Laporan Pinjaman") {
            new lap_pinjaman().setVisible(true);
            
        } if (s=="Laporan Simpanan") {
            new lap_simpanan().setVisible(true);
            
        } if (s=="Exit") {
            if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar aplikasi?","Konfirmasi...",JOptionPane.YES_NO_OPTION)==0) { 
                dispose();
            }
        }   if (s=="About") {
            JOptionPane.showMessageDialog(null,"Salam kenal dari Nadia, "+" \nGood Luck for us! "," Bantuan", JOptionPane.INFORMATION_MESSAGE);
        }   
    }

    
    }

   

   
  

