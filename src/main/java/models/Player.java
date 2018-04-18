package models;

import java.util.Arrays;

public class Player {
  private boolean isActive;
  private Hand hand;
  private int stack;
  private boolean hasDealerButton;
  private int potShare;
  private int costToPlay;

  public boolean isAllIn() {
    return isAllIn;
  }

  private boolean isAllIn;

  public Player(int stack) {
    this.stack = stack;
  }

  public boolean hasDealerButton() {
    return hasDealerButton;
  }

  public void toggleDealerButton() {
    hasDealerButton = !hasDealerButton;
  }

  public void setActive(boolean v) {
    isActive = v;
  }

  public int getStack() {
    return stack;
  }

  public boolean isActive() {
    return isActive;
  }

  public void resetPotShare() {
    potShare = 0;
  }

  public Hand getHand() {
    return hand;
  }

  public void setCostToPlay(int costToPlay) {
    this.costToPlay = costToPlay;
  }

  public int getCostToPlay() {
    return costToPlay;
  }

  public void charge(int amount) {
    amount += costToPlay;
    if (amount >= stack) {
      potShare += stack;
      stack = 0;
      isAllIn = true;
    } else {
      stack -= amount;
      potShare += amount;
    }
  }

  @Override
  public String toString() {
//    if (!isActive) {
//      return " is sitting out.";
//    }
    return "Player is in with a " + hand.cardAt(0) +
        " and a " + hand.cardAt(1) +
        " with " + stack +
        " in the bank.";
  }
}
