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
