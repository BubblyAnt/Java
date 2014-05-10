package test;

import static org.junit.Assert.*;

import java.util.zip.DataFormatException;

import main.ArrayStack;
import main.CommandRunner;

import org.junit.Before;
import org.junit.Test;

public class TestCommandRunner {
	ArrayStack<Integer> myStack;
	
	@Before
	public void beforeEveryTest() {
		myStack = new ArrayStack<Integer>();	
	}
	
	@Before
	public void afterEveryTest() {
		myStack = null;		
	}
	
	@Test
	public void pushCommandProceed() throws DataFormatException{
		String inputData = "push 12";
		String result = CommandRunner.proceed(inputData.split(" "), myStack);
		assertEquals(Integer.valueOf(12), myStack.peek());
		assertEquals(true, result == null);
	}
	
	@Test
	public void peekCommandProceed() throws DataFormatException{		
		CommandRunner.proceed("push 12".split(" "), myStack);
		String inputData = "peek";
		String result = CommandRunner.proceed(inputData.split(" "), myStack);	
		assertEquals("Peek - 12", result);
	}
	
	@Test
	public void isEmptyCommandProceed() throws DataFormatException{		
		String inputData = "isEmpty";
		String result = CommandRunner.proceed(inputData.split(" "), myStack);	
		assertEquals("Is empty - true", result);
		
		CommandRunner.proceed("push 12".split(" "), myStack);		
		result = CommandRunner.proceed(inputData.split(" "), myStack);	
		assertEquals("Is empty - false", result);
	}
	
	@Test
	public void popCommandProceed() throws DataFormatException{		
		CommandRunner.proceed("push 12".split(" "), myStack);
		String inputData = "pop";
		String result = CommandRunner.proceed(inputData.split(" "), myStack);	
		assertEquals("Pop - 12", result);			
		assertEquals(true, myStack.isEmpty());
	}
	
	@Test
	public void sizeCommandProceed() throws DataFormatException{				
		String inputData = "size";
		String result = CommandRunner.proceed(inputData.split(" "), myStack);	
		assertEquals("Size - 0", result);	
		
		CommandRunner.proceed("push 12".split(" "), myStack);	
		CommandRunner.proceed("push 10".split(" "), myStack);	
		result = CommandRunner.proceed(inputData.split(" "), myStack);	
		assertEquals("Size - 2", result);	
		
		CommandRunner.proceed("pop".split(" "), myStack);	
		result = CommandRunner.proceed(inputData.split(" "), myStack);	
		assertEquals("Size - 1", result);
	}

}
