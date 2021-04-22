
import java.util.ArrayList;
import java.util.List;

class User {

    String currentRoom;
    long startTime = System.currentTimeMillis();
    int points = 0;
    List<String> inventory = new ArrayList<>();
    List<String> answers = new ArrayList<>();
    boolean winOrLose;


    long getEndTime() {
        return System.currentTimeMillis() - startTime;
    }

    int getPoints() {
        return points;
    }

    void addPoints(int points) {
        this.points += points;
    }

    void losePoints(int points) {
        this.points -= points;
    }

    public List<String> getInventory() {
        return inventory;
    }

    void addItem(String item) {
        this.inventory.add(item);
    }

    void removeItem(String item) {
        this.inventory.remove(item);
    }

    public boolean getWinOrLose() {
        return winOrLose;
    }

    public void setWinOrLose(boolean winOrLose) {
        this.winOrLose = winOrLose;
    }

    public void restartTimer() {
        startTime = System.currentTimeMillis();
    }

    public void move(String roomName){
        this.currentRoom = roomName;
    }

    public boolean isCurrentRoom(String roomName){
        return roomName.equals(this.currentRoom);
    }

    public boolean isItemInInventory(String itemName){
        return this.inventory.contains(itemName);
    }

    public void addAnswer(String answer){
        this.answers.add(answer);
    }

    public boolean hasAnswer(String answer){
        return this.answers.contains(answer);
    }

}