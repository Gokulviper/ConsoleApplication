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
   static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        addMembers();
        addBooks();
        while (true){
            System.out.println("1)member login\n 2)library manager\n");
            int opt=sc.nextInt();
            switch (opt){
                case 1:
                {
                    System.out.println("1)sign in\n 2)new member sign up");
                    int option=sc.nextInt();
                    if(option==1){
                        System.out.println("enter your member id");
                        int id=sc.nextInt();
                        if (memberIdentifier.containsKey(id)){
                            System.out.println("welcome "+memberIdentifier.get(id).Name+"\n " );
                            Member m=memberIdentifier.get(id);
                            System.out.println("1)take book \n2)return book");
                            int o=sc.nextInt();
                            if (o==1){
                                if(m.RemainingBooks<=0) System.out.println("soory you reached the limit 5 please return some books ");
                                else{
                                    for(Book b:Books){
                         System.out.println("book id"+b.id+" book author "+b.author+"  book copies-"+b.copies+"  book available or not"+b.available+"  book category "+b.category+" book rackNo "+b.rackNo);
                                    }
                                    System.out.println("enter book id");
                                    int bookId=sc.nextInt();
                                    if(bookIdentifier.containsKey(bookId)){
                                       Book bb=bookIdentifier.get(bookId);
                                       if (bb.available&&bb.copies>=1){
                                           bb.copies--;
                                           if (bb.copies==0)bb.available=false;
                                           m.BooksTakenAndTimeRemaining.put(bookId,12);
                                           System.out.println("book taked sucessfully please return in 15 days otherwise fine for" +
                                                   "5 rupess per day");
                                       }else{
                                           System.out.println("currently the book is not available ");
                                       }
                                    }else{
                                        System.out.println("enter valid book id");
                                    }
                                }
                            }else if(o==2){
                                System.out.println("enter your member id");
                                int memberId=sc.nextInt();
                                System.out.println("enter book id");
                                int bookId=sc.nextInt();
                                  if (bookIdentifier.containsKey(bookId)){
                                      Book b=bookIdentifier.get(bookId);
                                      b.copies++;
                                      b.available=true;
                                      Member mm=memberIdentifier.get(memberId);
                                      mm.BooksTakenAndTimeRemaining.remove(bookId);
                                      System.out.println("thank you");

                                  }else{
                                      System.out.println("enter valid book id");
                                  }

                            }else{
                                System.out.println("enter 1 or 2");
                            }
                        }else{
                            System.out.println("sorry the id is not registered please create your account");
                        }
                    }else if(option==2){
                        System.out.println("welcome to our libarary");
                        addMember();
                    }else{
                        System.out.println("enter valid option");
                    }
                }break;
                case 2:{
                    System.out.println("1)view members 2)view books");
                    int o=sc.nextInt();
                    if (o==1){
                        for (Member m:memberIdentifier.values()){
                            System.out.println("member id"+m.id+" member name "+m.Name);
                            System.out.println("books taked");
                            for (int mmm:m.BooksTakenAndTimeRemaining.keySet()){
                                System.out.println(bookIdentifier.get(mmm).title);
                            }


                        }
                    }else{

                    }
                }break;
            }
        }
    }

    private static void addMember() {
        System.out.println("enter your name");
        String name=sc.next();Member m=new Member(memberId++,name,5,new HashMap<>());
        System.out.println(m.id + "this your new id");
        memberIdentifier.put(m.id,m);
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
    bookIdentifier.put(b1.id,b1); bookIdentifier.put(b2.id, b2); bookIdentifier.put(b3.id, b3); bookIdentifier.put(b4.id,b4);
        bookIdentifier.put(b5.id,b5); bookIdentifier.put(b6.id,b6); bookIdentifier.put(b7.id,b7); bookIdentifier.put(b8.id,b8);
    }

    private static void addMembers() {
        Member m1=new Member(memberId++,"Ram",5,new HashMap<>());
        Member m2=new Member(memberId++,"gokul",5,new HashMap<>());
        Member m3=new Member(memberId++,"ajay",5,new HashMap<>());
        Member m4=new Member(memberId++,"vicky",5,new HashMap<>());
        Member m5=new Member(memberId++,"arul",5,new HashMap<>());
        memberIdentifier.put(m1.id,m1); memberIdentifier.put(m2.id, m2); memberIdentifier.put(m3.id,m3);
        memberIdentifier.put(m4.id,m4); memberIdentifier.put(m5.id,m5);
    }
}
