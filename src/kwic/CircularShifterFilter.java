package kwic;

import java.util.Vector;

public class CircularShifterFilter extends Filter{
	
	private Vector<String> input;
	
	public CircularShifterFilter(Vector<String> in) {
		this.input = in;
	}
	
	public CircularShifterFilter() {
		
	}
	
	public Vector<String> circularShift() {
		Vector<String> input = read();
		Vector<String> finalOutput = new Vector<String>();
		for(int i = 0; i < input.size(); i++) {
			int lineLength = getArrLength(input.get(i));
			String output = input.get(i);
			for(int x = 0; x < lineLength; x++) {
				output = quickStringBuilder(output);
				finalOutput.add(output);	
			}
		}
		System.out.println("Size: " + finalOutput.size());
		write(finalOutput);
		return finalOutput;
	}
	
	private int getArrLength(String input) {
		String[] inputAr = input.replaceAll("[^a-zA-Z ]", "").split("\\s+");
		return inputAr.length;
	}
	
	private String quickStringBuilder(String input) {
		String[] inputAr = input.replaceAll("[^a-zA-Z ]", "").split("\\s+");
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
		return concatString;
	}

	@Override
	public void run() {
		circularShift();
	}
}
