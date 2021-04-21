
import java.util.ArrayList;
import java.util.List;

class User {
    long startTime = System.currentTimeMillis();
    int points = 0;
    List<String> inventory = new ArrayList<>();
    boolean winOrLose;

    long getEndTime() {
        return System.currentTimeMillis() - startTime;
    }

    int getPoints() {
        return points;
    }

    void setPoints(int points) {
        this.points += points;
    }

    public List<String> getInventory() {
        return inventory;
    }

    void addInventory(String item) {
        this.inventory.add(item);
    }

    public boolean isWinOrLose() {
        return winOrLose;
    }

    public void setWinOrLose(boolean winOrLose) {
        this.winOrLose = winOrLose;
    }
}