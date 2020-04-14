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

public class viewPengembalian extends JFrame {
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"No Pinjam","NIS","Nama Siswa","Kelas","Kode Buku","Nama Buku","Penerbit",
        "Tgl Pinjam","Tgl Kembali","Lama","Denda","Petugas","NIK"};

    JLabel ltitle = new JLabel("DATA PENGEMBALIAN BUKU");
    JLabel lnp = new JLabel("No Pinjam");
    JTextField fnp = new JTextField();
    JLabel lnis = new JLabel("NIS");
    JTextField fnis = new JTextField();
    JLabel lsiswa = new JLabel("Siswa");
    JLabel fsiswa = new JLabel("");
    JLabel lkelas = new JLabel("Kelas");
    JLabel fkelas = new JLabel("");
    JLabel lkode = new JLabel("Kode Buku");
    JTextField fkode = new JTextField();
    JLabel ljudul = new JLabel("Nama Buku");
    JLabel fjudul = new JLabel("");
    JLabel lpenerbit = new JLabel("Penerbit");
    JLabel fpenerbit = new JLabel("");
    JLabel lpinjam = new JLabel("Tgl Pinjam");
    JTextField fpinjam = new JTextField();
    JLabel lkembali = new JLabel("Tgl Kembali");
    JTextField fkembali = new JTextField();
    JLabel llama = new JLabel("Lama Pinjam");
    JLabel flama = new JLabel("");
    
    JLabel ldenda = new JLabel("Denda");
    JLabel fdenda = new JLabel("");
    JLabel lnik = new JLabel("NIK");
    JTextField fnik = new JTextField();
    JLabel ltugas = new JLabel("Karyawan yang bertugas");
    JLabel ftugas = new JLabel("");
    
    JButton btnSimpan = new JButton("SIMPAN");
    JButton btnHapus = new JButton("HAPUS");
    JButton btnCari = new JButton("CARI");
    JButton btnKeluar = new JButton("KELUAR");
    JButton btnRefresh = new JButton("REFRESH");
    JButton btnPrint = new JButton("PRINT");
    
    public viewPengembalian (){
        tableModel = new DefaultTableModel(namaKolom,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800, 500);
        
        //TABEL
        add(scrollPane);
        scrollPane.setBounds(20, 350, 750, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollpane-nya vertikal
        
        add(btnSimpan);
        btnSimpan.setBounds(430, 50, 100, 20);
        add(btnHapus);
        btnHapus.setBounds(550, 50, 100, 20);
        add(btnCari);
        btnCari.setBounds(430, 80, 100, 20);
        add(btnKeluar);
        btnKeluar.setBounds(550, 80, 100, 20);
        add(btnRefresh);
        btnRefresh.setBounds(430, 110, 100, 20);
        add(btnPrint);
        btnPrint.setBounds(550, 110, 100, 20);
        
        add(ltitle);
        ltitle.setBounds(300, 20, 200, 20);
        
        add(lnp);
        lnp.setBounds(50, 50, 100, 20);
        add(fnp);
        fnp.setBounds(170, 50, 150, 20);
        add(lnis);
        lnis.setBounds(50, 80, 150, 20);
        add(fnis);
        fnis.setBounds(170, 80, 150, 20);
        add(lsiswa);
        lsiswa.setBounds(50, 110, 150, 20);
        add(fsiswa);
        fsiswa.setBounds(170, 110, 150, 20);
        add(lkelas);
        lkelas.setBounds(50, 140, 150, 20);
        add(fkelas);
        fkelas.setBounds(170, 140, 150, 20);
        add(lkode);
        lkode.setBounds(50, 170, 150, 20);
        add(fkode);
        fkode.setBounds(170, 170, 150, 20);
        add(ljudul);
        ljudul.setBounds(50, 200, 150, 20);
        add(fjudul);
        fjudul.setBounds(170, 200, 150, 20);
        add(lpenerbit);
        lpenerbit.setBounds(50, 230, 150, 20);
        add(fpenerbit);
        fpenerbit.setBounds(170, 230, 150, 20);
        add(lpinjam);
        lpinjam.setBounds(50, 260, 150, 20);
        add(fpinjam);
        fpinjam.setBounds(170, 260, 150, 20);
        add(lkembali);
        lkembali.setBounds(50, 290, 150, 20);
        add(fkembali);
        fkembali.setBounds(170, 290, 150, 20);
        add(llama);
        llama.setBounds(50, 320, 150, 20);
        add(flama);
        flama.setBounds(170, 320, 150, 20);
        
        add(ldenda);
        ldenda.setBounds(430, 260, 100, 20);
        add(fdenda);
        fdenda.setBounds(550, 260, 150, 20);
        add(lnik);
        lnik.setBounds(430, 290, 100, 20);
        add(fnik);
        fnik.setBounds(550, 290, 150, 20);
        add(ltugas);
        ltugas.setBounds(430, 320, 100, 20);
        add(ftugas);
        ftugas.setBounds(550, 320, 150, 20);
        
         btnRefresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fkode.setText("");
                fpinjam.setText("");
                fnis.setText("");
                fpenerbit.setText("");
                fkembali.setText("");
                fnik.setText("");
                fnp.setText("");
                fdenda.setText("");
                ftugas.setText("");
                fkelas.setText("");
                fsiswa.setText("");
                fjudul.setText("");
                
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
    public String getsiswa(){
        return fsiswa.getText();
     }   
     public String getpinjam(){
         return fpinjam.getText();
     }
     public String getnis(){
         return fnis.getText();
     }
     public String getpenerbit(){
        return fpenerbit.getText();
     }       
     public String getkembali(){
         return fkembali.getText();
     }
     public String getnik(){
         return fnik.getText();
     }
     public String getnp(){
         return fnp.getText();
     }
}

