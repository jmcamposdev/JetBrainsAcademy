# Bulls and Cows


Learn how to use integer arithmetic, generate random numbers, store data in data structures, and handle errors.

This Project is separate in **7 Stages** we will describe each stage.

## Stage 1 ✅
Let's start by reminding ourselves how the game goes. There are two players: the first writes a secret 4-digit code using different digits, and the second has to guess it. At each turn, the second player writes a 4-digit number that they think might be the correct answer. Then, the first player grades that answer using bulls and cows as a notation. If a digit in the given answer matches a digit and its position in the code, it's called a "bull." If a given digit appears in the code but its position doesn't match, then it's called a "cow." The first player reveals how many bulls and cows there are. The information is general; in other words, it isn't bound to any particular digit. For example:

The code is 4931.  
The answer is 1234.  
The grade is 1 bull and 2 cows.

Here, 3 is a bull, 1 and 4 are cows. If all the digits are bulls, the secret code has been guessed and the game ends. If not, the game continues and the second player tries again.  
  
This may sound rather complicated, but don't worry, we will take it very gradually. In this stage, you will not even have to implement the gameplay: all you need to do now is output the text that could be in the game. In other words, you don't have to worry about handling any requests or processing data: your goal is to display an example text of the game.

### Objectives 🎯
In this stage, your program should:

-   Print a predefined game log that contains at least two turns.
-   The output to be graded is a 4-digit code consisting of unique digits.
-   The last line of your output contains a secret number.

> Your program should not take any input data. You only have to print a
> static game log

### Solution 💡
In this Stage we structure the output of the program and it would look like this:
``` java
System.out.println("The secret code is prepared: ****.\n");
        System.out.println("Turn 1. Answer:");
        System.out.println("1234");
        System.out.println("Grade: None.\n");
        System.out.println("Turn 2. Answer:None.\n" +.
                "9876\n" +
                "Grade: 4 bulls.\n" +.
                "Congrats! The secret code is 9876.");
```

## Stage 2 ✅
Let's add some interactivity to our program. The program should create a 4-digit secret code, and the player should try to guess it on the first try. The program should give a grade to evaluate how accurate the player was.

As you remember, a correctly guessed digit is a cow, and if its position is also correct, then it is a bull. After the player tries to guess the secret code, the program should grade the attempt and finish the execution.

For example, if the secret code is  `9305`, then:

1.  The number  `9305`  contains 4 bulls and 0 cows since all 4 digits are correct and their positions are correct as well. It's the only number that can contain 4 bulls, so it's also the secret code itself.
2.  The numbers  `3059`,  `3590`,  `5930`,  `5039`  contain 0 bulls and 4 cows since all 4 digits are correct but their positions don't match the positions in the secret code.
3.  The numbers  `9306`,  `9385`,  `9505`,  `1305`  contain 3 bulls.
4.  The numbers  `9350`,  `9035`,  `5309`,  `3905`  contain 2 bulls and 2 cows.
5.  The numbers  `1293`,  `5012`,  `3512`,  `5129`  contain 0 bulls and 2 cows.
6.  The numbers  `1246`,  `7184`,  `4862`,  `2718`  contain 0 bulls and 0 cows.

Note that guesses can contain repetitive digits, so:

1.  The number  `1111`  contains 0 bulls and 0 cows.
2.  The number  `9999`  contains 1 bull and 3 cows.
3.  The number  `9955`  contains 2 bulls and 2 cows.

### Objectives 🎯
In this stage, your goal is to write the core part of the game: the grader.

1.  Your program should take a 4-digit number as an input.
2.  Use a predefined 4-digit code and grade the answer that was input. You can do it digit by digit.

The grade is considered correct if it contains number-and-word pairs (like  `X bulls and Y cows`) that give the correct information. If the answer doesn't contain any bulls and cows, you should output  `None`.

