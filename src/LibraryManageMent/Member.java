package LibraryManageMent;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public  class Member{
    int id;
    String Name;
    int RemainingBooks;

    public Member(int id, String name, int remainingBooks, Map<Integer, Integer> booksTakenAndTimeRemaining) {
        this.id = id;
        Name = name;
        RemainingBooks = remainingBooks;
        BooksTakenAndTimeRemaining = booksTakenAndTimeRemaining;
    }

    Map<Integer,Integer> BooksTakenAndTimeRemaining=new HashMap<>();

}