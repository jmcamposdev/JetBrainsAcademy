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
        String userInput = sc.next();
        Choice userChoice = Choice.valueOf(userInput.toUpperCase());
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
