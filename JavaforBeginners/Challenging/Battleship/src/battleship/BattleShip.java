package battleship;

public class BattleShip {
    public static String PATTERN_COORDINATES = "[A-J](\\d|10) [A-J](\\d|10)";
    public static String PATTERN_COORDINATE = "[A-J](\\d|10)";
    private final int[][] board;
    private static final int FLOG_VALUE = 0;
    private static final int SHIP_VALUE = 1;
    private static final int HIT_VALUE = 2;
    private static final int MISS_VALUE = 3;
    private int numberOfSankShips = 0;

    private static final Ship[] ALL_SHIPS = {
            new Ship("Aircraft Carrier", 5),
            new Ship("Battleship", 4),
            new Ship("Submarine", 3),
            new Ship("Cruiser", 3),
            new Ship("Destroyer", 2)
    };

    public BattleShip (int size) {
        if (size < 10) {
            throw new IllegalArgumentException("The Board size is invalid");
        }
        board = new int[size][size]; // Create the board
        placeShips(); // Place the ships in the board

    }

    public boolean isAllShipSank () {
        return numberOfSankShips == ALL_SHIPS.length;
    }


    /**
     * This method ask the user for the coordinates of the ships and validate them
     * if the coordinates are valid, the ship is placed in the board otherwise the user is asked again for the coordinates.
     */
    private void placeShips () {
        String coordinates; // The coordinates of the ship
        for (Ship ship : ALL_SHIPS) { // For each ship
            System.out.println(this); // Print the board
            String shipName = ship.getName(); // Get the name of the ship
            int shipSize = ship.getSize(); // Get the size of the ship
            do { // Ask the user for the coordinates of the ship
                coordinates = GetData.getString("Enter the coordinates of the "+shipName+" ("+shipSize+" cells): ");
            } while (!validateCoordinates(coordinates,shipSize)); // Validate the coordinates
            putShipInCoordinates(getCoordinatesArray(coordinates)); // Put the ship in the board
        }
        System.out.println(this); // Print the board


    }

    private void putShipInCoordinates (int[] coordinates) {
        if (horizontalShip(coordinates)) { // If the ship is horizontal
            for (int i = coordinates[1]; i <= coordinates[3]; i++) { // Put the ship in the board
                board[coordinates[0]][i] = SHIP_VALUE;
            }
        } else { // If the ship is vertical
            for (int i = coordinates[0]; i <= coordinates[2]; i++) { // Put the ship in the board
                board[i][coordinates[1]] = SHIP_VALUE;
            }
        }

    }


    public boolean validateCoordinates (String coordinates ,int shipSize) {
        boolean validCoordinates = false;
        boolean validFormat = coordinates.matches(PATTERN_COORDINATES);
        if (validFormat) { // IF the format is correct
            int[] coordinatesInt = getCoordinatesArray(coordinates); // Get the coordinates in int format
            int firstRowIndex = coordinatesInt[0]; // Get the first row index
            int firstColumnIndex = coordinatesInt[1]; // Get the first column index
            int secondRowIndex = coordinatesInt[2]; // Get the second row index
            int secondColumnIndex = coordinatesInt[3]; // Get the second column index

            if (firstRowIndex == secondRowIndex) { // Validate if the coordinates are horizontal
                // Validate if the size of the ship is correct
                validCoordinates = ((secondColumnIndex - firstColumnIndex)+1) == shipSize;
            } else if (firstColumnIndex == secondColumnIndex){ // Validate if the coordinates are vertical
                // Validate if the size of the ship is correct
                validCoordinates = ((secondRowIndex - firstRowIndex) +1) == shipSize;
            } else { // If the coordinates are not horizontal or vertical that means that the format is wrong (diagonal)
                System.out.println("Error! Wrong ship location! Try again:");
            }
            // If the coordinates are not valid, print the error message
            if (!validCoordinates) {
                System.out.println("Error! Wrong length of the Submarine! Try again:");
            }
            // Validate if the ship is near another ship
            if (isShipNearCoordinates(coordinatesInt)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
                validCoordinates = false;
            }
        } else { // If the format is not correct, print the error message
            System.out.println("Error! The coordinates passes aren't correct. Try again:");
        }
        return validCoordinates;
    }

