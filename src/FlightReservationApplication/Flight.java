package FlightReservationApplication;

import java.util.*;
class Node2{
    int tickets;
    int money;
    Node2( int tickets,
          int money){
        this.tickets=tickets;
        this.money=money;

    }
}
class Node{
    int flightId;
    int passengerId;
    Node( int flightId,
            int passengerId){
        this.flightId=flightId;
        this.passengerId=passengerId;
    }
}
public class Flight {
    int id;
    int balanceSeats;
    int ticketPrice;
    int thisEarnings;
    ArrayList<String> details=new ArrayList<>();
    Map<Integer,Integer> checkRupees=new HashMap<>();
    Map<Integer,Integer> checkTicktes=new HashMap<>();
    String from;
    String to;
    List<String> passengerDetails=new ArrayList<>();
    int totalEarnings;

    Flight(  int id,
            int balanceSeats,
            int ticketPrice,
            int thisEarnings, ArrayList<String> details,  Map<Integer,Integer> checkRupees,
             Map<Integer,Integer> checkTicktes, String from,
                     String to,List<String>passengerDetails,int totalEarnings){
        this.id=id;
        this.balanceSeats=balanceSeats;
        this.ticketPrice=ticketPrice;
        this.thisEarnings=thisEarnings;
        this.details=details;
        this.checkRupees=checkRupees;
        this.from=from;
        this.to=to;
        this.passengerDetails=passengerDetails;
        this.totalEarnings=totalEarnings;
        this.checkTicktes=checkTicktes;
    }
}
