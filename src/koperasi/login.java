//untuk login awal menuju menu utama

package koperasi;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import view.GUIMENU;
import view.viewUtama;

/**
 *
 * @author User
 */

 public class login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    GUIlogin m = new GUIlogin();
            }
    
}

     class GUIlogin extends JFrame implements Runnable  {
        
    Container konten = getContentPane();
    
    JLabel ljudul = new JLabel("KOPERASI SIMPAN PINJAM ");
    JLabel luser = new JLabel("Username ");
    JLabel lpass = new JLabel("Password ");
    
    JTextField tuser = new JTextField();
    JPasswordField tpass = new JPasswordField();
    
    JButton blogin = new JButton("LOGIN");
    JButton bcancel = new JButton("CANCEL");
    JLabel background = new JLabel();
    JLabel jalan = new JLabel("Nadia Stefanny Ambarita (123170002)");
    JPanel jln = new JPanel();
    Thread t;
    boolean kanan=true;
    boolean kiri=false;
    boolean berjalan=true;
    int x,y;
    
    
    public GUIlogin() {
        
        setTitle ("Login");
        setVisible(true);
        setResizable(false);
        setSize (350,255);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         x=jalan.getX();
        y=jalan.getY();
        t=new Thread( this);
        t.start();
       
        
        setLayout(null);    // menggunakan Layout null
        konten.add(ljudul);
        konten.add(luser);
        konten.add(lpass); 
        konten.add(tuser); 
        konten.add(tpass); 
        konten.add(blogin); 
        konten.add(bcancel);  
        konten.add(background);
        konten.add(jln); 
        jln.add(jalan); 
        
        jln.setBounds(0,0,500,20);
        jln.setSize(500, 20);
    
        jalan.setFont(new Font(Font.SERIF,Font.BOLD,14));
        jln.setBackground(Color.decode("#0d5bab"));
        
        //tuser.setBounds(, 160, 250, 20);
        tuser.setBackground(Color.decode("#c3d7dc"));
        tuser.setCaretColor(Color.red);
        
        //tpass.setBounds(200, 220, 250, 20);
        tpass.setBackground(Color.decode("#c3d7dc"));
        tpass.setCaretColor(Color.red);
        
//        background.setIcon(new ImageIcon(getClass().getResource("src/gambar/back.png")));
//        background.setBounds(0, 20, 700, 400);
//        blogin.setIcon(new ImageIcon(getClass().getResource("src/gambar/download.jpg")));
//        blogin.setBounds(282, 289, 93, 28);
        //tpass.setEchoChar('*');
    
        ljudul.setBounds(100, 10, 200, 40);
        luser.setBounds(50, 60, 100, 20);
        lpass.setBounds(50, 100, 100, 20);
        tuser.setBounds(130, 60, 140, 20);
        tpass.setBounds(130, 100, 140, 20);
        blogin.setBounds(90, 150, 80, 30);
        bcancel.setBounds(200, 150, 80, 30);

        blogin.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
            String x = tuser.getText();
            String y = tpass.getText();
       if((x.equals("admin"))&&(y.equals("admin")))
    {   dispose();
      //  new background().setVisible(true);
      new viewUtama().setVisible(true);
   // new GUIMENU();
      
    }
             else if((x.equals(""))&&(y.equals("")))
           JOptionPane.showMessageDialog(null, "user dan password belum di isi", "hasil", JOptionPane.ERROR_MESSAGE);
 
       else if(x.equals(""))
           JOptionPane.showMessageDialog(null, "user belum di isi", "hasil", JOptionPane.ERROR_MESSAGE);
       else if(y.equals(""))
           JOptionPane.showMessageDialog(null, "password belum di isi", "hasil", JOptionPane.ERROR_MESSAGE);
       else JOptionPane.showMessageDialog(null, "Kombinasi user dan password salah", "hasil", JOptionPane.ERROR_MESSAGE);
} 
    
    });
        
        bcancel.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        dispose();
    } });
        
        
        
    }
  
public void run(){
while(1<2){
        if(berjalan){
        if(x>=jln.getWidth()){
            kanan=false;
            kiri=true;
    }
        if(kiri){
            x--;
            jalan.setLocation(x, y);
}
        if(x<=-700){
            kanan=true;
            kiri=false;
}
        if(kanan){
            x++;
            jalan.setLocation(x, y);
}
}
    try{
        Thread.sleep(10);
}   catch (InterruptedException ex){
        Logger.getLogger(GUIlogin.class.getName()).log(Level.SEVERE,null,ex);
           }repaint();
}
}

    
}
