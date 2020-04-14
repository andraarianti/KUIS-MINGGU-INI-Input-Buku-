package perpusdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

class Model {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpus";
    static final String USER = "root"; 
    static final String PASS = "";  
    
    Connection koneksi;
    Statement statement;
    
    public Model() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil!");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi gagal");
        }
    }
    
    //ANGGOTA
    public void insertAnggota(String nis, String nama, String agama, String ttl, String kelas, String daftar, String exp, String jk){
        try{
            String query = "INSERT INTO `anggota` (`nis`, `namaA`, `ttl`, `jk`, `agama`, `kelas`, `daftar`, `exp`) "
                    + "VALUES ('"+nis+"','"+nama+"','"+ttl+"','"+jk+"','"+agama+"','"+kelas+"','"+daftar+"','"+exp+"')";
            //String '"+string+"', kalau int "+int+"
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);//excecute query nya
            System.out.println("Data anggota berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data anggota berhasil ditambahkan");
            
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakDataA(){ // menghitung jumlah baris yang ada
        int jmlData = 0; // nilai awal 0
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `anggota`";
            ResultSet resultSet = statement.executeQuery(query);//pengambilan data dalam java dari database
            while(resultSet.next()){ // ambil nilai dari baris ke 0 sampai baris akhir
                jmlData++;
            }
            return jmlData; // mengembalikan julah data ke readMahasiswa
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String[][] readAnggota(){ 
        try{
            int jmlData = 0; 
            String data[][] = new String[getBanyakDataA()][8]; 
            String query = "Select * from `anggota`"; 
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("nis"); 
                data[jmlData][1] = resultSet.getString("namaA"); 
                data[jmlData][2] = resultSet.getString("ttl"); 
                data[jmlData][3] = resultSet.getString("jk");
                data[jmlData][4] = resultSet.getString("agama");
                data[jmlData][5] = resultSet.getString("daftar");
                data[jmlData][6] = resultSet.getString("exp");
                data[jmlData][7] = resultSet.getString("kelas");
                
                jmlData++; //barisnya berpindah terus sampai habis        
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
     public void deleteAnggota(String nis){ //menghapus data bds nis
        try{
            String query = "Delete from `anggota` WHERE `nis` = "+nis+"";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Anggota berhasil dihapus!");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
   //BUKU
     public void insertBuku(String kode, String judul, String pengarang, String penerbit, String terbit){
        try{
            String query = "INSERT INTO `buku` (`kode`, `judul`, `pengarang`, `penerbit`, `terbit`) VALUES ("+kode+",'"+judul+"','"+pengarang+"','"+penerbit+"','"+terbit+"')";
            //String '"+string+"', kalau int "+int+"
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);//excecute query nya
            System.out.println("Data buku berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data buku berhasil ditambahkan");
            
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
     
     public int getBanyakDataB(){ // menghitung jumlah baris yang ada
        int jmlData = 0; // nilai awal 0
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `buku`";
            ResultSet resultSet = statement.executeQuery(query);//pengambilan data dalam java dari database
            while(resultSet.next()){ // ambil nilai dari baris ke 0 sampai baris akhir
                jmlData++;
            }
            return jmlData; // mengembalikan julah data ke readMahasiswa
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
     
     public String[][] readBuku(){ //dua dimensi baris-kolom
        try{
            int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya
            String data[][] = new String[getBanyakDataB()][5]; // nemampung array. barisnya isinya di getBanyakData,kolomnya itu atribut
            String query = "Select * from `buku`"; //proses penampilan data
            ResultSet resultSet = statement.executeQuery(query); // result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("kode"); // Harus sesuai database
                data[jmlData][1] = resultSet.getString("judul"); // Harus sesuai database
                data[jmlData][2] = resultSet.getString("pengarang"); // Harus sesuai database
                data[jmlData][3] = resultSet.getString("penerbit");
                data[jmlData][4] = resultSet.getString("terbit");
                jmlData++; //barisnya berpindah terus sampai habis        
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
     
     public void deleteBuku(String kode){ //menghapus data bds judul
        try{
            String query = "Delete from `buku` WHERE `kode` = "+kode+"";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Buku berhasil dihapus!");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
     
     public void enterBuku(String gol){
         
     }
     
    public int getBanyakDataSearchBuku(String search){
        int jmlData=0;
        try{
            statement = koneksi.createStatement();
            String query ="Select * from `buku` where `Kode` like '%"+search+"%'";
            ResultSet resultSet =statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL ERROR");
            return 0;
        }
    }
    
    public String[][] searchBuku(String search){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearchBuku(search)][5];
        String query="Select * from `buku` where `kode` like '%"+search+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] = resultSet.getString("kode");
            data[jmlData][1] = resultSet.getString("judul");
            data[jmlData][2] = resultSet.getString("pengarang");
            data[jmlData][3] = resultSet.getString("penerbit");
            data[jmlData][4] = resultSet.getString("terbit");
            jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}
    
    //KARYAWAN
    public void insertKaryawan(String nik, String namaK, String jk, String golongan, String jabatan, String tunjangan, String gaji){
        try{
            String query = "INSERT INTO `karyawan` (`nik`, `namaK`, `jk`, `golongan`, `jabatan`, `tunjangan`, `gaji`) VALUES "
                    + "("+nik+",'"+namaK+"','"+jk+"','"+golongan+"','"+jabatan+"','"+tunjangan+"','"+gaji+"')";
            //String '"+string+"', kalau int "+int+"
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);//excecute query nya
            System.out.println("Data karyawan berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data karyawan berhasil ditambahkan");
            
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakDataK(){ // menghitung jumlah baris yang ada
        int jmlData = 0; // nilai awal 0
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `karyawan` ";
            ResultSet resultSet = statement.executeQuery(query);//pengambilan data dalam java dari database
            while(resultSet.next()){ // ambil nilai dari baris ke 0 sampai baris akhir
                jmlData++;
            }
            return jmlData; // mengembalikan julah data ke readMahasiswa
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
     public String[][] readKaryawan(){ //dua dimensi baris-kolom
        try{
            int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya
            String data[][] = new String[getBanyakDataK()][7]; // nemampung array. barisnya isinya di getBanyakData,kolomnya itu atribut
            String query = "Select * from `karyawan`"; //proses penampilan data
            ResultSet resultSet = statement.executeQuery(query); // result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("nik"); // Harus sesuai database
                data[jmlData][1] = resultSet.getString("namaK"); // Harus sesuai database
                data[jmlData][2] = resultSet.getString("jk"); // Harus sesuai database
                data[jmlData][3] = resultSet.getString("golongan");
                data[jmlData][4] = resultSet.getString("jabatan");
                data[jmlData][5] = resultSet.getString("tunjangan"); 
                data[jmlData][6] = resultSet.getString("gaji");
                jmlData++; //barisnya berpindah terus sampai habis        
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
     
      public void deleteKaryawan(String nik){ //menghapus data bds judul
        try{
            String query = "Delete from `karyawan` WHERE `nik` = "+nik+"";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Karyawan berhasil dihapus!");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public int getBanyakDataSearchKaryawan(String search){
        int jmlData=0;
        try{
            statement = koneksi.createStatement();
            String query ="Select * from `karyawan` where `NIK` like '%"+search+"%'";
            ResultSet resultSet =statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL ERROR");
            return 0;
        }
    }


    public String[][] searchKaryawan(String search){
        try{

            int jmlData = 0;
            String data[][]= new String[getBanyakDataSearchKaryawan(search)][8];
            String query="Select * from `karyawan` where `NIK` like '%"+search+"%'";
            ResultSet resultSet =statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("NIK : ");
                data[jmlData][1] = resultSet.getString("Nama Karyawan : ");
                data[jmlData][3] = resultSet.getString("Jenis Kelamin : ");
                data[jmlData][4] = resultSet.getString("Golongan : ");
                data[jmlData][5] = resultSet.getString("Jabatan : ");
                data[jmlData][6] = resultSet.getString("Tunjangan : ");
                data[jmlData][7] = resultSet.getString("Gaji : ");
                jmlData++;
            }

            return data;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL ERROR");
            return null;
        }
    }
    
    //PENGEMBALIAN
    public void insertPengembalian(String np, String nis, String kode, String pinjam, String kembali, String nik){
        try{
            String query = "INSERT INTO `pengembalian` (`np`, `nis`, `kode`,`pinjam`, `nik`) VALUES ("+np+","+nis+",'"+kode+"','"+pinjam+"','"+pinjam+"','"+kembali+"',"+nik+")";
            //String '"+string+"', kalau int "+int+"
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);//excecute query nya
            System.out.println("Data peminjaman berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data peminjaman berhasil ditambahkan");
            
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakDataP(){ // menghitung jumlah baris yang ada
        int jmlData = 0; // nilai awal 0
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `pengembalian`";
            ResultSet resultSet = statement.executeQuery(query);//pengambilan data dalam java dari database
            while(resultSet.next()){ // ambil nilai dari baris ke 0 sampai baris akhir
                jmlData++;
            }
            return jmlData; // mengembalikan julah data ke readMahasiswa
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String[][] readPengembalian(){ //dua dimensi baris-kolom
        try{
            int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya
            String data[][] = new String[getBanyakDataP()][13]; // nemampung array. barisnya isinya di getBanyakData,kolomnya itu atribut
            String query = "Select * from `pengembalian`"; //proses penampilan data
            ResultSet resultSet = statement.executeQuery(query); // result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("np"); // Harus sesuai database
                data[jmlData][1] = resultSet.getString("nis"); // Harus sesuai database
                data[jmlData][2] = resultSet.getString("namaP"); // Harus sesuai database
                data[jmlData][3] = resultSet.getString("kelas");
                data[jmlData][4] = resultSet.getString("kode");
                data[jmlData][5] = resultSet.getString("judul");
                data[jmlData][6] = resultSet.getString("penerbit");
                data[jmlData][7] = resultSet.getString("pinjam");
                data[jmlData][8] = resultSet.getString("kembali");
                data[jmlData][9] = resultSet.getString("lama");
                data[jmlData][10] = resultSet.getString("denda");
                data[jmlData][11] = resultSet.getString("namaK");
                data[jmlData][12] = resultSet.getString("nik");
                
                jmlData++; //barisnya berpindah terus sampai habis        
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void deletePengembalian(String np){ //menghapus data bds nis
        try{
            String query = "Delete from `pengembalian` WHERE `np` = "+np+"";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Anggota berhasil dihapus!");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public int getBanyakDataSearchPengembalian(String search){
    int jmlData=0;
    try{
        statement = koneksi.createStatement();
        String query ="Select * from `pengembalian` where `np` like '%"+search+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}


public String[][] searchPengembalian(String search){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearchPengembalian(search)][13];
        String query="Select * from `pengembalian` where `nis` like '%"+search+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] = resultSet.getString("No Peminjam : ");
            data[jmlData][1] = resultSet.getString("np");
            data[jmlData][2] = resultSet.getString("namaP");
            data[jmlData][3] = resultSet.getString("kelas");
            data[jmlData][4] = resultSet.getString("kode");
            data[jmlData][5] = resultSet.getString("judul");
            data[jmlData][6] = resultSet.getString("penerbit");
            data[jmlData][7] = resultSet.getString("pinjam");
            data[jmlData][8] = resultSet.getString("kembali");
            data[jmlData][9] = resultSet.getString("lama");
            data[jmlData][10] = resultSet.getString("denda");
            data[jmlData][11] = resultSet.getString("namaK");
            data[jmlData][12] = resultSet.getString("nik");
            jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}

}

