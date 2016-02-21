package kwic;

import java.util.Vector;

public class Pipe {
	private Vector<String> buf; 
	private boolean open; 
	
	public Pipe() {
		buf = new Vector<String>();
		open = true;
	}
	
	public void write(String s) {
		if(!open) {
			return;
		} else {
			buf.add(s);
		}
	}
	
	public void write(Vector<String> s) {
		if(!open) {
			return;
		} else {
			buf.addAll(s);
		}
	}
	
	public Vector<String> read() {
		while(buf.isEmpty()) {
			if(!open) {
				return null;
			}
			try {
				Thread.sleep(10);
			} catch(Exception e){
				 System.err.println(e.getMessage());
			}
		}  
			return buf;
	}
	
	public void close() {
		open = false;
	}
}
