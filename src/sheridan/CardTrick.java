/*
 * @modifier=Javnika Patel
 * StudentNumber: 991600462 
 */
package sheridan;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author javni
 * Added Lucky card logic to replace Guess card on 2021-02-09 as per the item 7 in the requirement
 */

public class CardTrick 
{
           /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        // Create an array to hold 7 cards
        Card[] hand = new Card[7];
        
        //System.out.println("Hand Size: " + hand.length);

        // We'll use Random to generate random numbers
        Random random = new Random();

        for (int i = 0; i < hand.length; i++) 
        {
            int value = random.nextInt(13) + 1;
            String suit = Card.SUITS[random.nextInt(4)];

            Card card = new Card();
            hand[i] = card;
            
            hand[i].setSuit(suit);
            hand[i].setValue(value);           
            
        }

        // print them out for debugging purposes
        System.out.println("Here are the cards in the hand");
        for (Card card : hand) {
            System.out.printf("%d of %s\n", card.getValue(), card.getSuit());
        }
               
        //Step 6 in the assigment - create luckyCard card object       
        Card luckyCard = new Card();
        luckyCard.setSuit("Diamonds");
        luckyCard.setValue(1);       

        
//        Commented based on requirement 7
//        // Now ask the user for a card
//        System.out.println("Pick a suit for your card");
//        for (int i = 0; i < Card.SUITS.length; i++) {
//            System.out.println((i + 1) + ": " + Card.SUITS[i]);
//        }
//        String suit = input.next();
//
//        System.out.println("Enter a value (1 to 13)");
//        int value = input.nextInt();
//
//        //Card userGuess = new Card(value, Card.SUITS[suit - 1]);
//        Card userGuess = new Card();
//        userGuess.setSuit(suit);
//        userGuess.setValue(value);

        boolean match = false;
        for (Card card : hand) {
            if (card.getValue() == luckyCard.getValue()
                    && card.getSuit().equals(luckyCard.getSuit())) {
                match = true;
                break;
            }
        }
    
        //String response = match ? "Right guess": "No match";
        String response = match ? "Winner! matched your lucky card.": "Loser, try agian.";
        
        System.out.println(response);
               
        
    }
    
}
