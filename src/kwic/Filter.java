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
	
	public void write(Vector<String> s) {
		output.write(s);
	}
	
	public Vector<String> read() {
		return input.read();
	}
}
