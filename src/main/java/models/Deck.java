package models;
import models.Card.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Deck {
  private List<Card> cards;

  public Deck() {
    cards = new ArrayList<>();
    for(Suit suit : Suit.values()) {
      for(Rank rank : Rank.values()) {
        cards.add(new Card(rank, suit));
      }
    }
    shuffle();
  }

  public Card pick() {
    Card card =  cards.remove(0);
    System.out.println("Now removing: " + card);
    return card;
  }

  public List<Card> getCards() {
    return cards;
  }

  private void shuffle() {
    Collections.shuffle(cards);
  }


}
