package chucknorriscipherencoder;

import java.util.Scanner;

/**
 * @author josemaria
 */
public class ChuckNorrisCipherEncoder {

    public static void main(String[] args) {
        String userInput;
        String userDecodeInput;
        String userEncodeInput;
        boolean isValidOption;
        boolean exit = false;
        do {
            do { // Ask the user Option and validate it
                userInput = getString("Please input operation (encode/decode/exit):");
                if (!userInput.matches("encode|decode|exit")) {
                    System.out.println("There is no '"+userInput+"' operation");
                    isValidOption = false;
                } else {
                    isValidOption = true;
                }
            } while (!isValidOption);

            switch (userInput) {
                case "encode" -> {
                    userDecodeInput = getString("Input string: ");
                    System.out.println("Encoded string:\n" +
                                        enCode(userDecodeInput+ "\n"));
                }
                case "decode" -> {
                    userEncodeInput = getString("Input encoded string:");
                    // Validate the enCode Input
                    if (!validateEnCode(userEncodeInput)) {
                        System.out.println("Encoded string is not valid.");
                    } else {
                        System.out.println("Decoded string: ");
                        System.out.println(deCode(userEncodeInput).trim());
                    }
                }
                case "exit" -> exit = true;
            }
        } while (!exit);
        System.out.println("Bye!");

    }

    public static String enCode (String inputToEnCode) {
        StringBuilder binary = new StringBuilder();
        // Transform to binary
        for (int i = 0; i < inputToEnCode.length(); i++) {
            binary.append(String.format("%7s", Integer.toBinaryString(inputToEnCode.charAt(i))).replace(" ", "0"));
        }
        StringBuilder inputEncode = new StringBuilder();
        char previous = binary.charAt(0);
        int count = 1;
        for (int i = 1; i < binary.length(); i++) {
            if (previous == binary.charAt(i)) {
                count++;
            } else {
                if (previous == '1') {
                    inputEncode.append("0 ").append("0".repeat(count)).append(" ");
                } else {
                    inputEncode.append("00 ").append("0".repeat(count)).append(" ");
                }
                previous = binary.charAt(i);
                count = 1;
            }

            if (i == binary.length()-1) {
                if (previous == '1') {
                    inputEncode.append("0 ").append("0".repeat(count)).append(" ");
                } else {
                    inputEncode.append("00 ").append("0".repeat(count)).append(" ");
                }
            }
        }
        return inputEncode.toString().trim();
    }

    public static String deCode (String inputToDecode) {
        String[] inputArray;
        StringBuilder toBinaryWithoutFormat = new StringBuilder();
        StringBuilder toBinaryWithFormat = new StringBuilder();
        String[] binaryArray;
        StringBuilder decode = new StringBuilder();

        inputArray = inputToDecode.split(" ");

        // Translate enCode to binary without format
        for (int i = 0; i < inputArray.length; i+=2) {
            if (inputArray[i].equals("0")) {
                toBinaryWithoutFormat.append(inputArray[i + 1].replaceAll("0", "1"));
            } else {
                toBinaryWithoutFormat.append(inputArray[i + 1]);
            }
        }

        // Makes binary with format
        for (int i = 0; i < toBinaryWithoutFormat.length(); i+=7) {
            toBinaryWithFormat.append(toBinaryWithoutFormat.substring(i, i + 7)).append(" ");
        }

        // Make binary 7 digit array
        binaryArray = toBinaryWithFormat.toString().split(" ");

        // Decode
        for (String s : binaryArray) {
            decode.append((char) Integer.parseInt(s, 2));
        }
        return decode.toString();
    }

    public static boolean validateEnCode (String enCode) {
        // Validate that only contains 0 ans spaces
        boolean isValid = !enCode.matches("^[^0+]+$");

        // The number of blocks is odd;
        String[] enCodeBlocks = enCode.split(" ");
        if (enCodeBlocks.length % 2 != 0 && isValid) isValid = false;

        // Validate that all start block are 0 or 00
        for (int i = 0; i < enCodeBlocks.length && isValid; i+=2) {
            if (!enCodeBlocks[i].matches("^0{1,2}$")) {
                isValid = false;
                break;
            }
        }

        // Validate that the length of the decoded binary string is not a multiple of 7
        if (isValid) {
            String binary = enCodeToBinary(enCodeBlocks);
            if (binary.length() % 7 != 0) isValid = false;
        }

        return isValid;
    }
    public static String enCodeToBinary(String[] enCodeBlocks) {
        if (enCodeBlocks.length % 2 != 0) {
            throw new IllegalArgumentException("The encode is invalid");
        }
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < enCodeBlocks.length; i+=2) {
            if (enCodeBlocks[i].equals("0")) {
                binary.append(enCodeBlocks[i + 1].replaceAll("0", "1"));
            } else {
                binary.append(enCodeBlocks[i + 1]);
            }
        }

        return binary.toString();
    }

    public static String getString (String messages) {
        Scanner sc = new Scanner(System.in);
        System.out.println(messages);
        return sc.nextLine();

    }
    
}
