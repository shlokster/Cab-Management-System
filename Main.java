package Cab;

import 

java.util.Scanner;

	public class Main {
		    
		public static void main(String[] args) {
		System.out.println("\t\tWELCOME TO SUNRISE CAB MANAGEMENT SYSTEM\t\t");
		System.out.println("*******************************************************************\n");
		System.out.println("Enter 1 for User");
		System.out.println("Enter 2 for Admin");
		int choice1;
		DriverLibrary d = new DriverLibrary("C:\\Users\\Annant Maheshwari\\eclipse-workspace\\JAVA\\src\\Cab\\Driver.csv");
		Booking b1 = new Booking("C:\\Users\\Annant Maheshwari\\eclipse-workspace\\JAVA\\src\\Cab\\Driver.csv",d);
		Admin a = new Admin("C:\\Users\\Annant Maheshwari\\eclipse-workspace\\JAVA\\src\\Cab\\Driver.csv");
		
		UserLibrary u0 = new UserLibrary();
		u0.userLibrary("C:\\Users\\Annant Maheshwari\\eclipse-workspace\\JAVA\\src\\Cab\\User.csv");
		Scanner sc = new Scanner(System.in);
		
		choice1 = sc.nextInt();
		
		if(choice1==1) {
			  
			int choice2;
			System.out.println("Press 1 for Login and 2 for Register");
			choice2=sc.nextInt();
			
			if(choice2==1) {
				System.out.print("Enter the email : \n");
				String emailt = sc.next();      
				System.out.print("Enter your password : \n");
				String passwordt = sc.next();    
				u0.logIn(emailt,passwordt);
//				System.out.println(u0.getGender());
				
			}
			if(choice2==2) {
				System.out.println("Enter Name: ");
				String namet = sc.next();
				System.out.println("Enter Email Id: ");
				String emailt = sc.next();  
				System.out.println("Enter Password: ");
				String passwordt = sc.next();
				System.out.println("Enter Age: ");  
				int aget  = sc.nextInt();
				System.out.println("Enter Phone Number: ");
				long PhNumt  = sc.nextLong();
				System.out.println("Enter Gender: (M/F)");
				String gendert = sc.next();
				u0.register(namet,emailt,passwordt,aget,PhNumt,gendert);
			}
			
			if(u0.getStatus()==true) {
				
			
			Scanner in = new Scanner(System.in);
			System.out.println("\nWould you like to book a ride (Y or N) : ");
			    String checkadd1 = in.next();
			   
			    if(checkadd1.equals("Y")) {
			    	
			    
			System.out.println("Enter time of travel between 0000 and 2359: ");	        
	        int time = Integer.parseInt(in.next());    
	        System.out.println("Enter pickup location from the following: ");
	        System.out.println("*-Liverpool\n*-Manchester\n*-Cambridge\n*-Oxford\n*-Brighton\n");
	        String location1 = in.next();
	        System.out.println("Enter drop-off location from the following: ");
	        System.out.println("*-Liverpool\n*-Manchester\n*-Cambridge\n*-Oxford\n*-Brighton\n");
	        String location2 = in.next();
	        System.out.println("Enter type of car from the following: ");
			System.out.println("*-Sedan\n*-Mini\n*-SUV\n");
			String carType = in.next();
	        b1.createBooking(time, location1, location2, carType);
	        
//	        b1.isDriver(location1);
	        
	        if(u0.getUserGender().equals("F")) {
	        	System.out.println("Would you prefer a female driver? (Y/N)");
	        	String choiceg = in.next();
	        	if(choiceg.equals("Y")) {
	    	     if(b1.isFemaleDriver(location1))  
	    	        {
	    	            b1.setBookingID();
	    	            b1.showBooking();
	    	            b1.setLocation();
	    	            System.out.print("Booking Successful!\n");	
	    	            System.out.print("Your fare for this ride is : ");		
	    				System.out.print(a.getReceipt(b1.getDistance(),b1.getTime()));
	    	        }
	    	       
	    	     else {
	        			System.out.println("\nYou will be assigned a male driver");

	        	        if(b1.isDriver(location1))  
	        	        {
	        	            b1.setBookingID();
	        	            b1.showBooking();
	        	            b1.setLocation();
	        	            System.out.print("Booking Successful!\n");	
	        	            System.out.print("Your fare for this ride is : ");		
	        				System.out.print(a.getReceipt(b1.getDistance(),b1.getTime()));
	        	        }
	        		}
	        	}
	        	else {
	        		if(b1.isDriver(location1))  
    	        	{
    	            b1.setBookingID();
    	            b1.showBooking();
    	            b1.setLocation();
    	            System.out.print("Booking Successful!\n");	
    	            System.out.print("Your fare for this ride is : ");		
    				System.out.print(a.getReceipt(b1.getDistance(),b1.getTime()));
    	        	}
	        	} 	
	        }
	        
	        else  //Male User 
	        	{
	        		if(b1.isDriver(location1))  
        	        {
        	            b1.setBookingID();
        	            b1.showBooking();
        	            b1.setLocation();
        	            System.out.print("Booking Successful!\n");	
        	            System.out.print("Your fare for this ride is : ");		
        				System.out.print(a.getReceipt(b1.getDistance(),b1.getTime()));
        	        }
        			
	        	}
	      	
			if(b1.getStatus()) {
				
				System.out.print("\nPlease enter the rating after the trip : ");
				float drating = in.nextFloat();
				a.setRating(drating,b1.getDriverNo(),b1.getlocation2());
			}
	        in.close();
		}
		}
		}
		
		
		else if(choice1==2){ //Admin

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
			   	      
			    System.out.println("Enter gender (M/F) : ");
			    String gender = myObj1.next();
			         
			    System.out.println("Enter rating : ");
			    float rating = myObj1.nextFloat();
			    
			    a.addDriver(userName,location,cartype,phno,age,cabid,gender,rating); 
			    
		    }
		    	 
		    myObj.nextLine();
		    
		    System.out.println("Do you want to delete a driver (Y or N) : ");
		    String checkdelete = myObj.next();
		    
		    if(checkdelete.equals("Y"))  {
		    	System.out.print("The available drivers in the database are : \n");
		    	a.printDdetails();
   
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
		System.out.println("Thank you for using our platform");
		}
		
	}