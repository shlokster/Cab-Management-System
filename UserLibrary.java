import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class UserLibrary {
	public User[] u = new User[100];
	public User UserObj = new User();
	public int rowCount = 0;
	public UserLibrary(){}
	

	public void userLibrary(String filename) {
		
		URL path = UserLibrary.class.getResource("User.csv");
		
		String fname = path.getPath();
		File myObj = new File(fname);      
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
						u[i].uage = lineScanner.nextInt();
						u[i].uPhNum = lineScanner.nextLong();
						u[i].ugender = lineScanner.nextBoolean();
					}
				lineScanner.close();
			}
			myReader.close();
			rowCount = i+1;
		} catch (FileNotFoundException e) {
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
		else
			System.out.print("LOGIN SUCCESSFUL \n The User array has been created : \n");
			return UserObj;
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
		
public static void main(String[] args) {
		
		UserLibrary u1 = new UserLibrary();  
		u1.userLibrary("User.csv");
		
		System.out.print("Enter the email : \n");
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();      
		System.out.print("Enter your password : \n");
		String y = sc.nextLine(); 
		u1.createObject(x,y);
		u1.printUser();
		sc.close();
	}
	
}