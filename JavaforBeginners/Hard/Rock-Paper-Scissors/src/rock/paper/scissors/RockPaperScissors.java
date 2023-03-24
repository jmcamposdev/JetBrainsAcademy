/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rock.paper.scissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author josemaria
 */
public class RockPaperScissors {

    public static Choice[][] winningCombinations = {
            {Choice.ROCK, Choice.SCISSORS},
            {Choice.PAPER, Choice.ROCK},
            {Choice.SCISSORS, Choice.PAPER}
    };
    public static Scanner sc = new Scanner(System.in);
    public static int userScore = 0;

    public static void main(String[] args) {
        boolean exitGame = false;
        String userInput;
        String userName;

        System.out.print("Enter your name:");
        userName = sc.next();
        userScore = readAndGetScore(userName);

        System.out.println("Hello, " + userName);
        while (!exitGame) {
            boolean validInput = false;
            do {
                System.out.print("Enter a Choice (rock|paper|scissors): ");
                userInput = sc.next();
                if (userInput.matches("!exit|!rating|rock|paper|scissors")) {
                    validInput = true;
                    if (userInput.equals("!exit")) exitGame = true;
                } else {
                    System.out.println("Invalid input");
                }
            } while (!validInput);

            if (!exitGame) {
                if (userInput.equals("!rating")) {
                    System.out.println("Your rating: " + userScore);
                } else {
                    play(Choice.valueOf(userInput.toUpperCase()));
                }
            }
        }
        System.out.println("Bye!");



    }

    public static void play (Choice userChoice ) {
        Choice computerChoice = Choice.values()[(int) (Math.random() * Choice.values().length)];
        if (computerChoice == userChoice) {
            System.out.println("There is a draw (" + computerChoice + ")");
            userScore += 50;
        } else if (userChoice == winningCombinations[computerChoice.ordinal()][1]) {
            System.out.println("Sorry, but the computer chose " + computerChoice);
        } else {
            System.out.println("Well done. The computer chose " + computerChoice + " and failed");
            userScore += 100;
        }
    }

    public static int readAndGetScore (String userName) {
        boolean userFoundInFile = false;
        int userScore = 0;
        File file = new File("./rating.txt");
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine() && !userFoundInFile){
                String[] split = fileScanner.nextLine().split(" ");
                if (split[0].equals(userName)) {
                    userScore = Integer.parseInt(split[1]);
                    userFoundInFile = true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return userScore;
    }
    
}
