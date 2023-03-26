package battleship;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player 1, place your ships on the game field");
        BattleShip battleShipPlayer1 = new BattleShip(10);
        System.out.println("Press Enter and pass the move to another player");
        sc.nextLine();
        System.out.println("Player 2, place your ships to the game field");
        BattleShip battleShipPlayer2 = new BattleShip(10);
        System.out.println("Press Enter and pass the move to another player");
        sc.nextLine();
        boolean player1Turn = true;
        boolean finish = false;
        int x, y;
        while (!finish) {
            System.out.println(player1Turn ? battleShipPlayer2.toStringFlog() : battleShipPlayer1.toStringFlog());
            System.out.println("---------------------");
            System.out.println(player1Turn ? battleShipPlayer1 : battleShipPlayer2);
            System.out.println("Player " + (player1Turn ? 1 : 2) + ", it's your turn:");
            String coordinates;
            boolean validCoordinate = false;
            do {
                coordinates = GetData.getString("Enter the coordinates: ");
                if (coordinates.matches(BattleShip.PATTERN_COORDINATE)) {
                    x = coordinates.charAt(0) - 'A';
                    y = Integer.parseInt(coordinates.substring(1)) - 1;
                    validCoordinate = BattleShip.isValidCoordinate(coordinates);
                    if (validCoordinate) {
                        String outPut = player1Turn ? battleShipPlayer2.isHit(x, y) : battleShipPlayer1.isHit(x, y);
                        System.out.println(outPut);
                    }
                } else {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                }
            } while (!validCoordinate);
            finish = battleShipPlayer1.isAllShipSank() || battleShipPlayer2.isAllShipSank();
            player1Turn = !player1Turn;
            if (!finish) {
                System.out.println("Press Enter and pass the move to another player");
                sc.nextLine();
            }
        }
        System.out.println("You sank the last ship. You won. Congratulations!");


    }

}
