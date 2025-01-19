import java.util.*;

class Letter {
    private char character;

    public Letter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return Character.toString(character);
    }
}


class Word {
    private List<Letter> letters;

    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    public String getWord() {
        StringBuilder builder = new StringBuilder();
        for (Letter letter : letters) {
            builder.append(letter.getCharacter());
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return getWord();
    }
}


class Sentence {
    private List<String> components;

    public Sentence(String sentence) {
        components = Arrays.asList(sentence.split("(?<=\"?[.!?])|\s+"));
    }

    public List<String> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return String.join(" ", components);
    }
}


class Text {
    private List<Sentence> sentences;

    public Text(String text) {
        sentences = new ArrayList<>();
        String[] sentenceArray = text.split("(?<=[.!?])\s+");
        for (String sentence : sentenceArray) {
            sentences.add(new Sentence(sentence));
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Sentence sentence : sentences) {
            builder.append(sentence.toString()).append(" ");
        }
        return builder.toString().trim();
    }
}


public class Main {


    private static int countVowels(String word) {
        int count = 0;
        String vowels = "aeiouyAEIOUY";
        for (char c : word.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

       // String rawText = "This is a simple example text to demonstrate sorting words by vowels.";
        System.out.println("Введіть текст: ");
        Scanner scanner = new Scanner(System.in);
        String rawText = scanner.nextLine();
        rawText = rawText.replaceAll("\\s+", " ").trim();

         Text text = new Text(rawText);

       List<Word> words = new ArrayList<>();
        for (Sentence sentence : text.getSentences()) {
            for (String component : sentence.getComponents()) {
                if (component.matches("[a-zA-Z]+")) {
                    words.add(new Word(component));
                }
            }
        }

        words.sort(Comparator.comparingInt(w -> countVowels(w.getWord())));

        System.out.println("Слова, відсортовані за кількістю голосних:");
        for (Word word : words) {
            System.out.println(word);
        }
    }
}
