
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class DriverLibrary {
	private Driver[] Drivers = new Driver[100];
	public DriverLibrary(){}
	private int numOfDrivers;
	int count = 0;
	String fileHeader;
	String filename;
	String Headers;
	public DriverLibrary(String filename) {  //Reads the data of the drivers from the csv file

			File myObj = new File(filename);      
			Scanner myReader;   
			try {
				myReader = new Scanner(myObj);
				Headers = myReader.nextLine();  
			while ((myReader.hasNextLine())) {  

				String data = myReader.nextLine();  
				String[] records = data.split("[,]"); //identifies the comma delimiter and split the row into fields
				int driverID = Integer.parseInt(records[0]);
				String name = records[1], location = records[2], type = records[3];
				long PhNum = Long.parseLong(records[4]);
				int age = Integer.parseInt(records[5]);
				int cabID = Integer.parseInt(records[6]);
				String gender = records[7];
				float rating = Float.parseFloat(records[8]);
				
				
				Drivers[count] = new Driver(driverID, name, location, type, PhNum, age, cabID, gender, rating);
				count++;
				numOfDrivers = count;

			
			
			}
			myReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();    
			}
			
		
		
		
	}
	public Driver[] getDrivers() {		//Returns an array of drivers
		return Arrays.copyOf(Drivers,numOfDrivers);  
	}

	public int getnumOfDrivers(){ //Return the total number of drivers
		return numOfDrivers;
	}
	
	public void updateDriverNum() {		//count of the number of drivers
		numOfDrivers++;
	}

	public void setLoc(String location, int driverNo) {	//Sets the new location after each trip
		for(int i=0;i<numOfDrivers;i++) {
			if(driverNo==Drivers[i].getDriverID()) {  
				Driver d1 = new Driver(Drivers[i].getDriverID(),Drivers[i].getName(),location,Drivers[i].getCarType(),Drivers[i].getNumber(),Drivers[i].getAge(),Drivers[i].getCabID(),Drivers[i].getGender(),Drivers[i].getRating());
				Drivers[i] = d1;
				break;
			}   
		}
		reWritefile("changelo",driverNo);
	}

	private void reWritefile(String modifier, int driverno) {   //Method to update the CSV file with the values  
		filename = "Driver.csv";		
		try {
			 {
				FileWriter csvWriter = new FileWriter(filename);
				csvWriter.append(Headers + "\n");
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

	
}


