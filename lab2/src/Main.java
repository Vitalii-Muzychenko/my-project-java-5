import java.util.*;

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

       // String text = "This is a simple example text to demonstrate sorting words by vowels.";
        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);
     String   text = scanner.nextLine();
        try {

            String[] words = text.split("\\s+");

            List<StringBuffer> wordList = new ArrayList<>();
            for (String word : words) {
                wordList.add(new StringBuffer(word));
            }

            wordList.sort(Comparator.comparingInt(w -> countVowels(w.toString())));

            System.out.println("Words sorted by the number of vowels:");
            for (StringBuffer word : wordList) {
                System.out.println(word);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
