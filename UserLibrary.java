import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class UserLibrary {
	private User[] Users = new User[100];
	public UserLibrary(){}
	private int numOfUsers;
	public UserLibrary(String filename) {

		try {
			int count = 0;

			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);//reads the file line by line

			while ((br.readLine() != null)) {

				String data = br.readLine();
				String[] records = data.split("[,]");//identifies the comma delimiter and split the row into fields
				int age = Integer.parseInt(records[3]);
				String name = records[0], email = records[1], password = records[2];
				long PhNum = Long.parseLong(records[4]);
				boolean gender = Boolean.parseBoolean(records[5]);

				Users[count] = new User(name, email, password,age,PhNum, gender);
				count++;
				numOfUsers = count;

			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	
	}
	public User[] getUsers() {
		return Arrays.copyOf(Users, 10);
	}

	public int getnumOfUsers(){
		return numOfUsers;
	}


}