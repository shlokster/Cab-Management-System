//package Cab;

import java.util.*;
public class Booking {
    private int time, driverno, numOfDrivers;
    private String location1, location2, carType, bookingID;
    private String loc[] = { "Liverpool", "Manchester", "Cambridge", "Oxford", "Brighton"};
    public Driver[] drivers;
    DriverLibrary d2;
    private boolean status = false;

    public Booking(String filename, DriverLibrary d1){            //gets array of drivers from DriverLibrary.java
        //DriverLibrary d1 = new DriverLibrary("C:\\Users\\Annant Maheshwari\\eclipse-workspace\\JAVA\\src\\Cab\\Driver.csv");
    	d2 = d1;
    	numOfDrivers = d1.getnumOfDrivers();
        drivers = d1.getDrivers();  
    }  

    public void createBooking(int time, String location1, String location2, String carType){
        this.time = time;
        this.location1 = location1;
        this.location2 = location2;
        this.carType = carType;
    }
    
    public int getDriverNo(){                   //gets index of driver assigned
        return this.driverno;
    }

    public double getDistance(){                //gets distance travelled from pickup to dropoff
        return Math.abs(Arrays.asList(loc).indexOf(location1) - Arrays.asList(loc).indexOf(location2))*10;
    }

    public void setLocation(){                  //calls setLoc() to change driver location after ride
        drivers[driverno].setLoc(location2);
        d2.setLoc(location1, driverno);
    }

    public void setBookingID(){                //generates unique Booking ID each ride
        bookingID = UUID.randomUUID().toString();
    }
    
    
    public boolean isDriver(String location1){
        int i;
        for(i = 0; i< numOfDrivers; i++){

            if((drivers[i].getLocation()).equals(this.location1) && //checks if driver is available at
                    (drivers[i].getCarType()).equals(carType))  //given location with given carType
            {
                driverno = i;
                System.out.println("Booking successful!");
                status = true;
                return true;
            }}

        if(i == numOfDrivers){
            System.out.println("Driver unavailable, please try again later.");
            return false;
        }
        if(time >= 130 && time <= 430){         //randomly assigns no driver due to low
                                                //availability at early hours
            return !(Math.random() >= 0.75);
        }
        return true;
    }
    
    public void updateDriverNum() {
    	DriverLibrary d2 = new DriverLibrary();
    	d2.updateDriverNum();
    }

    public Boolean getStatus(){
        return status;
    }

       	public boolean isFemaleDriver(String location1){
            int i;
            for(i = 0; i< numOfDrivers; i++){

                if((drivers[i].getLocation()).equals(this.location1) && //checks if driver is available at
                        (drivers[i].getCarType()).equals(carType) && drivers[i].getGender()==true)  //given location with given carType
                {
                    driverno = i;
                    System.out.println("Booking successful!");
                    status = true;
                    return true;
                }}

            if(i == numOfDrivers){
                System.out.println("Driver unavailable, please try again later.");
                return false;
            }
            if(time >= 130 && time <= 430){         //randomly assigns no driver due to low
                                                    //availability at early hours
                return !(Math.random() >= 0.75);
            }
            return true;
       	}

//    public boolean makeBooking(){       //gets booking details, calls isDriver(), showBooking(), setLoc()
//        System.out.println("Enter time of travel: ");
//        Scanner in = new Scanner(System.in);
//        time = in.nextInt();
//        System.out.println("Enter pickup location from the following: ");
//        System.out.println("*-Liverpool\n *-Manchester\n *-Cambridge\n *-Oxford\n *-Brighton\n");
//        location1 = in.next();
//        System.out.println("Enter drop-off location from the following: ");
//        System.out.println("*-Liverpool\n *-Manchester\n *-Cambridge\n *-Oxford\n *-Brighton\n");
//        location2 = in.next();
//        System.out.println("Enter type of car: ");
//        carType = in.next();
//        isDriver(location1);
//        if(isDriver(location1))
//        {
//            setBookingID();
//            showBooking();
//            setLocation();
//        }
//        in.close();
//        return true;
//    }
   

    public void showBooking(){                  //displays booking details
        System.out.println("\t\tBooking Details: ");
        System.out.println("**********************************");
        System.out.println("Booking ID: " + bookingID);
        System.out.println("Driver Name: " + drivers[driverno].getName());
        System.out.println("Driver Contact: " + drivers[driverno].getNumber());
        System.out.println("Time of pickup: " + time);
        System.out.println("Distance: " + getDistance());
    }

    


//    public String getlocation1() {
//        return location1;
//    }
//
//    public String getlocation2() {
//        return location2;
//    }
}

