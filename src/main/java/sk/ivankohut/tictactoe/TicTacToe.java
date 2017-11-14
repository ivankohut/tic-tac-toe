package sk.ivankohut.tictactoe;

public class TicTacToe {

	private final TextOutput output;

	public TicTacToe(TextOutput output) {
		this.output = output;
	}

	public void play() {
		output.add("Game Board Creation...");
		output.add(" | | ");
		output.add("-+-+-");
		output.add(" | | ");
		output.add("-+-+-");
		output.add(" | | ");
		output.add("");
		output.add("Board Created.");
		output.add("The game will start with player X");
	}
}
