import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "Drivers.csv";
		Admin a = new Admin(filename);
		
		Booking b = new Booking();	
		System.out.print("Your fare for this ride is : ");		
		System.out.print(a.getReceipt(b.getDistance()));
		
		Scanner myObj = new Scanner(System.in);
		Scanner myObj1 = new Scanner(System.in);
		Scanner myObj2 = new Scanner(System.in);
		
	    System.out.println("\nDo you want to add another driver (Y or N) : ");
	    String checkadd = myObj.next();
	   
	    if(checkadd.equals("Y")) {	    	
			
		    System.out.println("Enter name : ");
		    String userName = myObj1.nextLine();
		  
		    System.out.println("Enter location : ");
		    String location = myObj1.nextLine();
		   
		    System.out.println("Enter the type of car : ");
		    String cartype = myObj1.nextLine();
		  	    
		    System.out.println("Enter phone number : ");
		    long phno = myObj1.nextLong();
		          
		    System.out.println("Enter age : ");
		    int age = myObj1.nextInt();
		    	      
		    System.out.println("Enter the cab id : ");
		    int cabid = myObj1.nextInt();
		   	      
		    System.out.println("Enter gender (true-Female,false-Male) : ");
		    boolean gender = myObj1.nextBoolean();
		         
		    System.out.println("Enter rating : ");
		    float rating = myObj1.nextFloat();
		    
		    a.addDriver(userName,location,cartype,phno,age,cabid,gender,rating); 
		    
	    }
	    	 
	    myObj.nextLine();
	    
	    System.out.println("Do you want to delete a driver (Y or N) : ");
	    String checkdelete = myObj.next();
	    
	    if(checkdelete.equals("Y"))  {
	    	System.out.println("Enter Driver ID : ");
		    int dID = myObj.nextInt();
		    a.deleteDriver(dID);  
	    }
	    	 
	    if(b.isDriver()) {
	    	System.out.print("Please enter the rating after the trip : ");
	    	float drating = myObj2.nextFloat();
	    	a.setRating(drating, b.getDriverNo());  
	    }
	    
	    myObj1.close();
	    myObj.close();
	    myObj2.close();
	}
	
}
