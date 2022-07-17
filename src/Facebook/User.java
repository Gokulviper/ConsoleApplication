package Facebook;

import java.util.*;

public class User {
    String userName;
    String passWord;
    ArrayList<User> friends;
    ArrayList<String> posts;
    ArrayList<User>requests;
     User(String userName, String passWord,
             ArrayList<User> friends,
             ArrayList<String> posts, ArrayList<User>requests){
         this.userName=userName;
         this.passWord=passWord;
         this.friends=friends;
         this.posts=posts;
         this.requests=requests;
     }
}
