package EmpMangeMentSystem;

public class Employee {
    String name;
    int id;
    String Designation;
    int experience;
    int age;
    Employee(String name,int id,
            String designation,
            int experience,
            int age){
        this.name=name;
        this.Designation=designation;
        this.experience=experience;
        this.age=age;
        this.id=id;
    }
}