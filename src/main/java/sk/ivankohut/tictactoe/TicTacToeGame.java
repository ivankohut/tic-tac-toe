package sk.ivankohut.tictactoe;

import java.util.Optional;

public class TicTacToeGame implements Game {

	private final Board board;
	private final Player player1;
	private final Player player2;
	private final TextOutput output;
	private Player activePlayer;
	
	public TicTacToeGame(Board board, Player player1, Player player2, TextOutput output) {
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
		activePlayer = player1;
		this.output = output; 
	}

	@Override
	public Optional<Player> winner() {
		output.add("Game Board Creation...");
		board.print(output);
		output.add("Board Created.");
		output.add("The game will start with player " + activePlayer.name());
		while (board.isMovePossible()) {
			Optional<Player> maybeWinner = board.winner();
			if (maybeWinner.isPresent()) {
				return maybeWinner;
			}
			board.set(activePlayer.move(), activePlayer);
			output.add("Player " + activePlayer.name());
			board.print(output);
			activePlayer = (activePlayer == player1) ? player2 : player1;
		}
		return Optional.empty();
	}

}
