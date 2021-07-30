
import java.util.Scanner;  

public class User 
{  
	
	public String uemail,upassword,uname;
	public int uage;
	public long uPhNum;
	public Boolean ugender;

	
	public User() {
		uemail ="";
		upassword="";
		uname="";
		uage=0;
		uPhNum=0;
		ugender=false;
		}
	
	
	public User(String email, String password, String name, int age, long PhNum,Boolean gender) {
		uemail= email;
		upassword=password;
		uname=name;
		uage=age;
		uPhNum=PhNum;
		ugender=gender;
	}
		
	public String getEmail() {
		return uemail;
	}
	public String getPassword() {
		return upassword;
	}
	public String getName() {
		return uname;
	}
	public int getAge() {
		return uage;
	}
	public long getPhNum() {
		return uPhNum;
	}
	public Boolean getGender() {
		return ugender;
	}
	
	public void logIn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email: ");
		uemail = sc.nextLine();
		System.out.println("Enter password: ");
		upassword = sc.nextLine();
		sc.close();
		
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
	}

	
		
}
