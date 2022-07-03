package EmpMangeMentSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSystem {
    static int id=1;
    static List<Employee> employeesList=new ArrayList<>();
    public static void main(String[] args) {
        Employee e1 = new Employee("arun", id++, "sweeper", 4, 34);
        Employee e2 = new Employee("vicky", id++, "watchMan", 4, 38);
        Employee e3 = new Employee("prakash", id++, "tester", 4, 54);
        Employee e4 = new Employee("gokul", id++, "devops ", 4, 22);
        Employee e5 = new Employee("aariyan", id++, "game developer", 4, 34);
        employeesList.add(e1);
        employeesList.add(e2);
        employeesList.add(e3);
        employeesList.add(e4);
        employeesList.add(e5);
        System.out.println("WELCOME TO ZOHO");
        Scanner sc=new Scanner(System.in);
        boolean flag=false;
      while (true){

          System.out.println("1)view employee list\n 2)insert new employee \n3)search a employee\n" +
                  "4)delete the employee\n5)exit");
       int opt=sc.nextInt();
       switch (opt){
           case 1:{
               employeeTable();

           }break;
           case 2:{
               insert();
           }break;
           case 3:{
               search();
           }break;
           case 4:{
               delete();

           }break;
           case 5:{
               flag= true;
           }
           default:

               break;
       }
       if (flag){
           break;
       }
      }
        System.out.println("thank you have a nice day");

    }

    private static void delete() {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter id");
        int id=sc.nextInt();
       boolean flag=false;
        for (Employee e:employeesList){
            if (e.id==id){
                employeesList.remove(e);
                flag=true;
                break;
            }
        }
        if (!flag){
            System.out.println("enter correct id");
        }else{
            System.out.println("remove employee id sucessFully");
        }

    }

    private static void search() {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter id");
        int id=sc.nextInt();
        Employee emp=null;
        for (Employee e:employeesList){
            if (e.id==id){
                emp=e;
                break;
            }
        }
        if (emp==null){
            System.out.print("enter coorect id");
            return;
        }
        System.out.println("employeeName "+emp.name+"\nemployee id  "+emp.id+"\n designation  "+emp.Designation+"\nexperience  "+emp.experience+"\nage "+emp.age);
    }

    private static void insert() {

        Scanner sc=new Scanner(System.in);
        System.out.println("enter emp name");
        String name=sc.next();

        System.out.println("enter emp designation");
        String designation=sc.next();
        System.out.println("enter emp experience");
        int exp=sc.nextInt();
        System.out.println("enter emp age");
        int age=sc.nextInt();
          Employee e=new Employee(name,id++,designation,exp,age);
          employeesList.add(e);
        System.out.println("employee insertion sucessfully");
    }

    static void employeeTable(){
        System.out.println("name    Employee id    designation   experience    age" );
        for (Employee e:employeesList){
            System.out.println(e.name+"   "+e.id+"    "+e.Designation+"   "+e.experience+"    "+e.age);
        }
    }
}
