package kwic;

import java.util.Vector;

public class Pipe {
	private Vector<String> buf; 
	
	public Pipe() {
		buf = new Vector<String>();
	}
	
	public void write(Vector<String> s) {
			buf.addAll(s);
	}
	
	public Vector<String> read() {
		while(buf.isEmpty()) {
			try {
				Thread.sleep(10);
			} catch(Exception e){
				 System.err.println(e.getMessage());
			}
		}  
			return buf;
	}
}
