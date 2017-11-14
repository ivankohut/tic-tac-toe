package sk.ivankohut.tictactoe;

import java.io.PrintStream;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class PrintStreamTextOutputTest {
	@Test
	public void writesLineToUnderlyingStream() throws Exception {
		PrintStream printStream = mock(PrintStream.class);
		PrintStreamTextOutput sut = new PrintStreamTextOutput(printStream);
		String line = "anyString";
		// exercise
		sut.add(line);
		// verify
		verify(printStream).println(line);
	}
}
