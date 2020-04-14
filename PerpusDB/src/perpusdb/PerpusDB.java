package perpusdb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PerpusDB {
    public static void main(String[] args) {
        // TODO code application logic here
        Perpus perpus = new Perpus();
    }
}

class Perpus extends JFrame {
    Menu menu;
    
    JButton btnAnggota = new JButton("INPUT ANGGOTA");
    JButton btnBuku = new JButton("INPUT BUKU");
    JButton btnKaryawan = new JButton("INPUT KARYAWAN");
    JButton btnPinjam = new JButton("PEMINJAMAN");
    
    Perpus(){
        setTitle("PERPUSTAKAAN");
	setSize(350,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
        
        add(btnAnggota);
        add(btnBuku);
        add(btnKaryawan);
        add(btnPinjam);
        
        setVisible(true);
        btnAnggota.setBounds(10,50,150,40);
        btnKaryawan.setBounds(170,50,150,40);
        btnBuku.setBounds(10,100,150,40);
        btnPinjam.setBounds(170,100,150,40);
        
         btnAnggota.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Menu menu = new Menu();
                  menu.Anggota();
              }
         });
         
         btnKaryawan.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Menu menu = new Menu();
                  menu.Karyawan();
              }
         });
         
         btnBuku.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Menu menu = new Menu();
                  menu.Buku();
              }
         });
         
         btnPinjam.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Menu menu = new Menu();
                  menu.Pengembalian();
              }
         });
   }
           
}
