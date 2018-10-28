


import javax.swing.*;

import propackage.Card;
import propackage.CardPanel;
import propackage.Deck;

import java.awt.*;
import java.awt.event.*;

/**
 * The main window for dealing from a deck of cards.
 * @author lambertk
 *
 */
public class MainView extends JFrame{

	WarGame game = new WarGame(); 
	
	private Deck new_deck;//this deck is called in the newGame button
	
    public MainView(){
    	//game.deck = deck;
    	//this.new_deck = deck;
    	game.dealCard();
        CardPanel panel1 = new CardPanel();
        CardPanel panel2 = new CardPanel(); 
        JTextArea panelC = new JTextArea();
        panelC.setEditable(false);
        Container pane = getContentPane();
        GridBagConstraints c = new GridBagConstraints();
        
        c.weighty = 2.0;
        //Figure out labels for panels
        /*JLabel player1_label = new JLabel("Player 1");
        c.gridx=0;
        c.gridy=0;
        pane.add(player1_label, c);
        
        JLabel gameStatus_label = new JLabel("Game Status");
        c.gridx=1;
        c.gridy=0;
        pane.add(gameStatus_label, c);
        
        JLabel player2_label = new JLabel("Player 2");
        c.gridx=2;
        c.gridy=0;
        pane.add(player2_label, c);*/
        
        pane.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;

        c.gridx = 0;
        c.gridy = 1;
        pane.add(panel1, c);
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(panelC, c);
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(panel2,c);
        
        c.weighty = -2.0;
        
        JButton deal = new JButton("Deal");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(deal, c);
        
        JButton newGame = new JButton("New Game");        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(newGame, c);
        
        deal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	//System.out.println(game.player1.isDone());
            	System.out.println(game.player1.isDone());
            	if (!(game.player1.isDone())){//this line should be the same as the first line of code in WarGame.step()
            		//AS OF 10/25/2018--3:55 PM: only 1/4 of the deck is given to each player. Meaning that
            		//the game only lasts for 13 rounds...
            		//System.out.println("MainView checks WarGame for deck\n"+game.deck);
            		System.out.println("game player is not done");
            		Card card1 = game.player1.getCard();
    				Card card2 = game.player2.getCard();
    			
    				
                    card1.turn();
                    card2.turn();
                   
                    panel1.setCard(card1);
                    panel2.setCard(card2);
                    
                    if(game.winner()==""){
                    	panelC.setText("");
        			
        				game.stepGUI();//returns the gamestate that should be displayed in the center panel
        				panelC.setText(game.toString());
        				panelC.append(game.winner());
        			}
                }
            }});
        
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            		panelC.setText("");
            		//this line should reset the card panel
            		
            		System.out.println("New Game has been started");
            		game.reset();
            		System.out.println("deck\n"+new_deck);
            		game.dealCard();
            		System.out.println(game.player1.unplayedPile.size());
            		
                }
            });
        
        
    }
}