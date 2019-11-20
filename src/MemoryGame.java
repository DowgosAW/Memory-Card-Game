import java.util.ArrayList;

public abstract class MemoryGame extends Game {
    private ArrayList<Card> cardsMatched = new ArrayList<>();
    private int numberOfCardsToMatch;
    private int[] indexOfCardsCurrentlyFlipped;
    private int numberOfCardsCurrentlyFlipped=0;
    private Card[] gameBoard;
    private int numberCardsFlipped;

    public MemoryGame(int numberOfCardsToMatch, int sizeOfBoard) {
        this.numberOfCardsToMatch=numberOfCardsToMatch;
        indexOfCardsCurrentlyFlipped=new int[numberOfCardsToMatch];
        gameBoard = new Card[sizeOfBoard];
        Deck deck = createDeck(sizeOfBoard,numberOfCardsToMatch);
        for (int i =0; i<gameBoard.length; i++){
            gameBoard[i] = deck.drawCard();
        }
    }// some changes

    MemoryGame(int sizeOfBoard){
        this(2,sizeOfBoard);
    }

    public Card[] getCardsMatched() {
        return (Card[])cardsMatched.toArray();
    }

    public Card flipCardAt(int index) {
        Card card = gameBoard[index];
        if(!card.isFaceUp()){
            card.flipCard();
            indexOfCardsCurrentlyFlipped[numberOfCardsCurrentlyFlipped]= index;
            numberOfCardsCurrentlyFlipped++;
            if(numberOfCardsCurrentlyFlipped == numberOfCardsToMatch){
                System.out.println("Match Result = " + matchCards());
            }
        }
        return card;
    }

    public void removeCardAt(int index){
        gameBoard[index] = null;
    }

    protected abstract Deck createDeck(int numberOfCards, int numberOfCopies);

    private boolean matchCards(){
        for (int i=numberOfCardsToMatch-1; i>0; i--){
            Card card1 = gameBoard[indexOfCardsCurrentlyFlipped[i]];
            Card card2 = gameBoard[indexOfCardsCurrentlyFlipped[i-1]];
            if (!(isMatch(card1,card2))){
                resetFlippedCards();
                return false;
            }
        }
        awardMatch();
        return true;
    }

    private void resetFlippedCards(){
        for (int index : indexOfCardsCurrentlyFlipped){
            Card card = gameBoard[index];
            card.flipCard();
        }
        numberOfCardsCurrentlyFlipped=0;
        indexOfCardsCurrentlyFlipped=new int[numberOfCardsToMatch];
    }

    private void awardMatch(){
        for (int index : indexOfCardsCurrentlyFlipped){
            cardsMatched.add(gameBoard[index]);
            removeCardAt(index);
        }
        numberOfCardsCurrentlyFlipped = 0;
        indexOfCardsCurrentlyFlipped=new int[numberOfCardsToMatch];
    }

    private boolean isMatch(Card card1, Card card2){
        return card1.equals(card2);
    }
}
