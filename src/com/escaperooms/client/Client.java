package com.escaperooms.client;

import com.escaperooms.application.EscapeRoom;
import com.escaperooms.application.Playable;
import com.escaperooms.application.Traveler;
import com.escaperooms.application.User;

import java.io.IOException;
import java.util.*;

class Client {

    public static void main(String[] args) throws IOException {
        User user = new User();
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.load(escapeRoom);
        escapeRoom.generateEscapeRooms();
        Collection<Playable> escapeRoomCollection = escapeRoom.getEscapeRooms().values();
        List<Playable> escapeRooms = new ArrayList<>(escapeRoomCollection);
        System.out.println(escapeRoomCollection);
        Traveler traveler = new Traveler(user, escapeRooms, escapeRoom);

        for(int i = 0; i < escapeRoomCollection.size(); i++) {
            System.out.println(i + ": " + escapeRooms.get(i).getName());
        }

        System.out.println("Select a room to start in. ");
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());

        EscapeRoom room = escapeRooms.get(choice).getEscapeRoom();
        room.run(traveler, escapeRoom);
    }

}