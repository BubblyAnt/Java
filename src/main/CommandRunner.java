package main;

import java.io.*;
import java.util.zip.DataFormatException;

public class CommandRunner {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) {
        BufferedReader input = null;
        BufferedWriter output = null;
        try {
            if (args.length < 2) throw new DataFormatException("There are no file names in command line args");
            input = new BufferedReader(new FileReader(args[0]));
            output = new BufferedWriter(new FileWriter(args[1]));
            ArrayStack<Integer> myStack = new ArrayStack<Integer>();
            while (input.ready()) {
            	String s = input.readLine();
                if (s.isEmpty()) throw new DataFormatException("Empty command");
                String[] commandLine = s.split(" ");
                output.write("Command - " + s + LINE_SEPARATOR);
                String result = proceed(commandLine, myStack); 
                if (result != null) output.write(result + LINE_SEPARATOR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null) output.close();
            } catch (Exception e) {
                System.err.print(e);
            }
            try {
                if (input != null) input.close();
            } catch (Exception e) {
                System.err.print(e);
            }
        }
}
    
    public static String proceed(String[] commandLine, ArrayStack<Integer> myStack) throws DataFormatException {
    	String result = null;  
    	switch (commandLine[0]){
        case "push":
            myStack.push(Integer.parseInt(commandLine[1]));
            break;
        case "pop":
            result = "Pop - " + myStack.pop();
            break;
        case "peek":
        	result = "Peek - " + myStack.peek();
            break;
        case "isEmpty":
        	result = "Is empty - " + myStack.isEmpty();
            break;
        case "size":
        	result = "Size - " + myStack.size();
            break;
        case "toString":
        	result = "Stack - " + myStack.toString();
            break;
        case "clear":
            break;
        default:
            throw new DataFormatException("unknown command " + commandLine[0]);
    	}
		return result;
    }
}
