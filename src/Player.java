public class Player {
    //current value of cards
    public int valueOfHand;

    // hand - what cards you have

    public Card[] hand;

    //name of player
    public String name;

    // is dealer or player
    public boolean isDealer;

    // choose to hit
    public boolean isHit;

    // choose to stay
    public boolean isStay;

    public int numCards;
    public boolean revealCards;

    public Player(){
        valueOfHand = 0;
        name = "Mx. Bradford";
        isDealer = false;
        isHit = false;
        isStay = false;
        hand = new Card[2];
        numCards = 0;
        revealCards = false;
    }

    public void print(){

        if(isDealer){
            if(revealCards){
                System.out.println("Player " + name + " has these cards: ");
                for (int i = 0; i < hand.length; i++) {
                    hand[i].print();
                }
                System.out.println("with a value of " + valueOfHand);
            }else {
                System.out.println("Player " + name + " has these cards: ");
                hand[0].print();
                System.out.println("-" + " of " + "-" + " has a value of " + "-");
                System.out.println("with a value of " + hand[0].value);
            }
        }
        else {
            System.out.println("Player " + name + " has these cards: ");
            for (int i = 0; i < hand.length; i++) {
                hand[i].print();
            }
            System.out.println("with a value of " + valueOfHand);
        }
    }
    public void addCard(Card c){

        if(numCards>1) {
            Card[] temp = hand;
            hand = new Card[numCards + 1];
            for(int s = 0; s< temp.length; s++){
                hand[s] = temp[s];
            }
            hand[numCards] = c;
            numCards++;
            valueOfHand = valueOfHand + c.value;
        }
        else {
            hand[numCards] = c;
            numCards++;
            valueOfHand = valueOfHand + c.value;
        }
    }

    public void hit(){

    }

    public void stay(){

    }
}
