package kwic;

import java.util.Collections;
import java.util.Vector;

public class Kwic {
	
	private Vector<String> input;
	
	public Kwic(Vector<String> in) {
		input = in;
	}
	
	public Kwic() {
		
	}
	
	public Vector<String> kwicParser(Vector<String> input) {
		Vector<String> finalOutput = new Vector<String>();
		for(int i = 0; i < input.size(); i++) {
			int lineLength = getArrLength(input.get(i));
			String output = input.get(i);
			for(int x = 0; x < lineLength; x++) {
				output = quickStringBuilder(output);
				finalOutput.add(output);	
			}
		}
		Collections.sort(finalOutput, String.CASE_INSENSITIVE_ORDER);
		printInput(finalOutput);
		return finalOutput;
	}
	
	public Vector<String> kwicParser() {
		return kwicParser(input);
	}
	
	private void printInput(Vector<String> input) {
		System.out.println("Print input");
		System.out.println("-----------");
		for(int i = 0; i < input.size(); i++) {
			System.out.println(input.get(i));
		}
		System.out.println("-----------");
		System.out.println("End of input");
		System.out.println("");
	}
	
	private int getArrLength(String input) {
		String[] inputAr = input.replaceAll("[^a-zA-Z ]", "").split("\\s+");
		return inputAr.length;
	}
	private String quickStringBuilder(String input) {
		String[] inputAr = input.replaceAll("[^a-zA-Z ]", "").split("\\s+");
//		input = input.replaceAll("\\W", "");
		String temp = inputAr[inputAr.length - 1];
		String concatString = null;
		for(int i = 0; i < inputAr.length; i++) {
			if(i == 0) {
				continue;
			}
			if(concatString == null) {
				concatString = inputAr[i];
			} else {
				concatString+=" " + inputAr[i];
			}
		}
		concatString+= " " + inputAr[0];
//		System.out.println(concatString);
		return concatString;
		//refactor this portion of the code
		//the you from 8:02:28 knows exactly what TODO
		//DO YOU?
	}
}
