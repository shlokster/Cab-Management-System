//package Cab;



import java.util.Scanner;

	public class Main {
		    
		public static void main(String[] args) {
		System.out.println("1.User");
		System.out.println("2.Admin");
		int choice1;
		DriverLibrary d = new DriverLibrary("Driver.csv");
		Booking b1 = new Booking("Driver.csv",d);
		Admin a = new Admin("Driver.csv");
		
		UserLibrary u0 = new UserLibrary();
		u0.userLibrary("User.csv");
		Scanner sc = new Scanner(System.in);
		
		
		choice1 = sc.nextInt();
		
		if(choice1==1) {
			  
			int choice2;
			System.out.println("Press 1 for Login and 2 for Register");
			choice2=sc.nextInt();
			
			if(choice2==1) {
				System.out.print("Enter the email : \n");
				u0.uemail = sc.next();      
				System.out.print("Enter your password : \n");
				u0.upassword = sc.next();    
				u0.logIn();
				
			}
			if(choice2==2) {
				System.out.println("Enter Name: ");
				u0.uname = sc.next();
				System.out.println("Enter Email Id: ");
				u0.uemail = sc.next();  
				System.out.println("Enter Password: ");
				u0.upassword = sc.next();
				System.out.println("Enter Age: ");  
				u0.uage  = sc.nextInt();
				System.out.println("Enter Phone Number: ");
				u0.uPhNum  = sc.nextLong();
				System.out.println("Enter Gender:");
				u0.ugender = sc.nextBoolean();
				u0.register();
			}
			
			
			Scanner in = new Scanner(System.in); 
			
	        System.out.println("Enter time of travel: ");
	        int time = Integer.parseInt(in.next());    
	        System.out.println("Enter pickup location from the following: ");
	        System.out.println("*-Liverpool\n *-Manchester\n *-Cambridge\n *-Oxford\n *-Brighton\n");
	        String location1 = in.next();
	        System.out.println("Enter drop-off location from the following: ");
	        System.out.println("*-Liverpool\n *-Manchester\n *-Cambridge\n *-Oxford\n *-Brighton\n");
	        String location2 = in.next();
	        System.out.println("Enter type of car: ");
	        String carType = in.next();
	        b1.createBooking(time, location1, location2, carType);
//	        b1.isDriver(location1);
	        if(b1.isDriver(location1))  
	        {
	            b1.setBookingID();
	            b1.showBooking();
	            b1.setLocation();
	            System.out.print("Your fare for this ride is : ");		
				System.out.print(a.getReceipt(b1.getDistance()));
	        }
			if(b1.getStatus()) {
				System.out.print("\nPlease enter the rating after the trip : ");
				float drating = in.nextFloat();
				a.setRating(drating, b1.getDriverNo());
			}
	        in.close();
		}
			

		else if(choice1==2){

			Scanner myObj = new Scanner(System.in);
			Scanner myObj1 = new Scanner(System.in);
			Scanner myObj2 = new Scanner(System.in);
			
		    System.out.println("\nDo you want to add a driver (Y or N) : ");
		    String checkadd = myObj.next();
		   
		    if(checkadd.equals("Y")) {	    	
				
		    	b1.updateDriverNum();  
		    	
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
		    	 

		    
		    sc.close();
		    
		    myObj1.close();
		    myObj.close();
		    myObj2.close();
		    //sc.close();
		
	        }
		
		}
	}

