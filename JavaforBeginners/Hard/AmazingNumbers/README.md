# Amazing Numbers


The project covers basic operations on integers, as well as with collections. Make a program that indicates the properties of the numbers taken from the input.

This Project is separate in **8 Stages** we will describe each stage.

## Stage 1 ✅
Integers can be even or odd. All numbers that end with 0, 2, 4, 6, or 8 are even; the rest are odd. However, numbers have many other properties, you will learn about some of them in this project.

First, let's talk about  **Buzz numbers**. They are numbers that are either divisible by 7 or end with 7. For example, the number 14 is a buzz number, since it is divisible by 7 without a remainder; the number 17 ends with 7, so it is also a buzz number. However, the number 75 is not a Buzz number, since it is neither divisible by 7 nor does it end with 7. The number 7 is a Buzz number too.

Your task at this stage is to write a program that prints the natural number parity and determines whether this number is a Buzz. The program should print why this number is a Buzz number.

Do you know how to determine whether a number is divisible by 7 or not? We have a great tip:

1.  Remove the last digit;
2.  Multiply the removed digit by 2 and subtract it from the remaining number.
3.  If the result of the subtraction can be divided by 7, then the initial number is divisible by 7. You can apply the whole sequence multiple times until you get a relatively small/easy-to-interpret subtraction result.

For example, take 196. We remove the last digit and get 19. We subtract 12 (the removed digit multiplied by 2) to get 7. Since the last left digit is 7, the number is multiple of 7. So 196 is a Buzz number!

You can use any solution you want, the tests won't check it.

### Objectives 🎯
Your program should check whether the given natural number is a buzz number.

1.  Ask a user to enter a natural number.
2.  If the number is not natural, print an error message.
3.  Calculate and print the parity of the number.
4.  Check whether is the number is a Buzz number and print the explanation.
5.  Finish the program after printing the message.

Natural numbers are whole numbers starting from 1.

### Solution 💡
For this Stage I have created a function to validate that an Int is entered. 

First, I validate if the inserted number is positive. 
If it is not positive, I print that it is not a natural number. 
If it is a natural number, we print if the number is **even or odd** by performing the **mod of 2**. We check if it is a **Buzz Number** if it is divisible by 7 or ends in 7. 
We show the explanation 

 - If it is divisible by 7 and ends in 7 we show:<br> ` ... is divisible by 7 and ends with 7`
 - If it is divisible by 7 we only show:<br> `... is divisible by 7`
 - if it ends in 7 we show:<br> `... ends with 7`
 - If it is not Buzz we show: <br> `... is neither divisible by 7 nor does it end with 7
`

Code for Buzz:
``` java
public static boolean isbuzz (int number) {
        String numberString = String.valueOf(number);
        return number % 7 == 0 || numberString.charAt(numberString.length()-1) == '7';
    }
```

## Stage 2 ✅
Your next task is to determine whether a number is a  **Duck number**. A Duck number is a positive number that contains zeroes. For example, 321**0**, 8**0**5**0**896, 7**0**7**0**9 are Duck numbers. Note that a number with a leading 0 is not a Duck number. So, numbers like 035 or 0212 are not Duck numbers. Although, 012**0**3 is a Duck, since it has a trailing 0.

In this stage, we need to simplify the way we display the information. We already have several properties that we need to show; we are going to add new features to our program in each stage. From now on, the card should follow this notation:

```no-highlight
Properties of {number}
{property}: true/false
{property}: true/false
...
{property}: true/false
```

In this stage, the properties are  `even`,  `odd`,  `buzz`  and  `duck`. For  `14`, the program output should look like this:

```no-highlight
Properties of 14
        even: true
         odd: false
        buzz: true
        duck: false
```

The property order, indentation, and spaces are not checked by the tests. The tests are also case-insensitive.

### Objectives 🎯
Your program should print the properties of a natural number. In this stage, your program should:

1.  Ask a user to enter a natural number;
2.  If the number is not natural, the program should print an error message;
3.  If the number is natural, the program should indicate the properties of the number;
4.  Finish the program after printing the message.

