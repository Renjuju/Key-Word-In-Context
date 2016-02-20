package kwic;

import java.util.Collections;
import java.util.Vector;

public class AlphabetizerFilter extends Filter{
	public static void alphabetize(Vector<String> output) {
		Collections.sort(output, String.CASE_INSENSITIVE_ORDER);
	}
}
