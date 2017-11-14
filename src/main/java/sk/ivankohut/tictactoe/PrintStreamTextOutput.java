package sk.ivankohut.tictactoe;

import java.io.PrintStream;

public class PrintStreamTextOutput implements TextOutput {

	private final PrintStream printStream;

	public PrintStreamTextOutput(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void add(String line) {
		printStream.println(line);
	}
}
