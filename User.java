
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
	

	
		
}
