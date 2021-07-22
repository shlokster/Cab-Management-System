import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DriverLibrary {
	private Driver[] Drivers;

	public DriverLibrary() {
		Drivers = null;
	}

	public void driverdetails(String filename) {

		try {

			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);

			while ((br.readLine() != null)) {

				String data = br.readLine();
				String[] records = data.split("[|]");
				int driverID = Integer.parseInt(records[0]);
				String name = records[1], location = records[2], type = records[3];
				long PhNum = Long.parseLong(records[4]);
				int age = Integer.parseInt(records[5]);
				int cabID = Integer.parseInt(records[6]);
				boolean gender = Boolean.parseBoolean(records[7]);
				float rating = Float.parseFloat(records[8]);
				int count = 0;
                Drivers[count] = new Driver(driverID, name, location, type, PhNum, age, cabID, gender, rating);
				count++;
				br.close();
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DriverLibrary x = new DriverLibrary();
		String csvFile = "Driver.csv";
		x.driverdetails(csvFile);

	}

}
