/* File: terminalTester.java
 * Authors: Mickie Brown, Coletta Fuller, Alexander Caines, Mohini Tangri, Rohan Jairam
 * A terminal-based tester application for the top-level model class WarGame.
 */
import propackage.*;
import java.util.*;
import javax.swing.*;

public class terminaltester{

  public static void main(String[] args){
	  WarGame test = new WarGame();
		test.dealCard();
		//Deck deck = test.getDeck();
		//System.out.println(test.getDeck());
		// Player player1 = new Player();
		// Player player2 = new Player();
		// System.out.println("Player1");
		// player1.toStringUnplayed();
		// System.out.println("Player2");
		// player2.toStringUnplayed();
		String input = "next";
		while(input.equals("next")){
			System.out.println("Type 'close' to exit the game, type 'next' to run another round:");
			Scanner scan = new Scanner(System.in);
			input = scan.nextLine();
			if(test.winner()==""){
				// System.out.println(test.toString());
				test.stepTUI();
				System.out.println(test.toString());
				System.out.println(test.winner());
			}
		}


		}

}
