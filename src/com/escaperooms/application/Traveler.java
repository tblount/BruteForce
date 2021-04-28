package com.escaperooms.application;

import java.util.ArrayList;
import java.util.List;

public class Traveler {
    User user;
    EscapeRoom escapeRoom;


    public Traveler(User user, EscapeRoom escapeRoom) {
        this.user = user;
        this.escapeRoom = escapeRoom;
    }

    public void jump(EscapeRoom room) {
        escapeRoom.removeEscapeRoom(room.getName());
        room.run(this, escapeRoom);
    }

    public User getUser() {
        return this.user;
    }

    public List<Playable> getRooms() {
        return new ArrayList<>(escapeRoom.getEscapeRooms().values());
    }

    private boolean isEscapeRoomCompleted() {
        return getRooms().size() <= 0;
    }

    public void menu() {
        List<Playable> availableRooms = getRooms();
        if(!isEscapeRoomCompleted()) {
            for(int i = 0; i < availableRooms.size(); i++) {
                System.out.println(i + ": " + availableRooms.get(i).getName());
            }
            String selection = EscapeRoom.prompt("Select a room.", "[0-" + availableRooms.size() + "]", "Invalid choice.");
            int choice = Integer.parseInt(selection);
            EscapeRoom room = availableRooms.get(choice).getEscapeRoom();
            jump(room);
        } else {
            System.out.println("All rooms completed! You won!");
            System.exit(0);
        }

    }
}