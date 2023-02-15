package coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput;
        CoffeeType coffeType = CoffeeType.ESPRESSO;
        Machine coffeMachine = new Machine(400,540,120,9,550);

        while (coffeMachine.isWorking()) {
            System.out.print("Write action (buy, fill, take, remaining, exit):\n> ");
            userInput = sc.next();
            userInput = userInput.toLowerCase();
            switch (userInput) {
                case "buy" -> {
                    do {
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n >");
                        userInput = sc.next();
                        userInput = userInput.toLowerCase();
                    } while (!userInput.matches("1|2|3|back"));
                    if (userInput.equals("back"))
                        break;

                    switch (userInput) {
                        case "1" -> coffeType = CoffeeType.ESPRESSO;
                        case "2" -> coffeType = CoffeeType.LATTE;
                        case "3" -> coffeType = CoffeeType.CAPPUCCINO;
                        default -> System.out.println("It is a invalid option");
                    }

                    if (coffeMachine.getWater() < coffeType.getWater()) {
                        System.out.println("Sorry, not enough water!");
                        break;
                    }
                    if (coffeMachine.getMilk() < coffeType.getMilk()) {
                        System.out.println("Sorry, not enough milk!");
                        break;
                    }
                    if (coffeMachine.getBeans() < coffeType.getBeans()) {
                        System.out.println("Sorry, not enough beans!");
                        break;
                    }
                    if (coffeMachine.getCups() == 0) {
                        System.out.println("Sorry, not enough cups!");
                        break;
                    }

                    coffeMachine.removeWater(coffeType.getWater());
                    coffeMachine.removeMilk(coffeType.getMilk());
                    coffeMachine.removeBeans(coffeType.getBeans());
                    coffeMachine.removeCups(1);
                    coffeMachine.addMoney(coffeType.getPrice());
                }
                case "fill" -> {
                    coffeMachine.addWater(getInt("Write how many ml of water you want to add: \n> ",0));
                    coffeMachine.addMilk(getInt("Write how many ml of milk you want to add: \n> ", 0));
                    coffeMachine.addBeans(getInt("Write how many grams of coffee beans you want to add: \n> ",0));
                    coffeMachine.addCups(getInt("Write how many disposable cups you want to add: \n> ",0));
                }
                case "take" -> {
                    int currentMoney = coffeMachine.removeMoney();
                    System.out.println("I gave you $"+currentMoney+"\n");
                }
                case "remaining" -> System.out.println(coffeMachine);
                case "exit" -> coffeMachine.setIsWorking(false);
                default -> System.out.println("Is a invalid option please try again");
            }
        }

    }

    public static int getInt(String mensaje, int minimo) {
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
            if (numero < minimo){
                System.out.println("El rango no es el adecuado");
            }
        } while (numero < minimo);
        return numero;
    }
}
