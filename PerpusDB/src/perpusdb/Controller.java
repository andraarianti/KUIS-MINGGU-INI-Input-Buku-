package perpusdb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
class Controller {
    
    Model model;
    viewAnggota anggota;
    viewBuku buku;
    viewKaryawan karyawan;
    viewPengembalian kembali;
              
    
    //ANGGOTA
    Controller(viewAnggota anggota, Model model) {
        this.model = model;
        this.anggota = anggota;
        
        if(model.getBanyakDataA() != 0){
            String dataAnggota[][] = model.readAnggota();
            anggota.table.setModel((new JTable(dataAnggota, anggota.namaKolom)).getModel());
            
        } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        anggota.btnSimpan.addActionListener((ActionEvent e) -> {
            if(anggota.getnis().equals("")
                    || anggota.getnama().equals("")
                    || anggota.getagama().equals("")
                    || anggota.getttl().equals("")
                    || anggota.getkelas().equals("")
                    || anggota.getdaftar().equals("")
                    || anggota.getexp().equals("")
                    ) {
                JOptionPane.showMessageDialog(null, "Field tdk boleh kosong");
            } else{
                
                String nis = anggota.getnis();
                String nama = anggota.getnama();
                String agama = anggota.getagama();
                String jk = anggota.getjk();
                String ttl = anggota.getttl();
                String kelas = anggota.getkelas();
                String daftar = anggota.getdaftar();
                String exp = anggota.getexp();
                
                model.insertAnggota(nis, nama, agama, ttl, kelas, daftar, exp, jk);
                String dataAnggota[][] = model.readAnggota();
                anggota.table.setModel(new JTable(dataAnggota, anggota.namaKolom).getModel());
            }
        });
        
        anggota.btnHapus.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ex) {
            int baris = anggota.table.getSelectedRow();
            int kolom = anggota.table.getSelectedColumn();

            String dataterpilih = anggota.table.getValueAt(baris, 0).toString();
           
            System.out.println(dataterpilih);
            model.deleteAnggota(dataterpilih);
            String dataAnggota[][] = model.readAnggota();
            anggota.table.setModel(new JTable(dataAnggota, anggota.namaKolom).getModel());
        }
    });
    }

    
    //BUKU
    
    Controller(viewBuku buku, Model model) {
       if(model.getBanyakDataB() != 0){
            String dataBuku[][] = model.readBuku();
            buku.table.setModel((new JTable(dataBuku, buku.namaKolom)).getModel());
            
        } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        buku.btnSimpan.addActionListener((ActionEvent e) -> {
            if(buku.getkode().equals("")
                    || buku.getjudul().equals("")
                    || buku.getpengarang().equals("")
                    || buku.getpenerbit().equals("")
                    || buku.getterbit().equals("")
                    ) {
                JOptionPane.showMessageDialog(null, "Field tdk boleh kosong");
            } else{
                String kode = buku.getkode();
                String judul = buku.getjudul();
                String pengarang = buku.getpengarang();
                String penerbit = buku.getpenerbit();
                String terbit = buku.getterbit();
                
                model.insertBuku(kode, judul, pengarang, penerbit, terbit);
                String dataBuku[][] = model.readBuku();
                buku.table.setModel(new JTable(dataBuku, buku.namaKolom).getModel());
            }
        });
        
        buku.btnHapus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ex) {
                int baris = buku.table.getSelectedRow();
                int kolom = buku.table.getSelectedColumn();

                String dataterpilih = buku.table.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);
                model.deleteBuku(dataterpilih);
                String dataBuku[][] = model.readBuku();
                buku.table.setModel(new JTable(dataBuku, buku.namaKolom).getModel());
            }
        });
        
    }
    
    Controller(viewKaryawan karyawan, Model model) {
       if(model.getBanyakDataK() != 0){
            String dataKaryawan[][] = model.readKaryawan();
            karyawan.table.setModel((new JTable(dataKaryawan, karyawan.namaKolom)).getModel());
            
        } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
       
       karyawan.fgol.addKeyListener(new KeyAdapter(){
          @Override
          public void keyPressed(KeyEvent e){
              if(e.getKeyCode() == KeyEvent.VK_ENTER){
                  if(karyawan.getgol().equals("1")){
                      String jabatan = "Ketua";
                      karyawan.fjabatan.setText(jabatan);
                      String tunjangan = "500.000";
                      karyawan.ftunjangan.setText(tunjangan);
                      String gaji = "1.000.000";
                      karyawan.fgaji.setText(gaji);
                  }
                  else if(karyawan.getgol().equals("2")){
                      String jabatan = "Wakil Ketua";
                      karyawan.fjabatan.setText(jabatan);
                      String tunjangan = "300.000";
                      karyawan.ftunjangan.setText(tunjangan);
                      String gaji = "700.000";
                      karyawan.fgaji.setText(gaji);
                  }
                  else {
                      String jabatan = "Magang";
                      karyawan.fjabatan.setText(jabatan);
                      String tunjangan = "0";
                      karyawan.ftunjangan.setText(tunjangan);
                      String gaji = "500.000";
                      karyawan.fgaji.setText(gaji);
                  }
                  String jabatan = karyawan.fjabatan.getText();
                  String tunjangan = karyawan.ftunjangan.getText();
                  String gaji = karyawan.fgaji.getText();
            } 
          }
       });
       
        karyawan.btnSimpan.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               if(karyawan.getnik().equals("")
                       || karyawan.getkaryawan().equals("")
                       || karyawan.getgol().equals("")
                       ) {
                   JOptionPane.showMessageDialog(null, "Field tdk boleh kosong");
               }else{
                   String nik = karyawan.getnik();
                   String namaK = karyawan.getkaryawan();
                   String jk = karyawan.getjk().toString();
                   String golongan = karyawan.getgol();
                   String jabatan = karyawan.fjabatan.getText();
                   String tunjangan = karyawan.ftunjangan.getText();
                   String gaji = karyawan.fgaji.getText();
                  
                   model.insertKaryawan(nik , namaK, jk, golongan, jabatan, tunjangan, gaji);
                   String dataKaryawan[][] = model.readKaryawan();
                   karyawan.table.setModel(new JTable(dataKaryawan, karyawan.namaKolom).getModel());
               }
           }
       });   
       
             
        karyawan.btnHapus.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent ex) {
                int baris = karyawan.table.getSelectedRow();
                int kolom = karyawan.table.getSelectedColumn();

                String dataterpilih = karyawan.table.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);
                model.deleteKaryawan(dataterpilih);
                String dataKaryawan[][] = model.readKaryawan();
                karyawan.table.setModel(new JTable(dataKaryawan, karyawan.namaKolom).getModel());
            }
        });
    }
    
    Controller(viewPengembalian pengembalian, Model model) {
       if(model.getBanyakDataP() != 0){
            String dataPengembalian[][] = model.readPengembalian();
            pengembalian.table.setModel((new JTable(dataPengembalian, pengembalian.namaKolom)).getModel());
            
        } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        pengembalian.btnSimpan.addActionListener((ActionEvent e) -> {
            if(pengembalian.getnp().equals("")
                    || pengembalian.getnis().equals("")
                    || pengembalian.getkode().equals("")
                    || pengembalian.getpinjam().equals("")
                    || pengembalian.getkembali().equals("")
                    || pengembalian.getnik().equals("")
                    ) {
                JOptionPane.showMessageDialog(null, "Field tdk boleh kosong");
            } else{
                String np = pengembalian.getnp();
                String nis = pengembalian.getnis();
                String kode = pengembalian.getkode();
                String pinjam = pengembalian.getpinjam();
                String kembali = pengembalian.getkembali();
                String nik = pengembalian.getnik();
                
                model.insertPengembalian(np, nis, kode, pinjam, kembali, nik);
                String dataPengembalian[][] = model.readPengembalian();
                pengembalian.table.setModel(new JTable(dataPengembalian, pengembalian.namaKolom).getModel());
            }
        });
        
        pengembalian.btnHapus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ex) {
                int baris = pengembalian.table.getSelectedRow();
                int kolom = pengembalian.table.getSelectedColumn();

                String dataterpilih = pengembalian.table.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);
                model.deletePengembalian(dataterpilih);
                String dataPengembalian[][] = model.readPengembalian();
                pengembalian.table.setModel(new JTable(dataPengembalian, pengembalian.namaKolom).getModel());
            }
        });
    }

}
