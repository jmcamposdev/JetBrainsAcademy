/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rock.paper.scissors;

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exitGame = false;
        String userInput = "";


        while (!exitGame) {
            boolean validInput = false;
            do {
                System.out.print("Enter a Choice (rock|paper|scissors): ");
                userInput = sc.next();
                if (userInput.matches("!exit|rock|paper|scissors")) {
                    validInput = true;
                    if (userInput.equals("!exit")) exitGame = true;
                } else {
                    System.out.println("Invalid input");
                }
            } while (!validInput);

            if (!exitGame) {
                play(Choice.valueOf(userInput.toUpperCase()));
            }
        }
        System.out.println("Bye!");



    }

    public static void play (Choice userChoice) {
        Choice computerChoice = Choice.values()[(int) (Math.random() * Choice.values().length)];
        if (computerChoice == userChoice) {
            System.out.println("There is a draw (" + computerChoice + ")");
        } else if (userChoice == winningCombinations[computerChoice.ordinal()][1]) {
            System.out.println("Sorry, but the computer chose " + computerChoice);
        } else {
            System.out.println("Well done. The computer chose " + computerChoice + " and failed");
        }
    }
    
}
