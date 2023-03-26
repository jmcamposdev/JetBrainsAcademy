package battleship;

public class Main {
    public static void main(String[] args) {
        BattleShip battleShip = new BattleShip(10);
        System.out.println("The game starts!");
        while (true) {
            System.out.println(battleShip);
            String coordinates;
            boolean validCoordinate = false;
            do {
                coordinates = GetData.getString("Enter the coordinates: ");
                if (coordinates.matches(BattleShip.PATTERN_COORDINATE)) {
                    int x = coordinates.charAt(0) - 'A';
                    int y = Integer.parseInt(coordinates.substring(1)) - 1;
                    validCoordinate = battleShip.isValidCoordinate(coordinates);
                    if (validCoordinate) {
                        if (battleShip.isHit(x, y)) {
                            System.out.println("You hit a ship!");
                        } else {
                            System.out.println("You missed!");
                        }
                    }
                } else {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                }
            } while (!validCoordinate);
        }
    }

}
