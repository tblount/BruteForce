package com.escaperooms.client;

import com.escaperooms.application.EscapeRoom;
import com.escaperooms.application.Traveler;
import com.escaperooms.application.User;
import org.fusesource.jansi.AnsiConsole;

import java.io.IOException;

class Client {

    public static void main(String[] args) throws IOException {
//        AnsiConsole.systemInstall();
        User user = new User();
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.generateEscapeRooms(escapeRoom);
        String name = EscapeRoom.prompt("Please enter your name: ", "[ a-zA-z]*",
                "\nThat is not a valid name!\n");
        user.newName(name);
        Traveler traveler = new Traveler(user, escapeRoom);
        traveler.menu();
    }

}
