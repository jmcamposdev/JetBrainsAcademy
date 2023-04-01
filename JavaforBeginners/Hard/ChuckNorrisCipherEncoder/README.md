# Chuck Norris Cipher Encoder
This project will allow us to deal with string and character variables and work with loops and conditional statements. Get familiar with the binary notation and data type conversion. Create an application for the unary representation and decoding of any text.

This Project is separate in **5 Stages** we will describe each stage.

## Stage 1
To begin with, you will learn how to divide an encrypted message into the characters that it contains. You will need this for further work.

### Objectives 🎯
In this stage, your program should:

1.  Read a string from a console. The input contains a single line.
2.  Output all characters in the string, separated by one space (including the space characters themselves).

### Solution 💡
For this first Stage it is simple, I have created a `for` which prints the character on the screen with `charAt()` plus a space, the code would be:
```java
Scanner sc = new Scanner(System.in);
System.out.println("Input string:\n");
String input = sc.nextLine();
String[] splitString = input.split("");
for (int i = 0; i <input.length(); i++) {
	System.out.print(input.charAt(i)+" ");
}
```

## Stage 2 ✅
In this stage, you'll learn how to convert each character of a string into a binary form. Any ASCII character has a size of 7 bits; in binary, the form is  `0`  and  `1`. For example, the character  `A`  has a decimal value of  `65`. The binary representation is  `1000001`.  `b`  is  `98`  in decimal or  `1100010`in binary. The space character is  `32`  in decimal value or  `0100000`  in binary.

In this stage, you will learn to represent characters in binary form.

### Objectives 🎯
In this stage, your program should:

1.  Read a string from a console. The input contains a single line.
2.  Print  `The result:`  line, followed by each character of input on a separate line, formatted as  `<char> = <binary value>`.

Note that the binary representation must be 7-bit, even if the first digits are zeros. The  `Integer.toBinaryString()`  and  `String.format()`  methods can help you with that.

### Solution 💡
In this Stage the most difficult thing is to establish that all the characters must have 7 digits in binary for it I have created a function called `calculateBinary` to which you pass a char and it returns the binary with 7 digits. 
For them it is structured:
1. We convert the `char` to `int` with an implicit casting.
2. We pass the `int` to binary thanks to `String.toBinaryString`.
3. Then we iterate the `String` if it has less than 7 digits to insert 0 in front of it.
8. We return the binary `String`.
The code:
```java
public static String calculateBinary(char c) {
        int hex = c;
        String binary = Integer.toBinaryString(hex);
        for (int i = binary.length(); i < 7; i++) {
            binary = "0"+binary;
        }
        return binary;
    }
```

Then I found a much simpler way to convert on a single line using print formatting. And it goes like this:
``` java
for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i)+
                    " = " +
                    String.format("%7s",Integer.toBinaryString(input.charAt(i))).replace(" ", "0"));
        }
```
With this code we pass the character to binary as before but when entering the `%7s` format it forces that the `String` must have 7 characters and if it does not have 7 characters it enters spaces, that is why we put the `replace(" ", "0")` to replace all the spaces by 0.

All of the above is simply converting the user `String` to an `Array` using `split("")`.

## Stage 3 ✅
Binary with  `0`  and  `1`  is good, but binary with only  `0`  is even better! This encoding has a name — the Chuck Norris Unary Code.

Let's convert our text into a sequence of zeros and spaces!

### Objectives 🎯
The encoding principle is simple. The input message consists of ASCII characters (7-bit). You need to transform the text into the sequence of  `0`  and  `1`  and use the Chuck Norris technique. The encoded output message consists of blocks of  `0`. A block is separated from another block by a space.

Two consecutive blocks are used to produce a series of the same value bits (only  `1`  or`0`  values):

-   First block: it is always  `0`  or  `00`. If it is  `0`, then the series contains  `1`, if not, it contains  `0`
-   Second block: the number of  `0`  in this block is the number of bits in the series

Let's take a simple example with a message which consists of only one character  `C`. The  `C`  symbol in binary is represented as  `1000011`, so with Chuck Norris technique this gives:

-   `0 0`  (the first series consists of only a single  `1`);
-   `00 0000`  (the second series consists of four  `0`);
-   `0 00`  (the third consists of two  `1`)
-   So  `C`  is coded as:  `0 0 00 0000 0 00`

Make sure, that an encoding of a single character sequence is not separated. For example,  `000`  should be encoded as  `00 000`  and not as  `00 0 00 0 00 0`  or  `00 0 00 00`  or  `00 00 00 0`

In this stage, your program should:

1.  Read a string from a console. The input contains a single line.
2.  Print  `The result:`  line, followed by a line with an encoded message.

### Solution 💡
In this Stage I have refactored the function ` convertToBinary` now it receives an `Array` of `char` and returns a `String` fully converted to binary the code would be:
``` java
public static String convertToBinary (char[] c) {
         String binary = "";
         for (int i = 0; i < c.length; i++) {
             binary += String.format("%7s",Integer.toBinaryString(c[i])).replace(" ","0") ;
         }
         return binary;
     }
```
Now it's time to convert the binary to Chuck Norris Code for that I have created a function called `convertBinaryToChuckNorris` which iterates all the binary `String` and works by checking the previous character.
1. The first thing checks if the character is equal to the previous one if that is true it adds +1 in a counter.
2. If it is not the same as above. We check the previous one is equal to `1` if that is true we save `"0 "` and as many `"0"` as there are repeats otherwise we insert a 0 instead we insert `"00 "`.
3. Finally we check if the last character is a `1` or a `0` to insert `"0 "` or `"00 "` respectively.

