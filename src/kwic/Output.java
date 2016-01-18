package kwic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Output {
	
	public void getUserPreference(Vector<String> input) {
		System.out.println("Would you like to print to console or to file? (console/file)");
		Scanner in = new Scanner(System.in);
		String choice = in.nextLine();
		if(choice.equalsIgnoreCase("file")) {
			try {
				System.out.println("Enter your file name");
				String fileName = in.nextLine();
				saveOutputToFile(fileName, input);	
			} catch(Exception e) {
				
			}
		} else {
			printOutputToConsole(input);
		}
		in.close();
	}
	
	private void saveOutputToFile(String fileName, Vector<String> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

			for(int i = 0; i < list.size(); i++) {
				writer.write(list.get(i));
				writer.newLine();
			}
			writer.flush();  
			writer.close();  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void printOutputToConsole(Vector<String> input) {
		System.out.println("Print input");
		System.out.println("-----------");
		for(int i = 0; i < input.size(); i++) {
			System.out.println(input.get(i));
		}
		System.out.println("-----------");
		System.out.println("End of input");
		System.out.println("");
	}
}
