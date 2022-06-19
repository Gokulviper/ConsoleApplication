package FlightReservationApplication;

import java.util.*;

public class Booking {
   static List<Flight> flights=new ArrayList<>();
   static int id=1;
   static int passengerId=1;
    public static void main(String[] args) {
        createFlights();
        System.out.println("welcome jarvis air service");

        Scanner sc=new Scanner(System.in);
        int n=3;
        while (true){
            System.out.println("1)book ticket\n2)cancel ticket\n3)print flight details\n4)exit");
            int opt=sc.nextByte();
            switch (opt){
                case 1:{
                    book();

                }break;
                case 2:{
                    cancel();

                }break;
                case 3:{
                    printFlightDetails();

                } break;
                case 4:{
                    System.out.println("thanks for choose our service");
                    n=0;
                    break;
                }
                case 5:{
                    System.out.println("please enter valid option");
                    continue;
                }

            }
            if (n==0)return;
        }
    }

    private static void printFlightDetails() {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter flight id");
        int flightId=sc.nextByte();
        Flight f=FindFlight(flightId);
        if(f!=null){
            System.out.println("free seats "+f.balanceSeats+"\n flight totalEarnings "+f.totalEarnings
                    +"travel"+f.from +"to"+f.to+" \n");
            System.out.println(f.passengerDetails);

        }else{
            System.out.println("enter valid flight id");
            return;
        }
    }

    private static void cancel() {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your passenger id");
        int passId=sc.nextInt();
        System.out.println("enter your flight id");
        int flightId=sc.nextByte();
        Flight f=FindFlight(flightId);
        if (f!=null ){

            System.out.println("your cancel request is accepted");
            System.out.println("cancel charge for each ticket is 200");

            int tickets=f.checkTicktes.get(passId);
            int money= f.checkRupees.get(passId);
            f.balanceSeats+=tickets;
            int charge=tickets*200;
            int returnAmount=money-charge;
            System.out.println("your charge is "+charge+"   balance amount "+returnAmount+" return your account");
            f.totalEarnings-=returnAmount;

        }else{
            System.out.println("enter valid flight id or passenger id");
            return;
        }

    }

    private static void book() {
        Scanner sc=new Scanner(System.in);
        System.out.println("airbus id = 1  travel chennai to mumbai");
        System.out.println("king id = 2  travel chennai to banglore");
        System.out.println("air road id = 3  travel chennai to delhi");
        System.out.println("jarvis id = 4  travel chennai to england");
        System.out.println("enter flight id");
        int flightId= sc.nextByte();
        Flight f=  FindFlight(flightId);
        if(f!=null) {
            if (f.balanceSeats > 0) {
                System.out.println("enter how many tickets");
                int tickets = sc.nextInt();
                if (f.balanceSeats>=tickets){
                    int money=calculate(f,tickets);
                    System.out.println("enter your name");
                    String name=sc.next();
                    int passId=passengerId++;
                    String make="passnger name = "+name+"\npassenger id ="+passId+"\n total tickets "+tickets+"\n";
                    f.passengerDetails.add(make);
                    f.thisEarnings=money;
                    f.checkTicktes.put(passId,tickets);
                    f.checkRupees.put(passId,money);
                    f.totalEarnings+=money;
                    f.balanceSeats-=tickets;
                    System.out.println("booking successFully your tickets \ntotal cost"+money);
                    System.out.println("your passenger id"+passId);

                }else {
                    System.out.println("sorry you we dont enough seats the balance sheets in the flights is"+f.balanceSeats);
                }
            } else {
                System.out.println("sorry all tickets are booked");
            }
        }else{
            System.out.println("wrong flight id");
            return;
        }
    }

    private static int calculate(Flight f, int tickets) {
        int money=0;
        while (tickets-->0){
            money+=f.ticketPrice;
            f.ticketPrice+=200;
        }
        return money;
    }

    private static Flight FindFlight(int flightId) {
        Flight ff=null;
        for (Flight f:flights){
            if (f.id==flightId){
                ff=f;
            }
        }
        return ff;
    }

    private static void createFlights() {

  Flight f1=new Flight(id++,50,5000,0,new ArrayList<>(),new HashMap<>(),new HashMap<>(),"chennai","mumbai",new ArrayList<>(),0);
   Flight f2=new Flight(id++,50,5000,0,new ArrayList<>(),new HashMap<>(),new HashMap<>(),"chennai","banglore",new ArrayList<>(),0);
        Flight f3=new Flight(id++,50,5000,0,new ArrayList<>(),new HashMap<>(),new HashMap<>(),"chennai","delhi",new ArrayList<>(),0);

        Flight f4=new Flight(id++,50,5000,0,new ArrayList<>(),new HashMap<>(),new HashMap<>(),"chennai","england",new ArrayList<>(),0);
   flights.add(f1);flights.add(f2);flights.add(f3);flights.add(f4);
    }
}
