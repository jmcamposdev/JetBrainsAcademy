# Rock Paper Scissors Game

I present the Rock-Paper-Scissors game project from JetBrains Academy. This is a fun and interactive game that can be played in Player vs. Computer mode, 
In this project we will learn:

 - `Ramdom` Class
 - Formatted Strings
 - OPP
 - File management (Reading, Writing)

This Project is separate in **5 Stages** we will describe each stage.

## Stage 1
The program will read input from the user and then select an option that defeats the one picked by the user. The output will display `"Sorry, but the computer chose <option\>"`, where <option\> is the name of the option that the program's picked depending on the user's input.

For example, if the user enters "rock", the program will print "Sorry, but the computer chose paper". The computer will always win in this version of the game, selecting the option that defeats the user's choice:

-   If the user chooses paper, the computer chooses scissors.
-   If the user chooses scissors, the computer chooses rock.
-   If the user chooses rock, the computer chooses paper.

### Objective
The program should:

 -  Take input from the user;
-   Find an option that wins over the user's option.
-   Output the line:  `Sorry, but the computer chose <option>`

### Solution
For the First Stage. I implement a user Input and with that input used a switch that uses userInput and depending on what has been entered I print the corresponding output.

## Stage 2
Now we will change the game a little bit, the program reads input from the user, generates a random option using the class `Ramdom`, and then displays who won - the user or the computer.

Here are a few examples of the possible outcomes and the output that the program will display:

-   Loss: "Sorry, but the computer chose <option\>;"
-   Draw: "There is a draw (<option\>);"
-   Win: "Well done. The computer chose <option\> and failed;"

The power of the Random class is used to create a more unpredictable and exciting game for the players. So get ready to challenge yourself and test your luck against the computer in this fun and interactive game!

### Objective
Your program should:

-   Read the user input that includes an option;
-   Choose a random option;
-   Compare the options and determine the winner;
-   Output one of the lines above depending on the result of the game.

### Solution
For the second stage I  started again I have only left the user input.
I have created an array which stores the possible win combinations.
```
public static Choice[][] winningCombinations = {
            {Choice.ROCK,Choice.SCISSORS},
            {Choice.PAPER, Choice.ROCK},
            {Choice.SCISSORS,Choice.PAPER}
    };
```

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



