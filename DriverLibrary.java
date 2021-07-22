
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class DriverLibrary {
	private Driver[] Drivers = new Driver[100];
	public DriverLibrary(){}
	private int numOfDrivers;
	public DriverLibrary(String filename) {

		try {
			int count = 0;

			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);

			while ((br.readLine() != null)) {

				String data = br.readLine();
				String[] records = data.split("[,]");
				int driverID = Integer.parseInt(records[0]);
				String name = records[1], location = records[2], type = records[3];
				long PhNum = Long.parseLong(records[4]);
				int age = Integer.parseInt(records[5]);
				int cabID = Integer.parseInt(records[6]);
				boolean gender = Boolean.parseBoolean(records[7]);
				float rating = Float.parseFloat(records[8]);

				Drivers[count] = new Driver(driverID, name, location, type, PhNum, age, cabID, gender, rating);
				count++;
				numOfDrivers = count;

			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
	public Driver[] getDrivers() {
		return Arrays.copyOf(Drivers, 25);
	}

	public int getnumOfDrivers(){
		return numOfDrivers;
	}


}
