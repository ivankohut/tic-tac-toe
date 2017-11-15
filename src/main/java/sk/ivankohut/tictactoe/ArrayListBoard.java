package sk.ivankohut.tictactoe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ArrayListBoard implements Board {

	private final Collection<List<Integer>> winningLines; 
	private final List<Player> fields = new ArrayList<>(Collections.nCopies(9, (Player)null));
	
	public ArrayListBoard(Collection<List<Integer>> winningLines) {
		this.winningLines = winningLines;
	}

	@Override
	public Optional<Player> winner() {
		return winningLines.stream()
				.map(line -> lineWinner(line.get(0), line.get(1), line.get(2)))
				.filter(Optional::isPresent)
				.findFirst()
				.flatMap(Function.identity());
	}

	private Optional<Player> lineWinner(Integer field1, Integer field2, Integer field3) {
		Player firstField = fields.get(field1 - 1);
		if (firstField != null && firstField == fields.get(field2 - 1) && firstField == fields.get(field3 - 1)) {
			return Optional.of(firstField);
		} else {
			return Optional.empty();
		}
	}
		
	@Override
	public void set(Integer position, Player player) {
		fields.set(position - 1, player);
	}

	@Override
	public Boolean isMovePossible() {
		return fields.contains(null);
	}

	@Override
	public void print(TextOutput output) {
		String horizontalDelimiter = "-+-+-";
		output.add(printLine(1));
		output.add(horizontalDelimiter);
		output.add(printLine(2));
		output.add(horizontalDelimiter);
		output.add(printLine(3));
		output.add("");
	}

	private String printLine(int lineNumber) {
		Integer initialIndex = (lineNumber - 1) * 3; 
		return nameOfPlayerInField(initialIndex) + "|" + nameOfPlayerInField(initialIndex + 1) + "|" + nameOfPlayerInField(initialIndex + 2);
	}

	private Character nameOfPlayerInField(int index) {
		Player player = fields.get(index);
		return player != null ? player.name() : ' ';
	}
}
