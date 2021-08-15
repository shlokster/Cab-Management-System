
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

public class Driver {
	private final int driverID;
	private final String name;
	private String location;
	private final String type;
	private final long PhNum;
	private final int age;
	private final int cabID;
	private final boolean gender;
	private final float rating;
	// private driver[] drivers;

	public Driver(int driverID, String name, String location, String type, long PhNum, int age, int cabID,
			boolean gender, float rating) {

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

	public int getDriverID() {
		return driverID;
	}

	public String getName() {
		return name;

	}

	public String getLocation() {
		return location;

	}

	public String getCarType() {
		return type;
	}

	public long getNumber() {
		return PhNum;
	}

	public int getAge() {
		return age;

	}

	public int getCabID() {
		return cabID;

	}
        public void setLoc(String location2) {
        location = location2;
        }

	public float getRating() {
		return rating;
	}
	public boolean getGender(){
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
