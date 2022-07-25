package FamilyMatriMony;

import java.util.*;
/*
John, Male, Brad, Lisa
Emma, Female, Brad, Lisa
Alex, Male, John, Jenny
Emily, Female, Steve, Emma
Rachel, Female, Steve, Emma

 */
public class MatriMony {
    static int id=1;
   static Map<String , ArrayList<String>> dadAcces =new HashMap<>();
    static Map<String , ArrayList<String>> momAcces=new HashMap<>();
   static Map<String,ArrayList<String>>siblings=new HashMap<>();
   static Map<String,Boolean>maleIdentifer=new HashMap<>();
static Scanner sc=new Scanner(System.in);
 static    List<Person> allMembers =new ArrayList<>();
    public static void main(String[] args) {
        addMembers();
        addFamily();
        addSiblings();
        System.out.println("welcome");
         while (true){
             System.out.println("1)add family members \n 2)search allience 3)exit");
             int opt=sc.nextInt();
             switch (opt){
                 case 1:
                 {
                     addMoreMembers();
                     System.out.println("sucess added your family matrimony" );

                 }
                     break;
                 case 2:
                 {
                                allience();

                 }break;
                 case 3:
                 {
                     System.out.println("have a great day");
                     return;
                 }

             }
         }
    }

    private static void allience() {
        System.out.println("enter name");
        String name=sc.next();
        Person p=null;
        for (Person pp:allMembers){
            if (pp.name.equals(name)){
                p=pp;
            }
        }
        if(p!=null){
            String fatherName=p.fatherName;
            String motherName=p.motherName;
            boolean isMale= p.gender.equals("male");

            ArrayList<String> fatherSiblings=siblings.get(fatherName);
            ArrayList<String>motherSiblings=siblings.get(motherName);
            ArrayList<ArrayList<String>> fatherAllience=new ArrayList<>();
            ArrayList<ArrayList<String>> motherAllience=new ArrayList<>();
            if(fatherSiblings!=null) {


                for (String a : fatherSiblings) {
                    if (dadAcces.containsKey(a)) {
                        fatherAllience.add(dadAcces.get(a));
                    }else if(momAcces.containsKey(a)){
                        motherAllience.add(momAcces.get(a));
                    }
                }
            }
            if (motherSiblings!=null) {
                for (String a : motherSiblings) {
               if(dadAcces.containsKey(a)) {
                   fatherAllience.add( dadAcces.get(a));
               }else if(momAcces.containsKey(a)){
                   motherAllience.add(momAcces.get(a));
               }
                }
            }

          ArrayList<ArrayList<String>>ans=new ArrayList<>();
            ArrayList<String>res=new ArrayList<>();
            for (ArrayList<String> a:fatherAllience){
                        ans.add(a);
                }

            for (ArrayList<String>  a:motherAllience){
                        ans.add(a);

            }
            for (ArrayList<String> s:ans){
                for (String s1:s){
                    if (isMale){
                        if (!maleIdentifer.get(s1)){
                        res.add(s1);
                        }
                    }else{
                        if (maleIdentifer.get(s1)){
                            res.add(s1);
                        }
                    }
                }
            }
            if (res.size()==0){
                System.out.println("sorry no matches");
            }else
            System.out.println(res);
        }else{
            System.out.println("enter  valid family  member name");
            return;
        }
    }

    private static void addMoreMembers() {
        System.out.println("enter name");
        String  name=sc.next();
        System.out.println("enter gender");
        String  gender=sc.next();
        System.out.println("enter father name");
        String  fatherName=sc.next();
        System.out.println("enter mother name");
        String  motherName=sc.next();
      Person p=new Person(name,gender,fatherName,motherName);
      allMembers.add(p);
      if (p.gender.equals("male")){
          maleIdentifer.put(p.name,true);
      }else{
          maleIdentifer.put(p.name,false);
      }
          if (dadAcces.containsKey(p.fatherName)){
              dadAcces.get(p.fatherName).add(p.name);
          }else{
              dadAcces.put(p.fatherName,new ArrayList<>());
              dadAcces.get(p.fatherName).add(p.name);
          }
          if (momAcces.containsKey(p.motherName)){
              momAcces.get(p.motherName).add(p.name);
          }else{

              momAcces.put(p.motherName,new ArrayList<>());
              momAcces.get(p.motherName).add(p.name);
          }



        for (int i = 0; i <allMembers.size()-1 ; i++) {
            if (p.fatherName.equals(allMembers.get(i).fatherName)){
                siblings.get(allMembers.get(i).name).add(p.name);
            }
        }
        siblings.put(p.name,new ArrayList<>());
        for (int i = 0; i <allMembers.size()-1 ; i++) {
            if (p.fatherName.equals(allMembers.get(i).fatherName)){
                siblings.get(p.name).add(allMembers.get(i).name);
            }
        }
    }

    static   void addMembers(){
        Person p1=new Person("john","male","brad","lisa");
        Person p2=new Person("emma","female","brad","lisa");
        Person p3=new Person("alex","male","john","jenny");
        Person p6=new Person("gokul","male","john","jenny");
        Person p4=new Person("emily","female","steve","emma");
        Person p5=new Person("rachel","female","steve","emma");

        allMembers.add(p1); allMembers.add(p2); allMembers.add(p3); allMembers.add(p4); allMembers.add(p5);
        allMembers.add(p6);
          for (Person aa:allMembers){
              if(aa.gender.equals("male")){
                  maleIdentifer.put(aa.name,true);
              }else{
                  maleIdentifer.put(aa.name,false);
              }

          }
    }
    static void addSiblings(){
        for (int i = 0; i <allMembers.size() ; i++) {
            siblings.put(allMembers.get(i).name,new ArrayList<>());
            for (int j = 0; j <allMembers.size() ; j++) {
                if (i!=j){
                    if (allMembers.get(i).fatherName.equals(allMembers.get(j).fatherName)){
                        siblings.get(allMembers.get(i).name).add(allMembers.get(j).name);
                    }
                }
            }
        }

    }
   static void addFamily(){
        for (Person p: allMembers){
            dadAcces.put(p.fatherName,new ArrayList<>());
        }
       for (Person p: allMembers){
           momAcces.put(p.motherName,new ArrayList<>());
       }
        for(Person p: allMembers){
            dadAcces.get(p.fatherName).add(p.name);
        }
       for (Person p: allMembers){
           momAcces.get(p.motherName).add(p.name);
       }
   //    for (ArrayList a:momAcces.values())
    //       System.out.println(a);
    //   for (ArrayList a:dadAcces.values())
     //      System.out.println(a);

    }
}