### Solution 💡
In this Stage we assign a secret code which is `9305` and calculate how many `bulls` and `cows` for it we make a loop which is:
``` java
void checkCode() {
        // Checks if the user's input is identical to the secret code
        if (userInput.equals(secretCode)) {
            this.bulls = 4;
        } else {
            for (int i = 0; i < secretCode.length(); i++) {
                // if the characters are the same
                if (this.userInput.charAt(i) == secretCode.charAt(i)) {
                    addBulls();
                // if the secret code contains the character
                } else if (secretCode.contains(String.valueOf(userInput.charAt(i)))) {
                    addCows();
                }
            }
        }
    }
```

And then we print if it has guessed the code if it has `4 bulls` or if it has any `bull` or `cow` we tell it and if it has not got any we tell it.

## Stage 3 ✅
Using a predefined secret code doesn't make a fun game. Let's implement the ability to generate a pseudo-random secret number of a given length. If the length is greater than 10, print a warning message and do not generate a number.

### Objectives 🎯
In this stage, your program should generate a pseudo-random number of a given length with unique digits and print it. If the length is greater than 10, the program should print a message containing the word `Error`. The secret code may contain any digits from 0 to 9 but only once. The secret code shouldn't start with a digit 0: for the first digit of the secret code, use digits from 1 to 9.

### Solution 💡
In this Stage we discuss most of the code to implement the random number generator. For this I have created a function called:<br>`public static long generateRandomNumber(int length)`
In which we create a random number thanks to the `Math` class and it is: <br>`generateNumber += (int) (Math.random()*(9-1+1)+1);`

Which generates a number between 0 and 1 and we create a `while` that iterates until the number does not reach the desired length the code looks like this:
```java
public static long generateRandomNumber(int length) {
        String generateNumber = "";
        int random number;
        generateNumber += (int) (Math.random()*(9-1+1)+1); // Adding the first number 1 - 0
        while (generateNumber.length() != length) {
            randomNumber = (int) (Math.random() * (10)); // Generate a random number in the range 0 - 9
            if (!generateNumber.contains(String.valueOf(randomNumber))) {
                generateNumber += random number;
            }
        }
        return Integer.parseInt(generateNumber);
}
```
In the Main we show an error if the length is greater than 10:
```java
if (length >= 10) {
	System.output.println("Error");
} else {     
	System.out.println(generateRandomNumber(length));
}
```

## Stage 4 ✅
In this stage, you should combine all the previous parts into a simple playable version of the "Bulls and Cows" game. First, prompt the player to input the length of the secret code. The length will determine the difficulty level for the current game session. The program should generate a secret code of the given length. Remember that it should consist of unique numbers.

Then, the game starts and the program prompts the player to guess the code. When the player inputs a number, the program should grade it in bulls and cows. The game goes on until the code is guessed, that is, until the number of bulls is equal to the number of digits in the code. When the game ends, the program should finish its execution.

### Objectives 🎯
In this stage, your program should:

1.  Ask for the length of the secret code and then generate the code.
2.  Wait for the user input.
3.  Grade the guessing attempt in bulls and cows.
4.  If the secret code has been guessed, the program stops; otherwise, return to the second step.

### Solution 💡
In this Stage the first thing is to implement the validation by inserting the length of the secret code for this I have used a `do while` and the code is:
```java
do {
            System.out.println("Please, enter the secret code's length:\n> ");
            length = sc.nextInt();
            if (length > 10) {
                System.out.println("Error");
            }
        } while (length > 10);
```
Then we generate the number with the length and enter another `do while` which does not exit until the `bulls` are equal to the length of the number.
The code is: 
```java
do {
            System.out.println("Turn "+turns+":");
            System.out.print("> ");
            userInput = sc.next();
            accert = bullsAndCows.calculateBullsCows(userInput);
            if (accert[0] == length) {
                System.out.println("Grade: "+length+" bulls");
                System.out.println("Congratulations! You guessed the secret code.");
            } else if (accert[0] > 0 || accert[1] > 0) {
                System.out.println("Grade: "+accert[0]+" bulls and "+accert[1]+" cow");
            } else {
                System.out.println("None");
            }
            turns++;
        } while (accert[0] != length);
```
For it the class `BullsAndCows` with the method `calculateBullsCows` returns us an `Array` of `int` in which the first position are the `bulls` and in the second are the `cows`.

