//Methods:
//        Void - makeBooking()
//        Double getDistance()
//        Int getTime() --??
//        Void setLocation()
//        Boolean isDriver() - random func if time > 01:30 am
//        void showBooking
//
//        Variables:
//        Int time , bookingId
//        string location, loc[], String type of car,
import java.util.*;
public class Booking {
    private int time, driverno;
    private String location1, location2, carType, bookingID;
    private String loc[] = { "Liverpool", "Manchester", "Cambridge", "Oxford", "Brighton"};
    Driver[] drivers;

    public void getDrivers(Driver[] drivers){
        this.drivers = drivers;
    }

    public double getDistance(){
        return Math.abs(Arrays.asList(loc).indexOf(location1) - Arrays.asList(loc).indexOf(location2))*10;
    }

    public void setLocation(){
        drivers[driverno].setLoc(location2);
    }
    
    private void setBookingID(){
        bookingID = UUID.randomUUID().toString();
    }

    public boolean isDriver(){
        int i;
        for(i =0; i< drivers.length; i++)
            if(drivers[i].getLocation()==location1 && //checks if driver is available at
                    drivers[i].getCarType() == carType)  //given location with given carType
            {
                driverno = i;
                break;
            }
        if(i == drivers.length){
            System.out.println("Driver unavailable, please try again later.");
            return false;
        }
        if(time >= 130 && time <= 430){         //randomly assigns no driver due to low
                                                //availability at early hours
            if(Math.random()>=0.75)
                return false;
        }
        System.out.println("Booking successful!");
        return true;
    }


    public boolean makeBooking(){       //gets booking details, calls isDriver(), showBooking(), setLoc()
        System.out.println("Enter time of travel: ");
        Scanner in = new Scanner(System.in);
        time = in.nextInt();
        System.out.println("Enter pickup location from the following: ");
        System.out.println("*-Liverpool\n *-Manchester\n *-Cambridge\n *-Oxford\n *-Brighton\n");
        location1 = in.nextLine();
        System.out.println("Enter drop-off location from the following: ");
        System.out.println("*-Liverpool\n *-Manchester\n *-Cambridge\n *-Oxford\n *-Brighton\n");
        location2 = in.nextLine();
        System.out.println("Enter type of car: ");
        carType = in.nextLine();
        int i;
        isDriver();
        if(isDriver())
        {
            showBooking();
            setLocation();
        }
        in.close();
        return true;
    }

    public void showBooking(){
        System.out.println("\t\tBooking Details: ");
        System.out.println("**********************************");
        System.out.println("Booking ID: " + bookingID);
        System.out.println("Driver Name: " + drivers[driverno].getName());
        System.out.println("Driver Contact: " + drivers[driverno].getNumber());
        System.out.println("Time of pickup: " + time);
        System.out.println("Distance: " + getDistance());
    }
}