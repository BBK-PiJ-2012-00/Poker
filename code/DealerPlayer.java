/**
 * 
 */
package code;

/**
*
* @author gmarsh03
*/
public class DealerPlayer implements Player {
   
   private String dealerName;
   private Hand hand = new FiveCardHand();
   
   
   public DealerPlayer(String name) {
       this.dealerName = name;
   
   }
   
   
   @Override
	public void receiveCard(Card c) {
		hand.addCard(c);
	}
   
   
   @Override
   public Hand getHand() {
       return hand;
   }
   
   
   public int chooseDiscard() {
       
        int cardsChanged = 0;
        hand.evaluateHand();
        if(hand.getHandValue() == "Four of a Kind" || hand.getHandValue() == "Straight" || hand.getHandValue() == "Flush") {
            System.out.println("Malcolm doesn't look like he's discarding any cards!");
        }        
        
        else if (hand.getHandValue().equals("Three of a Kind")) {  // hand class returns handValue and for three of a kind 
                if (hand.getProcessingValue() == 1) {      //will return a 'processing value depending on the location of the trips in the hand
                    hand.discardCard(3);                   // 1: first three, 2: second 3, 3: third three
                    hand.discardCard(4);
                    cardsChanged = 2;
                }
                else if(hand.getProcessingValue() == 2) {
                    hand.discardCard(0);
                    hand.discardCard(4);
                    cardsChanged = 2;
                }
                else {
                    hand.discardCard(0);
                    hand.discardCard(1);
                    cardsChanged = 2;
                }
                
            }
        
        
        else if (hand.getHandValue().equals("Two Pair")) {
            if (hand.getProcessingValue() == 1) {          // processing values for 2 pair where P = paired card are 
                hand.discardCard(4);                       // 1: PPPPX, 2: PPXPP, 3: XPPPP.
                cardsChanged = 1;
            }
            else if (hand.getProcessingValue() == 2) {
                hand.discardCard(2);
                cardsChanged = 1;
            }
            else {
                hand.discardCard(0);
                cardsChanged = 1;
            }
   
           }
        
        
        else if (hand.getHandValue().equals("One Pair")) {  //processing values for 1 pair hands where P = paired card are
            if (hand.getProcessingValue() ==  1) {      // 1: PPXXX, 2: XPPXX, 3: XXPPX, 4: XXXPP
                hand.discardCard(2);
                hand.discardCard(3);
                hand.discardCard(4);
                cardsChanged = 3;
            }
            else if(hand.getProcessingValue() == 2) {
                hand.discardCard(0);
                hand.discardCard(3);
                hand.discardCard(4);
                cardsChanged = 3;
            }
            else if(hand.getProcessingValue() == 3) {
                hand.discardCard(0);
                hand.discardCard(1);
                hand.discardCard(4);
                cardsChanged = 3;
            }
            else {
                hand.discardCard(0);
                hand.discardCard(1);
                hand.discardCard(2);
                cardsChanged = 3;
            }
        }
        
        
        else if(hand.getProcessingValue() == 0) { // this is for non-made hands (eg high card)
            int spades = 0;                        // the first part of the section is to establish 
            int hearts = 0;                        // if the dealer should draw to a flush
            int clubs = 0;
            int diamonds = 0;
            for(int i = 4; i > -1; i--) {
                if(hand.getContents()[i].getSuit() == Suit.CLUBS ) {
                    clubs++;
                }
                else if(hand.getContents()[i].getSuit() == Suit.SPADES ) {
                    spades++;
                }
                 else if(hand.getContents()[i].getSuit() == Suit.DIAMONDS ) {
                    diamonds++;
                }
                 else if(hand.getContents()[i].getSuit() == Suit.HEARTS ) {
                    hearts++;
                }
                
            }
            if(spades == 4) {
                for(int i = 0; i < 4; i++) {
                    if(hand.getContents()[i].getSuit() != Suit.SPADES) {
                        hand.discardCard(i);
                        cardsChanged = 1;
                        break;
                    }
                }
                
            }
            if(diamonds == 4) {
                for(int i = 0; i < 4; i++) {
                    if(hand.getContents()[i].getSuit() != Suit.DIAMONDS) {
                        hand.discardCard(i);
                        cardsChanged = 1;
                        break;
                    }
                }
            }
            if(hearts == 4) {
                for(int i = 0; i < 4; i++) {
                    if(hand.getContents()[i].getSuit() != Suit.HEARTS) {
                        hand.discardCard(i);
                        cardsChanged = 1;
                        break;
                    }
                }
            }
            if(clubs == 4) {
                for(int i = 0; i < 4; i++) {
                    if(hand.getContents()[i].getSuit() != Suit.CLUBS) {
                        hand.discardCard(i);
                        cardsChanged = 1;
                        break;
                    }
                }
            }
       
       }
        
        
        else if(hand.getProcessingValue() == 0) { //this section tests to see if the first four or
            boolean lowStrDraw = true;             // last four cards are in sequence to decide whether to draw to a straight
            for (int i = 0; i < 3; i++) {
			if (hand.getContents()[i].getRankValue() != (hand.getContents()[i+1].getRankValue() - 1)) {
				lowStrDraw = false;
			}
		}
            if(lowStrDraw) {
                hand.discardCard(4);
                cardsChanged = 1;
            boolean highStrDraw = true;
            for (int i = 0; i < 3; i++) {
			if (hand.getContents()[i].getRankValue() != (hand.getContents()[i+1].getRankValue() - 1)) {
				highStrDraw = false;
			}
		}
            if(highStrDraw) {
                hand.discardCard(0);
                cardsChanged = 1;

               }
            
            }     
       }
        
        
        else { //this section discards the 3 lowest cards if they are below ten
            
            if(hand.getContents()[2].getRankValue() < 10) { 
            hand.discardCard(0);
            hand.discardCard(1);
            hand.discardCard(2);
            cardsChanged = 3;
           }
            else{
                hand.discardCard(0);   //or the 2 lowest if all 3 are not lower than ten
                hand.discardCard(1);
                cardsChanged = 2;
            }
        }
        
        
        return cardsChanged;
        
            
   }


	@Override
	public String getName() {
		return dealerName;
	}
}