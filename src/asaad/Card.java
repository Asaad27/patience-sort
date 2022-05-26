package asaad;

public class Card {
	public final int num;
	public Card previous = null;

	public Card(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "{" + num + "}";
	}
}
