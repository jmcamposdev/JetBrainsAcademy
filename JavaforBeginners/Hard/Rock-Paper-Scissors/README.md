# Rock Paper Scissors Game

I present the Rock-Paper-Scissors game project from JetBrains Academy. This is a fun and interactive game that can be played in Player vs. Computer mode, 
In this project we will learn:

 - `Ramdom` Class
 - Formatted Strings
 - OPP
 - File management (Reading, Writing)

This Project is separate in **5 Stages** we will describe each stage.

## Stage 1 ✅
The program will read input from the user and then select an option that defeats the one picked by the user. The output will display `"Sorry, but the computer chose <option\>"`, where <option\> is the name of the option that the program's picked depending on the user's input.

For example, if the user enters "rock", the program will print "Sorry, but the computer chose paper". The computer will always win in this version of the game, selecting the option that defeats the user's choice:

-   If the user chooses paper, the computer chooses scissors.
-   If the user chooses scissors, the computer chooses rock.
-   If the user chooses rock, the computer chooses paper.

### Objective 🎯
The program should:

 -  Take input from the user;
-   Find an option that wins over the user's option.
-   Output the line:  `Sorry, but the computer chose <option>`

### Solution 💡
For the First Stage. I implement a user Input and with that input used a switch that uses userInput and depending on what has been entered I print the corresponding output.

## Stage 2 ✅
Now we will change the game a little bit, the program reads input from the user, generates a random option using the class `Ramdom`, and then displays who won - the user or the computer.

Here are a few examples of the possible outcomes and the output that the program will display:

-   Loss: "Sorry, but the computer chose <option\>;"
-   Draw: "There is a draw (<option\>);"
-   Win: "Well done. The computer chose <option\> and failed;"

The power of the Random class is used to create a more unpredictable and exciting game for the players. So get ready to challenge yourself and test your luck against the computer in this fun and interactive game!

### Objective 🎯
The program should:

-   Read the user input that includes an option;
-   Choose a random option;
-   Compare the options and determine the winner;
-   Output one of the lines above depending on the result of the game.

### Solution 💡
For the second stage I  started again I have only left the user input.
I have created an array which stores the possible win combinations.
`public static Choice[][] winningCombinations = {
            {Choice.ROCK,Choice.SCISSORS},
            {Choice.PAPER, Choice.ROCK},
            {Choice.SCISSORS,Choice.PAPER}
    };`

Those combinations are based on an ENUM called **Choice** which contains **(ROCK, PAPER, SCISSOR)** .
A **random** number is generated between 0 and the number of objects in the ENUM and with that number
I get the option of the computer.

Now I check if they are equal to print `There is a draw(<option>);`
If it isn't equals, I check that the user input is equal to the losing option thanks to this line of code:
`if (userChoice == winningCombinations[computerChoice.ordinal()][1]`

If it is the same, it means that the user has lost and we print:
`Sorry, but the computer chose <option>;`
if it is not equal it means that the user has won and we print:
`Well done. The computer chose <option> and failed;`

## Stage 3 ✅
In the previous stage, we developed a Rock-Paper-Scissors game. However, it was just a single shot, which is not very engaging. In this new stage, we aim to make the game last forever by allowing users to play multiple times.

The program is now designed to take unlimited inputs until the user types `"!exit"`, which will terminate the program with a `"Bye!"` message. To handle any invalid inputs, the program is designed to recognize typos and incorrect inputs, and output a corresponding message: `"Invalid input."`

### Objective 🎯

The program should:

-   Take input from users;
-   If the input contains  `!exit`, output  `Bye!`  and stop the game;
-   If the input is the name of the option, then pick a random option and output a line with the result of the game in the following format (`<option>`  is the name of the option chosen by the program):
    -   Loss:  `Sorry, but the computer chose <option>`
    -   Draw:  `There is a draw (<option>)`
    -   Win:  `Well done. The computer chose <option> and failed`
-   If the input corresponds to anything else, output  `Invalid input`;
-   Repeat it all over again.

### Solution 💡
For the solution of this stage I have created a method called `play`:
```public static void play (Choice userChoice);```
The method receives the User's Choice and prints if he or the machine has won by reusing the code from the previous Stage.

In the **Main** I have created a While that iterates until the user enters `"!exit"` and inside a Do While to validate that the user can only insert **(!exit,rock,paper,scissors)** validated with a regular expression:
```userInput.matches("!exit|rock|paper|scissors")```

Once validated, proceed to play or exit the program.

## Stage 4 ✅
People love to see their results as they're advancing to their goals. So, let's learn how to show the scoreboard!

When the game starts, users must be able to enter their names. After that, the program should greet users and read a file named  *rating.txt*

It is the file that contains the current scores for different players. You can see the file format below: lines containing usernames and their scores, divided by a single space:

```
Tim 350
Jane 200
Alex 400
```
Take the current user score from the file and use it as a basis for counting the score during the game. For example, if a user entered `Tim`, then their score at the start of the game is `350`. If a user inputs a name that is not on the list, the program should count the score from `0`.

Print the user score with the  `!rating`  command. For example, if your rating is  `0`, then the program should print:

```no-highlight
Your rating: 0
```

Add  `50`  points for every draw,  `100`  for every win, and  `0`  for losing.

### Objectives 🎯
Your program should:

-   Output a line  `Enter your name:`. Users enter their names on the same line (not the one following the output!);
-   Read input with the name and output a new line:  `Hello, <name>`
-   Read  _rating.txt_ and check whether it contains an entry with the current username. If yes, use the score specified in the file as a starting point. If not, start the score from  `0`.
-   Play the game by the rules defined in the previous stages and read the user input;
-   If the input is  `!exit`, output  `Bye!`  and stop the game;
-   If the input is the name of the option, then pick a random option and output a line with the result in the following format (`<option>`  is the name of the option chosen by the program):
    -   Loss:  `Sorry, but the computer chose <option>`
    -   Draw:  `There is a draw (<option>)`
    -   Win:  `Well done. The computer chose <option> and failed`
-   For each draw, add  `50`  points to the score. For each win, add  `100`  points. In case a user loses, don't change the score;
-   If the input corresponds to anything else, output  `Invalid input`;
-   Restart the game.

### Solution 💡
In this stage the changes are subtle.
First of all add the request for the **username** before entering the `While` , Print the username.
I have created a **function** called:
`public static int readAndGetScore(String userName)`

With this function I create the `File` Object and with a `tryCatch` iterate through the entire file, first I check that it has rows with :
`fileScanner.hasNextLine()` 
And get the name and score thanks to `split` with:
`fileScanner.nextLine().split(" ");`

I **check** that they have the **same name**, if so, I return the score, if the name doesn't exist, **I return 0**.

In the loop I add a **condition**:
`if (userInput.equals("!rating"))`
To print the user's rating.
And this is all the necessary to pass this Stage
