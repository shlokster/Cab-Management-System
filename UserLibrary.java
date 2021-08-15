/*
 *		double getReceipt()			Calculate the fare of the trip
 * 		void addDriver()			Adds a driver to the CSV file
 * 		void buildDriverList()			Creates a list of drivers
 * 		int NextdriverID()			Calculate the 'DriverID' of the new added driver
 * 		void deleteDriver()			Deletes a driver from the CSV file
 * 		void setRating()			Sets the new rating after each trip for the respective driver
 * 		void reWritefile()			Method to update the CSV file with the values
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserLibrary extends User{
	private boolean status=false;
	public User[] u = new User[100];
	public User UserObj = new User();
	public int rowCount = 0;
	public UserLibrary(){}
	public String filename="C:\\Users\\Shlok\\eclipse-workspace\\ProjectIT\\src\\User.csv";

	public void userLibrary(String filename) {
		
		File myObj = new File(filename);      
		Scanner myReader;  
		
		int i =-1;
		
		try {
			myReader = new Scanner(myObj);
			myReader.nextLine();
			
			while (myReader.hasNextLine()) {
				
				String data = myReader.nextLine();
				
				Scanner lineScanner = new Scanner(data);
				lineScanner.useDelimiter(",");
				
				while(lineScanner.hasNext()) {
					    i++;
						u[i]= new User();
						u[i].uname = lineScanner.next();
						u[i].uemail = lineScanner.next();
						u[i].upassword = lineScanner.next();  
						u[i].uage = Integer.parseInt(lineScanner.next());
						u[i].uPhNum = lineScanner.nextLong();
						String gen = lineScanner.next();
						if(gen.equals("true")) {
						u[i].ugender = true;  }
						else {
						u[i].ugender = false;  }
							
					}
				
					
				lineScanner.close();
			}
			myReader.close();
			rowCount = i+1;
		} catch (FileNotFoundException e) {
			e.printStackTrace();    
		}
	}
	
	public void addUser(String name, String email, String password, int age, long PhNum, boolean gender) { 
		
		rowCount++;
		rowCount++;
		u[rowCount] = new User(name,email,password,age,PhNum,gender);
		reWritefile("ADD");
	}
	
	private void reWritefile(String modifier) {
				
		try {
			if (modifier.equals("ADD")) {
				FileWriter csvWriter = new FileWriter(filename,true);
				csvWriter.append(u[rowCount].getName()+","+u[rowCount].getEmail()+","+u[rowCount].getPassword()+","+u[rowCount].getAge()+","+u[rowCount].getPhNum()+","+u[rowCount].getGender()+"\n");
				csvWriter.flush();
				csvWriter.close();
				}  
		
			
		} catch (IOException e) {  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	
	public User createObject(String email,String password) {
		
		int i;
		int c=-1;
		for(i=0;i<rowCount;i++) {
				{ 
					
					if((u[i].uemail.equalsIgnoreCase(email)) && (u[i].upassword.equals(password)) ) {
						
						UserObj = u[i];  
						c++;  
					
						break;
					
				}
			}
		}
		if (c==-1)
			{System.out.print("LOGIN UNSUCCESSFUL\n\n");
				
			}
		else {
			System.out.print("LOGIN SUCCESSFUL \n");
			status=true;
		}
		return UserObj;
	}
	

    public Boolean getStatus(){
        return status;
    }

	
	public void printUser()
	{
		System.out.println(UserObj.uname);
		System.out.println(UserObj.uemail);
		System.out.println(UserObj.upassword);
		System.out.println(UserObj.uage);
		System.out.println(UserObj.uPhNum);
		System.out.println(UserObj.ugender);
		
	}
		
	
	public void logIn(String uemail, String upassword) {
		createObject(uemail,upassword);  
	}  
	
	public void register(String uname, String uemail, String upassword, int uage, long uPhNum, boolean ugender) {
		addUser(uname,uemail,upassword,uage,uPhNum,ugender);
		status=true;
	}

//	public static void main(String[] args) {
//		
//		UserLibrary u1 = new UserLibrary();  
//		
//		u1.userLibrary("C:\\Users\\Shlok\\eclipse-workspace\\ProjectIT\\src\\User.csv"); 
//		u1.logIn();
//		u1.printUser();
//		
//		
//	}
	
}
