package sk.ivankohut.tictactoe;

import java.util.Arrays;

/**
 * Program entry point.
 * There are no unit (meaningless) nor end-to-end (out of the scope) tests for this class.
 */
public class Main {
	public static void main(String[] args) {
		PrintStreamTextOutput output = new PrintStreamTextOutput(System.out);
		Integer secondsToThink = 2;
		new TextWinnerGratulation(
				output,
				new TicTacToeGame(
					new ArrayListBoard(Arrays.asList(
							Arrays.asList(1, 4, 7),
							Arrays.asList(2, 5, 8),
							Arrays.asList(3, 6, 9),
							Arrays.asList(1, 2, 3),
							Arrays.asList(5, 5, 6),
							Arrays.asList(7, 8, 9),
							Arrays.asList(1, 5, 9),
							Arrays.asList(3, 5, 7)
					)),
					new ThinkingPlayer(secondsToThink, new ConstantPlayer('X', 1, 3, 4)),
					new ThinkingPlayer(secondsToThink, new ConstantPlayer('O', 9, 8, 7)),
					output
				)
		)
		.say();
	}
}
