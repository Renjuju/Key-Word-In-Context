package kwic;

import java.util.Vector;

public class KwicRunner {
	public static void main(String args[]) {
//		InputFilter userInput = new InputFilter(); 
//		Vector<String> val = userInput.getUserInput();
		
//		CircularShifterFilter shifter = new CircularShifterFilter();
//		Vector<String> list = shifter.circularShift(val);
//
//		AlphabetizerFilter.alphabetize(list);
//		
//		OutputFilter output = new OutputFilter();
//		output.getUserPreference(list);
		
		(new Pipes(
				new InputFilter(),
				new CircularShifterFilter(),
				new AlphabetizerFilter(),
				new OutputFilter()
				)).run();
	}
}
