package com.escaperooms.client;

import com.escaperooms.application.EscapeRoom;
import com.escaperooms.application.Traveler;
import com.escaperooms.application.User;
import java.io.IOException;

class Client {

    public static void main(String[] args) throws IOException {
        User user = new User();
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.generateEscapeRooms();
        Traveler traveler = new Traveler(user, escapeRoom);
        traveler.menu();
    }

}