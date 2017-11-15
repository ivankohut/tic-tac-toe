package sk.ivankohut.tictactoe;

public interface Board extends Game {

	void set(Integer position, Player player);

	Boolean isMovePossible();

	void print(TextOutput output);

}
