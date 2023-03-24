package rockpaperscissors;

import java.util.Scanner;

public class Main {
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
