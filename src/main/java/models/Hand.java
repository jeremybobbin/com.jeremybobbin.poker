package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Hand {
  List<Card> cards;
  int Rank;

  public Hand() {
    cards = new ArrayList<>();
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public Card cardAt(int index) {
    return cards.get(index);
  }

  public int getRank() {
    return Rank;
  }
}