    private boolean horizontalShip (int[] coordinates) {
        return coordinates[0] == coordinates[2];
    }

    private int[] getCoordinatesArray (String coordinates) {
        // 0 = first row index, 1 = first column index, 2 = second row index, 3 = second column index
        int[] coordinatesArray = new int[4];
        // Validate the format of the coordinates
        if (!coordinates.matches(PATTERN_COORDINATES)) {
            throw new IllegalArgumentException("The coordinates passes aren't correct");
        }
        // Create an array with the coordinates in String format
        String[] coordinatesArrayString = coordinates.split(" ");
        // Validate the order of the coordinates
        if (
                (coordinatesArrayString[0].charAt(0) > coordinatesArrayString[1].charAt(0))
                        ||
                Integer.parseInt(coordinatesArrayString[0].substring(1)) > Integer.parseInt(coordinatesArrayString[1].substring(1))) {
            // If the order is wrong, change the order of the coordinates
            String aux = coordinatesArrayString[0];
            coordinatesArrayString[0] = coordinatesArrayString[1];
            coordinatesArrayString[1] = aux;
        }
        // Convert the coordinates to int format
        coordinatesArray[0] = coordinatesArrayString[0].charAt(0) - 'A';
        coordinatesArray[1] = Integer.parseInt(coordinatesArrayString[0].substring(1))-1;
        coordinatesArray[2] = coordinatesArrayString[1].charAt(0) - 'A';
        coordinatesArray[3] = Integer.parseInt(coordinatesArrayString[1].substring(1))-1;
        // Return the coordinates in int format
        return coordinatesArray;
    }

    /**
     * This method validate if the ship is near another ship
     * @param coordinates The coordinates of the ship
     * @return true if the ship is near another ship, false if not
     */
    private boolean isShipNearCoordinates (int[] coordinates) {
        boolean isShipNear = false; // Variable to validate if the ship is near another ship
        int firstRowIndex = coordinates[0]; // Get the first row index
        int firstColumnIndex = coordinates[1]; // Get the first column index
        int secondRowIndex = coordinates[2]; // Get the second row index
        int secondColumnIndex = coordinates[3]; // Get the second column index

        if (horizontalShip(coordinates)) { // Validate if the ship is horizontal
            if (firstRowIndex != 0) { // Validate the Top of the Ship
                for (int i = firstColumnIndex; i <= secondColumnIndex && !isShipNear; i++) {
                    isShipNear = board[firstRowIndex-1][i] == SHIP_VALUE;
                }
            }
            if (!isShipNear && firstRowIndex != board[0].length-1){ // Validate the Bottom of the Ship
                for (int i = firstColumnIndex; i <= secondColumnIndex && !isShipNear; i++) {
                    isShipNear = board[firstRowIndex+1][i] == SHIP_VALUE;
                }
            }
            if (!isShipNear && firstColumnIndex != 0) { // validate the left side of the ship
                isShipNear = board[firstRowIndex][firstColumnIndex-1] == SHIP_VALUE;
            }
            if (!isShipNear && secondColumnIndex != board[0].length-1) { // validate the right side of the ship
                isShipNear = board[secondRowIndex][secondColumnIndex+1] == SHIP_VALUE;
            }
        } else { // Validate if the ship is vertical
            if (firstColumnIndex != 0) { // Validate the left side of the ship
                for (int i = firstRowIndex; i <= secondRowIndex && !isShipNear; i++) {
                    isShipNear = board[i][firstColumnIndex-1] == SHIP_VALUE;
                }
            }
            if (!isShipNear && secondColumnIndex != board[0].length-1) { // Validate the right side of the ship
                for (int i = firstRowIndex; i <= secondRowIndex && !isShipNear; i++) {
                    isShipNear = board[i][secondColumnIndex+1] == SHIP_VALUE;
                }
            }
            if (!isShipNear && firstRowIndex != 0) { // Validate the Top of the ship
                isShipNear = board[firstRowIndex-1][firstColumnIndex] == SHIP_VALUE;
            }
            if (!isShipNear && secondRowIndex != board[0].length-1) { // Validate the Bottom of the ship
                isShipNear = board[secondRowIndex+1][secondColumnIndex] == SHIP_VALUE;
            }
        }
        return isShipNear;
    }

