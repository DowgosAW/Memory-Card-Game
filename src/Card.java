public abstract class Card {
    private boolean isFaceUp = false;

    public void flipCard(){
        isFaceUp = !isFaceUp;
    }
}
