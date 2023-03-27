/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package readabilityscore;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author josemaria
 */
public class ReadabilityScore {

    public class Main {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (FileReader fileReader = new FileReader(args[0])) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                text.append(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("The text is:");
        System.out.println(text);

        String[] sentences = text.toString().split("[.!?]");
        int words = text.toString().split("\\s+").length;
        int characters = text.toString().replaceAll("\\s+", "").length();
        double score = 4.71 * (characters / (double) words) + 0.5 * (words / (double) sentences.length) - 21.43;

        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences.length);
        System.out.println("Characters: " + characters);
        System.out.println("The score is: " + score);
        System.out.println("This text should be understood by " + (score <= 1 ? "5-6" : score <= 2 ? "6-7" : score <= 3 ? "7-8" : score <= 4 ? "8-9" : score <= 5 ? "9-19" : score <= 6 ? "10-11" : score <= 7 ? "11:12" : score <= 8 ? "12-13" : score <= 9 ? "13-14" : score <= 10 ? "14-15" : score <= 11 ? "15-16" : score <= 12 ? "16-17" : score <= 13 ? "17-18" : "18-22") + " year olds.");

    }
}
    
}
