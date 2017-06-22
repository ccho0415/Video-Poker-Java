//********************************************************************
//  
//  Player.java       Author: Christine Chong cc4190
//
//  For keeping track of player stats
//********************************************************************

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player {
	
		
	private ArrayList<Card> hand = new ArrayList<Card>(); // the player's cards
	private double bankroll;
    private double bet;
    private Scanner input;

// A Constructor Method		
	public Player(ArrayList<Card> hand, double bet, double bankroll){		
	    this.hand = hand;
        this.bet = bet;
        this.bankroll = bankroll;
	}
    
// A Method for Adding Cards
	public void addCard(Card c){
        hand.add(c); 
	}

//  A Method for Removing Cards
	public void removeCard(Card c){
	   hand.remove(c);
    }

//  A Method for Making Bets
    public void bets(){
        bankroll = getBankroll();
        System.out.println("You have "+ bankroll + " $"); 
        System.out.println("Please enter the amount of money you are willing to bet");
        input = new Scanner(System.in);
        if(input.hasNextDouble()){
            bet = input.nextDouble();
            if(bet !=0 && bet <= bankroll && bet >0){
                System.out.println("You are betting "+ bet +" $");
                bankroll = bankroll - bet;
                bankroll = Math.round(bankroll * 100);
                bankroll = bankroll/100;
                System.out.println("You have "+ bankroll + " $ left");
            }else{
                System.out.println("Please put in a proper input");
                bets();                
            }
        }else{
            System.out.println("Please put in a proper input");
            bets();
        }
    }

//  A Method to Increase BankRoll When Winning
    public void winnings(double odds){
        bankroll = bankroll + bet*odds;
    }
    
// A Method to get Bet Number
    public double getBet(){
        return bet;
    }
    
// A Method to get BankRoll
    public double getBankroll(){
        return bankroll;
    }
    
// A Method for a New Hand    
    public void newHand(ArrayList<Card> hand, double newbet, double newbankroll){
        this.hand = hand;
        bet = newbet;
        bankroll = newbankroll;
    }
}


