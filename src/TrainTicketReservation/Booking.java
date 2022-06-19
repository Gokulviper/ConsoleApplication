package TrainTicketReservation;

import javax.sound.midi.MidiFileFormat;
import java.awt.desktop.QuitResponse;
import java.util.*;
import java.util.Scanner;

public class Booking {
    static int pId=1;
    static List<Integer>LowerBirth=new ArrayList<>();
    static List<Integer>UpperBirth=new ArrayList<>();
    static List<Integer>MiddleBirth=new ArrayList<>();
    static List<Integer>RAC=new ArrayList<>();
    static List<Integer> Waiting =new ArrayList<>();
    static Queue<Integer>RacList=new LinkedList<>();
    static Queue<Integer>WaitingList=new LinkedList<>();
    static Map<Integer,Passenger>passengerDetails=new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fillTickets(1, 1, 1, 1, 1);
        while (true) {
            System.out.println("1)booking\n2)cancel\n3)showing passengerList\n4)freeTickets\n5)exit");
            int opt = sc.nextInt();
            switch (opt) {
                case 1: {
                    System.out.println("enter passenger name");
                    String name = sc.next();
                    System.out.println("enter age");
                    int age = sc.nextInt();
                    System.out.println("enter your preffered birth  (L,U,M)");
                    char berth = sc.next().charAt(0);
                    if (berth == 'L' || berth == 'U' || berth == 'M') {
                        boolean free = checkFreeTicktes();
                        if (!free) {
                            System.out.println("sorry no tickets available");
                            return;
                        }
                        bookTicket(name, age, berth);


                    } else {
                        System.out.println("please enter valid birth");
                        break;
                    }
                }
                break;
                case 2: {
                    System.out.println("enter your id");
                    int id = sc.nextInt();

                    boolean isChane=false,isRac=false;
                  if (passengerDetails.containsKey(id)){
                    Passenger  p=passengerDetails.get(id);
                      if (p.givenBerth=='U'){
                          UpperBirth.add(UpperBirth.size()+1);
                          passengerDetails.remove(id);
                          isChane=true;
                      }else if (p.givenBerth=='M'){
                          MiddleBirth.add(MiddleBirth.size()+1);
                          passengerDetails.remove(id);
                          isChane=true;
                      }else if (p.givenBerth=='L'){
                          LowerBirth.add(LowerBirth.size()+1);
                          passengerDetails.remove(id);
                          isChane=true;
                      }
                      else if (p.givenBerth=='R'){
                          RAC.add(RAC.size()+1);
                          passengerDetails.remove(id);
                          isRac=true;
                      }else{
                          Waiting.add(Waiting.size()+1);
                          passengerDetails.remove(id);
                      }
                      if (RAC.size()>0&&isChane&&!isRac){

                         if( passengerDetails.containsKey(RacList.peek())){
                            Passenger chagePassenger=passengerDetails.get(RacList.poll());
                             char berth=chagePassenger.preferdBirth;
                             if (berth=='M'&&!MiddleBirth.isEmpty()){
                                 chagePassenger.givenBerth='M';
                                 MiddleBirth.remove(0);

                             }else if (berth=='U'&&!UpperBirth.isEmpty()){
                                 chagePassenger.givenBerth='U';
                                 UpperBirth.remove(0);
                             }
                             else if (berth=='L'&&!LowerBirth.isEmpty()){
                                 chagePassenger.givenBerth='L';
                                 LowerBirth.remove(0);
                             }else if (chagePassenger.givenBerth=='W'){
                                 chagePassenger.givenBerth='R';
                                 RAC.remove(0);
                             }
                         }

                      }else if (Waiting.size()>0&&isChane){

                        Passenger  changePassenger=passengerDetails.get(WaitingList.poll());
                          char berth=changePassenger.preferdBirth;
                          if (berth=='M'&&!MiddleBirth.isEmpty()){
                              changePassenger.givenBerth='M';
                              MiddleBirth.remove(0);

                          }else if (berth=='U'&&!UpperBirth.isEmpty()){
                              changePassenger.givenBerth='U';
                              UpperBirth.remove(0);
                          }
                          else if (berth=='L'&&!LowerBirth.isEmpty()){
                              changePassenger.givenBerth='L';
                              LowerBirth.remove(0);
                          }else if (changePassenger.givenBerth=='W'){
                              changePassenger.givenBerth='R';
                              RAC.remove(0);
                          }

                      }
                  }else{
                      System.out.println("enter valid id");
                  }

                }
                break;
                case 3: {
                    int id=pId;
                    for (int i=1;i<=id;i++){
                        if (passengerDetails.containsKey(i)){
                            Passenger p=passengerDetails.get(i);
                            System.out.println(p.details);
                        }
                    }

                }
                break;
                case 4: {
                    System.out.println("free tickets");
                    System.out.println("Middle birth" +MiddleBirth.size());
                    System.out.println("upper birth" +UpperBirth.size());
                    System.out.println("Lower birth" +LowerBirth.size());
                    System.out.println("Rac List" +RAC.size());
                    System.out.println("Waiting list" +Waiting.size());
                }
                break;
                case 5:
                    break;
                default:
                    break;

            }
        }
    }


    private static void bookTicket(String name, int age, char berth) {
        Passenger p=new Passenger(pId++,name,age,berth,"",'C');
        if (berth=='U'&&  UpperBirth.size()>0){
            UpperBirth.remove(0);
            System.out.println("you prefferd berth is available booked sucessFully");
            p.details+="name :"+name+ "\n age :"+age+ "\n berth :"+'U'+"\n id :"+p.id;
            p.givenBerth='U';
            passengerDetails.put(p.id, p);
            System.out.println(p.details);

        }else if (berth=='M'&&  MiddleBirth.size()>0){
            MiddleBirth.remove(0);
            System.out.println("you prefferd berth is available booked sucessFully");
            p.details+="name :"+name+ "\n age :"+age+ "\n berth :"+'M'+"\n id :"+p.id;
            p.givenBerth='M';
            passengerDetails.put(p.id, p);
            System.out.println(p.details);
        }
        else if (berth=='L'&&  LowerBirth.size()>0){
            LowerBirth.remove(0);
            System.out.println("you prefferd berth is available booked sucessFully");
            p.details+="name :"+name+ "\n age :"+age+ "\n berth :"+'L'+"\n id :"+p.id;
            p.givenBerth='L';
            passengerDetails.put(p.id, p);
            System.out.println(p.details);

        }else if (RAC.size()>0){
            RAC.remove(0);
            System.out.println("you prefferd berth is not available RAC booked sucessFully");
            p.details+="name :"+name+ "\n age :"+age+ "\n berth :"+"Rac"+"\n id :"+p.id;
            p.givenBerth='R';
            RacList.add(p.id);
            passengerDetails.put(p.id, p);
            System.out.println(p.details);

        }else{
            Waiting.remove(0);
            System.out.println("you prefferd berth is not available WaitingList booked sucessFully");
            p.details+="name :"+name+ "\n age :"+age+ "\n berth :"+"waitingList"+"\n id :"+p.id;
            p.givenBerth='W';
            WaitingList.add(p.id);
            passengerDetails.put(p.id, p);
            System.out.println(p.details);
        }
    }

    private static void fillTickets(int i, int i1, int i2, int i3, int i4) {
        for (int j = 1; j  <=i; j++) {
            LowerBirth.add(j);
        }
        for (int j = 1; j  <=i1; j++) {
            UpperBirth.add(j);
        }
        for (int j = 1; j  <=i2; j++) {
            MiddleBirth.add(j);
        }
        for (int j = 1; j  <=i3; j++) {
            RAC.add(j);
        }
        for (int j = 1; j  <=i4; j++) {
            Waiting.add(j);
        }
    }

    private static boolean checkFreeTicktes() {
        if (LowerBirth.size()==0&&UpperBirth.size()==0&&MiddleBirth.size()==0&&RAC.size()==0&& Waiting.size()==0){
            return false;
        }
        return true;
    }
}
