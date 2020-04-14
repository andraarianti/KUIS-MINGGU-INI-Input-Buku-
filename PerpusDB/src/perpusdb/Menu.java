package perpusdb;


public class Menu {
        
    public void Anggota(){
        viewAnggota anggota = new viewAnggota();
        Model model = new Model();
        Controller controller = new Controller(anggota, model);
    }
    
    public void Buku(){
        viewBuku buku = new viewBuku();
        Model model = new Model();
        Controller controller = new Controller(buku, model);
    }
    
    public void Karyawan(){
        viewKaryawan karyawan = new viewKaryawan();
        Model model = new Model();
        Controller controller = new Controller(karyawan, model);
    }
    
    public void Pengembalian(){
        viewPengembalian kembali = new viewPengembalian();
        Model model = new Model();
        Controller controller = new Controller(kembali, model);
    }
        
}
