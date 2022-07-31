package FoofDeliverySystem;

import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;

public class DeliveryBoy {
    int id;
    char currentLocation;
    boolean hisFree;
    char nextLocation;
    int earnings;
    List<String> details=new ArrayList<>();
     int tripss;

    public DeliveryBoy() {

    }

    int cancelTrips;

    public DeliveryBoy(int id, char currentLocation, boolean hisFree, char nextLocation, int earnings, List<String> detailsint, int tripss, int cancelTrips) {
        this.id = id;
        this.currentLocation = currentLocation;
        this.hisFree = hisFree;
        this.nextLocation = nextLocation;
        this.earnings = earnings;
        this.details = details;
        this.tripss = tripss;
        this.cancelTrips = cancelTrips;
    }
}
