package TaxiBookingApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Scanner;

public class Index {
    static List<taxis>Taxis=new ArrayList<>();
    public static void main(String[] args) {
        taxis t1 = new taxis(1, 6, 6, 'A', 'A', false, true, "",0,0,new ArrayList<>());
        taxis t2 = new taxis(2, 6, 6, 'A', 'A', false, true, "",0,0,new ArrayList<>());
        taxis t3 = new taxis(3, 6, 6, 'A', 'A', false, true, "",0,0,new ArrayList<>());
        taxis t4 = new taxis(4, 6, 6, 'A', 'A', false, true, "",0,0,new ArrayList<>());
        Taxis.add(t1);
        Taxis.add(t2);
        Taxis.add(t3);
        Taxis.add(t4);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("welcome to txi service\n 1 book \n 2 cancel booking \n 3 trip details \n exit");
          byte opt=sc.nextByte();
          if (opt==1){

              System.out.println("enter pick up point");
              char pickPoint=sc.next().charAt(0);
              System.out.println("enter drop  point");
              char dropPoint=sc.next().charAt(0);
              System.out.println("enter pick up time");
              int pickTime=sc.nextInt();
              taxis Taxi=getFreeTaxis(pickPoint,dropPoint,pickTime);
              if (Taxi==null){
                  System.out.println("no taxis Are Available");
                  break;
              }
              bookTaxi(Taxi,pickPoint,dropPoint,pickTime);
              System.out.println("booking sucessfully taxi id is "+Taxi.taxiID);

          }else  if (opt==2){
              System.out.println("enter taxi id");
              int id= sc.nextInt();
              taxis taxi=null;
              for (taxis t:Taxis){
                  if (id==t.taxiID){
                      taxi=t;
                  }
              }
              taxi.booked=true;
              System.out.println("cancelling fees is half of your amount we debited ");
              int debit=taxi.thisRideEarnings/2;
              taxi.earnings-=debit;

          }else if (opt==3){
              System.out.println("enter taxi id");
              int id= sc.nextInt();
              taxis taxi=null;
              for (taxis t:Taxis){
                  if (id==t.taxiID){
                      taxi=t;
                  }
              }
              System.out.println(taxi.tripDetails);

          }else if (opt==4){
              System.out.println("thanks for visit our service");
              break;
          }else{
              System.out.println("please enter correct option");
              continue;
          }

        }
    }

    private static void bookTaxi(taxis taxi, char pickPoint, char dropPoint, int pickTime) {
        taxi.booked=true;
        int reacTime=Math.abs((dropPoint-'0')-(pickPoint-'0'));
        int amount=reacTime*100;
        taxi.earnings+=amount;
        taxi.nextFreeTime=taxi.current_time+reacTime;
        taxi.currentPoint=dropPoint;
        taxi.thisRideEarnings=amount;
        String s="taxi id  "+taxi.taxiID+" "+ taxi.thisRideEarnings+" "+amount+" trip"+pickPoint+"  to  "+dropPoint;
       taxi.tripDetails.add(s);
    }

    private static taxis getFreeTaxis(char pickPoint, char dropPoint, int pickTime) {
        List<taxis>freeTaxis=new ArrayList<>();
        List<taxis>nearBYTaxis=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for (taxis t:Taxis){
            if (!t.booked||(t.booked&&pickTime>t.nextFreeTime)){
                freeTaxis.add(t);
                int reacTime=Math.abs((t.currentPoint-'0')-(pickPoint-'0'));
                min=Math.min(reacTime,min);
            }
        }
        for (taxis t:freeTaxis) {

            int reacTime = Math.abs((t.currentPoint - '0') - (pickPoint - '0'));
            if (reacTime <= pickTime) {
                if (reacTime == min) {
                    nearBYTaxis.add(t);
                }
            }
        }
        if (nearBYTaxis.size()>1){
            Collections.sort(nearBYTaxis,(a,b)-> a.earnings- b.earnings);
        }

         return nearBYTaxis.get(0);

    }
}
