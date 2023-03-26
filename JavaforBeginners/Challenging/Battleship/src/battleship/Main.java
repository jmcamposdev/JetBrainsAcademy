package battleship;

public class Main {
    public static void main(String[] args) {
        BattleShip battleShip = new BattleShip(10);
        int x,y;
        System.out.println("The game starts!");
        System.out.println(battleShip.toStringFlog());
        while (!battleShip.gameWon()) {
            String coordinates;
            boolean validCoordinate = false;
            do {
                coordinates = GetData.getString("Enter the coordinates: ");
                if (coordinates.matches(BattleShip.PATTERN_COORDINATE)) {
                    x = coordinates.charAt(0) - 'A';
                    y = Integer.parseInt(coordinates.substring(1)) - 1;
                    validCoordinate = battleShip.isValidCoordinate(coordinates);
                    if (validCoordinate) {
                        String outPut = battleShip.isHit(x, y);
                        System.out.println(battleShip.toStringFlog());
                        System.out.println(outPut);
                    }
                } else {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                }
            } while (!validCoordinate);
        }
        System.out.println("You sank the last ship. You won. Congratulations!");


    }

}
