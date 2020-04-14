package perpusdb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class viewKaryawan extends JFrame{
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIK","Nama Karyawan","Jenis Kelamin","Golongan","Jabatan","Tunjangan","Gaji"};
    
    JLabel ljudul = new JLabel("DATA KARYAWAN");
    JLabel lnik = new JLabel("NIK");
    JTextField fnik = new JTextField();
    JLabel lkaryawan = new JLabel("Nama Karyawan");
    JTextField fkaryawan = new JTextField();
    JLabel ljk = new JLabel("Jenis Kelamin");
    JRadioButton radioPria = new JRadioButton(" Laki-Laki ");
    JRadioButton radioWanita = new JRadioButton("Perempuan ");
    JLabel lgol = new JLabel("Golongan");
    JTextField fgol = new JTextField();
    JLabel ljabatan = new JLabel("Jabatan");
    JLabel fjabatan = new JLabel("");
    JLabel ltunjangan = new JLabel("Tunjangan");
    JLabel ftunjangan = new JLabel("");
    JLabel lgaji = new JLabel("Jumlah Gaji");
    JLabel fgaji = new JLabel("");
    
    JButton btnSimpan = new JButton("SIMPAN");
    JButton btnHapus = new JButton("HAPUS");
    JButton btnCari = new JButton("CARI");
    JButton btnKeluar = new JButton("KELUAR");
    JButton btnRefresh = new JButton("REFRESH");
    
    public viewKaryawan (){
        tableModel = new DefaultTableModel(namaKolom,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800, 500);
        
        //TABEL
        add(scrollPane);
        scrollPane.setBounds(20, 270, 750, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollpane-nya vertikal
        
        add(btnSimpan);
        btnSimpan.setBounds(430, 80, 100, 40);
        add(btnHapus);
        btnHapus.setBounds(540, 80, 100, 40);
        add(btnCari);
        btnCari.setBounds(650, 80, 100, 40);
        add(btnKeluar);
        btnKeluar.setBounds(490, 140, 100, 40);
        add(btnRefresh);
        btnRefresh.setBounds(600, 140, 100, 40);
        
        add(ljudul);
        ljudul.setBounds(350, 30, 200, 20);
        add(lnik);
        lnik.setBounds(50, 60, 100, 20);
        add(fnik);
        fnik.setBounds(170, 60, 180, 20);
        add(lkaryawan);
        lkaryawan.setBounds(50, 90, 100, 20);
        add(fkaryawan);
        fkaryawan.setBounds(170, 90, 180, 20);
        
        add(ljk);
        ljk.setBounds(50, 120, 100, 20);
        add(radioPria);
        radioPria.setBounds(160, 120, 100, 20);
        add(radioWanita);
        radioWanita.setBounds(260, 120, 100, 20);
        
        add(lgol);
        lgol.setBounds(50, 150, 100, 20);
        add(fgol);
        fgol.setBounds(170, 150, 180, 20);
        add(ljabatan);
        ljabatan.setBounds(50, 180, 100, 20);
        add(fjabatan);
        fjabatan.setBounds(170, 180, 180, 20);
        add(ltunjangan);
        ltunjangan.setBounds(50, 210, 180, 20);
        add(ftunjangan);
        ftunjangan.setBounds(170, 210, 180, 20);
        add(lgaji);
        lgaji.setBounds(50, 240, 180, 20);
        add(fgaji);
        fgaji.setBounds(170, 240, 180, 20);
        
        
         btnRefresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fnik.setText("");
                fkaryawan.setText("");
                fgol.setText("");
            }
        });
        
        btnKeluar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 dispose();
            }
        });
    }
    public String getnik(){
        return fnik.getText();
     }  
    public String getjk(){
         if (radioPria.isSelected()) 
           return radioPria.getText();
        else if (radioWanita.isSelected()) 
           return radioWanita   .getText();
        else
            return null;
    }  
     public String getkaryawan(){
         return fkaryawan.getText();
     }
     public String getgol(){
         return fgol.getText();
     }
     public String getjabatan(){
        return fjabatan.getText();
     }  
    public String gettunjangan(){
        return ftunjangan.getText();
    }  
     public String getgaji(){
         return fgaji.getText();
     }
}
