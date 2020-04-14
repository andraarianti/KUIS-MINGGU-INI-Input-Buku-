package perpusdb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class viewAnggota extends JFrame {
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIS","Nama Siswa","TTL","Jenis Kelamin","Agama","Tgl Daftar","Berlaku S/D","Kelas"};
    
    JLabel ljudul = new JLabel("DATA ANGGOTA");
    JLabel lnis = new JLabel("NIS");
    JTextField fnis = new JTextField();
    JLabel lnama = new JLabel("Nama");
    JTextField fnama = new JTextField();
    JLabel lttl = new JLabel("TTL");
    JTextField fttl = new JTextField();
    JLabel ljk = new JLabel("Jenis Kelamin");
    JRadioButton radioPria = new JRadioButton(" Laki-Laki ");
    JRadioButton radioWanita = new JRadioButton("Perempuan ");
    JLabel lagama = new JLabel(" Agama ");
       String[] agama =
                {"Islam","Kristen","Katolik","Hindu","Budha","Atheis","Indomie"};
    JComboBox cbagama = new JComboBox(agama);
    JLabel lkelas = new JLabel("Kelas");
    JTextField fkelas = new JTextField();
    JLabel ldaftar = new JLabel("Tanggal Daftar");
    JTextField fdaftar = new JTextField();
    JLabel lexp = new JLabel("Berlaku Hingga");
    JTextField fexp = new JTextField();
    
    JButton btnSimpan = new JButton("SIMPAN");
    JButton btnHapus = new JButton("HAPUS");
    JButton btnKeluar = new JButton("KELUAR");
    JButton btnRefresh = new JButton("REFRESH");

       
    public viewAnggota(){
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
        
        add(ljudul);
        ljudul.setBounds(350, 30, 200, 20);
        add(lnis);
        lnis.setBounds(50, 60, 100, 20);
        add(fnis);
        fnis.setBounds(170, 60, 180, 20);
        add(lnama);
        lnama.setBounds(50, 90, 100, 20);
        add(fnama);
        fnama.setBounds(170, 90, 180, 20);
        add(lttl);
        lttl.setBounds(50, 120, 100, 20);
        add(fttl);
        fttl.setBounds(170, 120, 180, 20);
        
        add(ljk);
        ljk.setBounds(50, 150, 100, 20);
        add(radioPria);
        radioPria.setBounds(160, 150, 100, 20);
        add(radioWanita);
        radioWanita.setBounds(260, 150, 100, 20);
        
        add(lagama);
        lagama.setBounds(400, 60, 70, 20);
        add(cbagama);
        cbagama.setBounds(500, 60, 100, 20);
        
        add(lkelas);
        lkelas.setBounds(400, 90, 150, 20);
        add(fkelas);
        fkelas.setBounds(500, 90, 150, 20);
        add(ldaftar);
        ldaftar.setBounds(400, 120, 150, 20);
        add(fdaftar);
        fdaftar.setBounds(500, 120, 150, 20);
        add(lexp);
        lexp.setBounds(400, 150, 150, 20);
        add(fexp);
        fexp.setBounds(500, 150, 150, 20);
        
        add(btnSimpan);
        btnSimpan.setBounds(170, 185, 100, 20);
        add(btnHapus);
        btnHapus.setBounds(300, 185, 100, 20);
        add(btnRefresh);
        btnRefresh.setBounds(420, 185, 100, 20);
        add(btnKeluar);
        btnKeluar.setBounds(540, 185, 100, 20);
            
        btnRefresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fnis.setText("");
                fnama.setText("");
                fttl.setText("");
                cbagama.getAction();
                fkelas.setText("");
                fdaftar.setText("");
                fexp.setText("");
            }
        });
        
        btnKeluar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 dispose();
            }
        });
        
    }
    public String getnis(){
        return fnis.getText();
     }       
     public String getnama(){
         return fnama.getText();
     }
     public String getagama(){
         return cbagama.getSelectedItem().toString();
     }
      public String getjk(){
        if (radioPria.isSelected()) 
           return radioPria.getText();
        else if (radioWanita.isSelected()) 
           return radioWanita.getText();
        else
            return null;
     }
      
     public String getttl(){
         return fttl.getText();
     }
     public String getkelas(){
         return fkelas.getText();
     }
     public String getdaftar(){
         return fdaftar.getText();
     }
      public String getexp(){
         return fexp.getText();
     }
}