The code would be like this:
``` java
public static String convertBinaryToChuckNorris(String binary) {
         String chuckNorris = "";
         char previous = binary.charAt(0);
         String encoding = "0";
         int count = 1;
         for (int i = 1; i < binary.length(); i++) {
             if (previous == binary.charAt(i)) {
                 count++;
             } else {
                 if (previous == '1') {
                     chuckNorris += "0 "+encoding.repeat(count)+" ";
                 } else {
                     chuckNorris += "00 "+encoding.repeat(count)+" ";
                 }
                 previous = binary.charAt(i);
                 count = 1;
             }

             if (i == binary.length()-1) {
                 if (previous == '1') {
                     chuckNorris += "0 "+encoding.repeat(count)+" ";
                 } else {
                     chuckNorris += "00 "+encoding.repeat(count)+" ";
                 }
             }
         }
         return chuck Norris;
     }
```

## Stage 4 ✅
In this stage, you will write a decoder for a cipher. You need to transform the encrypted message into its original format.

### Objectives 🎯
Your program receives a string of zeros and spaces and converts it to readable text. You must parse the string to the blocks of zeroes and decode the message the same way as in previous stages but in reversed order.

For example, your program receives  `0 0 00 0000 0 000 00 0000 0 00`. You can split blocks of zeros and group those blocks by two. Then you need to decode these blocks like in the previous stage:

-   `0 0`  is  `1`
-   `00 0000`  is  `0000`
-   `0 000`  is  `111`
-   `00 0000`  is  `0000`
-   `0 00`  is  `11`

Concatenation of the lines above gives us  `10000111000011`.

After that, you need to split the result into blocks of seven symbols (binary form) and convert these blocks to characters. In this case, splitting  `10000111000011`  by seven symbols gives us two characters —  `1000011`  `1000011`  , convert them into characters and the result will be  `CC`  (`C`is  `1000011`).

In this stage, your program should:

1.  Read a string from a console. The input contains a single line of spaces and  `0`  characters.
2.  Print  `The result:`  line, followed by a line with a decoded message.

The  `Integer.parseInt()`  method might be useful at this stage.

### Solution 💡
For this Stage I have refactored the `encode` a bit by adding the binary translation inside and now it is time to develop the `decode` for this I have structured it:
1. Pass the `String` to binary.
2. Format the `Binary String` by adding spaces every 7 characters.
3. Create an `Array` of every 7 binary digits.
4. Pass each element of the `Array` thanks to `Integer.parseInt(<binary/>, 2)` the 2 means that it is in base 2. And make an explicit cast to `char`.

The code would be:
``` java
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
```

## Stage 5 ✅
Let's finish our encryption-decryption software by adding a simple user interface. The program asks the user for the desired option (encode/decode/exit), performs it, and all that in a loop until the user wants to finish.

### Objectives 🎯
n this stage, your program should:

1.  Ask users what they want to do, encode a string, decode a string or quit the program with  
    `Please input operation (encode/decode/exit):`
2.  If user inputs  `encode`  as the desired operation, the program should print  `Input string:`to the output, read a line and output two lines —  `Encoded string:`  followed by the encoded string;
3.  If user inputs  `decode`  as the desired operation, the program should print  `Input encoded string:`  to the output, read a line and output two lines —  `Decoded string:`  followed by the actual decoded string;
4.  If user inputs  `exit`  as the desired operation, the program should say  `Bye!`  and finish its execution.

The program should be looped to terminate only if the user inputs  `exit`  as an operation. Otherwise, it should continue asking users  `Please input operation (encode/decode/exit):`  after each iteration.

Also, let's prevent some incorrect input.

1.  If the user misspells the operation name, the program should print out  `There is no '<input>' operation`
2.  If the user provided an incorrect encoded message as input to decode, the program should print out appropriate feedback containing  `not valid`  substring

List of not valid encoded messages:

-   The encoded message includes characters other than  `0`  or spaces;
-   The first block of each sequence is not  `0`  or  `00`;
-   The number of blocks is odd;
-   The length of the decoded binary string is not a multiple of 7.

### Solution 💡
For this Stage, the first thing is to validate that you enter `(encode,decode,exit)` to validate it I have used a regex which is:<br>`userInput.matches("encode|decode|exit")`

If the input is not valid, you will be asked to enter it again.
If it is valid, I proceed to use a `switch` for each option:
For the `encode` option it is not necessary to validate it.
For the `decode` option it is necessary to validate the input, for this I have created a function called `validateEnCode` which validates that it is formed only with 0 and spaces that contain one or two continuous 0s which mark if they are 0 or 1 and validate the The length of the binary `String` must be a multiple of 7.
The code is:
``` java
public static boolean validateEnCode(String enCode) {
         // Validate that only contains 0 ans spaces
         boolean isValid = !enCode.matches("^[^0+]+$");

         // The number of blocks is odd;
         String[] enCodeBlocks = enCode.split(" ");
         if (enCodeBlocks.length % 2 != 0 && isValid) isValid = false;

         // Validate that all start blocks are 0 or 00
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
```

Finally add the exit option which controls a `boolean` to exit the `while`. and end the program

> **Thank you for reading the project and I hope you find it useful 😉 <br>
> If you liked it please give me ⭐️**
