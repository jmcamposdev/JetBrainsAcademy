package rock.paper.scissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author josemaria
 */
public class RockPaperScissors {

    public static Scanner sc = new Scanner(System.in);
    public static int userScore = 0;
    public static ArrayList<Choice> userChoices = new ArrayList<>();
    public static String REG_USER_CHOICES = "ROCK|FIRE|SCISSORS|SNAKE|HUMAN|TREE|WOLF|SPONGE|PAPER|AIR|WATER|DRAGON|DEVIL|LIGHTNING|GUN";

    public static void main(String[] args) {
        System.out.println(info());

        boolean exitGame = false;
        String userInput;
        String userName;

        System.out.print("Enter your name: ");
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
        boolean validUserChoices = true;
        System.out.println("Input the choices separated by commas\n(if you don't input anything, the default choices are (ROCK,PAPER,SCISSORS): ");
        String userChoice = sc.nextLine();
        ArrayList<Choice> userChoices = new ArrayList<>();
        if (userChoice.length() > 0) {
            String[] split = userChoice.split(",");
            for(int i = 0; i < split.length && validUserChoices; i++) {
                if (split[i].toUpperCase().matches(REG_USER_CHOICES)) {
                    userChoices.add(Choice.valueOf(split[i].toUpperCase()));
                } else {
                    validUserChoices = false;
                    System.out.println("Invalid input "+ split[i].toUpperCase() + ". Please try again");
                }
            }
        } else {
            userChoices.add(Choice.ROCK);
            userChoices.add(Choice.PAPER);
            userChoices.add(Choice.SCISSORS);
        }
        return validUserChoices ? userChoices : getUserChoices();
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
        ArrayList<Choice> winningCombinations = allWinningCombinations(userChoice);
        winningCombinations.removeIf(choice -> !userChoices.contains(choice));
        return winningCombinations;
    }

    public static ArrayList<Choice> allWinningCombinations (Choice choice) {
        ArrayList<Choice> winningCombinations = new ArrayList<>();
        ArrayList<Choice> allChoices = new ArrayList<>(Arrays.asList(Choice.values()));
        int numberOfWinningCombinations = allChoices.size() / 2;
        int indexUserChoice = allChoices.indexOf(choice);
        while (numberOfWinningCombinations > 0) {
            if (indexUserChoice == allChoices.size() - 1) {
                indexUserChoice = 0;
            } else {
                indexUserChoice++;
            }
            winningCombinations.add(allChoices.get(indexUserChoice));
            numberOfWinningCombinations--;
        }
        return winningCombinations;
    }

    public static String info () {
        return """
                This is a game of Rock, Paper, Scissors extended with the following choices:\s
                   ROCK, FIRE, SCISSORS, SNAKE, HUMAN, TREE, WOLF, SPONGE, PAPER, AIR, WATER, DRAGON, DEVIL, LIGHTNING, GUN
                The game will ask you to input your name and then the choices you want to play with.
                If you don't input any choices, the default choices will be used are (ROCK,PAPER,SCISSORS).
                You can also input your own choices separated by commas.
                """;
    }

}
