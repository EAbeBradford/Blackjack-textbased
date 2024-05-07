import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {
        Casino cs = new Casino();
    }
    public Card[] deck = new Card[52];
    public Player user;
    public Player dealer;
    public int numCardsPlayed = 0;
    public boolean isUserBust;
    public boolean isDealerBust;
    public  Casino(){
        makeDeck();
       // printDeck();
        shuffle();
      //  System.out.println("shuffled");
      //  printDeck();
        user = new Player();
        dealer = new Player();
        dealer.isDealer = true;
        dealer.name = "Dealer";
        deal();
        user.print();
        System.out.println();
        dealer.print();

        System.out.println("Welcome to Mx. Bradford's Casino");
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What is your name?");

        String userName = scan.nextLine();  // Read user input
        //System.out.println("Username is: " + userName);  // Output user input

        user.name = userName;
        System.out.println();
        dealer.print();
        System.out.println();

        user.print();
        while(user.isStay==false && user.valueOfHand<=21) {

            System.out.println("Do you want to hit (h) or stay (s)?");
            String isHit = scan.nextLine();  // Read user input
            if (isHit.equals("s")) {
                stay();
            } else {
                userHit();
            }
        }





    }

    public  void makeDeck(){
        int loc = 0;
        for(int s = 0; s<4; s++){
            for (int t = 1; t <14; t++){
                deck[loc] = new Card(s, t);
                loc++;
            }
        }
    }

    public void printDeck(){
        for(int c = 0; c< deck.length; c++){
            System.out.print(c +": ");
            deck[c].print();
        }
    }

    public void shuffle(){
        for(int c = 0; c< deck.length; c++){
            int rand = (int)(Math.random()*52);

            Card temp = deck[rand];
            deck[rand] = deck[c];
            deck[c] = temp;

        }
    }

    public void deal(){

        user.addCard(deck[0]);
        deck[0].isPlayed = true;
        dealer.addCard(deck[1]);
        deck[1].isPlayed = true;

        user.addCard(deck[2]);
        deck[2].isPlayed = true;

        dealer.addCard(deck[3]);
        deck[3].isPlayed = true;
        numCardsPlayed = 4;
    }

    public void dealerHit(){
        while(dealer.valueOfHand<17){
            dealer.addCard(deck[numCardsPlayed]);
            deck[numCardsPlayed].isPlayed = true;
        }
        checkWinner();
    }
    public void userHit(){
        System.out.println("You chose to hit");
        System.out.println();
        user.isHit = true;
        user.isStay = false;
        user.addCard(deck[numCardsPlayed]);
        deck[numCardsPlayed].isPlayed = true;
        numCardsPlayed++;
        user.print();
        checkBust();
    }
    public void stay(){
        System.out.println("You chose to stay");
        user.isHit = false;
        user.isStay = true;
        dealerHit();
    }

    public void checkBust(){
        if(user.valueOfHand> 21){
            System.out.println("You BUST!!");
            isUserBust = true;
            checkWinner();
        }

    }

    public void checkWinner(){

        dealer.revealCards = true;
        dealer.print();
        System.out.println();
        user.print();
        System.out.println();
        System.out.println("the winner is....");

        if(dealer.valueOfHand>21){
            System.out.println("dealer BUST!");
            isDealerBust = true;
        }

        if(isUserBust && isDealerBust){
            System.out.println("no one wins");
        } else if(isUserBust){
            System.out.println("Dealer wins!");

        } else if(isDealerBust){
            System.out.println(user.name + " wins!");
        } else if(dealer.valueOfHand> user.valueOfHand){
            System.out.println("Dealer wins!");
        } else if(dealer.valueOfHand< user.valueOfHand){
            System.out.println(user.name + " wins!");

        } else{
            System.out.println("TIE!");
        }




    }

}
