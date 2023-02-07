/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simplechattybot;

import java.util.Scanner;

/**
 *
 * @author josemaria
 */
public class SimpleChattyBot {

    final static Scanner scanner = new Scanner(System.in); // Do not change this line

    public static void main(String[] args) {
        greet("Aid", "2018"); // change it as you need
        remindName();
        guessAge();
        count();
        test();
        end();
    }

    static void greet(String assistantName, String birthYear) {
        System.out.println("Hello! My name is " + assistantName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
    }

    static void remindName() {
        System.out.print("> ");
        String name = scanner.nextLine();
        System.out.println("What a great name you have, " + name + "!");
    }

    static void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int rem3 = getInt("Divide your age by 3 > ");
        int rem5 = getInt("Divide your age by 5 > ");
        int rem7 = getInt("Divide your age by 7 > ");
        int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }

    static void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int num = getInt("> ");
        for (int i = 0; i <= num; i++) {
            System.out.printf("%d!\n", i);
        }
    }

    static void test() {
        int option;
        System.out.println("Let's test your programming knowledge.");
        System.out.println("""
                            Why do we use methods?
                            1. To repeat a statement multiple times.
                            2. To decompose a program into several small subroutines.
                            3. To determine the execution time of a program.
                            4. To interrupt the execution of a program.""");
            do{
                option = getInt("> ");
                if (option != 2) {
                    System.out.println("Please, try again.");
                }
            } while(option != 2);
    }

    static void end() {
        System.out.println("Congratulations, have a nice day!"); // Do not change this text
    }
    
    public static int getInt(String message) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print(message);
        while (!sc.hasNextInt()){
            System.out.println("Enter a numeric value");
            System.out.print(message);
            sc.nextLine();
        }
        num = sc.nextInt();
        return num;
    }
    
}
