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
                System.out.println("*********Hi " + userName + ". Welcome to Anna and Greg's 5 Card Stud Challenge********");
                String begin = JOptionPane.showInputDialog("Please enter any key to launch a game: ");
                
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
            System.out.println("you're going to lose a lot of money!");
            pause();
            System.out.println("Your dealer today is called " + dealerName + ". He says hello and good luck.");
            pause();
            mainGameCycle();
          
        }
        
        public void mainGameCycle(){
            boolean finished = false;
            while(!finished){
                
                deck = new DeckImpl(); // a new deck object is created at the start of each hand and shuffled
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
                while(cardsToBin > 0) {
                    int cardDis;
                    cardDis = Integer.parseInt(JOptionPane.showInputDialog("Which card would you like to discard next? [Enter 1,2,3,4 or 5]"));
                    if(cardDis > 0 && cardDis < 6) {
                        humanPlayer.getHand().discardCard(cardDis);
                        cardsToBin--;
                    }
                    else {
                        System.out.println("You may only enter 1,2,3,4 or 5");
                    }

                }

                for (int i = cardsToReplace; i > 0;i--)
                {
                    humanPlayer.receiveCard(deck.popCard());
                }
                System.out.println("dealing your replacement cards......");
                pause();
                System.out.println("Your final 5-card hand is: "); 
                humanPlayer.getHand().evaluateHand();
                
                System.out.println(humanPlayer.getHand().displayHand());
                System.out.println("You have: " + humanPlayer.getHand().getHandValue());
                pause();
                System.out.println("Finished player discard....computer is thinking");
                pause();
                
                System.out.println("Malcolm has finished changing cards....");

                int dealerReplace = dealerPlayer.chooseDiscard();  //the dealer's automated discard decision begins
                for(int i = dealerReplace;i > 0;i--) {
                    dealerPlayer.receiveCard(deck.popCard());
                }
                System.out.println("Malcolm has: ");
                System.out.println(dealerPlayer.getHand().displayHand());
                System.out.println("For a: " + dealerPlayer.getHand().getHandValue());
                System.out.println("You have: " + humanPlayer.getHand().getHandValue());
                compareHands();
                
                String cont = JOptionPane.showInputDialog("Would you like to play another hand? Enter Y to continue or N to exit: ");
                
                if (cont == "N" || cont == "n") {
                    finished = true;
                    System.out.append("Thanks for playing!");
                }
            }
        }
        


        public void compareHands() {
            int comparison = humanPlayer.getHand().compareTo(dealerPlayer.getHand()); //this section compares hands at showdown
                if(comparison > 0) {
                    System.out.println("Congratulations! You have won the hand!");
                }
                else if(comparison < 0) {
                    System.out.println("The computer has won the hand! Better luck next time!");
                }
                else if(comparison == 0) {
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
        }
    
	public static void main(String[] args) {

		TableTopImpl test = new TableTopImpl();
		test.prepareTable();

	}
}