### Solution 💡
For this Stage we reuse the base of the previous Stage the `If` to validate if a number is natural or not.
Once with that validated if the number is natural we proceed to print: `Even, Odd, Buzz, Duck`.
To print I have used functions that return a `boolean` for each type. I have encapsulated the code of the Buzz in a function and I have created a function to validate if a number is Duck for it.
- I pass the number to a String
- I return if the number contains any 0's with `contains` of the **String** Class.

``` java
public static boolean isDuck(int number) {
        String numberString = String.valueOf(number);
        return numberString.contains("0");
    }
```

To print if it is of a type or not I have used:
`System.out.println("Type: " + is<Type/>);`

## Stage 3 ✅
In this stage, the program should check whether a number is a  **Palindromic** one. A Palindromic number is symmetrical; in other words, it stays the same regardless of whether we read it from left or right. For example, 17371  is a palindromic number. 5 is also a palindromic number.  1234  is not. If read it from right, it becomes 4321. Add this new property to our program.

In previous stages, the program could process only one number. From now on, the program should accept a request from a user, analyze and execute it. The program should print  `Enter a request`  instead of asking for a natural number. The program should also continue execution unless a user enters a terminate command. Let's make it  `0`  (zero).

Your program should welcome users and print the instructions. At this point, make your program execute two commands. If a user enters a natural number, the program should indicate the properties of that number. If a user enters zero, then the program should exit. If a user enters a negative number by mistake, print an error message.

### Objectives 🎯
In this stage, your program should:

1.  Welcome users;
2.  Display the instructions;
3.  Ask for a request;
4.  Terminate the program if a user enters zero;
5.  If a number is not natural, print an error message;
6.  Print the properties of the natural number;
7.  Continue execution from step 3, after the request has been processed.

### Solution 💡
For this Stage the code is restructured a little because we must make a loop until the user enters 0 to validate.
To solve the loop I have created a `boolean exit` which is initialized to False and the while is `while(!exit)`.
Now it is time to implement the `isPalindromic` function which is structured in:
1. Pass the `long` to `String` using `String.valueOf()`.
2. We pass the `String` to a `StringBuilder` in order to reverse it.
3. We return if the two `String` are equal. If they are equal it is Palindromic 

``` java
public static boolean isPalindromic(long number) {
        String numberString = String.valueOf(number);
        String reverseNumber = new StringBuilder(numberString).reverse().toString();
        return numberString.equals(reverseNumber);
    }
```

## Stage 4 ✅
In this stage, we are going to add one more property —  **Gapful numbers**. It is a number that contains at least 3 digits and is divisible by the concatenation of its first and last digit  **without a remainder**. 12 is not a Gapful number, as it has only two digits. 132 is a Gapful number, as  **1**3**2**  % 12 == 0. Another good example of a Gapful number is 7881, as  **7**88**1 %**  71 == 0.

Until this stage, the program could process only one number at a time. Now, a user should be able to enter two numbers to obtain the properties of a list of numbers. Separate the numbers with one space. Space separates the first number in the list and the length of the list. For, example.  `100 2`  tells the program to process two numbers:  `100`  and  `101`.  `1 100`  means that the program is about to process 100 numbers, starting from  `1`. If a user enters one number, the program should work the same as in the previous stages. The program should analyze a number and print its properties. As before, if a user enters a single  `0`  (zero), terminate the program. Information about each number should be printed in one line in the following format:

```no-highlight
             140 is even, buzz, duck, gapful
             141 is odd, palindromic
```

So, the format is  `{number} is {property}, {property}, ... {property}`

### Objectives 🎯
Your program should process various user requests. In this stage, your program should:

1.  Welcome users;
2.  Display the instructions;
3.  Ask for a request;
4.  If a user enters zero, terminate the program;
5.  If a user enters an empty request, print the instructions;
6.  If numbers are not natural, print an error message;
7.  If one number is entered, calculate and print the properties of this number;
8.  For two numbers, print the list of numbers with properties;
9.  Once the request is processed, continue execution from step 3.

