//********************************************************************
//  
//  Card.java       Author: Christine Chong cc4190
//
//  For creating, sorting and returning values of Cards
//********************************************************************

public class Card implements Comparable<Card>{
	
	private int suit;
	private int rank;

//  A constructor for Card
	public Card(int s, int r){
		suit = s;
        rank = r;
	}

//  A sort for Comparing Cards
	public int compareTo(Card c){
        if(this.getRank()>c.getRank()){
            return 1;
        }else if(this.getRank()<c.getRank()){
            return -1;
        }else{
            return 0;
        }

	}
    
// 	Returning the String Value of the Card
	public String toString(){
		return "Suit: "+suit+" Rank: "+ rank;
	}
    
// Return the value of the rank.
    public int getRank(){
        return rank;
    }
    
// Return the value of the suit
    public int getSuit(){
        return suit;
    }    
}
