package sk.ivankohut.tictactoe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ConstantPlayer implements Player {

	private final Character name;
	private final Queue<Integer> moves;

	public ConstantPlayer(Character name, Integer ... moves) {
		this.name = name;
		this.moves = new LinkedList<>(Arrays.asList(moves));
	}
	
	public ConstantPlayer(Integer ... moves) {
		this('N', moves);
	}

	@Override
	public Character name() {
		return name;
	}
	
	@Override
	public Integer move() {
		return moves.poll();
	}
}
