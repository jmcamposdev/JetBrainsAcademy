# Tic Tac Toe Game

Everybody remembers this paper-and-pencil game from childhood: Tic-Tac-Toe, also known as Noughts and crosses or Xs and Os. A single mistake usually costs you the game, but thankfully it is simple enough that most players discover the best strategy quickly. Let’s program Tic-Tac-Toe and get playing!

After finishing this project, you'll get to know a lot about planning and developing a complex program from scratch, using methods, nested lists, list comprehension, handling errors, and processing user input.


This Project is separate in **5 Stages** we will describe each stage.

## Stage 1 ✅
**Tic-tac-toe**  is a game known all over the world. Each country may have its own version of the name, sometimes the rules are different, but the essence of the game remains the same. Below are the main rules that may be familiar to you since childhood.

Tic-tac-toe is played by two players on a 3x3 grid. One of the players is 'X', and the other player is 'O'. X plays first, then O takes the next turn, and so on.

The players write 'X' and 'O' on a 3x3 field.

The first player that puts 3 X's or 3 O's in a straight line (including diagonals) wins the game.

### Objectives 🎯
Your first task in this project is to print the game grid in the console output. Use what you’ve learned about the `print()` function to print three lines, each containing three characters (X’s and O’s) to represent a game of tic-tac-toe where all fields of the grid have been filled in.
Example:
```no-highlight
X O X
O X O
X X O 
```

### Solution 💡
For this Stage, you can print that with `System.out.println` but that's a bad idea for the future, so I create an Array `int[][] table` and populate it with the same values ​​as the previous example.

## Stage 2 ✅
Our program should be able to display the grid at all stages of the game. Now we’re going to write a program that allows the user to enter a string representing the game state and correctly prints the 3x3 game grid based on this input. We’ll also add some boundaries around the game grid.

### Objectives 🎯
In this stage, you will write a program that:

1.  Reads a string of 9 symbols from the input and displays them to the user in a 3x3 grid. The grid can contain only  `X`,  `O`  and  `_`  symbols.
2.  Outputs a line of dashes  `---------`  above and below the grid, adds a pipe  `|`  symbol to the beginning and end of each line of the grid, and adds a space between all characters in the grid.

Example:
```no-highlight
> O_OXXO_XX
---------
| O _ O |
| X X O |
| _ X X |
---------
```

### Solution 💡
For this Stage, I made a for loop that iterates 3 times and prints the first 3 characters (I made an `index = 0` and print the `index` for the second character, I print `++index` and the same for the third character and that for 3 times ) of the String and before and after the loop I added `---------
`

## Stage 3 ✅
In this stage, we’re going to analyze the game state to determine if either player has already won the game or it is still ongoing, if the game is a draw, or if the user has entered an impossible game state (two winners, or with one player having made too many moves).

### Objectives 🎯
n this stage, your program should:

1.  Take a string entered by the user and print the game grid as in the previous stage.
2.  Analyze the game state and print the result. Possible states:
-   `Game not finished`  when neither side has three in a row but the grid still has empty cells.
-   `Draw`  when no side has a three in a row and the grid has no empty cells.
-   `X wins`  when the grid has three X’s in a row (including diagonals).
-   `O wins`  when the grid has three O’s in a row (including diagonals). 
-   `Impossible`  when the grid has three X’s in a row as well as three O’s in a row, or there are a lot more X's than O's or vice versa (the difference should be 1 or 0; if the difference is 2 or more, then the game state is impossible).
    
In this stage, we will assume that either X or O can start the game.

You can choose whether to use a space  or underscore  `_`  to print empty cells.

### Solution 💡
To resolve this Stage :

 1. I create a Function called: <br> `public static char[][] convert(String boardString)` <br> Thats Function convert the String passed to a `char Array` validate that the `String` passed has a size of 9 to create the Array.
