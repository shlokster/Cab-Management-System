import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * METHODS :
 * 		Admin()						parameterized constructor
 * 		double getReceipt()			Calculate the fare of the trip
 * 		void addDriver()			Adds a driver to the CSV file
 * 		void buildDriverList()		Creates a list of drivers
 * 		int NextdriverID()			Calculate the 'DriverID' of the new added driver
 * 		void deleteDriver()			Deletes a driver from the CSV file
 * 		void setRating()			Sets the new rating after each trip for the respective driver
 * 		void reWritefile()			Method to update the CSV file with the values  
 */

public class Admin {

	String filename;
	Driver[] driverList = new Driver[1000];
	String fileHeader;
	boolean blankFile = true;
	int driverCount = 0;
		
	public Admin(String sfilename) {
		filename = sfilename;
		buildDriverList();
	}
	
	public double getReceipt(double d) {
		return d*20;  
	}  
	
	public void addDriver(String name, String location, String type, long PhNum, int age, int cabID,
			boolean gender, float rating) { 
		
		int nextDriverID = NextdriverID(); 	
	  	driverCount++;
		driverList[driverCount-1] = new Driver(nextDriverID,name,location,type,PhNum,age,cabID,gender,rating);
		reWritefile("ADD");
	}
	
	private void reWritefile(String modifier) {
				
		try {
			if (modifier.equals("ADD")) {
				FileWriter csvWriter = new FileWriter(filename,true);
				csvWriter.append(driverList[driverCount-1].getDriverID()+","+ driverList[driverCount-1].getName()+","+driverList[driverCount-1].getLocation()+","+driverList[driverCount-1].getCarType()+","+driverList[driverCount-1].getNumber()+","+driverList[driverCount-1].getAge()+","+driverList[driverCount-1].getCabID()+","+driverList[driverCount-1].getGender()+","+driverList[driverCount-1].getRating()+"\n");
				csvWriter.flush();
				csvWriter.close();
				}  
			else {
				 	FileWriter csvWriter = new FileWriter(filename);
				 	csvWriter.append(fileHeader+"\n");
				 	for(int i=0;i<driverCount;i++) {							
							try {
								csvWriter.append(driverList[i].getDriverID()+","+driverList[i].getName()+","+driverList[i].getLocation()+","+driverList[i].getCarType()+","+driverList[i].getNumber()+","+driverList[i].getAge()+","+driverList[i].getCabID()+","+driverList[i].getGender()+","+driverList[i].getRating()+"\n");
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
	
	private void buildDriverList() {		
		
		File myObj = new File(filename);      
		Scanner myReader;       
		  
		int i =-1;
		
		try {
			myReader = new Scanner(myObj);
			String Header = myReader.nextLine();
			Scanner lineScanner1 = new Scanner(Header);  
			
			fileHeader = lineScanner1.next();
			lineScanner1.close();
			
			
			while (myReader.hasNextLine()) {
				blankFile = false;				
				String data = myReader.nextLine();
				
				Scanner lineScanner = new Scanner(data);
				lineScanner.useDelimiter(",");
				
				while(lineScanner.hasNext()) {
					    i++;
						driverList[i]= new Driver(lineScanner.nextInt(),lineScanner.next(),lineScanner.next(),lineScanner.next(),lineScanner.nextLong(),lineScanner.nextInt(),lineScanner.nextInt(),lineScanner.nextBoolean(),lineScanner.nextFloat());	
					}
				lineScanner.close();
			}
			driverCount = i+1;
			myReader.close();
				
			} catch (FileNotFoundException e) {
			e.printStackTrace();    
		}
	}
	
	private int NextdriverID() {
		if (blankFile)
			return 1;
		else
			return driverList[driverCount-1].getDriverID() + 1;
	}
	
	public void deleteDriver(int driverId) { 
		
		for(int i=0;i<driverCount;i++) {
	    	if(driverId==driverList[i].getDriverID()) {
	    		for(int j=i;j<driverCount-1;j++)
	    			driverList[j]=driverList[j+1];  
	    		driverList[driverCount-1]=null;
	    		driverCount--;  
	    		break;    
	    	}
	    }  
		reWritefile("DELETE");   
	}
	
	public void setRating(float drating,int driverNo) {    
		for(int i=0;i<driverCount;i++) {
			if(driverNo==driverList[i].getDriverID()) {
				float newRating = (float) ((driverList[i].getRating() + drating)/2.0);
				Driver d1 = new Driver(driverList[i].getDriverID(),driverList[i].getName(),driverList[i].getLocation(),driverList[i].getCarType(),driverList[i].getNumber(),driverList[i].getAge(),driverList[i].getCabID(),driverList[i].getGender(),newRating);
				driverList[i] = d1;
				break;
			}   
		}
		reWritefile("RATING");
	}
	
}
