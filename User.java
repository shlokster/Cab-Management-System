import java.util.Scanner;
public class User {
	
	private final String email,password,name;
	private final int age;
	private final long PhNum;
	private final Boolean gender;
	
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
		
		String email = sc.nextLine();
		System.out.println("Enter password: ");
		String password = sc.nextLine();
	
		
	}
	
	public void register() {
		System.out.println("Enter password: ");
		System.out.println("Enter password: ");
		System.out.println("Enter password: ");
		System.out.println("Enter password: ");
	}
	

}
