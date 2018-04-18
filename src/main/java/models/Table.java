package models;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Table {
  private Set<Player> players;
  private int pot;
  private Deck deck;
  private int cardsPerPlayer;

  public Table(int playerCount) {
    deck = new Deck();
    players = new HashSet<>();
    addPlayers(playerCount);
  }

  private void addPlayers(int playerCount) {
    for (int i = 0; i < playerCount; i++) {
      players.add(new Player(100));
    }
  }

  public void addMoney(int money) {
    pot += money;
  }

  public void deal() {
    int cardsToBeDealt = 1;
    switch (cardsPerPlayer) {
      case 0 : cardsToBeDealt = 2;
      break;
      case 2 : cardsToBeDealt = 3;
      break;
      case 7 : cardsToBeDealt = 0;
      break;
    }
    for (int i = 0; i < cardsToBeDealt; i++) {
      for (Player player : players) {
        Hand hand = player.getHand();
        hand.addCard(deck.pick());
        cardsPerPlayer++;
      }
    }
  }

  public void play() {
    long playersWithMoney = players.stream()
        .filter(player -> player.getStack() > 0)
        .count();
    while (playersWithMoney >= 2) {
      iterate();
    }
  }

  private List<Player> getActivePlayers() {
    return players.stream()
        .filter(Player::isActive)
        .collect(Collectors.toList());
  }

  private void iterate() {
    players.forEach(Player::resetPotShare);
    while (getActivePlayers().size() >= 2) {
      deal();
      do {
        List<Player> activePlayers = getActivePlayers();
        activePlayers.stream()
            .filter(Player::isAllIn)
            .forEach(this::promptPlayer);
      } while (playersStillOwe());
    }
  }

  private boolean playersStillOwe() {
    return players.stream()
        .anyMatch(player -> player.getCostToPlay() > 0);
  }


  private void costToPlay(Player player) {
    int highestPotShare = players.stream()
        .map(Player::getStack)
        .collect(Collectors.summarizingInt(Integer::intValue))
        .getMax();
    player.setCostToPlay(highestPotShare - player.getStack());
  }

  private void promptPlayer(Player player) {
    costToPlay(player);
    //User interface goes here
    if (player.isAllIn()) {
      return;
    }
    String uiResponse = "";
    switch (uiResponse) {
      case "fold":
        player.setActive(false);
        break;
      case "call":
        player.charge(0);
        break;
      default:
        int betAmount = Integer.parseInt(uiResponse);
        player.charge(betAmount);
        break;
    }
  }
}
