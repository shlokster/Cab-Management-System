import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;  
import java.io.IOException;
import java.util.Scanner;  
public class User  
{  
	
	private String email,password,name;
	private int age;
	private long PhNum;
	private Boolean gender;

	String filename;
	User[] userList = new User[1000];
	String fileHeader;
	boolean blankFile = true;
	int userCount = 0;
		
	public User(String sfilename) {
		filename = sfilename;
		buildUserList();
	}
	

	private void buildUserList() {		
		
		File myObj = new File(filename);      
		Scanner myReader;       
		  
		int i =-1;
		
		try {
			myReader = new Scanner(myObj);
			String Header = myReader.nextLine();
			Scanner lineScanner1 = new Scanner(Header);  
			
			fileHeader = lineScanner1.next();
			lineScanner1.close();
			
			
			while (myReader.hasNextLine()) {
				blankFile = false;				
				String data = myReader.nextLine();
				
				Scanner lineScanner = new Scanner(data);
				lineScanner.useDelimiter(",");
				
				while(lineScanner.hasNext()) {
					    i++;
						userList[i]= new User(lineScanner.next(),lineScanner.next(),lineScanner.next(),lineScanner.nextInt(),lineScanner.nextLong(),lineScanner.nextBoolean());	
					}
				lineScanner.close();
			}
			userCount = i+1;
			myReader.close();
				
			} catch (FileNotFoundException e) {
			e.printStackTrace();    
		}
	}
		
	public User(String email, String password, String name, int age, long PhNum,Boolean gender ) {
		this.email= email;
		this.password=password;
		this.name=name;
		this.age=age;
		this.PhNum=PhNum;
		this.gender=gender;
	}
		
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public long getPhNum() {
		return PhNum;
	}
	public Boolean getGender() {
		return gender;
	}
	
	public void logIn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email: ");
		this.email = sc.nextLine();
		System.out.println("Enter password: ");
		this.password = sc.nextLine();
		sc.close();
		
	}
	
	public void register() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Name: ");
		this.name = scan.nextLine();
		System.out.println("Enter Email Id: ");
		this.email = scan.nextLine();
		System.out.println("Enter Password: ");
		this.password = scan.nextLine();
		System.out.println("Enter Age: ");
		this.age  = scan.nextInt();
		System.out.println("Enter Phone Number: ");
		this.PhNum  = scan.nextLong();
		System.out.println("Enter Gender:");
		this.gender = scan.nextBoolean();
		scan.close();
	}
	
	
	public Boolean check()
	{  
		String line = "";  
		String splitBy = ",";  
		int present=0;
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Shlok\\Downloads\\Cab-Management-System-main\\Cab-Management-System-main\\User.csv"));  
			while ((line = br.readLine()) != null)   
			{  
				String[] UserList = line.split(splitBy);    // use comma as separator  
				if( UserList[1].equalsIgnoreCase(getEmail()) && UserList[2].equals(getPassword())) {
					present++;
					createObject(getEmail(),getPassword());
				}
				else
					continue;
			} 
			br.close();
		}   
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}  
	
		if(present>0)
			return true;
		else
			return false;

	} 
	

	public void createObject(String email,String password) {    
		for(int i=0;i<userCount;i++) {
			if(email==userList[i].getEmail() && password==userList[i].getPassword() ) {
				User u1 = new User(userList[i].getEmail(),userList[i].getPassword(),userList[i].getName(),userList[i].getAge(),userList[i].getPhNum(),userList[i].getGender());
				userList[i] = u1;
				break;
			}   
		}
		
	}
	
	
	public static void main(String[] args) {
//		User obj=new User("S","s","s",18,191293,false);
//		User obj1=new User("C:\\Users\\Shlok\\Downloads\\Cab-Management-System-main\\Cab-Management-System-main\\User.csv");
//		obj.logIn();
//		System.out.println(obj.check());
//		System.out.println(obj.getAge());
	}
	
} 