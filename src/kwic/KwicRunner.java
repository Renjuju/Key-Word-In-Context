package kwic;


public class KwicRunner {
	public static void main(String args[]) {
		(new Pipes(
				new InputFilter(),
				new CircularShifterFilter(),
				new AlphabetizerFilter(),
				new OutputFilter()
				)).run();
	}
}
