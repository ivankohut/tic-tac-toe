package sk.ivankohut.tictactoe;

/**
 * Program entry point.
 * There are no unit (meaningless) nor end-to-end (out of the scope) tests for this class.
 */
public class Main {
	public static void main(String[] args) {
		new TicTacToe(
				new PrintStreamTextOutput(System.out)
		)
		.play();
	}
}
