package perpusdb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class viewBuku extends JFrame {
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Kode Buku","Nama Buku","Nama Pengarang","Nama Penerbit","Tahun Terbit"};
    
    JLabel ltitle = new JLabel("DATA BUKU");
    JLabel lkode = new JLabel("Kode Buku");
    JTextField fkode = new JTextField();
    JLabel ljudul = new JLabel("Judul");
    JTextField fjudul = new JTextField();
    JLabel lpengarang = new JLabel("Nama Pengarang");
    JTextField fpengarang = new JTextField();
    JLabel lpenerbit = new JLabel("Nama Penerbit");
    JTextField fpenerbit = new JTextField();
    JLabel lterbit = new JLabel("Tahun Terbit");
    JTextField fterbit = new JTextField();
    
    JButton btnSimpan = new JButton("SIMPAN");
    JButton btnHapus = new JButton("HAPUS");
    JButton btnCari = new JButton("CARI");
    JButton btnKeluar = new JButton("KELUAR");
    JButton btnRefresh = new JButton("REFRESH");

    public viewBuku (){
        tableModel = new DefaultTableModel(namaKolom,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800, 500);
        
        //TABEL
        add(scrollPane);
        scrollPane.setBounds(20, 230, 750, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollpane-nya vertikal
        
        add(ltitle);
        ltitle.setBounds(350, 30, 200, 20);
        add(lkode);
        lkode.setBounds(50, 60, 100, 20);
        add(fkode);
        fkode.setBounds(170, 60, 180, 20);
        add(ljudul);
        ljudul.setBounds(50, 90, 100, 20);
        add(fjudul);
        fjudul.setBounds(170, 90, 180, 20);
        add(lpengarang);
        lpengarang.setBounds(50, 120, 100, 20);
        add(fpengarang);
        fpengarang.setBounds(170, 120, 180, 20);
        add(lpenerbit);
        lpenerbit.setBounds(50, 150, 100, 20);
        add(fpenerbit);
        fpenerbit.setBounds(170, 150, 180, 20);
        add(lterbit);
        lterbit.setBounds(50, 180, 100, 20);
        add(fterbit);
        fterbit.setBounds(170, 180, 180, 20);
        
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
        
        btnRefresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fkode.setText("");
                fjudul.setText("");
                fpengarang.setText("");
                fpenerbit.setText("");
                fterbit.setText("");
            }
        });
        
        btnKeluar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 dispose();
            }
        });
    }
    public String getkode(){
         return fkode.getText();
     }
    public String getjudul(){
         return fjudul.getText();
     }
    public String getpengarang(){
         return fpengarang.getText();
     }
    public String getpenerbit(){
         return fpenerbit.getText();
     }
    public String getterbit(){
         return fterbit.getText();
     }
}
