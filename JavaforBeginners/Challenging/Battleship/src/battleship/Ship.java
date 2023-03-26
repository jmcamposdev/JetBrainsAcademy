package battleship;

public class Ship {
    String name;
    int size;

    public Ship (String name, int size) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("The Board name can't be empty or only spaces");
        }
        if (size < 1) {
            throw new IllegalArgumentException("The size can't be negative");
        }
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
