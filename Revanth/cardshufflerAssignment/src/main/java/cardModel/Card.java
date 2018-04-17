package cardModel;

public class Card {

	private Suits suite;

	private Rank rank;

	public Card(Suits s, Rank r) {
		this.suite = s;
		this.rank = r;
	}

	public Suits getSuite() {
		return suite;
	}

	public void setSuite(Suits suite) {
		this.suite = suite;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Card [" + suite + ", " + rank + "]";
	}

}
