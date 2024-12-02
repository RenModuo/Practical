package FileIO;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileO {

	public static void main(String[] args) {
		FileO writer = new FileO();
		writer.run();	//Calling method
	}
	
	public void run() {
		Scanner keyboard = new Scanner(System.in);
		
		PrintWriter outputStream = null;
		
		//For entering name of file
		System.out.println("Enter the name + extension of the file you want to create: ");
		String fileName = keyboard.nextLine();
		
		//Try code in section
		try {
			outputStream = new PrintWriter(fileName);
		}	catch(FileNotFoundException e) {	//Catch Error
			System.out.println("Error when trying to open file " + fileName);	//Display when error
			System.exit(0);
		}
		
		//Prompt user input
		System.out.println("Enter however many lines of text as you want (input 'end' to stop): ");
		//Control loop
		boolean End = false;
		
		//Count loop iteration
		int count = 1;
		
		while(!End) {
			String line = keyboard.nextLine();	//Get line from input stream 
			
			if(!line.equalsIgnoreCase("end")) {
				outputStream.println(count + ", " + line);	//Write line into file
			}
			else End = true;	//End loop
			
			count++;	//Increment count
		}
		
		//Close Instance
		keyboard.close();
		outputStream.close();
		
		System.out.println("Those lines were written into " + fileName);
	}

}
