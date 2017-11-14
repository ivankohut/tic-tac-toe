package sk.ivankohut.tictactoe;

import java.util.Collection;

public class CollectionTextOutput implements TextOutput {

	private final Collection<String> collection;

	public CollectionTextOutput(Collection<String> collection) {
		this.collection = collection;
	}

	@Override
	public void add(String line) {
		collection.add(line);
	}
}
