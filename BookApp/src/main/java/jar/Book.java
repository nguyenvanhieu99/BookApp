package jar;

class Book{
    private int id;
    private String ten, nhaXuatBan;
    private int namXuatBan;
    private double gia;

    public Book(int id, String ten, String nhaXuatBan, int namXuatBan, double gia){
        this.id = id;
        this.ten = ten;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.gia = gia;
    }

    public String getTen(){
        return this.ten;
    }

    public String getNhaXuatBan(){
        return this.nhaXuatBan;
    }
    
    public int getNamXuatBan(){
        return this.namXuatBan;
    }

    public double getGia(){
        return this.gia;
    }
    


}