In the current stage, the property names include  `even`,  `odd`,  `buzz`  ,  `duck`,  `palindromic`  and  `gapful`. The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like. Please, add the information below:

### Solution 💡
For this Stage we must implement the following x number.
For it the Input I pass it to an `Array`:<br>
`String[] params = input.split(" ");`
I obtain the first element that is the number:
`n = Long.parseLong(params[0]);`
Now we check if you have passed the second parameter or if you only want to show the data of the number for this we use:
`listLength = params.length == 1 ? 1 : Integer.parseInt(params[1]);`
Which uses a Ternary operand to check if the length of the `Array` is 1 we store 1 but if not we store the number that the user has entered.

After checking we validate if the `listLength` is only 1 we display the values of the Number otherwise we iterate in a `for` as many times as the number entered.

It is also necessary to add the `isGapful` function which is structured:
 We pass the number to a `String` using `String.valueOf()` 2.
2. We check if the number has less than 3 digits we return `false` otherwise we continue validating.
3. We obtain the divisor with this code:
``` java
String divider = numberString.substring(0,1)+numberString.substring(numberString.length()-1);
```
Which obtains the first digit thanks to the `substring()` method that goes from 0 to the exclusive 1 and the last digit by obtaining the length of the string and subtracting 1.
4. Once the `divider` is obtained we return if the mod of the number between the divider returns 0. If it returns 0 it is a `Gapful`.
Code:
``` java
public static boolean isGapful (long number) {
        String numberString = String.valueOf(number);
        if (numberString.length() < 3) {
            return false;
        }
        String divider = numberString.substring(0,1)+numberString.substring(numberString.length()-1);
        return number % Integer.parseInt(divider) == 0;
    }
```

## Stage 5 ✅
In this stage, we will add another property that is called a  **Spy number**. A number is said to be Spy if the sum of all digits is equal to the product of all digits.

Our program calculates the properties of numbers, and also knows how to process a list of numbers. But what if we want to find numbers that have a certain property? For example, in case we want to find ten Buzz numbers starting from 1000. We need to add a new request feature for this. In addition, add a new property — Spy numbers. These numbers hide well, so beware. Your task is to modify the program so that it can search for these numbers.

### Objectives 🎯
Your program should process the user requests. In this stage, your program should:

1.  Welcome users;
2.  Display the instructions;
3.  Ask for a request;
4.  If a user enters zero, terminate the program;
5.  If numbers are not natural, print an error message;
6.  If a user inputs an incorrect property, print the error message and the list of available properties;
7.  For one number, print the properties of the number;
8.  For two numbers, print the list of numbers with their properties;
9.  For two numbers and a property, print the list of numbers and their properties filtered by the indicated property;
10.  Once a request is processed, continue execution from step 3.

In the current stage, the property names include  `even`,  `odd`,  `buzz`,  `duck`,  `palindromic`  ,  `gapful`, and  `spy`. The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like. Please, add the information below:

### Solution 💡
For this Stage we have to implement filters and the Spy Number we start with the Spy number.

To implement the Spy number I have created a function which validates if the number is Spy or not called `isSpy` and it is structured:
1. We convert the number to a `String` using `String.valueOf()` 2.
2. We create an `Array` of all digits using `split("")` which separates character by character.
3. Iterate in a `foreach` all digits and store the sum of all digits and in another variable the product of all digits.
4. We compare if the **sum** and **product** are equal. If they are equal it is a Spy number.

The function:
``` java
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
```

We must now modify the User Input implementation to allow you to enter a filter.
To do this first for readability I have created an Enum which stores all types of numbers:
``` java
public enum NumbersType {
    ALL, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD
}
```
For user input we add a small piece of code to store the constraint.
``` java
boolean restrictionType = params.length == 3;
            NumbersType numbersType = NumbersType.ALL;
            if (restrictionType) {
                numbersType = isValidType(params[2]);
            }
```
The code checks if 3 elements exist we initialize the `numbersType` to `ALL` and if `restictionType` is true we assign the type.

