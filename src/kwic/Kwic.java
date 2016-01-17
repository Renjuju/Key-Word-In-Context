package kwic;

import java.util.Arrays;
import java.util.Vector;

public class Kwic {
	
	private Vector<String> input;
	
	public Kwic(Vector<String> in) {
		input = in;
	}
	
	public Kwic() {
		
	}
	
	public Vector<String>kwicParser(Vector<String> input) {
		Vector<String> finalOutput = new Vector<String>();
		for(int i = 0; i < input.size(); i++) {
			String output = quickStringBuilder(input.get(i));
			finalOutput.add(output);
		}
		printInput(finalOutput);
		return finalOutput;
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
	
	private String quickStringBuilder(String input) {
		String[] x = input.split(" ");
		String temp = x[x.length - 1];
		x[x.length - 1] = x[0];
		x[0] = temp;
		input = x.toString();
		return input;
		
		//refactor this portion of the code
		//the you from 8:02:28 knows exactly what TODO
		//DO YOU?
		//nigguh
	}
}
