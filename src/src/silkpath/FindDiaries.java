package silkpath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class has a static method to take in one user and find that user's dating diaries and store on that user
 * @author silkpath
 *
 */
public class FindDiaries {
	/**
     * Find diaries of passed in user
     * @param user
     * @return an array list of diaries or null
     */	
	public static ArrayList<Diary> find(User user) {
		ArrayList<Diary> diaries = new ArrayList<>();
		File f = new File (user.getUsername()+ ".txt");
		Scanner scan;
		try {
			scan = new Scanner(f);
			String s = scan.nextLine();
			//System.out.println("The first line: " + s);
			s = scan.nextLine();
			//System.out.println("The second line: " + s);
			String[] match;
			
			 //If everything is correct, we loop to add each line of dating diary
			while (scan.hasNextLine()) {
				String[] parsed = scan.nextLine().split("===");
				String matchName = parsed[0];
				String age = parsed[1];
				String photo = parsed[2];
				String blurb = parsed[3];
				String date = parsed[4];
				String address = parsed[5];
				String notes = parsed[6];
				Diary d = new Diary(matchName, age, photo ,blurb, date, address, notes);
				diaries.add(d);
			}
			scan.close();
			return diaries;		
		} catch (FileNotFoundException e) {
			System.out.println("Did not find user in our system.");
			return null;
		}
		
	}
	
}
