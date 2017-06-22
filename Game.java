//********************************************************************
//  
//  Game.java       Author: Christine Chong cc4190
//
//  For staring game and checking hand
//********************************************************************

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Game {
	
	private Player p;
	private Deck deck;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private Boolean forTest = false;
    private String[] inputHand;
    private ValidateString s;
    private ValidateString in;
    private Boolean changed = false;
    private Scanner input;
    // Constructor for Testing     
	public Game(String[] testHand){
        deck = new Deck();
        inputHand = testHand;	
        forTest = true;
	}
    
    // Constructor for Regular Play
    public Game(){
        deck = new Deck();
        for(int i=0; i<5; i++){
            hand.add(deck.deal());
        }
        p = new Player(hand, 0.0, 777.7 );      
	}
    
    //  Play Method
	public void play(){
        if(forTest == true){
            ValidateString s = new ValidateString(inputHand);  
            //  Hand Validation System       
            if(s.checkLength() == true && s.checkRepeat() == true){
                System.out.println("Valid Hand");
                handHandler(inputHand);
                System.out.println(""+checkHand(hand)); 
                System.out.println("Game Over! Thanks for playing");                                           
            }else{
                System.out.println("Not a Valid Hand");
            }            
        }else if (changed == false){     
            printHand(hand);
            handChanger(hand);
                
        }else{
           p.bets();   
           printHand(hand);
           sort();
           System.out.println(""+checkHand(hand)); 
           if(p.getBankroll() != 0){
               playAgain();
           }else{
               System.out.println("Game Over! Thanks for playing");                
           }
                       
        }
        
	}
    
    // This method checks if the user would like their hand to be changed.     
    public void handChanger(ArrayList<Card> hand){
        System.out.println("Would you like to Change Your Hand? 1 for Yes 0 for No");
        input = new Scanner(System.in);
        if(input.hasNextInt()){
            int change = input.nextInt();
            if(change == 1){
                changed = true;
                checkChangeHand(hand);
                play();  
            }else if (change ==0){
                changed = true;
                play();    
            }else{
                System.out.println("Please put in a proper input");
                handChanger(hand);
            }    
        }else{
            System.out.println("Please put in a proper input");
            handChanger(hand);
        }


    }
    
    // This methods checks the player requests for removing and adding cards
    public void checkChangeHand(ArrayList<Card> hand){
        System.out.println("Please input the card numbers you would" + 
                           " like to change. \n Please split each digit with a comma. "+
                           "\n Please do not enter any spaces. \n"+
                           "The First Card has the number 0. \n The Fifth Card has the number 4.");
        input = new Scanner(System.in);
        String cardSwitchString = input.nextLine();
        ValidateString in = new ValidateString(cardSwitchString);
        if(in.checkAlpha() == true){
            System.out.println("Please put in a valid input");
            checkChangeHand(hand);
        }else{
            changeHand(hand, cardSwitchString);
        }
      
    }
    
    // This method removes and adds the cards that the player requests for    
    public void changeHand(ArrayList<Card> hand, String cardSwitchString){
         String[] cardSwitchArrString = cardSwitchString.split(",");
        ArrayList<Card> cardSwitchArrInt = new ArrayList<Card>();
        for(int i=0; i<cardSwitchArrString.length; i++){
            int index = Integer.parseInt(cardSwitchArrString[i]);
            cardSwitchArrInt.add(hand.get(index));
        }
        
        for(int i=0; i<cardSwitchArrInt.size();i++){
            Card remove = cardSwitchArrInt.get(i);
            p.removeCard(remove);
            p.addCard(deck.deal());
        }        
    }
    // Outputs what is in the hand that was drawn
    public void printHand(ArrayList<Card> hand){
        System.out.println("Your hand currently is : ");
        for(int i = 0; i< hand.size(); i++){
            int suit = hand.get(i).getSuit();
            int rank = hand.get(i).getRank();
            if(suit == 1){
                if(rank <10 && rank != 1){
                    System.out.println(rank+" of Spades");  
                }else if (rank == 1){
                    System.out.println("Ace of Spades");
                }else if(rank > 9){
                    if(rank == 10){
                        System.out.println("10 of Spades");
                    }else if(rank == 11){
                        System.out.println("Jack of Spades"); 
                    }else if(rank == 12){
                        System.out.println("Queen of Spades");
                    }else if(rank == 13){
                        System.out.println("King of Spades"); 
                    }else{
                        System.out.println("Not a Valid Card");
                    }
                }else{
                    System.out.println("Not a Valid Card");
                }    

            }else if(suit == 2){
                if(rank <10 && rank != 1){
                    System.out.println(rank+" of Hearts");  
                }else if (rank == 1){
                    System.out.println("Ace of Hearts");
                }else if(rank > 9){
                    if(rank == 10){
                        System.out.println("10 of Hearts");
                    }else if(rank == 11){
                        System.out.println("Jack of Hearts"); 
                    }else if(rank == 12){
                        System.out.println("Queen of Hearts");
                    }else if(rank == 13){
                        System.out.println("King of Hearts"); 
                    }else{
                        System.out.println("Not a Valid Card");
                    }
                }else{
                    System.out.println("Not a Valid Card");
                }  
            }else if (suit == 3){
                if(rank <10 && rank != 1){
                    System.out.println(rank+" of Diamonds");  
                }else if (rank == 1){
                    System.out.println("Ace of Diamonds");
                }else if(rank > 9){
                    if(rank == 10){
                        System.out.println("10 of Diamonds");
                    }else if(rank == 11){
                        System.out.println("Jack of Diamonds"); 
                    }else if(rank == 12){
                        System.out.println("Queen of Diamonds");
                    }else if(rank == 13){
                        System.out.println("King of Diamonds"); 
                    }else{
                        System.out.println("Not a Valid Card");
                    }
                }else{
                    System.out.println("Not a Valid Card");
                }                
            }else if (suit == 4){
                if(rank <10 && rank != 1){
                    System.out.println(rank+" of Clubs");  
                }else if (rank == 1){
                    System.out.println("Ace of Clubs");
                }else if(rank > 9){
                    if(rank == 10){
                        System.out.println("10 of Clubs");
                    }else if(rank == 11){
                        System.out.println("Jack of Clubs"); 
                    }else if(rank == 12){
                        System.out.println("Queen of Clubs");
                    }else if(rank == 13){
                        System.out.println("King of Clubs"); 
                    }else{
                        System.out.println("Not a Valid Card");
                    }
                }else{
                    System.out.println("Not a Valid Card");
                }                  
            }else{
                System.out.println("Not a Valid Card");
            }            
        }
    }
    // Outputs what is in the hand that was typed in and sends it to the next method	
    public void handHandler(String[] testHand){
        String[] inputHand = testHand;
        for (int i=0; i<inputHand.length; i++){
            String input = inputHand[i];
            int max = input.length();
            if(input.charAt(0) == 's'){
                if(max==2 && input.charAt(1) != '1'){
                    System.out.println(input.charAt(1)+" of Spades");  
                    int value = Character.getNumericValue(input.charAt(1));
                    Card c = new Card(1, value);
                    hand.add(c);
                }else if (max==2 && input.charAt(1) == '1'){
                    System.out.println("Ace of Spades");
                    Card c = new Card(1, 1);
                    hand.add(c);
                }else if(max==3){
                    if(input.charAt(2)=='0'){
                        System.out.println("10 of Spades");
                        Card c = new Card(1, 10);
                        hand.add(c);
                    }else if(input.charAt(2)=='1'){
                        System.out.println("Jack of Spades"); 
                        Card c = new Card(1, 11);
                        hand.add(c);
                    }else if(input.charAt(2)=='2'){
                        System.out.println("Queen of Spades");
                        Card c = new Card(1, 12);
                        hand.add(c);
                    }else if(input.charAt(2)=='3'){
                        System.out.println("King of Spades"); 
                        Card c = new Card(1, 13);
                        hand.add(c);
                    }else{
                        System.out.println("Not a Valid Card");
                    }
                }else{
                    System.out.println("Not a Valid Card");
                }    

            }else if(input.charAt(0)=='h'){
                if(max==2 && input.charAt(1) != '1'){
                    System.out.println(input.charAt(1)+" of Hearts"); 
                    int value = Character.getNumericValue(input.charAt(1));
                    Card c = new Card(2, value);
                    hand.add(c);
                }else if (max==2 && input.charAt(1) == '1'){
                    System.out.println("Ace of Hearts");
                    Card c = new Card(2, 1);
                    hand.add(c);
                }else if(max==3){
                    if(input.charAt(2)=='0'){
                        System.out.println("10 of Hearts");
                        Card c = new Card(2, 10);
                        hand.add(c);
                    }else if(input.charAt(2)=='1'){
                        System.out.println("Jack of Hearts"); 
                        Card c = new Card(2, 11);
                        hand.add(c);
                    }else if(input.charAt(2)=='2'){
                        System.out.println("Queen of Hearts");
                        Card c = new Card(2, 12);
                        hand.add(c);
                    }else if(input.charAt(2)=='3'){
                        System.out.println("King of Hearts");
                        Card c = new Card(2, 13);
                        hand.add(c);
                    }else{
                        System.out.println("Not a Valid Card");
                    }
                }else{
                    System.out.println("Not a Valid Card");
                }  
            }else if (input.charAt(0)=='d'){
                if(max==2 && input.charAt(1) != '1'){
                    System.out.println(input.charAt(1)+" of Diamonds");     
                    int value = Character.getNumericValue(input.charAt(1));
                    Card c = new Card(3, value);
                    hand.add(c); 
                }else if (max==2 && input.charAt(1) == '1'){
                    System.out.println("Ace of Diamonds");
                    Card c = new Card(3, 1);
                    hand.add(c);
                }else if(max==3){
                    if(input.charAt(2)=='0'){
                        System.out.println("10 of Diamonds");
                        Card c = new Card(3, 10);
                        hand.add(c);
                    }else if(input.charAt(2)=='1'){
                        System.out.println("Jack of Diamonds");  
                        Card c = new Card(3, 11);
                        hand.add(c);
                    }else if(input.charAt(2)=='2'){
                        System.out.println("Queen of Diamonds"); 
                        Card c = new Card(3, 12);
                        hand.add(c);
                    }else if(input.charAt(2)=='3'){
                        System.out.println("King of Diamonds");
                        Card c = new Card(3, 13);
                        hand.add(c);
                    }else{
                        System.out.println("Not a Valid Card");
                    }
                }else{
                    System.out.println("Not a Valid Card");
                }                  
            }else if (input.charAt(0)=='c'){
                if(max==2 && input.charAt(1) != '1'){
                    System.out.println(input.charAt(1)+" of Clubs"); 
                    int value = Character.getNumericValue(input.charAt(1));
                    Card c = new Card(4, value);
                    hand.add(c);
                }else if (max==2 && input.charAt(1) == '1'){
                    System.out.println("Ace of Clubs");
                    Card c = new Card(4, 1);
                    hand.add(c);
                }else if(max==3){
                    if(input.charAt(2)=='0'){
                        System.out.println("10 of Clubs");
                        Card c = new Card(4, 10);
                        hand.add(c);
                    }else if(input.charAt(2)=='1'){
                        System.out.println("Jack of Clubs"); 
                        Card c = new Card(4, 11);
                        hand.add(c);
                    }else if(input.charAt(2)=='2'){
                        System.out.println("Queen of Clubs"); 
                        Card c = new Card(4, 12);
                        hand.add(c);
                    }else if(input.charAt(2)=='3'){
                        System.out.println("King of Clubs"); 
                        Card c = new Card(4, 13);
                        hand.add(c);
                    }else{
                        System.out.println("Not a Valid Card");
                    }
                }else{
                    System.out.println("Not a Valid Card");
                }                  
            }else{
                System.out.println("Not a Valid Card");
            }
    
        }		
        sort();        
    }
    
    // Sorts the Hand     
    public void sort(){
        Collections.sort(hand);
    }
    
    // This Scores the Hand     
	public String checkHand(ArrayList<Card> hand){
		String string = "";
        int max = hand.size();
        boolean royalFlush = false, straightFlush = false, fourOfAKind = false,
        fullHouse = false, flush = false, straight = false,
        threeOfAKind = false, twoPair = false, pair = false;
       
        for(int i=0; i<max; i++){
            // Flush Check           
            if(i<1 && hand.get(i).getSuit() == hand.get(i+1).getSuit() 
               && hand.get(i).getSuit() == hand.get(i+2).getSuit() 
               && hand.get(i).getSuit() == hand.get(i+3).getSuit() 
               && hand.get(i).getSuit() == hand.get(i+4).getSuit()){
                flush = true;
            }
            // Straight Check         
            if(i<1 && hand.get(i+4).getRank()-hand.get(i).getRank() == 4 
               || i<1 && hand.get(i).getRank() == 1 && hand.get(i+4).getRank() == 13
               && hand.get(i+4).getRank() - hand.get(i+1).getRank() == 3){
                straight = true;
            }
            // Royal Flush Check            
            if (i<1  && straight == true && flush == true
                && hand.get(i).getRank() == 1 
                && hand.get(i+4).getRank() == 13){
                royalFlush = true;
            }
            // Straight Flush Check             
            straightFlush = straight && flush;
            // Four of a Kind Check     
            if(i<1 && hand.get(i).getRank() == hand.get(i+1).getRank()
              && hand.get(i).getRank() == hand.get(i+2).getRank()
              && hand.get(i).getRank() == hand.get(i+3).getRank() 
              ||i>3 && hand.get(i).getRank() == hand.get(i-1).getRank()
              && hand.get(i).getRank() == hand.get(i-2).getRank()
              && hand.get(i).getRank() == hand.get(i-3).getRank()){
                fourOfAKind = true;
            }
            // Three of a Kind Check          
            if(fourOfAKind == false && i<2 && hand.get(i).getRank() == hand.get(i+1).getRank()
              && hand.get(i).getRank() == hand.get(i+2).getRank() 
              ||fourOfAKind == false && i>2 && hand.get(i).getRank() == hand.get(i-1).getRank()
              && hand.get(i).getRank() == hand.get(i-2).getRank() ){
                threeOfAKind = true;
            }
            // Pair Check             
            if(fourOfAKind == false && i<4 && hand.get(i).getRank() == hand.get(i+1).getRank() ||
              fourOfAKind == false  && i>0 && hand.get(i).getRank() == hand.get(i-1).getRank() ){
                pair = true;
            }
            // Two Pair Check            
            if(pair == true && i<4 && hand.get(i).getRank() == hand.get(i+1).getRank() ||
              pair == true && i>0 && hand.get(i).getRank() == hand.get(i-1).getRank() ){
                twoPair = true;
            }
            fullHouse = threeOfAKind && pair;
        }
        if(forTest == false){
            if(royalFlush){
                p.winnings(250);
                double bankroll = p.getBankroll();
                return "Royal Flush!! \n Super Congrats you have "+bankroll+" $.";
            }
            if(straightFlush){
                p.winnings(50);
                double bankroll = p.getBankroll();
                return "Straight Flush \n Congrats you have "+bankroll+" $.";
            }
            if(fourOfAKind){
                p.winnings(25);
                double bankroll = p.getBankroll();
                return "Four of a Kind \n Congrats you have "+bankroll+" $.";
            }
            if(fullHouse){
                p.winnings(6);
                double bankroll = p.getBankroll();
                return "Full House \n Congrats you have "+bankroll+" $.";
            }
            if(flush){
                p.winnings(5);
                double bankroll = p.getBankroll();
                return "Flush \n Congrats you have "+bankroll+" $.";
            }
            if(straight){
                p.winnings(4);
                double bankroll = p.getBankroll();
                return "Straight \n Congrats you have "+bankroll+" $.";
            }
            if(threeOfAKind){
                p.winnings(3);
                double bankroll = p.getBankroll();
                return "Three of a Kind \n Congrats you have "+bankroll+" $.";
            }
            if(twoPair){
                p.winnings(2);
                double bankroll = p.getBankroll();
                return "Two Pair \n Congrats you have "+bankroll+" $.";
            }
            if(pair){
                p.winnings(1);
                double bankroll = p.getBankroll();
                return "Pair \n Congrats you have "+bankroll+" $.";
            }
            else{
                p.winnings(0);
                double bankroll = p.getBankroll();
                return "Boo you have "+bankroll+" $.";
            }            
        }else{
            if(royalFlush){
                return "Royal Flush!!";
            }
            if(straightFlush){
                return "Straight Flush";
            }
            if(fourOfAKind){
                return "Four of a Kind";
            }
            if(fullHouse){
                return "Full House";
            }
            if(flush){
                return "Flush";
            }
            if(straight){
                return "Straight";
            }
            if(threeOfAKind){
                return "Three of a Kind";
            }
            if(twoPair){
                return "Two Pair";
            }
            if(pair){
                return "Pair";
            }
            else{
                return "Not a Winner";
            }             
        }		
	}
    
    // This Method is to see if the player wants to continue
    public void playAgain(){
        System.out.println("Do you wish to continue? 1 for Yes 0 for No");
        Scanner continput = new Scanner(System.in);
        if(continput.hasNextInt()){
            int cont = continput.nextInt();
            if(cont == 1){
                reset();
                play();
            }else if (cont == 0){
                System.out.println("Game Over! Thanks for playing"); 
                double currentbankroll = p.getBankroll();
                System.out.println("You ended with "+ currentbankroll + " $");
            }else{
                System.out.println("Please put in a proper input");
                playAgain();
            }    
        }else{
            System.out.println("Please put in a proper input");
            playAgain();        
        }
    }
    
    // This Method is to reset some values  
    public void reset(){
        deck = new Deck();
        hand = new ArrayList<Card>();
        for(int i=0; i<5; i++){
            hand.add(deck.deal());
        }        
        double currentbank = p.getBankroll();
        p.newHand(hand, 0.0, currentbank);
        forTest = false;
        inputHand = new String[5];
        changed = false;       
    }

}
