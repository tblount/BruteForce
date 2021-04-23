package com.escaperooms.application;

import java.util.List;

public class Traveler {
    List<Playable> escapeRooms;
    User user;
    EscapeRoom escapeRoom;


    public Traveler(User user, List<Playable> escapeRooms, EscapeRoom escapeRoom) {
        this.escapeRooms = escapeRooms;
        this.user = user;
        this.escapeRoom = escapeRoom;
    }

    public void jump(EscapeRoom room) {
        room.run(this, escapeRoom);
    }

    public User getUser() {
        return this.user;
    }

    public List<Playable> getRooms() {
        return escapeRooms;
    }
}