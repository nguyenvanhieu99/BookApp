package jar;

// import javax.swing.BoxLayout;
// import javax.swing.JFrame;

// import java.awt.BorderLayout;
import java.util.ArrayList;
// import javax.swing.Button;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class MainDisplay extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    ArrayList<String> bookType = new ArrayList<String>();
    ArrayList<Book> bookList;
    ArrayList<BookShell> bookShellList;
    JPanel typePanel, bookArea, bookDisplayArea, directButtonArea;
    JLabel cover;
    JButton next, back;
    int lastIndex = 0;

    public static ArrayList<Book> genBookList(String type) {
        ArrayList<Book> bookList = new ArrayList<Book>();
        if (type.equals("Type 1")) {
            bookList.add(new Book(1, "Type1_1", "KimDong", 2019, 100000));
            bookList.add(new Book(2, "Type1_2", "KimDong", 2019, 100000));
            bookList.add(new Book(3, "Type1_3", "KimDong", 2019, 100000));
            bookList.add(new Book(4, "Type1_4", "KimDong", 2019, 100000));
            
            bookList.add(new Book(5, "Type1_5", "KimDong", 2019, 100000));
            bookList.add(new Book(6, "Type1_6", "KimDong", 2019, 100000));
            bookList.add(new Book(7, "Type1_7", "KimDong", 2019, 100000));
            bookList.add(new Book(8, "Type1_8", "KimDong", 2019, 100000));
            
            bookList.add(new Book(9, "Type1_9", "KimDong", 2019, 100000));
            bookList.add(new Book(10, "Type1_10", "KimDong", 2019, 100000));
            bookList.add(new Book(11, "Type1_11", "KimDong", 2019, 100000));
            bookList.add(new Book(12, "Type1_12", "KimDong", 2019, 100000));
            
            bookList.add(new Book(13, "Type1_13", "KimDong", 2019, 100000));
            bookList.add(new Book(14, "Type1_14", "KimDong", 2019, 100000));
            bookList.add(new Book(15, "Type1_15", "KimDong", 2019, 100000));
            bookList.add(new Book(16, "Type1_16", "KimDong", 2019, 100000));
        }
        if (type.equals("Type 2")) {
            bookList.add(new Book(1, "Type2_1", "KimVang", 2019, 110000));
            bookList.add(new Book(2, "Type2_2", "KimVang", 2019, 110000));
            bookList.add(new Book(3, "Type2_3", "KimVang", 2019, 110000));
            bookList.add(new Book(4, "Type2_4", "KimVang", 2019, 110000));
        } else {
            return bookList;
        }
        return bookList;
    }

    // public static ArrayList<Book> genBookList(){
    //     ArrayList<Book> arr = new ArrayList<Book>();
    //     arr.add(new Book(1, "abc", "abc", 2018, 100.00));
    //     arr.add(new Book(1, "abc", "abc", 2018, 100.00));
    //     arr.add(new Book(1, "abc", "abc", 2018, 100.00));
    //     arr.add(new Book(1, "abc", "abc", 2018, 100.00));
    //     arr.add(new Book(1, "abc", "abc", 2018, 100.00));
        
    //     arr.add(new Book(1, "abc1", "abc", 2018, 100.00));
    //     arr.add(new Book(1, "abc2", "abc", 2018, 100.00));
    //     arr.add(new Book(1, "abc3", "abc", 2018, 100.00));
    //     arr.add(new Book(1, "abc5", "abc", 2018, 100.00));
    //     arr.add(new Book(1, "abc4", "abc", 2018, 100.00));
        
    //     arr.add(new Book(1, "abc44", "abc", 2018, 100.00));
    //     arr.add(new Book(1, "abc444", "abc", 2018, 100.00));
    //     arr.add(new Book(1, "abc4444", "abc", 2018, 100.00));
    //     arr.add(new Book(1, "abc44444", "abc", 2018, 100.00));
    //     arr.add(new Book(1, "abc444444", "abc", 2018, 100.00));
    //     return arr;
    // }

    public MainDisplay() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        bookType.add("Type 1");
        bookType.add("Type 2");
        bookType.add("Type 3");
        bookType.add("Type 4");
        bookType.add("Type 5");
        bookType.add("Type 6");
        bookList = new ArrayList<Book>();

        //Initializing
        typePanel = new JPanel();
        typePanel.setLayout(new GridLayout(6, 1));
        bookArea = new JPanel(new BorderLayout());
        bookDisplayArea = new JPanel(new GridLayout(3, 3));
        directButtonArea = new JPanel(new FlowLayout());
        cover = new JLabel(new ImageIcon(ImageUtils.getImage("cover.jpg", 600, 100)));
        next = new JButton("Next");
        back = new JButton("Back");
        // bookDisplayArea.add(new BookShell(bookList.get(0)));

        //adding event
        bookShellList = new ArrayList<BookShell>();
        for (Book book : bookList){
            bookShellList.add(new BookShell(book));
        }
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookDisplayArea.removeAll();
                for (int i = lastIndex; i<Math.min(bookShellList.size(), lastIndex + 9); i++){
                    bookDisplayArea.add(bookShellList.get(i));
                }
                if (lastIndex + 9 < bookList.size()){
                    lastIndex += 9;
                }
                bookDisplayArea.updateUI();
            } 
        });

        back.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                bookDisplayArea.removeAll();
                int startId = Math.max(0, lastIndex - 9);
                int endId = lastIndex;
                for (int i = startId; i<endId; i++){
                    bookDisplayArea.add(bookShellList.get(i));
                }
                if (lastIndex - 9 >= 8){
                    lastIndex -= 9;
                }
                bookDisplayArea.updateUI();
			}
        });


        //adding components
        bookArea.add(bookDisplayArea, BorderLayout.CENTER);

        this.add(typePanel, BorderLayout.WEST);
        this.add(bookArea, BorderLayout.CENTER);
        this.add(cover, BorderLayout.PAGE_START);
        
        bookArea.add(directButtonArea, BorderLayout.PAGE_END);
        directButtonArea.add(back);
        directButtonArea.add(next);

        for (String type : bookType){
            JButton button = new JButton(type);
            button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton)e.getSource();
                    bookList = genBookList(b.getText());
                    bookShellList.clear();
                    for (Book book : bookList){
                        bookShellList.add(new BookShell(book));
                    }
                    bookDisplayArea.removeAll();
                    for (int i = 0; i<Math.min(bookShellList.size(), 9); i++){
                        bookDisplayArea.add(bookShellList.get(i));
                    }
                    lastIndex = Math.min(bookShellList.size(), 9);
                    bookDisplayArea.updateUI();
                }
            });
            typePanel.add(button);
        }

    }
}