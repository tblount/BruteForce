package escaperooms.application;

import java.util.ArrayList;
import java.util.List;

public class User {

    String name;
    String currentRoom;
    long startTime = System.currentTimeMillis();
    int points = 0;
    List<String> inventory = new ArrayList<>();
    List<String> answers = new ArrayList<>();
    boolean winOrLose;


    public long getEndTime() {
        return System.currentTimeMillis() - startTime;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void losePoints(int points) {
        this.points -= points;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void showInventory() {
        if(inventory.size()==0){
            System.out.println("You have nothing in your inventory");
        }else{
            System.out.println("You have " + inventory + " in your inventory");
        }
    }

    public void addItem(String item) {
        this.inventory.add(item);
    }

    public void removeItem(String item) {
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

    public void newName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}