Then in the part of the code to iterate and display the next n we must add an `if` which is:
``` java
if (numbersType == NumbersType.ALL) {
                            for (int i = 0; i < listLength; i++) {
                                System.out.println(printInlineProps(n++, numbersType));
                            }
                        } else {
                            while (listLength != 0) {
                                String numberOutput = printInlineProps(n++,numbersType);
                                if (!numberOutput.isEmpty()) {
                                    System.out.println(numberOutput);
                                    listLength--;
                                }

                            }
                        }
```
This code checks if the `numbersType` is `ALL` if so we display the next n otherwise we iterate until we get the numbers contained in the ENUM.

## Stage 6 ✅

 N is a  **sunny**  number if N+1 is a  **perfect square**  number. In mathematics, a square  number or a perfect square is an integer that is the square of an integer; in other words, it is the product of an integer with itself. For example, 9 is a square number, since it equals 32  and can be written as 3×3.

Our program can search for Spy and Palindromic numbers. What if we want to find all even Spy numbers? Or find all odd numbers among Palindromic numbers? Are there any Palindromics that are also Spies? In this stage, you will add the ability to search for several properties at once!

What if a user enters the same property twice by mistake? For example, they want to find all even numbers that are even? Just ignore this duplicate property. What about two mutually exclusive properties? For example, if a user wants to find even numbers that are odd. In this case, the program will initiate the search, but there are no such numbers. We need to make our program foolproof. If a request contains mutually exclusive properties, the program should abort this request and warn the user. There are three pairs of mutually exclusive properties. A request cannot include  **Even and Odd**,  **Duck and Spy**,  **Sunny and Square** numbers.

### Objectives 🎯
Your program should process the user requests. In this stage, your program should:

1.  Welcome users;
2.  Display the instructions;
3.  Ask for a request;
4.  If a user enters zero, terminate the program;
5.  If numbers are not natural, print the error message;
6.  If an incorrect property is specified, print the error message and the list of available properties;
7.  For one number, calculate and print the properties of the number;
8.  For two numbers, print the list of numbers with their properties;
9.  For two numbers and one property, print the numbers with this property only;
10.  For two numbers and two properties, print the numbers that have both properties.
11.  If a user specifies mutually exclusive properties, abort the request and warn a user.
12.  Once a request has been processed, continue execution from step 3.

In the current stage, the property names include  `even`,  `odd`,  `buzz`  ,  `duck`,  `palindromic`  ,  `gapful`  ,  `spy`,  `square`, and  `sunny`. The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like. Please, add the information below:

### Solution 💡
For this Stage the first thing is to implement the `isPerfectSquare` and `isFunny` function which is structured:
**isPerfectSquare**:
1. We perform the square root of the number.
2. We return if the square root raised to 2 is equal to the number. If it is equal the number is a **PerfectSquare**.
Code:
``` java
public static boolean isPerfectSquare (long number) {
        long sqrt = (long) Math.sqrt(number);
        return sqrt * sqrt == number;
    }
```

**isFunny**:
1. A number is funny when the `number +1` is a **PerfectSquare** number.
Code:
``` java
public static static boolean isSunny (long number) {
        return isPerfectSquare(number + 1);
    }
```
And the **last thing** is to adapt to obtain if the user has inserted two filters and to check that these filters are not contradictory.

For it I followed the same procedure that with the first filter to verify if a second filter exists to add it and the function `printInlineProps` now receives an `Array` of `NumbersType` and If the number does not contain all the `NumbersType` 
We return the `String` empty. 

## Stage 7 ✅
A number is a  **Jumping number** if the adjacent digits inside the number differ by 1. The difference between 9 and 0 is not considered as 1. Single-digit numbers are considered Jumping numbers. For example, 78987, and 4343456 are Jumping numbers, but 796 and 89098 are not.

In this stage, we will also remove the limitation on pending properties in a request. The program knows how to calculate ten properties of numbers, and it would be strange to limit the query to just two properties. Let's remove this limitation. Let the program indicate all properties for all numbers in the request.

### Objectives 🎯
Your program should process the user requests. In this stage, your program should:

