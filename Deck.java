//********************************************************************
//  
//  Deck.java       Author: Christine Chong cc4190
//
//  For creating, shuffling and dealing a deck of cards
//********************************************************************

import java.util.ArrayList;
import java.util.Collections;
public class Deck {
	
	private ArrayList<Card> cards;
	private int top = -1; // the index of the top of the deck

// A constructor for Deck    
	public Deck(){
        cards = new ArrayList<Card>();
        for(int s=1; s<5; s++){
            for(int r=1; r<14; r++){
                Card c = new Card(s, r);
                cards.add(c);
            }
        }           
        shuffle();

	}

// A method to shuffle the cards on the Deck    
	public void shuffle(){
		Collections.shuffle(cards);
	}

// A method to deal the top card of the deck
	public Card deal(){
        top++;    
		return cards.get(top);

	}

// A method to print out all the entire deck (this is good for testing)
    public void getDeck(){
        System.out.println(""+cards);
    }


}
