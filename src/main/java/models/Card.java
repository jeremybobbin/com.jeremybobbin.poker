package models;

public class Card {
  public enum Rank{TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
    NINE, TEN, JACK, QUEEN, KING, ACE}
  public enum Suit{SPADES, CLUBS, HEARTS, DIAMONDS}

  private final Suit suit;
  private final Rank rank;

  public Card(Rank rank, Suit suit) {
      this.rank = rank;
      this.suit = suit;
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    String rankName = rank.toString().charAt(0) + rank.toString().substring(1).toLowerCase();
    String suitName = suit.toString().charAt(0) + suit.toString().substring(1).toLowerCase();

    return String.format("%s of %s", rankName, suitName);
  }
}
