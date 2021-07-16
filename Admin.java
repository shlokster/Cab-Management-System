import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * METHODS :
 * 		double getReceipt()
 * 		void addDriver()
 * 		void buildDriverList()
 * 		int NextdriverID()
 * 		void deleteDriver()
 */

public class Admin {

	String filename;
	driver[] driverList = new driver[1000];
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
	    try {
			FileWriter csvWriter = new FileWriter(filename,true);
			csvWriter.append(nextDriverID+","+ name+","+location+","+type+","+PhNum+","+age+","+cabID+","+gender+","+rating+"\n");
			driverCount++;
			driverList[driverCount-1]= new driver(nextDriverID,name,location,type,PhNum,age,cabID,gender,rating);
			csvWriter.flush();
			csvWriter.close();  
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
			myReader.nextLine();
			
			while (myReader.hasNextLine()) {
				blankFile = false;				
				String data = myReader.nextLine();
				
				Scanner lineScanner = new Scanner(data);
				lineScanner.useDelimiter(",");
				
				while(lineScanner.hasNext()) {
					    i++;
						driverList[i]= new driver(lineScanner.nextInt(),lineScanner.next(),lineScanner.next(),lineScanner.next(),lineScanner.nextLong(),lineScanner.nextInt(),lineScanner.nextInt(),lineScanner.nextBoolean(),lineScanner.nextFloat());
						
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
			return driverList[driverCount-1].getdriverid() + 1;
	}
	
	public void deleteDriver(int driverId) { 
		
		for(int i=0;i<driverCount;i++) {
	    	if(driverId==driverList[i].getdriverid()) {
	    		for(int j=i;j<driverCount-1;j++)
	    			driverList[j]=driverList[j+1];  
	    		driverList[driverCount-1]=null;
	    		driverCount--;  
	    		break;    
	    	}
	    }  
		FileWriter csvWriter = null;
		try {
			csvWriter = new FileWriter(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    for(int i=0;i<driverCount;i++) {							
					try {
						csvWriter.append(driverList[i].getdriverid()+","+driverList[i].getname()+","+driverList[i].getlocation()+","+driverList[i].getTypeofcar()+","+driverList[i].getphnum()+","+driverList[i].getage()+","+driverList[i].getcabID()+","+driverList[i].getGender()+","+driverList[i].getrating()+"\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	    }	    
		try {
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
}