```
public static char[][] convert(String boardString) {
       // Validate that the String contains 9 characters
       if (str.length() != 9) { 
       throw  new  IllegalArgumentException("The String is invalid."); 
       } 
       // Create a 3x3 Matrix  
       char[][] arr = new  char[3][3]; 
	   // Fill the Matrix that each character of the String
	   int index  =  0; 
	   for (int  i  =  0; i < 3; i++) { 
		   for (int  j  =  0; j < 3; j++) { 
			   arr[i][j] = str.charAt(index); index++; 
			} 
		} 
		// Return the Matrix
		return arr; 
    }
```
 2. Once the Matrix is ​​obtained, we proceed to validate it.

## Stage 4 ✅
It's time to make our game interactive! Now we're going to add the ability for a user to make a move. To do this, we need to divide the grid into cells. Suppose the top left cell has the coordinates (1, 1) and the bottom right cell has the coordinates (3, 3):  
  
(1, 1) (1, 2) (1, 3)  
(2, 1) (2, 2) (2, 3)  
(3, 1) (3, 2) (3, 3)

The program should ask the user to enter the coordinates of the cell where they want to make a move.

In this stage, the user plays as X, not O. Keep in mind that the first coordinate goes from top to bottom and the second coordinate goes from left to right. The coordinates can include the numbers 1, 2, or 3.

What happens if the user enters incorrect coordinates? The user could enter symbols instead of numbers, or enter coordinates representing occupied cells or cells that aren't even on the grid. You need to check the user's input and catch possible exceptions.

### Objectives 🎯
The program should work as follows:

1.  Get the initial 3x3 grid from the input as in the previous stages. Here the user should input 9 symbols representing the field, for example,  `_XXOO_OX_`.
2.  Output this 3x3 grid as in the previous stages.
3.  Prompt the user to make a move. The user should input 2 coordinate numbers that represent the cell where they want to place their X, for example,  `1 1`.
4.  Analyze user input. If the input is incorrect, inform the user why their input is wrong:  
    Print  `This cell is occupied! Choose another one!`  if the cell is not empty.  
    Print  `You should enter numbers!`  if the user enters non-numeric symbols in the coordinates input.  
    Print  `Coordinates should be from 1 to 3!`  if the user enters coordinates outside the game grid.  
    Keep prompting the user to enter the coordinates until the user input is valid.
5.  If the input is correct, update the grid to include the user's move and print the updated grid to the console.

To summarize, you need to output the field 2 times: once before the user's move (based on the first line of input) and once after the user has entered valid coordinates (then you need to update the grid to include that move).

### Solution 💡
For this Stage I need to do:

 1. Convert the String to a char Matrix. This Funtions was created in the pass Stage.
 2. Create a 'While' to ask the user Row and Column for put X or O and validate that the coordinate passes is empty there isn't a X or O.
 3. Validate that the coordinate passed are between 0 and 4 otherwise print 					`Coordinates should be from 1 to 3!`
 4. Put the X or O on the position passed.

## Stage 5 ✅
Our game is almost ready! Now let's combine what we’ve learned in the previous stages to make a game of tic-tac-toe that two players can play from the beginning (with an empty grid) through to the end (until there is a draw, or one of the players wins).

The first player has to play as X and their opponent plays as O.

### Objectives 🎯
In this stage, you should write a program that:

1.  Prints an empty grid at the beginning of the game.
2.  Creates a game loop where the program asks the user to enter the cell coordinates, analyzes the move for correctness and shows a grid with the changes if everything is okay.
3.  Ends the game when someone wins or there is a draw.

You need to output the final result at the end of the game. Good luck!

### Solution 💡

 1. Start the programa which a Empty Board
 2. Use a `while` until one of the two wins or draws
 3. Validate that de coordinate passed are correct are between 0 and 3 and the position is empty.
 4. For each move I need to validate if it has won or if there is a draw to end the game.
 5. When the Game Finish show why if X or O win or if there is a draw.
	X or O wins:
	` <Symbol\> wins`
	Or if there is a Draw:
	`The Game Finish by draw`

> **Thank you for reading the project and I hope you find it useful 😉 <br>
> If you liked it please give me ⭐️**
 
