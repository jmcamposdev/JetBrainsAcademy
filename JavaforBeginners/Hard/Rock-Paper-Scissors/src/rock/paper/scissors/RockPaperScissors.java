/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rock.paper.scissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author josemaria
 */
public class RockPaperScissors {

    public static Scanner sc = new Scanner(System.in);
    public static int userScore = 0;
    public static ArrayList<Choice> userChoices = new ArrayList<>();

    public static void main(String[] args) {


        boolean exitGame = false;
        String userInput;
        String userName;

        System.out.print("Enter your name:");
        userName = sc.nextLine();
        System.out.println("Hello, " + userName);

        userScore = readAndGetScore(userName);

        userChoices = getUserChoices();
        Collections.sort(userChoices);
        System.out.println("Okay, let's start");

        while (!exitGame) {
            System.out.print("Enter a Choice: ");
            userInput = sc.next();
            if (validateUserChoice(userInput, userChoices)) {
                play(Choice.valueOf(userInput.toUpperCase()), userChoices);
            } else if (userInput.equals("!rating")) {
                System.out.println("Your rating: " + userScore);
            } else if (userInput.equals("!exit")) {
                exitGame = true;
            } else {
                System.out.println("Invalid input");
            }
        }
        System.out.println("Bye!");



    }

    public static void play (Choice userChoice, ArrayList<Choice> userChoices ) {
        Random random = new Random();
        // Get a random value from the userChoices array
        Choice computerChoice = userChoices.get(random.nextInt(userChoices.size()));
        if (computerChoice == userChoice) {
            System.out.println("There is a draw (" + computerChoice + ")");
            userScore += 50;
        } else if (userWinningCombinations(new ArrayList<>(userChoices), userChoice).contains(computerChoice)) {
            System.out.println("Well done. The computer chose " + computerChoice + " and failed");
            userScore += 100;
        } else {
            System.out.println("Sorry, but the computer chose " + computerChoice);
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

    public static ArrayList<Choice> getUserChoices () {
        String userChoice = sc.nextLine();
        ArrayList<Choice> userChoices = new ArrayList<>();
        if (userChoice.length() > 0) {
            String[] split = userChoice.split(",");
            for (String s : split) {
                userChoices.add(Choice.valueOf(s.toUpperCase()));
            }
        } else {
            userChoices.add(Choice.ROCK);
            userChoices.add(Choice.PAPER);
            userChoices.add(Choice.SCISSORS);
        }
        return userChoices;
    }

    public static boolean validateUserChoice (String userChoice, ArrayList<Choice> userChoices) {
        boolean validChoice = false;
        for (int i = 0; i < userChoices.size() && !validChoice; i++) {
            Choice choice = userChoices.get(i);
            if (choice.name().equals(userChoice.toUpperCase())) {
                validChoice = true;
            }
        }
        return validChoice;
    }

    public static ArrayList<Choice> userWinningCombinations (ArrayList<Choice> userChoices, Choice userChoice) {
        ArrayList<Choice> winningCombinations = new ArrayList<>();
        int numberOfWinningCombinations = userChoices.size() / 2;
        int indexUserChoice = userChoices.indexOf(userChoice);
        while (numberOfWinningCombinations > 0) {
            if (indexUserChoice == userChoices.size() - 1) {
                indexUserChoice = 0;
            } else {
                indexUserChoice++;
            }
            winningCombinations.add(userChoices.get(indexUserChoice));
            numberOfWinningCombinations--;
        }
        return winningCombinations;
    }
    
}
