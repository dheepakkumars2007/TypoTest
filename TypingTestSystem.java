import java.util.*;

public class TypingTestSystem {

    static String[] sentences = {
            "Practice makes a person perfect",
            "Java programming is powerful and versatile",
            "Coding improves logical thinking",
            "Technology changes the world rapidly",
            "Consistency is the key to success"
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("⌨️ Typing Test");
        System.out.println("Improve your speed and accuracy\n");

        boolean playAgain = true;

        while (playAgain) {
            // Select a random sentence
            String currentSentence = sentences[rand.nextInt(sentences.length)];
            System.out.println("Type the following sentence:\n");
            System.out.println(currentSentence + "\n");

            System.out.println("Start typing below:");

            // Start timing
            long startTime = System.currentTimeMillis();
            String input = sc.nextLine();
            long endTime = System.currentTimeMillis();

            // Prevent extra typing
            if (input.length() > currentSentence.length()) {
                input = input.substring(0, currentSentence.length());
            }

            // Calculate correctness
            int correct = 0;
            int len = Math.min(input.length(), currentSentence.length());

            for (int i = 0; i < len; i++) {
                if (input.charAt(i) == currentSentence.charAt(i)) {
                    correct++;
                }
            }

            double time = (endTime - startTime) / 1000.0;
            if (time <= 0)
                time = 1;

            int wpm = (int) ((input.length() / 5.0 / time) * 60);
            int accuracy = (int) ((correct * 100.0) / currentSentence.length());

            System.out.println("\n✅ Test Completed!");
            System.out.println("⏱ Time: " + (int) time + "s");
            System.out.println("⚡ WPM: " + wpm);
            System.out.println("🎯 Accuracy: " + accuracy + "%");

            // Ask if user wants to retry
            System.out.print("\nDo you want to try again? (yes/no): ");
            String answer = sc.nextLine().trim().toLowerCase();
            playAgain = answer.equals("yes") || answer.equals("y");
            System.out.println();
        }

        System.out.println("Thanks for using Typing Test! 🚀");
        sc.close();
    }
}