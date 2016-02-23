package kwic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class InputFilter extends Filter{
	Scanner in = new Scanner(System.in);
	private Vector<String> textLines = new Vector<String>();
	
	public Vector<String> getUserInput() {
		System.out.println("Would you like to provide the text input? (Y/N)");
		String userResponse = in.nextLine();
		if(userResponse.equalsIgnoreCase("y") || userResponse.equalsIgnoreCase("yes")) {
			return getInput();
		} else {
			System.out.println("Enter your file name");
			String fileName = in.nextLine();
			return getTextFile(fileName);
		}
	}
		
	
	private Vector<String> getInput() {
		System.out.println("Enter the number of lines you would like to type");
		try {
			int numberOfLines = Integer.parseInt(in.nextLine());
			for(int i = 0; i < numberOfLines; i++) {
				System.out.println(i + ") ");
				String line = in.nextLine();
				textLines.add(line);
			}
		} catch(Exception e) {
			System.out.println("Enter a valid input");
			getUserInput();
		}
		printInput(textLines);
		write(textLines);
		return textLines;
	}
	
	public Vector<String> getTextFile(String fileName) {
		Vector<String> input = new Vector<String>();
		try {
			input = readFile(fileName);
			printInput(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		write(input);
		return input;
	}
	
	private void printInput(Vector<String> input) {
		if(input == null) {
			return;
		}
		System.out.println("Print input");
		System.out.println("-----------");
		for(int i = 0; i < input.size(); i++) {
			System.out.println(input.get(i));
		}
		System.out.println("-----------");
		System.out.println("End of input");
		System.out.println("");
	}
	
	private Vector<String> readFile(String pathName) throws IOException {
		Vector<String> input = new Vector<String>();
		try {
			Scanner reader = new Scanner(new File(pathName));
		    while(reader.hasNext()){
		        input.add(reader.nextLine());
		    }
		    reader.close();
		    return input;
		} catch(Exception e) {
			
		}
		return null;
	}


	@Override
	public void run() {
		getUserInput();
	}
}
