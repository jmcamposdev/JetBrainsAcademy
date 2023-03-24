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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        switch (userInput) {
            case "rock" -> System.out.println("Sorry, but the computer chose paper");
            case "paper" -> System.out.println("Sorry, but the computer chose scissors");
            case "scissors" -> System.out.println("Sorry, but the computer chose rock");
            default -> System.out.println("Error!");
        }
    }
    
}
