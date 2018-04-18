import java.util.List;
import java.util.Set;
import models.Card;
import models.Card.Rank;
import models.Card.Suit;
import models.Deck;
import models.Player;
import models.Table;

public class Poker {
  public static void main(String[] args) {
//    Card card = new Card(Rank.TWO, Suit.SPADES);
    Table table = new Table(2);
    System.out.println("Now playing.");
    table.play();
  }
}
