

//package cabsystem1;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class DriverLibrary {
	private Driver[] Drivers = new Driver[100];

	public DriverLibrary() {
	}

	String filename;
	private int numOfDrivers;
	// int driverCount = 0;
	int count = 0;
	String fileHeader;

	Scanner myObj = new Scanner(System.in);
//	Booking b = new Booking();

	public DriverLibrary(String filename) {

		try {

			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr); // reads the file line by line

			while ((br.readLine() != null)) {

				String data = br.readLine();
				String[] records = data.split("[,]"); // identifies the comma delimiter and split the row into fields
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

	public int getnumOfDrivers() {
		return numOfDrivers;
	}

	public void setLoc(String location, int driverNo) {
		for (int i = 0; i < count; i++) {
			if (driverNo == Drivers[i].getDriverID()) {
				String newLocation = (String) ((Drivers[i].getLocation()));
				Driver d1 = new Driver(Drivers[i].getDriverID(), Drivers[i].getName(), newLocation,
						Drivers[i].getCarType(), Drivers[i].getNumber(), Drivers[i].getAge(), Drivers[i].getCabID(),
						Drivers[i].getGender(), Drivers[i].getRating());
				Drivers[i] = d1;
				break;
			}
		}
		reWritefile("changeloc");
	}

	private void reWritefile(String modifier) {

		try {
			if (modifier.equals("changeloc")) {
				FileWriter csvWriter = new FileWriter(filename, true);
				csvWriter.append(Drivers[count - 1].getDriverID() + "," + Drivers[count - 1].getName() + ","
						+ Drivers[count - 1].getLocation() + "," + Drivers[count - 1].getCarType() + ","
						+ Drivers[count - 1].getNumber() + "," + Drivers[count - 1].getAge() + ","
						+ Drivers[count - 1].getCabID() + "," + Drivers[count - 1].getGender() + ","
						+ Drivers[count - 1].getRating() + "\n");
				csvWriter.flush();
				csvWriter.close();
			} else {
				FileWriter csvWriter = new FileWriter(filename);
				csvWriter.append(fileHeader + "\n");
				for (int i = 0; i < count; i++) {
					try {
						csvWriter.append(Drivers[i].getDriverID() + "," + Drivers[i].getName() + ","
								+ Drivers[i].getLocation() + "," + Drivers[i].getCarType() + ","
								+ Drivers[i].getNumber() + "," + Drivers[i].getAge() + "," + Drivers[i].getCabID() + ","
								+ Drivers[i].getGender() + "," + Drivers[i].getRating() + "\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				csvWriter.flush();
				csvWriter.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DriverLibrary d1 = new DriverLibrary("Driver.csv");
		System.out.println(d1.getDrivers()[5].getName());

	}
}
