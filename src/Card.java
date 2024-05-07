public class Card {
    public String suit;
    public int value;
    public String type;
    public boolean isPlayed;

    public Card(int pSuit, int pValue){
        switch (pSuit) {
            case 0:
                suit = "Diamonds";
                break;
            case 1:
                suit = "Hearts";
                break;
            case 2:
                suit = "Clubs";
                break;
            default:
                suit = "Spades";
                break;
        }
        switch (pValue){
            case 1:
                type = "Ace";
                value = 10;
                break;
            case 2:
                type = "Two";
                value = 2;
                break;
            case 3:
                type = "Three";
                value = 3;
                break;
            case 4:
                type = "Four";
                value = 4;
                break;
            case 5:
                type = "Five";
                value = 5;
                break;
            case 6:
                type = "Six";
                value = 6;
                break;
            case 7:
                type = "Seven";
                value = 7;
                break;
            case 8:
                type = "Eight";
                value = 8;
                break;
            case 9:
                type = "nine";
                value = 9;
                break;
            case 10:
                type = "Ten";
                value = 10;
                break;
            case 11:
                type = "Jack";
                value = 10;
                break;
            case 12:
                type = "Queen";
                value = 10;
                break;
            default:
                type = "King";
                value = 10;
        }
        isPlayed = false;
    }
    public void print(){
        System.out.println(type + " of "  +suit+ " has a value of " + value);
    }


}
