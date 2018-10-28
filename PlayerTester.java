import java.util.*;
import javax.swing.*;
import propackage.*;


public class PlayerTester{

	public static void main(String[] args){

		Player player = new Player();
		Card card = new Card(Suit.spade, 5);
		Card card2 = new Card (Suit.spade, 9);

		Deck deck = new Deck();
		System.out.println(deck);

		System.out.println("\nTest addtoWinningsPile:");
		System.out.println("Before:");
		System.out.println(player.winningsPile);
		player.addtoWinningsPile(card);
		player.addtoWinningsPile(card2);
		System.out.println("After:");
		System.out.println(player.winningsPile);

		System.out.println("\nTest addtoUnplayedPile:");
		System.out.println("Before:");
		System.out.println(player.unplayedPile);
		player.addtoUnplayedPile(card);
		player.addtoUnplayedPile(card2);
		System.out.println("After:");
		System.out.println(player.unplayedPile);

		System.out.println("\nTest toString:");
		System.out.println(player.toString());

		System.out.println("\nTest toStringUnplayed:");
		System.out.println(player.toStringUnplayed());

		System.out.println("\nTest getCard:");
		while (! player.isDone())
			System.out.println(player.getCard());

		System.out.println("\nTest isDone:");
		System.out.println(player.isDone());

		System.out.println("\nTest winningsCount:");
		System.out.println(player.winningsCount());


	}
}
