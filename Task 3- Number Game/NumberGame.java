import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("I've chosen a number between 1 and 100. Try to guess it!");

            while (numberOfAttempts < 10 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too lower");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too higher");
                } else {
                    hasGuessedCorrectly = true;
                    score += 10 - numberOfAttempts + 1; //
                    System.out.println(
                            "Congratulations! You guessed the correct number in " + numberOfAttempts + " attempts.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've run out of attempts. The correct number was" + numberToGuess + ".");
            }

            System.out.println("Your current score is: " + score);

            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Your final score is: " + score);
        scanner.close();
    }
}
