/**
 * 
 */
package code;

import javax.swing.JOptionPane;

/**
 * @author Anna Taylor
 *
 */
public class TableTopImpl implements TableTop {
	private Player humanPlayer;
	private Player dealerPlayer; 
	private Deck deck;
        String dealerName = "Malcolm";


	public void prepareTable() { // creates human and dealer players and takes user's name

		String userName = JOptionPane.showInputDialog("Please enter your name: ");
		humanPlayer = new HumanPlayer(userName);
		dealerPlayer = new DealerPlayer(dealerName);
                System.out.println("**************************************************************************************");
                System.out.println("**************************************************************************************");
                System.out.println("******************WELCOME TO ANNA AND GREG'S 5 CARD STUD CHALLENGE********************");
                System.out.println("**************************************************************************************");
                System.out.println("**************************************************************************************");
                System.out.println("");
                System.out.println("");
                pause();
                System.out.println("Hi "+userName+". Hope you're ready to get the cards in the air! Please wait....");
                pause();
                commenceGame();
	}
        
        public void pause() {
            try {
            Thread.sleep(1800);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
        
        public void commenceGame() { // introduction to game and dealer (only at the start)
            
            System.out.println("Executing.....");
            pause();
            System.out.println("Ok let's play 5 Card Stud. If you don't know the rules.....");
            pause();
            System.out.println("You're probably going to lose a lot of money!");
            pause();
            System.out.println("Your dealer today is called " + dealerName + ". He says hello and good luck.");
            pause();
            mainGameCycle();
          
        }
        
        public void mainGameCycle(){
            boolean finished = false;
            while(!finished){
                
                deck = new DeckImpl(); // a new deck object is created at the start of each hand and shuffled
                System.out.println("Ok let's shuffle up and deal!");
                pause();
                System.out.println("shuffling deck....");
                deck.shuffleCards();
                humanPlayer.getHand().clearHand();
                dealerPlayer.getHand().clearHand();
                pause();
                System.out.println("dealing cards....");
                for(int i = 0; i < 5; i++) {
                humanPlayer.receiveCard(deck.popCard());
                dealerPlayer.receiveCard(deck.popCard());
                }
                pause();

                System.out.println("Your hand is: ");
                humanPlayer.getHand().evaluateHand();
                System.out.println(humanPlayer.getHand().displayHand());
                System.out.println("You have: " + humanPlayer.getHand().getHandValue());
                pause();
                pause();
                String x = JOptionPane.showInputDialog("How many cards would you like to discard? [Maximum 3] ");
                int cardsToBin = Integer.parseInt(x);

                while(cardsToBin > 3 || cardsToBin < 0) {
                    System.out.println("You may only enter 0-3 cards to discard, please try again: ");
                    x = JOptionPane.showInputDialog("How many cards would you like to discard? [Maximum 3] ");
                    cardsToBin = Integer.parseInt(x);
                }
                
                int cardsToReplace = cardsToBin;
                
                /**
                 * At this point whilst 'cardsToBin' is still positive, discardCard is called and passed the integer entered by the user. 
                 * The hand is not resorted during this process so that the numbers of the cards does not change during the discard.
                 */
                int cardDis = 0;
                while(cardsToBin > 0) {                    
	                cardDis = Integer.parseInt(JOptionPane.showInputDialog("Which card would you like to discard next? [Enter 1,2,3,4 or 5]"));
	                if(cardDis > 0 && cardDis < 6) {
	                    humanPlayer.getHand().discardCard(cardDis);
	                    cardsToBin--;
	                }
	                else {
	                    System.out.println("You may only enter 1,2,3,4 or 5");
	                }
	            }
                
	            for (int i = cardsToReplace; i > 0;i--) {
	                humanPlayer.receiveCard(deck.popCard());
	            }
                if (cardDis > 0) { //Only print message below if user has opted to swap out cards
                	System.out.println("dealing your replacement cards......");
                }
                pause();
                System.out.println("Your final 5-card hand is: ");
                humanPlayer.getHand().evaluateHand();
                
                System.out.println(humanPlayer.getHand().displayHand());
                System.out.println("You have: " + humanPlayer.getHand().getHandValue());
                pause();
                System.out.println("Finished player discard....computer is thinking");
                pause();
               

                int dealerReplace = dealerPlayer.chooseDiscard();  //the dealer's automated discard decision begins
                for(int i = dealerReplace;i > 0;i--) {
                    dealerPlayer.receiveCard(deck.popCard());
                }
                dealerPlayer.getHand().evaluateHand();
                System.out.println("Malcolm has discarded " +dealerReplace+" cards");
                pause();
                System.out.println("Malcolm has finished changing cards....");
                pause();
                System.out.println("Malcolm has: ");
                System.out.println(dealerPlayer.getHand().displayHand());
                System.out.println("For a: " + dealerPlayer.getHand().getHandValue());
                pause();
                System.out.println("You have: " + humanPlayer.getHand().getHandValue());
                pause();
                compareHands();
                
                String cont = JOptionPane.showInputDialog("Would you like to play another hand? Enter Y to continue or N to exit: ");
                
                if (cont.contains("N")|| cont.equals("n")) {
                    finished = true;
                    System.out.append("Thanks for playing!");
                }
            }
        }
        


        public void compareHands() {
            int comparison = humanPlayer.getHand().compareTo(dealerPlayer.getHand()); //this section compares hands at showdown
                if(comparison > 0) {                                                    //if this value is positive
                    System.out.println("Congratulations! You have won the hand!");      //the first hand is higher in value
                }
                else if(comparison < 0) {                                               // negative indicates a lower value
                    System.out.println("The computer has won the hand! Better luck next time!");
                }
                
                
                
                else if(comparison == 0) { //if the comparison or rank is equal, the hand needs to be compared further
                    if(humanPlayer.getHand().getHandValueScore() == 7 || humanPlayer.getHand().getHandValueScore() == 4) { //represents quads and trips by score
                        if(humanPlayer.getHand().getPairValue() > dealerPlayer.getHand().getPairValue()) {
                        System.out.println("Congratulations! You have won the hand");
                        }
                        else {
                        System.out.println("The computer has won the hand! Better luck next time!"); //there can only be 1 quad or trip hand of any value
                        }                                                                           //and so the winner is clear
                    }
                    else if(humanPlayer.getHand().getHandValueScore() == 2) { //represents one pair
                        if(humanPlayer.getHand().getPairValue() > dealerPlayer.getHand().getPairValue()){
                            System.out.println("Congratulations! You have won the hand");
                        }
                        else if(humanPlayer.getHand().getPairValue() < dealerPlayer.getHand().getPairValue()){
                            System.out.println("The computer has won the hand! Better luck next time!");
                        }
                        else {
                            standardHandComparison(); //equal one pair hands need to call this method to evaluate the rest of the cards in order to establish winner
                        }
                    }
                    else if(humanPlayer.getHand().getHandValueScore() == 3) {  //same applies as above for 2 pair hands 
                        if(humanPlayer.getHand().getPairValue() > dealerPlayer.getHand().getPairValue()){
                            System.out.println("Congratulations! You have won the hand");
                        }
                        else if(humanPlayer.getHand().getPairValue() < dealerPlayer.getHand().getPairValue()){
                            System.out.println("The computer has won the hand! Better luck next time!");
                        }
                        else if(humanPlayer.getHand().getLowerPairValue() > dealerPlayer.getHand().getLowerPairValue()) { //two pair hands also include this method
                            System.out.println("Congratulations! You have won the hand");                                   //to compare the lower pair when higher pair is equal in rank
                        }
                        else if(humanPlayer.getHand().getLowerPairValue() < dealerPlayer.getHand().getLowerPairValue()){
                            System.out.println("The computer has won the hand! Better luck next time!");
                        }
                        else {
                            standardHandComparison();
                        }
                    }
                }
        }
                   
        
        
        public void standardHandComparison() {  //this method is for comparing hands that have equal rank value and cannot be distinguished by pair valuing.
                for(int i = 4; i >= 0 ; i--) {
                            int humanDraw = humanPlayer.getHand().getContents()[i].getRankValue();
                            int compDraw = dealerPlayer.getHand().getContents()[i].getRankValue();
                            if(humanDraw > compDraw) {
                                System.out.println("Congratulations! You have won the hand");
                                break;
                            }
                            else if(compDraw > humanDraw) {
                                System.out.println("The computer has won the hand! Better luck next time!");
                                break;
                            }
                            if(i == 0 && compDraw == humanDraw) {
                                System.out.println("The hand is a draw! Please play again.");
                            }      
                        }
        
    }
	public static void main(String[] args) {

		TableTopImpl test = new TableTopImpl();
		test.prepareTable();

	}
}
