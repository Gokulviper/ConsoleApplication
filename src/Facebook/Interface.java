package Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Interface {
    static ArrayList<User> users=new ArrayList<>();
   static Map<String,String>userIdentifier=new HashMap<>();
    static Map<String,User>getUser=new HashMap<>();
 static    Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        addUsersInitial();
        System.out.println("FaceBook");
        Scanner sc=new Scanner(System.in);
        boolean flag=false;
        while (true){
            System.out.println("1)login\n2)new User sign in \n3)forgot PassWord\n4)exit");
            int opt=sc.nextInt();
            switch (opt){
                case 1:
                        System.out.println("enter user name");
                    String  uName = sc.next();
                        System.out.println("enter passWord");
                        String passWord = sc.next();
                        if (!find(uName, passWord)) {
                            System.out.println("invalid username or password");
                            break;

                    }
                  User user=get(uName);
                if (user==null){
                    System.out.println("something went wrong");
                    break;
                }
                boolean bool=false;
                bool=  show(user);
                if (bool)continue;
                else{
                    flag=true;
                }
                break;
                case 2:
                 User u1=   register();
                 if(u1!=null) {
                     show(u1);
                 }
                   break;
                case 3:
                    while (true) {
                        System.out.println("enter your name");
                        String name = sc.next();
                        if (userIdentifier.containsKey(name)) {
                            System.out.println("this is your password" + userIdentifier.get(name));
                            break;
                        } else {
                            System.out.println("enter valid user name");
                            continue;
                        }
                    }
                    break;
                case 4:
                    System.out.println("have a great day");
                   return;
            }
        }
    }

    private static User register() {
        System.out.println("enter your username");
        String name=sc.next();
        if (userIdentifier.containsKey(name)){
            System.out.println("the username is already taken");
            return null;
        }
        System.out.println("enter password");
        String pass=sc.next();
        User u=new User(name,pass,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        users.add(u);
        userIdentifier.put(name,pass);
        getUser.put(name,u);
        System.out.println("resiterd sucessfuuly");
        return u;
    }

    private static boolean show(User user) {
        boolean bool=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("welcome "+user.userName);
        while (true) {
            System.out.println("1)add new Friends\n 2)your friends\n 3)your posts\n4)friend requests\n5)logout\n6)exit");
            int opt = sc.nextInt();
            switch (opt){
                case 1:
                    showAvailUsers(user);
                    break;
                case 2:
                    for (int i = 0; i <user.friends.size() ; i++) {
                        System.out.println(user.friends.get(i).userName);
                        System.out.println("seemMore" + user.friends.get(i).userName + "press 1 press 2 or next");
                        int o = sc.nextInt();
                        if (o == 1) {
                            seeMore(user.friends.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.println("1 for add post 2 for view your old post");
                    int p=sc.nextInt();
                    if (p==1){
                        System.out.println("type here\n");
                        String s=sc.next();
                        user.posts.add(s);
                    }
                    if (user.posts.isEmpty()){
                        System.out.println("no posts");
                        continue;
                    }
                    for (int i = 0; i <user.posts.size() ; i++) {
                        System.out.println(user.posts.get(i));
                    }
                    break;
                case 4:
                    if (user.requests.isEmpty()){
                        System.out.println("no friend requests");
                        continue;
                    }
                    for (int i = 0; i <user.requests.size() ; i++) {
                        System.out.println(user.requests.get(i));
                        System.out.println("accpet 1  reject 2");
                        int o=sc.nextInt();
                        if (o==1){
                            addingFriedns(user,user.requests.get(i));
                        }
                            user.requests.remove(user.requests.get(i));

                    }
                    break;
                case 5:
                    bool=true;
                    return bool;
                case 6:
                    return bool;

            }
        }
    }
    private static void addingFriedns(User user2, User user1) {
        user1.friends.add(user2);
        user2.friends.add(user1);
        System.out.println("you are friends now ");

    }
    private static void seeMore(User user) {
        while (true) {
            System.out.println("1)friends\n2)posts\n3)back");
            int opt = sc.nextInt();
            if (opt == 1) {
                for (int i = 0; i < user.friends.size(); i++) {
                    System.out.println(user.friends.get(i).userName);
                }
            } else if(opt==2) {
                if (user.posts.isEmpty()){
                    System.out.println("no posts");
                    continue;
                }
                for (int i = 0; i <user.posts.size() ; i++) {
                    System.out.println(user.posts.get(i));
                }
            }else{
                return;
            }
        }
    }

    private static void showAvailUsers(User user) {
        int i=1;
        for(User u:users){
            if(!contains(u,user)){
                System.out.println(u.userName+"press 1 to request " +
                        "\n press 2 to next");
                int opt=sc.nextInt();
                if (opt==1){
                    u.requests.add(user);
                }
            }
        }
    }

    private static boolean contains(User u, User user) {
        for (int i = 0; i <user.friends.size() ; i++) {
            if (user.friends.get(i)==u){
                return true;
            }
        }
        return false;
    }

    private static User get(String uName) {
        User u=null;
        for(Map.Entry<String,User> user:getUser.entrySet()){
            if (user.getKey().equals(uName)){
                u=user.getValue();
            }
        }
        return u;
    }

    private static boolean find(String uName, String passWord) {
       boolean flag=false;
        for (Map.Entry<String,String> user:userIdentifier.entrySet()){
           if (user.getKey().equals(uName)){
               if (user.getValue().equals(passWord)){
                  flag=true;
               }
           }
        }
        return flag;
    }

    private static void addUsersInitial() {
        User u1=new User("gokul","1234",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User u2=new User("arun","dfgd",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User u3=new User("vivky","1212323",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User u5=new User("dikki","98776",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User u4=new User("praksh","3454",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        users.add(u1);   users.add(u2);   users.add(u3);   users.add(u4);   users.add(u5);
        userIdentifier.put(u1.userName,u1.passWord);userIdentifier.put(u2.userName,u2.passWord);
        userIdentifier.put(u3.userName,u3.passWord);userIdentifier.put(u4.userName,u4.passWord);
        userIdentifier.put(u5.userName,u5.passWord);
        getUser.put(u1.userName,u1);getUser.put(u2.userName,u2);getUser.put(u3.userName,u3);
        getUser.put(u4.userName,u4);getUser.put(u5.userName,u5);
    }
}
