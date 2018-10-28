package propackage;

import java.util.*;
import javax.swing.*;

public class Player{
	public List<Card> winningsPile;
  public List<Card> unplayedPile;

	public Player(){
		winningsPile = new ArrayList<Card>();
		unplayedPile = new ArrayList<Card>();
	}

  public String toString(){
    String winningsCurrent = "";
    for (Card c : winningsPile)
      winningsCurrent += c + "\n";
    return winningsCurrent;
  }

	public String toStringUnplayed(){
    String unplayedCurrent = "";
    for (Card c : unplayedPile)
      unplayedCurrent += c + "\n";
    return unplayedCurrent;
  }

  public void addtoUnplayedPile(Card card){
    unplayedPile.add(card);
  }

  public void addtoWinningsPile(Card card){
    winningsPile.add(card);
  }

  public Card getCard(){
		Card card = unplayedPile.get(0);
		unplayedPile.remove(0);
		return card;
  }

  public boolean isDone(){
    return unplayedPile.size() == 0;

  }
  public int winningsCount(){
    return winningsPile.size();
  }


  }
