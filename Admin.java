import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Admin {

    String filename;
    Driver[] driverList = new Driver[1000];
    String fileHeader;
    boolean blankFile = true;
    int driverCount = 0;
    DriverLibrary d = new DriverLibrary();

    public Admin(String sfilename) {		//parameterized constructor
        filename = sfilename;
        buildDriverList();
    }

    public double getReceipt(double d,int t) {		//Calculate the fare of the trip
        if(t>=0130 && t<=0430)
            return d*3;
        return d*2;
    }

    public void addDriver(String name, String location, String type, long PhNum, int age, int cabID,	
                          String gender, float rating) {		//Adds a driver to the CSV file

        int nextDriverID = NextdriverID();
        driverCount++;
        driverList[driverCount-1] = new Driver(nextDriverID,name,location,type,PhNum,age,cabID,gender,rating);
        reWritefile("ADD");
    }

    private void reWritefile(String modifier) {		//Method to update the CSV file with the values

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

    private void buildDriverList() {		//Creates a list of drivers

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
                    driverList[i]= new Driver(lineScanner.nextInt(),lineScanner.next(),lineScanner.next(),lineScanner.next(),lineScanner.nextLong(),lineScanner.nextInt(),lineScanner.nextInt(),lineScanner.next(),lineScanner.nextFloat());
                }
                lineScanner.close();
            }
            driverCount = i+1;
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private int NextdriverID() {		//Calculate the 'DriverID' of the new added driver
        if (blankFile)
            return 1;
        else
            return driverList[driverCount-1].getDriverID() + 1;
    }

    public void deleteDriver(int driverId) {		//Deletes a driver from the CSV file

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

    public void setRating(float drating,int driverNo,String loc) {	//Sets the new rating after each trip for the respective driver
        driverNo+=1;
        for(int i=0;i<driverCount;i++) {
            if(driverNo == driverList[i].getDriverID()) {
                float newRating = (float) ((driverList[i].getRating() + drating)/2.0);
                Driver d1 = new Driver(driverList[i].getDriverID(),driverList[i].getName(),
                        loc,driverList[i].getCarType(),driverList[i].getNumber(),driverList[i].getAge(),
                        driverList[i].getCabID(),driverList[i].getGender(),newRating);
                driverList[i] = d1;
                break;
            }
        }
        reWritefile("RATING");
    }

    public void printDdetails() {		//prints driver details
        for(int i=0;i<driverCount;i++) {
            System.out.print(driverList[i].getDriverID()+"\t"+driverList[i].getName()+"\n");
        }
    }

}
