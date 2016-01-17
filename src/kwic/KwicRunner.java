package kwic;

import java.util.Vector;

public class KwicRunner {
	public static void main(String args[]) {
		Input userInput = new Input(); 
		Vector<String> testVal = userInput.getUserInput();
		Kwic tooQuick = new Kwic(testVal);
		tooQuick.kwicParser();
	}
}
