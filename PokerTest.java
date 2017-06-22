//********************************************************************
//  
//  Deck.java       Author: Christine Chong cc4190
//
//  For creating, shuffling and dealing a deck of cards
//********************************************************************

public class PokerTest{

    //this class must remain unchanged
    //your code must work with this test class
 
    public static void main(String[] args){
        if (args.length<1){
            Game g = new Game();
            g.play();
        }
        else{
            Game g = new Game(args);
            g.play();
        }
    }

}
