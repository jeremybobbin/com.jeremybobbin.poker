package models;

import static models.Card.Suit.*;
import static models.Card.Rank.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class HandTest {
  private Player player;

  @Before
  public void setUp() {
    player = new Player(100);
  }

  @Test
  public void rankOccurencesRecognizesFourOfAKind() {
    player.getHand().addCard(new Card(ACE, DIAMONDS));
    player.getHand().addCard(new Card(ACE, CLUBS));
    player.getHand().addCard(new Card(ACE, SPADES));
    player.getHand().addCard(new Card(ACE, HEARTS));
    Map<Integer, Card.Rank> map = player.getHand().rankOccurrences();
    Card.Rank occurances = map.get(4);
    assertEquals(ACE, occurances);
  }

  @Test
  public void suitOccurencesRecognizesFlush() {
    player.getHand().addCard(new Card(ACE, HEARTS));
    player.getHand().addCard(new Card(KING, HEARTS));
    player.getHand().addCard(new Card(QUEEN, HEARTS));
    player.getHand().addCard(new Card(JACK, HEARTS));
    player.getHand().addCard(new Card(TEN, HEARTS));
    Card.Suit occurences = player.getHand().suitOccurences().get(5);
    assertEquals(HEARTS, occurences);
  }
}