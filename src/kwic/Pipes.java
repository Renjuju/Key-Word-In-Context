package kwic;

public class Pipes implements Runnable{
	private Filter[] filters;
	
	public Pipes(Filter ... filters) {
		this.filters = filters;
		
		for(int i = 0; i < filters.length - 1; i++) {
			Pipe pipe = new Pipe();
			filters[i].setOutput(pipe);
			filters[i+1].setInput(pipe);
		}
	}

	@Override
	public void run() {
		for(Filter f : filters) {
			(new Thread(f)).start();
		}
	}
}
