import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class UserLibrary extends User{
	public User[] u = new User[100];
	public User UserObj = new User();
	public int rowCount = 0;
	public UserLibrary(){}
	public String filename="User.csv";

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
				{ if(i==0) {
					System.out.print(u[i].getName());
				}
					
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
			System.out.print("LOGIN SUCCESSFUL \nThe User array has been created : \n");
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
		
	
	public void logIn() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the email : \n");
		uemail = sc.nextLine();      
		System.out.print("Enter your password : \n");
		upassword = sc.nextLine(); 
		sc.close();
		createObject(uemail,upassword);
	}
	
	public void register() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Name: ");
		uname = scan.nextLine();
		System.out.println("Enter Email Id: ");
		uemail = scan.nextLine();
		System.out.println("Enter Password: ");
		upassword = scan.nextLine();
		System.out.println("Enter Age: ");
		uage  = scan.nextInt();
		System.out.println("Enter Phone Number: ");
		uPhNum  = scan.nextLong();
		System.out.println("Enter Gender:");
		ugender = scan.nextBoolean();
		scan.close();
		addUser(uname,uemail,upassword,uage,uPhNum,ugender);
	}

public static void main(String[] args) {
		
		UserLibrary u1 = new UserLibrary();  
		
		u1.userLibrary("User.csv");
		u1.register();
		
		
	}
	
}