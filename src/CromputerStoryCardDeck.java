public class CromputerStoryCardDeck extends Deck {

    public CromputerStoryCardDeck(int numberOfCards, int numberOfCopies, boolean shouldBeShuffled) {
        for (int i = 0; i < numberOfCards; i++) {
            for (String character : CromputerStoryCard.CHARACTER_VALUES) {
                CromputerStoryCard card = new CromputerStoryCard(character);
                addCard(card);
            }
        }
    }
}