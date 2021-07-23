import java.util.Scanner;
public class User {
	
	private String email,password,name;
	private int age;
	private long PhNum;
	private Boolean gender;
	
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
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String name = scan.nextLine();
		System.out.println("Enter Email Id: ");
		String email = scan.nextLine();
		System.out.println("Enter Password: ");
		String password = scan.nextLine();
		System.out.println("Enter Phone Number: ");
		long PhNum = scan.getLong();
		System.out.println("Enter Age: ");
		int age = scan.getInt();
		System.out.println("Enter Gender: \nPress 1 for Female\nPress 0 for Male");
		Boolean gender = scan.getBoolean();
	}
	

}
