
public class User 
{  
	
	protected String uemail,upassword,uname;
	protected int uage;
	protected long uPhNum;
	protected String ugender;

	
	public User() {
		uemail ="";
		upassword="";
		uname="";
		uage=0;
		uPhNum=0;
		ugender="";
		}
	
	
	public User( String name, String email, String password, int age, long PhNum,String gender) {
		uname=name;
		uemail= email;
		upassword=password;
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
	public String getGenderU() {
		return ugender;
	}
	
		
}