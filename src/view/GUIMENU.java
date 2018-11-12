//main program nya
package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

   public class GUIMENU extends JFrame{ 
    
    Container konten = getContentPane();
   // JLabel background = new JLabel(); 
    //JPanel konten;
    JLabel ljudul = new JLabel("KOPERASI SIMPAN PINJAM ");
    JLabel lnama = new JLabel("Nadia Stefanny Ambarita ");
    JLabel lnim = new JLabel("               123170002 ");
    
    JButton bjpinjam = new JButton("JENIS PINJAMAN");
    JButton bjsimpan = new JButton("JENIS SIMPANAN");
    JButton btsimpan = new JButton("TRANSAKSI SIMPANAN");
    JButton btpinjam = new JButton("TRANSAKSI PINJAMAN");
    JButton banggota = new JButton("ANGGOTA");
    JButton brekening = new JButton("REKENING NASABAH");
    JButton bkeluar = new JButton("KELUAR");
    
    
    public GUIMENU()
    {
        dispose();
      //  initComponents();
        setTitle ("KOPERASI");
        setVisible(true);
        setResizable(false);
        setSize (600,475);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
              
        setLayout(null);    // menggunakan Layout null
        konten.add(ljudul);
        konten.add(lnama);
        konten.add(lnim); 
        konten.add(bjpinjam); 
        konten.add(bjsimpan); 
        konten.add(btpinjam); 
        konten.add(btsimpan);  
        konten.add(banggota);  
        konten.add(brekening);  
        konten.add(bkeluar); 
       // konten.addSeparator();
       // konten.add(background);
        
        ljudul.setBounds(160, 10, 250, 40);
        lnama.setBounds(300, 50, 200, 20);
        lnim.setBounds(320, 70, 130, 20);
        bjpinjam.setBounds(50, 120, 150, 30);
        bjsimpan.setBounds(50, 160, 150, 30);
        btpinjam.setBounds(50, 200, 200, 30);
        btsimpan.setBounds(50, 240, 200, 30);
        banggota.setBounds(250, 120, 150, 30);
        brekening.setBounds(250, 160, 150, 30);
        bkeluar.setBounds(250, 200, 150, 30);
        
//        background.setBounds(10, 10, 600, 475);
//        background.setIcon(new ImageIcon(getClass().getResource("/gambarr/background.jpg")));


            bjpinjam.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent aa){
            dispose();
          new GUI_JENIS_PINJMAN().setVisible(true);
        }

        });
            
            bjsimpan.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ab){
            dispose();
           new GUI_JENIS_SIMPANAN().setVisible(true);
           dispose();
        }

        });
            
            
            btpinjam.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ac){
            dispose();
            new GUI_TRANSAKSI_PINJAMAN().setVisible(true);
        }
        });
            
            btsimpan.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ad){
            dispose();
            new GUI_TRANSAKSI_SIMPANAN().setVisible(true);

        }
        });
            
            banggota.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            dispose();
           new GUI_FORM_ANGGOTA().setVisible(true);
        }
        });
            
            brekening.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent af){
            dispose();

        }

        });
            
            bkeluar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ag){
            dispose();

        }

        });
            
            
            
            
        }

    
}
