public class CromputerStoryCard extends Card{
    public final static String[] CHARACTER_VALUES= {"Cromptous", "Chromebook Default", "Chromebook Disgust", "Sap Man", "Denis", "Jimbulo Bimbulor", "Lance", "Victorian Gentleman","SD Card", "Colossus", "Denie", "D-Money", "Meat Salesman" };
    private String character;

    public CromputerStoryCard(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return this.character;
    }

    public String toString() {
        return "CromputerStoryCard{" +
                "character='" + character + '\'' +
                '}';
    }

    public boolean equals(Card card) {
        return character.equals(card);
    }
}