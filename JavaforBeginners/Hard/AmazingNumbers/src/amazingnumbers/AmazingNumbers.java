/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package amazingnumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author josemaria
 */
public class AmazingNumbers {

    public static final String VALID_TYPE_PATTERN = "EVEN|ODD|BUZZ|DUCK|PALINDROMIC|SQUARE|SUNNY|GAPFUL|SPY|JUMPING|HAPPY|SAD";

    public static void main(String[] args) {
        System.out.println(menu());
        long n = -1;
        int listLength;
        while (n != 0) {
            System.out.print("Enter a request: ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (validateInput(input)) {
                String[] params = input.toUpperCase().split(" "); // Get all input fields
                int paramsLength = params.length; // Get number of input fields
                n = Long.parseLong(params[0]); // Get the number
                listLength = paramsLength == 1 ? 0 : Integer.parseInt(params[1]); // Get the list length
                ArrayList<NumbersType> requiredTypes = new ArrayList<>(); // The list
                ArrayList<NumbersType> excludedTypes = new ArrayList<>(); // The list
                if (paramsLength > 2) {
                    for (int i = 2; i < paramsLength; i++) {
                        if (params[i].charAt(0) == '-') {
                            excludedTypes.add(NumbersType.valueOf(params[i].substring(1)));
                        } else {
                            requiredTypes.add(NumbersType.valueOf(params[i]));
                        }
                    }
                }
                if (n != 0) {
                    if (listLength == 0) {
                        printProps(n);
                    } else {
                        if (requiredTypes.isEmpty() && excludedTypes.isEmpty()) {
                            for (int i = 0; i < listLength; i++) {
                                System.out.println(printInlineProps(n++, requiredTypes, excludedTypes));
                            }
                        } else {
                            while (listLength != 0) {
                                String numberOutput = printInlineProps(n++,requiredTypes, excludedTypes);
                                if (!numberOutput.isEmpty()) {
                                    System.out.println(numberOutput);
                                    listLength--;
                                }

                            }
                        }

                    }
                }

            }
            if (n == 0) {
                System.out.println("Goodbye!");
            }
        }

    }

    public static boolean isNatural (long number) {
        return number > 0;
    }
    public static boolean isEven (long number) {
        return  number % 2 == 0;
    }
    public static boolean isBuzz (long number) {
        return number % 7 == 0 || number % 10 == 7;
    }
    public static boolean isDuck(long number) {
        String numberString = String.valueOf(number);
        return numberString.contains("0");
    }
    public static boolean isPalindromic(long number) {
        String numberString = String.valueOf(number);
        String reverseNumber = new StringBuilder(numberString).reverse().toString();
        return numberString.equals(reverseNumber);
    }
    public static boolean isGapful (long number) {
        String numberString = String.valueOf(number);
        if (numberString.length() < 3) {
            return false;
        }
        String divider = numberString.charAt(0)+numberString.substring(numberString.length()-1);
        return number % Integer.parseInt(divider) == 0;
    }

    public static boolean isSpy (long number) {
        String numberString = String.valueOf(number);
        String[] digits = numberString.split("");
        int sumAllDigits = 0;
        int productAllDigits = 1;
        for (String digit : digits) {
            sumAllDigits += Integer.parseInt(digit);
            productAllDigits *= Integer.parseInt(digit);
        }
        return sumAllDigits == productAllDigits;
    }

