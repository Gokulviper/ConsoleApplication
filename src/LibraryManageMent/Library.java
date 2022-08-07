package LibraryManageMent;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class Library {
    static int bookId=1;
    static int memberId =1;
    static List<Member>Members=new ArrayList<>();
    static List<Book>Books=new ArrayList<>();
    static Map<Integer,Book>bookIdentifier=new HashMap<>();
    static Map<Integer,Member>memberIdentifier=new HashMap<>();
    public static void main(String[] args) {
        addMembers();
        addBooks();
    }

    private static void addBooks() {
   Book b1=new Book(bookId++,1,"realWord","hari","Study","study",3,true);
  Book b2=new Book(bookId++,1,"ai","hansen","Study","study",1,true);
 Book b3=new Book(bookId++,1,"cci","raman","Study","study",3,true);
Book b4=new Book(bookId++,1,"acword","vijay","entertainment","entertainment",6,true);
 Book b5=new Book(bookId++,2,"isro","rak","rocket","study",3,true);
    Book b6=new Book(bookId++,4,"realWord","hari","Study","study",3,true);
    Book b7=new Book(bookId++,7,"realWord","hari","Study","study",3,true);
  Book b8=new Book(bookId++,9,"realWord","hari","Study","study",3,true);
    bookIdentifier.put(bookId,b1); bookIdentifier.put(bookId,b2); bookIdentifier.put(bookId,b3); bookIdentifier.put(bookId,b4);
        bookIdentifier.put(bookId,b5); bookIdentifier.put(bookId,b6); bookIdentifier.put(bookId,b7); bookIdentifier.put(bookId,b8);
    }

    private static void addMembers() {
        Member m1=new Member(memberId++,"Ram",5,new HashMap<>());
        Member m2=new Member(memberId++,"gokul",5,new HashMap<>());
        Member m3=new Member(memberId++,"ajay",5,new HashMap<>());
        Member m4=new Member(memberId++,"vicky",5,new HashMap<>());
        Member m5=new Member(memberId++,"arul",5,new HashMap<>());
        memberIdentifier.put(memberId,m1); memberIdentifier.put(memberId,m2); memberIdentifier.put(memberId,m3);
        memberIdentifier.put(memberId,m4); memberIdentifier.put(memberId,m5);
    }
}
