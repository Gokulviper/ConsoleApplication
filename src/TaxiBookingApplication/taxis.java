package TaxiBookingApplication;

import java.util.ArrayList;
import java.util.List;

public class taxis {
    int thisRideEarnings;
    int taxiID;
    int current_time;
    int nextFreeTime;
    char currentPoint;
    char nextFreePoint;
    boolean booked;
    boolean active;
    int earnings;
    List<String>tripDetails=new ArrayList<>();
    taxis( int taxiID,

            int current_time,
            int nextFreeTime,
            char currentPoint,
            char nextFreePoint,
            boolean booked,
            boolean active,String s,int earnings,   int  thisRideEarnings,List<String>tripdetails ){
        this.taxiID=taxiID;
        this.current_time=current_time;
        this.nextFreePoint=nextFreePoint;
        this.nextFreeTime=nextFreeTime;
        this.currentPoint=currentPoint;
        this.booked=booked;
        this.active=active;

        this.earnings=earnings;
        this.thisRideEarnings=thisRideEarnings;
        this.tripDetails=tripdetails;

    }

    }