    public String isHit (int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            throw new IllegalArgumentException("The coordinates passes aren't correct");
        }
        boolean isAHitValue = board[x][y] == HIT_VALUE;
        String result = "You missed!";
        if (isAHitValue) {
            result =  "You hit a ship!";
        } else{
            boolean isHit = board[x][y] == SHIP_VALUE;
            board[x][y] = isHit ? HIT_VALUE : MISS_VALUE;
            if (isHit) {
                if (isShipSank(x, y)) {
                    result = "You sank a ship!";
                } else {
                    result = "You hit a ship!";
                }
            }
        }
        return isAllShipSank() ? "" : result;
    }

    private boolean isShipSank(int x, int y) {
        boolean isShipSank = true;
        int shipX = x;
        int shipY = y;
        // Validate the Top of the ship
        while (shipX > 0 && (board[shipX-1][shipY] == SHIP_VALUE || board[shipX-1][shipY] == HIT_VALUE) && isShipSank) {
            shipX--;
            if (board[shipX][shipY] == SHIP_VALUE) {
                isShipSank = false;
            }
        }
        // Validate the Bottom of the ship
        shipX = x;
        while (shipX < board.length-1 && (board[shipX+1][shipY] == SHIP_VALUE || board[shipX+1][shipY] == HIT_VALUE) && isShipSank) {
            shipX++;
            if (board[shipX][shipY] == SHIP_VALUE) {
                isShipSank = false;
            }
        }
        // Validate the left side of the ship
        shipX = x;
        while (shipY > 0 && (board[shipX][shipY-1] == SHIP_VALUE || board[shipX][shipY-1] == HIT_VALUE) && isShipSank) {
            shipY--;
            if (board[shipX][shipY] == SHIP_VALUE) {
                isShipSank = false;
            }
        }
        // Validate the right side of the ship
        shipY = y;
        while (shipY < board[0].length-1 && (board[shipX][shipY+1] == SHIP_VALUE || board[shipX][shipY+1] == HIT_VALUE) && isShipSank) {
            shipY++;
            if (board[shipX][shipY] == SHIP_VALUE) {
                isShipSank = false;
            }
        }
        if (isShipSank) {
            numberOfSankShips++;
        }
        return isShipSank;
    }

    public static boolean isValidCoordinate (String coordinate) {
        boolean isValidCoordinate = false;
        if (coordinate.matches(PATTERN_COORDINATE)) {
            int x = coordinate.charAt(0) - 'A';
            int y = Integer.parseInt(coordinate.substring(1))-1;
            if (x >= 0 && x < 10 && y >= 0 && y < 10) {
                isValidCoordinate = true;
            }
        }
        return isValidCoordinate;
    }

    @Override
    public String toString() {
        char rowIndex = 'A';
        StringBuilder boardString = new StringBuilder();
        boardString.append("  1 2 3 4 5 6 7 8 9 10\n");
        for (int[] array : this.board) {
            boardString.append(rowIndex++);
            for (int value : array) {
                char icon = value == FLOG_VALUE ? '~' :
                        value == SHIP_VALUE ? 'O' :
                                value == HIT_VALUE ? 'X' : 'M';
                boardString.append(" ").append(icon);
            }
            if (rowIndex != 'K') {
                boardString.append("\n");
            }
        }
        return boardString.toString();
    }

    public String toStringFlog() {
        char rowIndex = 'A';
        StringBuilder boardString = new StringBuilder();
        boardString.append("  1 2 3 4 5 6 7 8 9 10\n");
        for (int[] array : this.board) {
            boardString.append(rowIndex++);
            for (int value : array) {
                char icon = value == FLOG_VALUE ? '~' :
                        value == SHIP_VALUE ? '~' :
                                value == HIT_VALUE ? 'X' : 'M';
                boardString.append(" ").append(icon);
            }
            if (rowIndex != 'K') {
                boardString.append("\n");
            }
        }
        return boardString.toString();
    }
}
