package sk.ivankohut.tictactoe;

public class TextWinnerGratulation {

	private static final String DRAW_MESSAGE = "GAME ENDS WITH A DRAW!";
	
	private final TextOutput output;
	private final Game game;

	public TextWinnerGratulation(TextOutput output, Game game) {
		this.output = output;
		this.game = game;
	}

	public void say() {
		output.add(game.winner().map(winner -> "PLAYER " + winner.name() + " WON!").orElse(DRAW_MESSAGE));
	}
}
