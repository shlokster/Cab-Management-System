//
//import java.util.Scanner;
//
//public class MainClass {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String filename = "C:\\Users\\Shlok\\eclipse-workspace\\ProjectIT\\bin\\Driver.csv";
//		Admin a = new Admin(filename);
//		 
//		Booking b1 = new Booking("C:\\Users\\Shlok\\eclipse-workspace\\ProjectIT\\bin\\Driver.csv",d);
//		
//        System.out.println("Enter time of travel: ");
//        Scanner in = new Scanner(System.in);
//        int time = in.nextInt();
//        System.out.println("Enter pickup location from the following: ");
//        System.out.println("*-Liverpool\n *-Manchester\n *-Cambridge\n *-Oxford\n *-Brighton\n");
//        String location1 = in.next();
//        System.out.println("Enter drop-off location from the following: ");
//        System.out.println("*-Liverpool\n *-Manchester\n *-Cambridge\n *-Oxford\n *-Brighton\n");
//        String location2 = in.next();
//        System.out.println("Enter type of car: ");
//        String carType = in.next();
//        b1.createBooking(time, location1, location2, carType);
//        b1.isDriver(location1);
//        if(b1.isDriver(location1))
//        {
//            b1.setBookingID();
//            b1.showBooking();
//            b1.setLocation();
//        }
//			
//		System.out.print("Your fare for this ride is : ");		
//		System.out.print(a.getReceipt(b1.getDistance()));  
//		
//		Scanner myObj = new Scanner(System.in);
//		Scanner myObj1 = new Scanner(System.in);
//		Scanner myObj2 = new Scanner(System.in);
//		
//	    System.out.println("\nDo you want to add another driver (Y or N) : ");
//	    String checkadd = myObj.next();
//	   
//	    if(checkadd.equals("Y")) {	    	
//			
//	    	b1.updateDriverNum();  
//	    	
//	    	System.out.println("Enter name : ");
//		    String userName = myObj1.nextLine();
//		  
//		    System.out.println("Enter location : ");
//		    String location = myObj1.nextLine();
//		   
//		    System.out.println("Enter the type of car : ");
//		    String cartype = myObj1.nextLine();
//		  	    
//		    System.out.println("Enter phone number : ");
//		    long phno = myObj1.nextLong();
//		          
//		    System.out.println("Enter age : ");
//		    int age = myObj1.nextInt();
//		    	      
//		    System.out.println("Enter the cab id : ");
//		    int cabid = myObj1.nextInt();
//		   	      
//		    System.out.println("Enter gender (true-Female,false-Male) : ");
//		    boolean gender = myObj1.nextBoolean();
//		         
//		    System.out.println("Enter rating : ");
//		    float rating = myObj1.nextFloat();
//		    
//		    a.addDriver(userName,location,cartype,phno,age,cabid,gender,rating); 
//		    
//	    }
//	    	 
//	    myObj.nextLine();
//	    
//	    System.out.println("Do you want to delete a driver (Y or N) : ");
//	    String checkdelete = myObj.next();
//	    
//	    if(checkdelete.equals("Y"))  {
//	    	System.out.println("Enter Driver ID : ");
//		    int dID = myObj.nextInt();
//		    a.deleteDriver(dID);  
//	    }  
//	    	 
//	    if(b1.isDriver(b1.getlocation1())) {
//	    	System.out.print("Please enter the rating after the trip : ");
//	    	float drating = myObj2.nextFloat();
//	    	a.setRating(drating, b1.getDriverNo());    
//	    }
//	    
//	    in.close();
//	    myObj1.close();
//	    myObj.close();
//	    myObj2.close();
//	}
//	
//}
