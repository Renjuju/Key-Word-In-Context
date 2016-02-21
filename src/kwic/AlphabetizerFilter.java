package kwic;

import java.util.Collections;
import java.util.Vector;

public class AlphabetizerFilter extends Filter{

	public AlphabetizerFilter() {
		
	}
	public void alphabetize() {
		Vector<String> output = read();
		Collections.sort(output, String.CASE_INSENSITIVE_ORDER);
		write(output);
	}

	@Override
	public void run() {
		alphabetize();
	}
}
