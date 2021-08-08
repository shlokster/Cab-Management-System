package Cab;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserLibrary extends User{
	public User[] u = new User[100];
	public User UserObj = new User();
	public int rowCount = 0;
	public UserLibrary(){}
	public String filename="C:\\Users\\Annant Maheshwari\\eclipse-workspace\\JAVA\\src\\Cab\\User.csv";

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
			System.out.print("LOGIN SUCCESSFUL \nThe User Object has been created : \n");
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
		createObject(uemail,upassword);  
	}  
	
	public void register() {
		addUser(uname,uemail,upassword,uage,uPhNum,ugender);
	}

public static void main(String[] args) {
		
		UserLibrary u1 = new UserLibrary();  
		
		u1.userLibrary("C:\\Users\\Annant Maheshwari\\eclipse-workspace\\JAVA\\src\\Cab\\User.csv"); 
		u1.register();
		
		
	}
	
}