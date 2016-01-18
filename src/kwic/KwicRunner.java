package kwic;

import java.util.Vector;

public class KwicRunner {
	public static void main(String args[]) {
		Input userInput = new Input(); 
		Vector<String> val = userInput.getUserInput();
		
		Kwic tooQuick = new Kwic(val);
		Vector<String> list = tooQuick.kwicParser();
		
		Output output = new Output();
		output.getUserPreference(list);
	}
}
