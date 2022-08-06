package FoofDeliverySystem;

import TaxiBookingApplication.Index;

import javax.swing.text.DefaultEditorKit;
import java.util.*;
import java.util.List;
import java.util.Scanner;



public class MainInterFace {
    static int id=1;
    static Scanner sc=new Scanner(System.in);
    static List<DeliveryBoy>allWorkers=new ArrayList<>();
    static Map<Integer,Integer>foodCost=new HashMap<>();
    static Map<Integer,Integer>orderIdMaintained=new HashMap<>();
    public static void main(String[] args) {

        addworkers();
        addFoodCosts();
        System.out.println("welcome gokul food delivery");
        while (true){
            System.out.println("1)Order food \n2)Cancel your order\n 3)worker information \n4)exit");
            int opt=sc.nextInt();
            switch (opt){
                case 1:
                {
                    order();
                }break;
                case 2:
                {
                            cancel();
                }break;
                case 3:
                {
                    detailsss();
                }break;
                case 4:{
                    System.out.println("thanks for choosing our service");
                    return;
                }
            }

        }
    }
    private static void detailsss() {
        System.out.println("enter worker id");
        int id=sc.nextInt();
        DeliveryBoy d=null;
        for (DeliveryBoy dd:allWorkers)if (id==dd.id)d=dd;
        System.out.println("curret Location of Worker - "+d.currentLocation);
        System.out.println("Worker total deliveries - "+d.tripss);
        System.out.println("Worker total cancel deliveries - "+d.cancelTrips);
        System.out.println("Worker total earnings - "+d.earnings);
        System.out.println("Worker trip details  - "+d.details);
    }

    private static void cancel() {
        System.out.println("enter your booking id");
        int id=sc.nextInt();
        DeliveryBoy d=null;
        for (DeliveryBoy dd:allWorkers)if (id==dd.id)d=dd;
        int dedcost=orderIdMaintained.get(d.id)-50;
        d.earnings-=dedcost;
        d.cancelTrips+=1;
        System.out.println("the cancel charge for 50 rupeees balance amount "+dedcost+" is returned your account" +
                "\n thanks for choosing our service");
       d.hisFree=true;
    }

    private static void order() {
        System.out.println("1 for order Dosai -30\n2 for order idly -30 \n 3 - for order poori \n4 - for order biriyani -100" +
                "\n 5 - for meels -80");
        int opt=sc.nextInt();
        if (opt>=1&&opt<=5) {
            System.out.println("enter quantity");
            int qty = sc.nextInt();
            System.out.println("enter your location");
            char loc = sc.next().charAt(0);
            if (loc >= 'A' && loc <= 'E') {
                DeliveryBoy d = getNeryBuyDriver(loc);
                if (d != null) {
                    d.earnings += foodCost.get(opt) * qty;
                    d.hisFree = false;
                    d.nextLocation = loc;
                    d.tripss+=1;
                    String trip = "ride from " + d.currentLocation + " to " + loc + " this ride earings" + foodCost.get(opt) * qty;
                    d.details.add(trip);
                    orderIdMaintained.put(d.id, foodCost.get(opt) * qty);
                    System.out.println("your order sucessfully placed your order id is -"+ d.id +"" +
                            "  please remember this id if you want to cancel order enter that id");
                } else {
                    return;
                }
            } else {
                System.out.println("soory our service not for your locaion may be we cover your location too" +
                        "thanks for choosing our service ");
                return;
            }
        }else{
            System.out.println("enter correct food value");
        }
    }

    private static DeliveryBoy getNeryBuyDriver(char location) {
        DeliveryBoy d=null;
        List<DeliveryBoy>current=new ArrayList<>(allWorkers);
        current.removeIf(d1 -> !d1.hisFree);
        int min=Integer.MAX_VALUE;
        for (DeliveryBoy c:current){
            int dis=Math.abs(location-c.currentLocation);
            min=Math.min(min,dis);
        }
        for (DeliveryBoy c:current){
            int dis=Math.abs(location-c.currentLocation);
         if (dis!=min)current.remove(c);
        }
        if (current.size()>1){
            Collections.sort(current,(a,b)->a.earnings-b.earnings);
        }
        if (current.size()==0){
            System.out.println("so all workers are busy please try later");
            return null;
        }
        d=current.get(0);
        return d;
    }

    private static void addFoodCosts() {
        foodCost.put(1,30);//dosai
        foodCost.put(2,30);//idly
        foodCost.put(3,50);//poori
        foodCost.put(4,100);//biriyani
        foodCost.put(5,80);//meels

    }

    private static void addworkers() {
        DeliveryBoy d1=new DeliveryBoy(id++,'A',true,'0',0,new ArrayList<>(),0,0);
        DeliveryBoy d2=new DeliveryBoy(id++,'A',true,'0',0,new ArrayList<>(),0,0);
        DeliveryBoy d3=new DeliveryBoy(id++,'A',true,'0',0,new ArrayList<>(),0,0);
        DeliveryBoy d4=new DeliveryBoy(id++,'A',true,'0',0,new ArrayList<>(),0,0);
        DeliveryBoy d5=new DeliveryBoy(id++,'A',true,'0',0,new ArrayList<>(),0,0);
        DeliveryBoy d6=new DeliveryBoy(id++,'A',true,'0',0,new ArrayList<>(),0,0);
        allWorkers.add(d1);allWorkers.add(d2);allWorkers.add(d3);allWorkers.add(d4);allWorkers.add(d5);allWorkers.add(d6);
    }
}
