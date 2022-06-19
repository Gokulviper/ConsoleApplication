package TrainTicketReservation;

public class Passenger {
     int id;
    String name;
    int age;
    char preferdBirth;
    char givenBerth;
    String details;
    Passenger(int id,
            String name,
            int age,
            char preferdBirth,
            String details, char givenBerth){
        this.id=id;
        this.name=name;
        this.age=age;
        this.preferdBirth=preferdBirth;
        this.details=details;
        this.givenBerth=givenBerth;
    }
}
