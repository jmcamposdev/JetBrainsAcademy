/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bullsandcows;

import java.util.Random;
import java.util.Scanner;

/**
 * @author josemaria
 */
public class BullsAndCows {

    public static final String POSSIBILITIES = "0123456789abzdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String secretCode;
        int secretCodeLength;
        int possibleCharacters;
        int turns = 1;
        String userInput;
        int[] bullsAndCows;
        // Asking the secret code length
        secretCodeLength = getInt("Please, enter the secret code's length:",1,36);
        // Asking the possible characters in the code
        possibleCharacters = getInt("Please, enter the secret code's length:",secretCodeLength,36);
        secretCode = generateRandomCode(secretCodeLength,possibleCharacters); // Generate the code
        System.out.println(generateInfo(secretCodeLength,possibleCharacters)); // Print the range of the characters
        System.out.println("Okay, let's start a game!");
        do {
            System.out.println("Turn "+(turns++)+":"); // Show the turn
            userInput = sc.next(); // Ask to the user the code
            bullsAndCows = calculateBullsCows(secretCode,userInput); // Calculate the bulls and cows
            if (bullsAndCows[0] == secretCodeLength) { // If the code is correct
                System.out.println("Grade: "+secretCodeLength+" bulls");
                System.out.println("Congratulations! You guessed the secret code.");
            } else if (bullsAndCows[0] > 0 || bullsAndCows[1] > 0) { // If has at less 1 cow or bull
                System.out.println("Grade: "+bullsAndCows[0]+" bulls and "+bullsAndCows[1]+" cow");
            } else { // If don't hit any number
                System.out.println("None");
            }
        } while (bullsAndCows[0] != secretCodeLength);

    }

    public static String generateRandomCode (int length, int posibleCharacters) {
        StringBuilder secretCode = new StringBuilder();
        Random random = new Random();
        String randomPart;
        for (int i = 0; i < length; i++) {
            do {
                randomPart = String.valueOf(POSSIBILITIES.charAt(random.nextInt(posibleCharacters))); // Get a random character
            } while (secretCode.toString().contains(randomPart)); // Validate that isn't in the current String
            secretCode.append(randomPart); // Add to the current String

        }
        return secretCode.toString();
    }

    public static int[] calculateBullsCows(String secretCode, String code) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secretCode.length(); i++) {
            if (secretCode.charAt(i) == code.charAt(i)) { // Check if has the same character
                bulls++;
            } else if (secretCode.contains(String.valueOf(code.charAt(i)))) { // Check if contains the character
                cows++;
            }
        }
        return new int[] {bulls,cows}; // Return an array
    }

    public static String generateInfo (int length, int possibleCharacters) {
        StringBuilder intro = new StringBuilder("The secret is prepared: ");
        // Generate the length of the code
        intro.append("*".repeat(Math.max(0, length)));
        if (possibleCharacters <= 10) { // Add the range of characters
            intro.append(" (0-").append(possibleCharacters - 1).append(")");
        } else  {
            intro.append(" (0 - 9, a - ").append(POSSIBILITIES.charAt(possibleCharacters - 1)).append(")");
        }
        return intro.toString();
    }

    // Get an int in a range of a minimum and a maximum both included
    public static int getInt(String mensaje, int minimo, int maximo) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextInt()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextInt();
            if (numero < minimo || numero > maximo){
                System.out.println("El rango no es el adecuado");
            }
        } while (numero < minimo || numero > maximo);
        return numero;
    }
    
}
