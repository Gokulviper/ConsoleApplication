package LibraryManageMent;

public class Book {
    int id;
    int rackNo;
    String title;
    String author;
    String subject;
    String category;
    int copies;
    boolean available;

    public Book(int id,int rackNo,String title, String author, String subject, String category,int copies,boolean available) {
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.category = category;
        this.id=id;
        this.rackNo=rackNo;
        this.copies=copies;
        this.available=available;
    }
}