1.  Welcome users;
2.  Display the instructions;
3.  Ask for a request;
4.  If a user enters zero, terminate the program;
5.  If numbers are not natural, print the error message;
6.  If an incorrect property is specified, print the error message and the list of available properties;
7.  For one number, print the properties of the number;
8.  For two numbers, print the list of numbers with their properties.
9.  For two numbers and properties, print the numbers with the specified properties;
10.  If a user specifies mutually exclusive properties, abort the request and warn the user;
11.  Once a request has been processed, continue execution from step 3.

In the current stage, the property names include  `even`,  `odd`,  `buzz`,  `duck`,  `palindromic`,  `gapful`,  `spy`,  `square`,  `sunny`, and  `jumping`. The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like.

### Solution 💡
For this Stage the first thing I have realized is a function to check when it is a **jumping number** called `isJumpingNumber` and I have structured it:
1. Create a `boolean` variable that is initialized to `true`.
2. Pass the number to a `String` with `String.valueOf()`.
3. Create an `Array` for each digit with `split("")`.
4. Create a `for` that iterates all the numbers and checks if the digit and the next digit are 1 if the difference is not 1 we set the `boolean` to `false` .
5. We return the `boolean` .
The code is:
```java
public static boolean isJumping (long number) {
        boolean isJumping = true;
        String numberString = String.valueOf(number);
        String[] digits = numberString.split("");
        for (int i = 0; i < digits.length - 1 && isJumping; i++) {
            if (Math.abs(Integer.parseInt(digits[i]) - Integer.parseInt(digits[i+1]))) != 1) {
                isJumping = false;
            }
        }
        return isJumping;
    }
```
 And it is time to delimit the number of filters for them already using a loop and an `Array` of `NumbersType` that iterates from the 3rd element to the length of the Array.

## Stage 8 ✅
In number theory, a  **happy** number is a number that reaches 1 after a sequence during which the number is replaced by the sum of each digit squares. For example, 13 is a happy number, as 12 + 32= 10  which leads to 12  + 02  = 1. On the other hand, 4 is not a happy number because the sequence starts with 42  = 16, 12  + 62  = 37, and finally reaches 22  + 02  = 4. This is the number that started the sequence, so the process goes on in an infinite cycle. A number that is not happy is called  **Sad**  (or  **Unhappy**).

Our program is finished. It can indicate many interesting properties of numbers, it knows how to calculate them. Now, when prompted, a user can have a list of number properties. To complete the program, let's add an ability to exclude a property from the search query. If a user puts a  **minus** (`-`) before the property, exclude this property from the search query. For example, if a user specifies  `palindromic -duck`, it means that they are looking for Palindromic numbers that are not Ducks.

### Objectives 🎯
Your program should process the user requests. In this stage, your program should:

1.  Welcome users;
2.  Display the instructions;
3.  Ask for a request;
4.  If a user enters an empty request, print the instructions;
5.  If the user enters zero, terminate the program;
6.  If numbers are not natural, print the error message;
7.  If an incorrect property is specified, print the error message and the list of available properties;
8.  For one number, print the properties of the number;
9.  For two numbers, print the properties of all numbers in the list;
10.  For two numbers and two properties, print the list of numbers that contain the specified properties;
11.  If a property is preceded by a minus, this property should not be present in a number;
12.  If the user specifies mutually exclusive properties, abort the request and warn the user.
13.  Once the request is processed, continue execution from step 3.

### Solution 💡
In this stage, property names include  `even`,  `odd`,  `buzz`,  `duck`,  `palindromic`,  `gapful`,  `spy`,  `sunny`,  `square`,  `jumping`,  `sad`, and  `happy`. Mutually exclusive properties are  **even/odd**,  **duck/spy**,  **sunny/square**,  **sad/happy** pairs, as well as direct opposites (`property`  and  `-property`). The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like.

For this Stage the first thing is to implement the **happy numbers** the code is:
```java
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
```
 And also implement the filter with `-` for them we create two `Array` one with what it must have and another with what it must not have and we iterate and if it starts with `-` we add it to one and if it does not have `-` we add it to the other.
> **Thank you for reading the project and I hope you find it useful 😉 <br>
> If you liked it please give me ⭐️**
