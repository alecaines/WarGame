import java.util.*;
import javax.swing.*;
import propackage.*;


public class WarGame{

	public List<Card> warPile;
	Player player1;
	Player player2;
	Deck deck;
	String gameState;
	String player1_status;
	String player2_status;
	int count1;
	int count2;
	int roundCount;
	String winner = "";
	


	public WarGame(){
		player1 = new Player();
		player2 = new Player();
		deck = new Deck();
		
		
		gameState = "";
		warPile = new ArrayList<Card>();
		count1 = player1.winningsCount();
		count2 = player2.winningsCount();
		player1_status = "";
		player2_status = "";
		roundCount =0;
		deck.shuffle();
		//System.out.println("WarGame checks for Deck here\n"+deck);
	}
	
	public void reset() {
		
		player1 = new Player();
		player2 = new Player();
		deck = new Deck();
		
		
		gameState = "";
		warPile = new ArrayList<Card>();
		count1 = player1.winningsCount();
		count2 = player2.winningsCount();
		player1_status = "";
		player2_status = "";
		roundCount =0;
		deck.shuffle();
	}
	public Deck getDeck(){
		return deck;
	}

	public Player getPlayer1(){
		return player1;
	}

	public Player getPlayer2(){
		return player2;
	}

	public String toString(){
    return gameState;
	}

	public void dealCard(){
		System.out.println("dealCard() has been hit");
		System.out.println(deck);
		while (!(deck.isEmpty())){

			player1.addtoUnplayedPile(deck.deal());
			player2.addtoUnplayedPile(deck.deal());
		}
	}
	
	public String stepGUI(){//SHOULD THIS RETURN THE TWO CARDS
		if(!(player1.isDone())){
				roundCount+=1;
				Card card1 = player1.getCard();
				Card card2 = player2.getCard();

				warPile.add(card1);
				warPile.add(card2);

				player1_status = "Player 1: " + "\n" + "Current Card: " + card1.toString()+"\n"+
				"Unplayed pile: " + player1.unplayedPile.size() + "\n"+
				"Winnings pile: " + player1.winningsPile.size()+"\n";

				player2_status = "Player 2: " + "\n" + "Current Card: " + card1.toString()+"\n"+
				"Unplayed pile: " + player2.unplayedPile.size() + "\n"+
				"Winnings pile: " + player2.winningsPile.size()+"\n";

				gameState = ("\nROUND "+roundCount+"\n"+player1_status + "\n"+player2_status);

				if (card1.getRank() == card2.getRank()){
					gameState+= ("\nNo round winner. Cards added to War pile\n");
				}
				else if (card1.getRank() > card2.getRank()){
					gameState+= ("\nPlayer 1 wins this round! Cards added to Player 1's Winnings Pile\n");
					transferCards(player1);
				}
				else if (card1.getRank() < card2.getRank()){
					gameState+= ("\nPlayer 2 wins this round! Cards added to Player 2's Winnings Pile\n");
					transferCards(player2);
				}
			}

		return gameState;
		}
	
	public String stepTUI(){//SHOULD THIS RETURN THE TWO CARDS
		if(!(player1.isDone())){
				roundCount+=1;
				Card card1 = player1.getCard();
				Card card2 = player2.getCard();

				warPile.add(card1);
				warPile.add(card2);

				player1_status = "Player 1: " + "\n" + "Current Card: " + card1.toString()+"\n"+
				"Unplayed pile: " + player1.unplayedPile.size() + "\n"+
				"Winnings pile: " + player1.winningsPile.size()+"\n";

				player2_status = "Player 2: " + "\n" + "Current Card: " + card1.toString()+"\n"+
				"Unplayed pile: " + player2.unplayedPile.size() + "\n"+
				"Winnings pile: " + player2.winningsPile.size()+"\n";

				gameState += ("\nROUND "+roundCount+"\n"+player1_status + "\n"+player2_status);

				if (card1.getRank() == card2.getRank()){
					gameState+= ("\nNo round winner. Cards added to War pile\n");
				}
				else if (card1.getRank() > card2.getRank()){
					gameState+= ("\nPlayer 1 wins this round! Cards added to Player 1's Winnings Pile\n");
					transferCards(player1);
				}
				else if (card1.getRank() < card2.getRank()){
					gameState+= ("\nPlayer 2 wins this round! Cards added to Player 2's Winnings Pile\n");
					transferCards(player2);
				}
			}

		return gameState;
		}

	public void transferCards(Player player){
		if(!(player.unplayedPile.size() == 0)){
			Card card = player.unplayedPile.get(0);
			while (warPile.size()>0)
				player.addtoWinningsPile(warPile.remove(0));
			}
		}

	public String winner(){

		if (player1.isDone()||player2.isDone()){
			if (count1 > count2){
				winner+=Integer.toString(count1);
			}
			else if (count1 < count2){
				winner+=Integer.toString(count2);
			}
			else{
				winner+=("It's a tie!");
			}
		}
		return winner;
	}

}