    public static boolean isPerfectSquare (long number) {
        long sqrt = (long) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    public static boolean isSunny (long number) {
        return isPerfectSquare(number + 1);
    }

    public static boolean isJumping (long number) {
        boolean isJumping = true;
        String numberString = String.valueOf(number);
        String[] digits = numberString.split("");
        for (int i = 0; i < digits.length - 1 && isJumping; i++) {
            if (Math.abs(Integer.parseInt(digits[i]) - Integer.parseInt(digits[i+1])) != 1) {
                isJumping = false;
            }
        }
        return isJumping;
    }

    public static boolean isHappy (long number) {
        boolean isHappy = false;
        long sum = 0;
        while (sum != 1 && sum != 4) {
            sum = 0;
            String numberString = String.valueOf(number);
            String[] digits = numberString.split("");
            for (String digit : digits) {
                sum += Integer.parseInt(digit) * Integer.parseInt(digit);
            }
            number = sum;
        }
        if (sum == 1) {
            isHappy = true;
        }
        return isHappy;
    }

    public static void printProps(long number) {
        System.out.println("Properties of "+ number);
        System.out.println("        Buzz: "+ isBuzz(number));
        System.out.println("        Duck: "+ isDuck(number));
        System.out.println(" Palindromic: "+ isPalindromic(number));
        System.out.println("      Gapful: "+ isGapful(number));
        System.out.println("         Spy: "+ isSpy(number));
        System.out.println("      Square: "+ isPerfectSquare(number));
        System.out.println("       Sunny: "+ isSunny(number));
        System.out.println("    Jumping:"+ isJumping(number));
        System.out.println("        Happy: "+ isHappy(number));
        System.out.println("        Sad: "+ !isHappy(number));
        System.out.println("        Even: "+ isEven(number));
        System.out.println("         Odd: "+ !isEven(number));
    }

    public static String printInlineProps (long number, ArrayList<NumbersType> requestedTypes , ArrayList<NumbersType> excludedTypes) {
        StringBuilder propsString = new StringBuilder();
        ArrayList<NumbersType> allNumberProps = new ArrayList<>();
        if (isBuzz(number)) {
            allNumberProps.add(NumbersType.BUZZ);
        }
        if (isDuck(number)) {
            allNumberProps.add(NumbersType.DUCK);
        }
        if (isPalindromic(number)) {
            allNumberProps.add(NumbersType.PALINDROMIC);
        }
        if (isGapful(number)) {
            allNumberProps.add(NumbersType.GAPFUL);
        }
        if (isSpy(number)) {
            allNumberProps.add(NumbersType.SPY);
        }
        if (isPerfectSquare(number)) {
            allNumberProps.add(NumbersType.SQUARE);
        }
        if (isSunny(number)) {
            allNumberProps.add(NumbersType.SUNNY);
        }
        if (isJumping(number)) {
            allNumberProps.add(NumbersType.JUMPING);
        }
        if (isHappy(number)) {
            allNumberProps.add(NumbersType.HAPPY);
        } else {
            allNumberProps.add(NumbersType.SAD);
        }
        if (isEven(number)) {
            allNumberProps.add(NumbersType.EVEN);
        } else {
            allNumberProps.add(NumbersType.ODD);
        }

        if (requestedTypes.size() == 1 && requestedTypes.get(0) == NumbersType.ALL) {
            propsString.append(printNumberProps(number, allNumberProps));
        } else {
            boolean containsAllProps = true;
            for (NumbersType numberType : requestedTypes) {
                if (!allNumberProps.contains(numberType)) {
                    containsAllProps = false;
                }
            }
            for (NumbersType numberType : excludedTypes) {
                if (allNumberProps.contains(numberType)) {
                    containsAllProps = false;
                }
            }

            if (containsAllProps) {
                propsString.append(printNumberProps(number, allNumberProps));
            }
        }

        return propsString.toString();
    }

    public static String printNumberProps (long number, ArrayList<NumbersType> props) {
        StringBuilder propsString = new StringBuilder();
        propsString.append(number).append(" is ");
        for (NumbersType prop : props) {
            propsString.append(prop.toString().toLowerCase()).append(", ");
        }
        return propsString.toString();
    }

    public static String menu() {
        return """
                Welcome to Amazing Numbers!
                                
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be printed;
                - two natural numbers and properties to search for;
                - a property preceded by minus must not be present in numbers;
                - separate the parameters with one space;
                - enter 0 to exit.""";
    }

    public static boolean validateInput (String input) {
        boolean validaInput = true;
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList(input.toUpperCase().split(" ")));
        ArrayList<String> requiredPropertiesOfTheNumber = new ArrayList<>();
        ArrayList<String> excludedPropertiesOfTheNumber = new ArrayList<>();
        ArrayList<String> badProperties = new ArrayList<>();

        for (int i = 2; i < parameters.size(); i++) {
            if (parameters.get(i).charAt(0) == '-') {
                excludedPropertiesOfTheNumber.add(parameters.get(i).substring(1));
            } else {
                requiredPropertiesOfTheNumber.add(parameters.get(i));
            }
        }

        if (parameters.size() >= 1 && Long.parseLong(parameters.get(0)) < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            validaInput = false;
        } else if (parameters.size() == 2 && !isNatural(Long.parseLong(parameters.get(1)))) {
            System.out.println("The second parameter should be a natural number.");
            validaInput = false;
        }

        for (int i = 2; i < parameters.size(); i++) {
            String property = parameters.get(i);
            if (property.startsWith("-")) {
                property = property.substring(1);
            }
            if (!property.matches(VALID_TYPE_PATTERN)) {
                badProperties.add(parameters.get(i));
            }
        }

        if (badProperties.size() > 0) {
            System.out.println("The "+(badProperties.size()==1 ? "property " : "properties ")+badProperties+(badProperties.size()==1 ? " is" : " are")+" wrong.\n" +
                    "Available properties: "+ Arrays.toString(NumbersType.values())+"\n");
            validaInput = false;
        }

        if (validaInput && (requiredPropertiesOfTheNumber.contains("EVEN") && requiredPropertiesOfTheNumber.contains("ODD"))
        || (excludedPropertiesOfTheNumber.contains("EVEN") && excludedPropertiesOfTheNumber.contains("ODD"))) {
            System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]\n" +
                    "There are no numbers with these properties.");
            validaInput = false;
        }
        if (validaInput && (requiredPropertiesOfTheNumber.contains("DUCK") && requiredPropertiesOfTheNumber.contains("SPY"))
        || (excludedPropertiesOfTheNumber.contains("DUCK") && excludedPropertiesOfTheNumber.contains("SPY"))) {
            System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                    "There are no numbers with these properties.");
            validaInput = false;
        }
        if (validaInput && (requiredPropertiesOfTheNumber.contains("SQUARE") && requiredPropertiesOfTheNumber.contains("SUNNY"))
        || (excludedPropertiesOfTheNumber.contains("SQUARE") && excludedPropertiesOfTheNumber.contains("SUNNY"))) {
            System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]\n" +
                    "There are no numbers with these properties.");
            validaInput = false;
        }
        if (validaInput && (requiredPropertiesOfTheNumber.contains("HAPPY") && requiredPropertiesOfTheNumber.contains("SAD"))
        || (excludedPropertiesOfTheNumber.contains("HAPPY") && excludedPropertiesOfTheNumber.contains("SAD"))) {
            System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]\n" +
                    "There are no numbers with these properties.");
            validaInput = false;
        }

        boolean invalidProperties = false;
        String property = "";
        for (int i = 0; i < requiredPropertiesOfTheNumber.size() && !invalidProperties; i++) {
            for (int j = 0; j < excludedPropertiesOfTheNumber.size() && !invalidProperties; j++) {
                if (requiredPropertiesOfTheNumber.contains(excludedPropertiesOfTheNumber.get(j))) {
                    invalidProperties = true;
                    property = excludedPropertiesOfTheNumber.get(j);
                }
            }
        }

        if (invalidProperties) {
            System.out.println("The request contains mutually exclusive properties: ["+property+", "+"-"+property+"]\n" +
                    "There are no numbers with these properties.");
            validaInput = false;
        }

        return validaInput;
    }
    
}
