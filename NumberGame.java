import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int rounds = 0;
        String playAgain = "yes";

        System.out.println("================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("================================");

        while (playAgain.equalsIgnoreCase("yes")) {
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            rounds++;

            System.out.println("\nGuess a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Enter a number from 1 to 100.");
                    continue;
                }

                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number!");
                    System.out.println("Attempts used: " + attempts);
                    score += maxAttempts - attempts + 1;
                    guessed = true;
                    break;
                } else if (guess < number) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("Game over! The number was " + number);
            }

            System.out.println("Your score: " + score);
            System.out.print("Play another round? (yes/no): ");
            playAgain = sc.next();
        }

        System.out.println("\n================================");
        System.out.println("           GAME SUMMARY");
        System.out.println("================================");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Final score: " + score);
        System.out.println("Thanks for playing!");

        sc.close();
    }
}