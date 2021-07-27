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
import java.awt.print.Book;
import java.io.IOException;
import java.util.*;
public class Booking {
    private int time, driverno, numOfDrivers;
    private String location1, location2, carType, bookingID;
    private String loc[] = { "Liverpool", "Manchester", "Cambridge", "Oxford", "Brighton"};
    public Driver[] drivers;

    public Booking(String filename){            //gets array of drivers from DriverLibrary.java
        DriverLibrary d1 = new DriverLibrary(filename);
        numOfDrivers = d1.getnumOfDrivers();
        drivers = Arrays.copyOfRange(d1.getDrivers(), 0, 25);
    }
    
    public int getDriverNo(){                   //gets index of driver assigned
        return this.driverno;
    }

    public double getDistance(){                //gets distance travelled from pickup to dropoff
        return Math.abs(Arrays.asList(loc).indexOf(location1) - Arrays.asList(loc).indexOf(location2))*10;
    }

    public void setLocation(){                  //calls setLoc() to change driver location after ride
        drivers[driverno].setLoc(location2);
    }

    private void setBookingID(){                //generates unique Booking ID each ride
        bookingID = UUID.randomUUID().toString();
    }

    public boolean isDriver(String location1){      //checks if driver is available at
        int i;                                      //given location with given carType

        for(i =0; i< numOfDrivers; i++){
            if(drivers[i].getLocation() == location1 && 
                    drivers[i].getCarType() == carType)  
            {
                driverno = i;
                break;
            }
        if(i == drivers.length){
            System.out.println("Driver unavailable, please try again later.");
            return false;
        }}
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
        location1 = in.next();
        System.out.println("Enter drop-off location from the following: ");
        System.out.println("*-Liverpool\n *-Manchester\n *-Cambridge\n *-Oxford\n *-Brighton\n");
        location2 = in.next();
        System.out.println("Enter type of car: ");
        carType = in.nextLine();
        isDriver(location1);
        if(isDriver(location1))
        {
            setBookingID();
            showBooking();
            setLocation();
        }
        in.close();
        return true;
    }
   

    public void showBooking(){                  //displays booking details
        System.out.println("\t\tBooking Details: ");
        System.out.println("**********************************");
        System.out.println("Booking ID: " + bookingID);
        System.out.println("Driver Name: " + drivers[driverno].getName());
        System.out.println("Driver Contact: " + drivers[driverno].getNumber());
        System.out.println("Time of pickup: " + time);
        System.out.println("Distance: " + getDistance());
    }

    public static void main(String[] args) {
        Booking b1 = new Booking("Driver.csv");
        b1.makeBooking();


    }


}

