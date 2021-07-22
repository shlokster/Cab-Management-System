/*
 Methods:
void driverdetails, 
Variables:
String name, location,type 
long PhNum
int age, cabID , driverID
Boolean gender
Float rating
*/

public class driver {
	private final int driverID;
	private final String name;
	private final String location;
	private final String type;
	private final long PhNum;
	private final int age;
	private final int cabID;
	private final boolean gender;
	private final float rating;
	// private driver[] drivers;

	public driver(int driverID, String name, String location, String type, long PhNum, int age, int cabID,
			boolean gender, float rating) {//

		this.driverID = driverID;
		this.name = name;
		this.location = location;
		this.type = type;
		this.PhNum = PhNum;
		this.age = age;
		this.cabID = cabID;
		this.gender = gender;
		this.rating = rating;
	}

	public int getdriverid() {
		return driverID;
	}

	public String getname() {
		return name;

	}

	public String getlocation() {
		return location;

	}

	public String getTypeofcar() {
		return type;
	}

	public long getphnum() {
		return PhNum;
	}

	public int getage() {
		return age;

	}

	public int getcabID() {
		return cabID;

	}

	public float getrating() {
		return rating;
	}
	public boolean getgender(){
		return gender;
	}

	public String toString() {
		String s = "";
		s += "Driverid" + driverID + "\n";
		s += "Name" + name + "\n";
		s += "Location  :" + location + "\n";
		s += "Type :" + type + "\n";
		s += "Phone no :" + PhNum + "\n";
		s += "Age: " + age + "\n";
		s += "CabId: " + cabID + "\n";
		s += "Gender: " + gender + "\n";
		s += "Rating: " + rating + "\n";

		return s;
	}

}
