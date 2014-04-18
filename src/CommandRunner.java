import java.io.*;
import java.util.zip.DataFormatException;

public class CommandRunner {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
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
                switch (commandLine[0]){
                    case "push":
                        myStack.push(Integer.parseInt(commandLine[1]));
                        break;
                    case "pop":
                        output.write("Pop - " + myStack.pop() + LINE_SEPARATOR);
                        break;
                    case "peek":
                        output.write("Peek - " + myStack.peek() + LINE_SEPARATOR);
                        break;
                    case "isEmpty":
                        output.write("Is empty - " + myStack.isEmpty() + LINE_SEPARATOR);
                        break;
                    case "size":
                        output.write("Size - " + myStack.size() + LINE_SEPARATOR);
                        break;
                    case "toString":
                        output.write("Stack - " + myStack.toString() + LINE_SEPARATOR);
                        break;
                    case "clear":
                        break;
                    default:
                        throw new DataFormatException("unknown command " + commandLine[0]);
                }
            }
        } catch (Exception e) {
            System.err.print(e);
        } finally {
            if (output != null) output.close();
            if (input != null) input.close();
        }
    }
}
