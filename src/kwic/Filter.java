package kwic;

import java.util.Vector;

public abstract class Filter implements Runnable {
	public Pipe input;
	public Pipe output;
	
	public void setInput(Pipe pipe) {
		input = pipe;
	}
	
	public void setOutput(Pipe pipe) {
		output = pipe;
	}
	
	public void write(String s) {
		if(s.equals(null) || s == null) {
			output.close();
			return;
		}
		output.write(s);
	}
	
	public void write(Vector<String> s) {
		output.write(s);
	}
	
	public Vector<String> read() {
		return input.read();
	}
}
