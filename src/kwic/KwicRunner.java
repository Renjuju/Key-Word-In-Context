package kwic;

import java.util.Vector;

public class KwicRunner {
	public static void main(String args[]) {
		Kwic tooQuick = new Kwic();
		Input userInput = new Input(); 
		Vector<String> testVal = userInput.getUserInput();
		tooQuick.kwicParser(testVal);
		
	}
}
