package models;
import models.Card.*;

import static models.Card.Suit.values;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    return cards.remove(0);
  }

  public List<Card> getCards() {
    return cards;
  }

  private void shuffle() {
    Collections.shuffle(cards);
  }


}
