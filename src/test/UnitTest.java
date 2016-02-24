package test;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kwic.AlphabetizerFilter;
import kwic.CircularShifterFilter;
import kwic.Filter;
import kwic.InputFilter;
import kwic.OutputFilter;
import kwic.Pipe;
import kwic.Pipes;


public class UnitTest {

	@Test
	public void checkAlphabetizerDoesntThrowError() {
		try {
			new Pipes(new AlphabetizerFilter()).run();;
		} catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void checkCircularShifterDoesNotErrorOut() {
		try {
			new Pipes(new CircularShifterFilter()).run();;
		} catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void checkForPipeLeaks() {
		try {
			Pipe myPipe = new Pipe();
			Vector<String> string = new Vector<String>();
			myPipe.write(string);	
		} catch(Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	public void multiplePipesDontThrowErrors() {
		try {
			new Pipes(new AlphabetizerFilter(),
					  new AlphabetizerFilter(),
					  new AlphabetizerFilter(),
					  new AlphabetizerFilter()).run();;
		} catch(Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	@Test
	public void checkPipeForValidOutput() {
		try {
			InputMock input = new InputMock();
			OutputMock output = new OutputMock();
			new Pipes(input, new CircularShifterFilter(), new AlphabetizerFilter(), output).run();
		} catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
//	mocking the input
	class InputMock extends Filter {

		@Override
		public void run() {
			Vector<String> textInput = new Vector<String>();
			textInput.add("What is gooder than god,");
			textInput.add("more evil than the devil,");
			textInput.add("the rich need it,");
			textInput.add("and if you eat it you will die?");
			write(textInput);
		}
		
	}
	
	class OutputMock extends Filter {
		public int sizeOfOutput = 0;
		@Override
		public void run() {
		Vector<String> output = read();	
			for(String s : output) {
				System.out.println(s);
			}
			sizeOfOutput = output.size();
			System.out.println(sizeOfOutput);
		}
		
		public int getSize() {
			return sizeOfOutput;
		}
	}
}
