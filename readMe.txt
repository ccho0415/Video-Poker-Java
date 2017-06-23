//********************************************************************
//  
// Read Me       Author: Christine Chong cc4190
//
// For Clarifying Any of the Code Written and Explaining Design
//*********************************************************************


Poker Design:
    A lot of the design was dictated by what we went over in class. 
        1. Array Lists
            - A manageable way to keep track of decks and card hands
        2. Popping the Stack for Dealing the Deck
            - Taking the top off of each stack and dealing that to the player
            - Increment the top number
        3. Comparable
            - Allows for the Collections.sort() method
        4. Collections.sort()
            - Allows for easy sorting of a hand
        5. Compare To
            - Allows for the Collections.sort() method
        6. Straight Method
            - Looking at the first and last indexes and checking the range
        7. Shuffle Method
            - Using the Collections.shuffle() method
        8. Card Constructor
            - Needs Suit and Value
        9. Test Hand
            - To see if card hand checker works.
    Card Class
        I used the given code.
    Deck Class
        I used the given code
        Custom Method:
            Printing the Deck. (This is only for testing purposes).
    Game Class
        Create 2 Seperate Paths (the paths are seperated by the forTest value)
            1. Testing Path
                a. Set Constructor
                b. Set forTest to True
                c. Check for Valid input
                d. Check the Hand
                e. End Game
            2. Play Path
                a. Set Constructor
                    - New deck
                    - Deal that deck
                    - New player object
                b. Check if this is the Test Path
                c. Print the Hand
                    A bunch of If statements
                d. Ask if they want to change the hand
                    Yes -> Change
                        Check for the right inputs
                        Change the hand
                        Go back to play Set Changed to true
                    No -> go back to play set changed to true
                c. Once Changed is true Ask for Bets.
                    Use the bets method in player class
                d. Print the Current Hand
                e. Sort that Hand.
                    Use Collections.sort
                f. Check the Hand
                    A bunch of If statements
                        Flush - if all the cards equal suits to the first card
                        Straight - if all the cards are increments of 1 from the first card )
                                            (Special Exception for Royals)
                        Royal Flush - if flush == T straight == T and first rank is ace and last rank is king
                        Straight Flush - if straight == T and flush == T
                        Four of a Kind - check if the first or the last is equal to the 3 cards next to it
                        Three of a Kind - check if  there is no four of a kind and check the two cards next to the current index
                        Pair - check if four of a kind is false and check the card next to it
                        Two Pair - check if you have a pair. If you have another pair you are good to go!
                        Full House- Check if there is a three of a kind and pair
                        Go from Top to Bottom and Check for the highest value
                            Use the winnings method to pay out.
                            Get the new Bank Roll
                            Print Out
                g. Ask for Play Again (If they have money) We don't accept broke people here.
                    Ask for Continue
                        Reset if Yes
                            Get a New Deck
                            Get a new Hand
                            Deal that new hand
                            Get the current bankroll
                            set a new player class
                            Set the forTest to false
                            Set input Hand to a new String
                            set changed to false
                        End if No
    Player Class
        I used the given code
        I wrote a new Hand method for the reset.
        
Validate String
    2 Constructors
        One for String Array
        One for String
    Check Length
        Make sure the inputted hand length is 5
    Check Repeat
        Make sure there are no repeating cards
    Check for Alphabet Letters
        Make sure the input matches the numbers 0-4 and is seperated by commas
    Check Array
        Make sure for each index that the element matches a numerical value.
               
Array Methods:
    A lot of the design was dictated by previous knowledge about Arrays. 
        1. Swap First and Last
            Index the first as 0
            Index the last as the length of the list - 1 (Because the first index is 0)
            Exchange Indicies
        2. Shift Element to Right
            Save the last index into temp.
            From the last index, copy over the earlier index into the last index.
            Set the first index as the last index.
        3. Replace Even
            Find the elements where element % 2 is 0
            Replace those elements with 0s.
        4. Replace Middle
            Between the first and last element check the left side of the element (i-1) and the 
            right side of the element (i+1). Replace the current element with the bigger element
        5. Remove the Middle
            Recopy the array into a new array without the middle elements (Excluding them in
            the for loop boundaries.). Then use Arrays.copyOf to set the values array as this new array.
        6. Move Evens
            If the value is even
            Set it as the max in the second for loop
            and starting from this value and incrementing down, exchange it with the previous element
            increase an increment. (the location index after where all current even numbers are located).
        7. Second Largest
            Run through a loop
            if the current value is bigger than the largest.
            Set the value of second largest as the current largest.
            Set the value of largest as the current value.
            If the current value is larger than second largest.
            Set the value of second largest as largest.
        8. Sorted Increasing
            Check through the loop. If the i+1 is not bigger than i, return false
            Otherwise return true.
        9. Adjacent Dupes.
            For the values between index 1 and max. Check if the left and right side are equal to i.
            If yes (at least once) return true.
            Else Return false.
        10. Contains Dupes
            Check if there is a duplicate between 2 for loops.
            If there is then return true.
            Else Return false.

        