## Stage 5 ✅
The algorithm suggested for generating the secret code in the previous stage was really a “reinvention of the wheel”. Java already has the tools for generating random numbers! Research some common pseudo-random generation methods such as  `Math.random()`  and other methods from the  `Random`  class. Choose the method you like and use it to rewrite the secret code generation.

Nothing else is supposed to change at this stage: the program asks for the length, generates a secret code, and then receives and grades the attempts until the code is guessed. Your task here is to rewrite the code generator without breaking the existing code.

### Objectives 🎯
In this stage, rewrite the secret code generator using a suitable Java method.

### Solution 💡
We are already ahead of this Stage since the code generator uses `Math.random` so this Stage can be skipped.

## Stage 6 ✅
Some players need a challenge, so let's make the secret code in the game harder to guess. Add support for more than 10 symbols by adding letters. Now, the secret code can contain the numbers  `0-9`  and the lowercase Latin characters  `a-z`. The new maximum length for the code is 36. Note that the length of the secret word may not match the number of possible characters in the secret code, so you should request input twice: once for the secret code length and once for the number of possible characters.

Also, since a secret code is not a number anymore, the symbol  `0`  should be allowed as the first character in a secret code.

### Objectives 🎯
In this step, your program should:

1.  Ask for the length of the secret code.
2.  Ask for the range of possible characters in the secret code.
3.  Generate a secret code using numbers and characters. This time, you should also print the secret code using  `*`  characters and print which characters were used to generate the secret code.
4.  Function as a fully playable game.

### Solution 💡
For this Stage, the first thing is to implement the request to the user to enter how many possible characters he wants to appear. Once the data is requested. We proceed to create the `secret code`.

For this I have created a `static` variable which contemplates all the possibilities:
```java
public static final String POSSIBILITIES = "0123456789abzdefghijklmnopqrstuvwxyz";
```
With this and a function called `generateRandomCode` which is structured:
1. Instantiate a `Random` class
2. Iterate through a `for` as many times as the length you want.
3. Within the `for` a `do while` that generates a random number which obtains the `charAt` of `POSSIBILITIES` and if that character is already in the String, it generates another one again.

The code is:
``` java
public static String generateRandomCode (int length, int posibleCharacters) {
        String secretCode = "";
        Random random = new Random();
        String randomPart = "";
        for (int i = 0; i < length; i++) {
            do {
                randomPart = String.valueOf(POSSIBILITIES.charAt(random.nextInt(posibleCharacters)));
            } while (secretCode.contains(randomPart));
            secretCode += randomPart;

        }
        return secretCode;
    }
```

## Stage 7
There are a lot of error possibilities. What if someone enters an answer of the wrong length? Or the number of possible symbols is less than the length of the code? What if the answer contains invalid symbols? The game may crash before the secret number was guessed!

Let's handle errors like this. At this point, you can implement this without the  `try catch`construction. Use the following rule of thumb: if you can avoid the exception-based logic, avoid it! If you use exceptions in normal situations, how would you deal with unusual (exceptional) situations? Now it may not seem that important, but when you need to find errors in more complex programs, this makes a difference.

### Objectives 🎯
In this stage, your program should:

1.  Handle incorrect input.
2.  Print an error message that contains the word  `error`. After that, don't ask for the numbers again, just finish the program.

### Solution 💡
For this Stage I have created a function called `getInt` which validates that a number is entered and the function is:
``` java
public static int getInt(String message, int minimum, int maximum) {
         Scanner sc = new Scanner(System.in);
         int number;
         do {
             System.out.print(message);
             while (!sc.hasNextInt()){
                 System.out.println("Enter a numeric value.");
                 System.out.print(message);
                 sc. nextLine();
             }
             number = sc.nextInt();
             if (number < minimum || number > maximum){
                 System.out.println("The range is not adequate");
             }
         } while (number < minimum || number > maximum);
         return number;
     }
```

This function is used to request the user the length of the secret number and the number of characters he wants.

> **Thank you for reading the project and I hope you find it useful 😉 <br>
> If you liked it please give me ⭐️**
