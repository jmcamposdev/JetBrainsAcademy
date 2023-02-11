/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinema;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author josemaria
 */
public class Cinema {

     public static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = GetData.getInt("Enter the number of rows:\n> ",1); // Get the rows
        int columns = GetData.getInt("Enter the number of seats in each row:\n> ",1); // Get columns
        char[][] cinema = new char[rows][columns];
        fillCinema(cinema); // Fill the array which 'S'

        int numberOfBuyTickets = 0; // Number of Buys Tickets
        double individualPercent = (1.0/(rows*columns))*100.0; // The percentage of each ticket
        double percentOfBuyTickets = 0.0; // The percentage of all sell Tickets
        int currentIncome = 0; // The income of all tickets
        int totalIncome = totalIncome(cinema); // The global income
        int userOption; // The user input
        boolean exit = false; // To exit
        while (!exit) {
            System.out.println(showMenu()); // Print the Menu
            userOption = GetData.getInt("> ",0,3); // Get the user option
            switch (userOption) {
                case 1 -> { // Print the cinema seats
                    System.out.println(showCinema(cinema));
                }
                case 2 -> {
                    if (!emptySeats(cinema)) {
                        System.out.println("The cinema is Full");
                        break;
                    }

                    boolean isOccupied = true;
                    int userRow = 0,userColumn;
                    while (isOccupied) {
                        userRow = GetData.getInt("Enter a row number:\n> ",1,cinema.length); // Ask the row
                        userColumn= GetData.getInt("Enter a seat number in that row:\n> ",1,cinema[0].length); // Ask the column
                        isOccupied = occupiedSeat(cinema,userRow-1,userColumn-1); // VCheck if the seat is occupied if it is not occupied occupy it
                        if (isOccupied) { // If the seat is occupied say
                            System.out.print("That ticket has already been purchased!");
                        }
                    }
                    // If the seat is not occupied
                    int price = calculatePrice(cinema,userRow-1); // Calculate the price of the row
                    System.out.println("Ticket price: $"+price); // Print the price
                    currentIncome += price; // Sum the price to the actual Income
                    numberOfBuyTickets++; // Sum one ticket more
                    percentOfBuyTickets += individualPercent; // Add one percentage to the total


                }
                case 3 -> { // Show the Cinema Statistics
                    System.out.println("Number of purchased tickets: "+numberOfBuyTickets);
                    System.out.println("Percentage: "+df.format(percentOfBuyTickets)+"%");
                    System.out.println("Current income: $"+currentIncome);
                    System.out.println("Total income: $"+totalIncome);
                }
                case 0 -> exit = true; // Exit the program
            }
        }

    }
    // Fill the Cinema array which 'S'
    public static void fillCinema (char[][] cinema) {
        for (char[] chars : cinema) {
            Arrays.fill(chars, 'S');
        }
    }

    // Return a String of the current cinema stage
    public static String showCinema (char[][] cinema) {
        String cinemaString = "\nCinema:\n ";
        // Insert Column Index
        for (int i = 1; i <= cinema[0].length; i++) {
            cinemaString += " "+i;
        }
        cinemaString += "\n";

        // Insert Rows Data and Rows index
        for (int i = 0; i < cinema.length; i++) {
            cinemaString += i+1;
            for (int j = 0; j < cinema[i].length; j++) {
                cinemaString += " "+cinema[i][j];
            }
            cinemaString += "\n";
        }
        return cinemaString;
    }

    // Calculate the price in base the row and a the total seats
    public static int calculatePrice (char[][] cinema,int row) {
        // If the cinema Seats is less than 60 OR the row is in the half front the price is 10
        return cinema.length * cinema[0].length < 60 || row < (cinema.length/2) ? 10 : 8;
    }

    public static boolean occupiedSeat (char[][] cinema,int row,int column) {
        if (row < 0 || row >= cinema.length) {
            throw new IllegalArgumentException("The row value is out of range");
        }
        if (column < 0 || column >= cinema[0].length) {
            throw new IllegalArgumentException("The column value is out of range");
        }
        boolean isOcupped = cinema[row][column] == 'B';
        if (!isOcupped) {
            cinema[row][column] = 'B';
        }
        return isOcupped;
    }

    public static int totalIncome (char[][] cinema) {
        int totalIncome = 0;
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[0].length; j++) {
                totalIncome += calculatePrice(cinema,i);
            }
        }
        return totalIncome;
    }

    public static boolean emptySeats (char[][] cinema) {
        boolean emptySeats = false;
        for (int i = 0; i < cinema.length && !emptySeats; i++) {
            for (int j = 0; j < cinema[i].length && !emptySeats; j++) {
                if (cinema[i][j] == 'S') {
                    emptySeats = true;
                }
            }
        }
        return emptySeats;
    }

    public static String showMenu() {
        return """
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                """;
    }
    
}
