package jar;

import javax.swing.*;

class BookShell extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Book book;
    JLabel img;
    public BookShell(Book book){
        this.book = book;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        String ten = this.book.getTen();
        String nhaXuatBan = this.book.getNhaXuatBan();

        img = new JLabel(new ImageIcon(ImageUtils.getImage("img.jpg", 100, 100)));
        this.add(img);
        this.add(new JLabel(ten));
        this.add(new JLabel(nhaXuatBan));
    }
}