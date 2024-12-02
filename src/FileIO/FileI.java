package FileIO;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileI {

	public static void main(String[] args) {
		FileI reader = new FileI();
		reader.run();	//Calling method
	}
	
	public void run() {
		Scanner keyboard = new Scanner(System.in);
		
		Scanner inputStream = null;
		
		//For entering name of file
		System.out.println("Enter the name + extension of the file you want to open: ");
		String fileName = keyboard.nextLine();
		
		//Try code in section
		try {
			System.out.println("The file " + fileName + " contains the following:\n");
			inputStream = new Scanner(new File(fileName));
		}	catch(FileNotFoundException e) {	//Catch error
			System.out.println("Error when trying to open file " + fileName);	//Display when error
			System.exit(0);
		}
		
		//Loop to iterate through each line and print them
		while(inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			System.out.println(line);
		}
		
		//Close instances
		keyboard.close();
		inputStream.close();
	}

}
