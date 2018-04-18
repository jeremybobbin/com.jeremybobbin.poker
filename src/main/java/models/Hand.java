package models;

import static java.lang.StrictMath.toIntExact;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hand {
  private List<Card> cards;
  private int handRank;


  public Hand() {
    cards = new ArrayList<>();
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public Card cardAt(int index) {
    return cards.get(index);
  }

  public Map<Integer, Card.Rank> rankOccurrences() {
    Map<Integer, Card.Rank> rankToOcc = new HashMap<>();
        cards.stream()
        .collect(groupingBy(Card::getRank, Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
        .forEach((r, l) -> rankToOcc.put(toIntExact(l), r));
    return rankToOcc;
  }

  public Map<Integer, Card.Suit> suitOccurences() {
    Map<Integer, Card.Suit> suitToOcc = new HashMap<>();
    cards.stream()
        .collect(groupingBy(Card::getSuit, Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
        .forEach((s, l) -> suitToOcc.put(toIntExact(l), s));
    return suitToOcc;
  }

}
