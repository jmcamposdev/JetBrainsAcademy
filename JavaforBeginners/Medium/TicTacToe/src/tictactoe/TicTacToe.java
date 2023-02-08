package tictactoe;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author josemaria
 */
public class TicTacToe {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String formatBase = "\\d \\d"; // Validate de First Format
        final String formatRange = "[1-3] [1-3]"; // Validate de Range
        char[][] board = new char[3][3]; // The board
        String input; // The user input
        boolean win = false,draw = false; // The break points of the game
        int turn = 1;
        char[] tokens = {'O','X'};

        fillBoard(board); // Fill the board which white spaces
        System.out.println(showBoard(board)); // Show board
        while (!win && !draw) { // While anyone win or draw
            System.out.print("> ");
            input = sc.nextLine(); // Get the user Input
            if (!validateInput(input,formatBase)){ // Validate the first Format
                System.out.println("You should enter numbers!"); // Show the error
            } else if (!validateInput(input,formatRange)){ // Validate the range
                System.out.println("Coordinates should be from 1 to 3!"); // Show the error
            } else{ // If is all well
                int[] range = {Character.getNumericValue(input.charAt(0))-1,Character.getNumericValue(input.charAt(2))-1}; // Calculate de index
                if (!putToken(board,range,tokens[turn%2])){  // If we can't put the tab show that this place is occupied
                    System.out.println("This cell is occupied! Choose another one!");
                    } else{ // Validate if there are a win or a draw
                    System.out.println(showBoard(board)); // Show board
                    win = rowLine(board,tokens[turn%2]) || columnLine(board,tokens[turn%2]) || diagonalLine(board,tokens[turn%2]);
                    draw = gameDraw(board);
                    turn++;
                }
            }
        }
        turn--;
        if (win) {
            System.out.println(tokens[turn%2]+" wins");
        } else {
            System.out.println("Draw");
        }
        /*
        do {
            //System.out.print("> ");
            input = sc.nextLine();
            if (!validateInput(input,formatBase)){
                System.out.println("You should enter numbers!");
            } else if (!validateInput(input,formatRange)){
                System.out.println("Coordinates should be from 1 to 3!");
            } else{
                int[] range = {Character.getNumericValue(input.charAt(0))-1,Character.getNumericValue(input.charAt(2))-1};
                if (!putToken(board,range,'X')){
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    System.out.println(showBoard(board));
                    show++;
                }

            }
        } while (show < 2);
         */
        /*


        if (imposible) {
            System.out.println("Impossible");
        } else if (xWin) {
            System.out.println("X wins");
        } else if (oWin) {
            System.out.println("O wins");
        } else if (gameNotFinish) {
            System.out.println("Game not finished");
        } else if (draw) {
            System.out.println("Draw");
        }
         */


    }
    public static void fillBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], ' ');
        }
    }
    public static String showBoard (char[][] board) {
        StringBuilder boardString = new StringBuilder("---------\n");
        for (int i = 0; i < board.length; i++) {
            boardString.append("| ");
            for (int j = 0; j < board[i].length; j++) {
                boardString.append(board[i][j]).append(" ");
            }
            boardString.append("|\n");
        }
        boardString.append("---------");
        return boardString.toString();
    }

    public static boolean isOccupied(char[][] board,int[] range){
        return board[range[0]][range[1]] != ' ';
    }

    public static boolean putToken (char[][] board,int[] coordinate,char token) {
        if (isOccupied(board,coordinate)) {
            return false;
        }
        board[coordinate[0]][coordinate[1]] = token;
        return true;
    }

    public static char[][] convert(String boardString) {
        if (boardString.length() > 9) {
            throw new IllegalArgumentException("Longitud no apropiada");
        }
        char[][] board  = new char[3][3];
        int index = 0;
        int secongindex = 0;
        for (int i = 0; i < boardString.length(); i++) {
            board[index][secongindex] = boardString.charAt(i);

            index = i < 2 ? 0 : i < 5 ? 1 : 2;
            if (i < 2) {
                secongindex++;
            } else if (i == 2) {
                secongindex = 0;
            } else if (i < 5) {
                secongindex ++;
            } else if (i == 5){
                secongindex = 0;
            } else {
                secongindex++;
            }
        }

        return board;
    }

    public static boolean gameImposible(char[][] board) {
        boolean isImposible;
        int diference;
        int x = 0,o = 0;
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == 'X') {
                    x++;
                } else if (aChar == 'O') {
                    o++;
                }
            }
        }
        diference = Math.max(o,x) - Math.min(o,x);
        isImposible = diference >= 2;
        if (!isImposible) {
            boolean xRow = rowLine(board,'X');
            boolean oRow = rowLine(board,'O');
            boolean xColumn = columnLine(board,'X');
            boolean oColumn = columnLine(board,'O');
            isImposible = (xRow || xColumn) && (oRow || oColumn) ;
        }
        return isImposible;
    }
    public static boolean gameDraw(char[][] board) {
        if (rowLine(board,'X') || rowLine(board,'O') || columnLine(board,'X') || columnLine(board,'O')) {
            return false;
        }
        boolean asEmptySpace = false;
        for (int i = 0; i < board.length && !asEmptySpace; i++) {
            for (int j = 0; j < board[i].length && !asEmptySpace; j++) {
                if (board[i][j] == ' ') {
                    asEmptySpace = true;
                }
            }
        }
        return !asEmptySpace;
    }


    public static boolean rowLine (char[][] board,char token) {
        boolean isLine = false;
        int count = 0;
        for (int i = 0; i < board.length && !isLine; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == token){
                    count++;
                }
            }
            isLine = count == 3;
            count = 0;
        }
        return isLine;
    }

    public static boolean columnLine (char[][] board,char token) {
        boolean isLine = false;
        int count = 0;
        for (int i = 0; i < board.length && !isLine; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == token){
                    count++;
                }
            }
            isLine = count == 3;
            count = 0;
        }
        return isLine;
    }

    public static boolean diagonalLine (char[][] board,char token) {
        boolean downDiagonal = board[0][0] == token && board[1][1] == token && board[2][2] == token;
        boolean topDiagonal = board[2][0] == token &&  board[1][1] == token && board[0][2] == token;

        return downDiagonal || topDiagonal;
    }

    public static boolean validateInput (String input,String regx) {
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
