import java.util.*;

public abstract class Deck {
    private ArrayList<Card> cards = new ArrayList<>();
    private boolean willShuffle = false;

    public void Shuffle(){
        Collections.shuffle(cards);
    }

    public void addCard(Card card){
        cards.add(card);
    }

    private Card removeCardAt(int index){
        return cards.remove(index);
    }

    public Card drawCard(){
        return removeCardAt(0);
    }

    public int cardCount(){
        return cards.size();
    }

    public Card drawRandomCard(){
        Random random = new Random();
         int index = random.nextInt(cards.size());
         return removeCardAt(index);
    }
}
