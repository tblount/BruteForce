package com.escaperooms.joninexams;

import com.escaperooms.application.EscapeRoom;
import com.escaperooms.application.Playable;
import com.escaperooms.application.Traveler;
import com.escaperooms.application.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class JoninExams extends EscapeRoom {
    Traveler traveler;
    User user;
    EscapeRoom escapeRoom;

    public JoninExams () throws IOException {

    }
    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        this.escapeRoom = escapeRoom;
        this.traveler = traveler;
        this.user = traveler.getUser();
        escapeRoom.getEscapeRooms().remove("Jonin Exams");
        welcome();
    }

    @Override
    public void terminate() {

    }

    @Override
    public Playable playable() throws IOException {
        return new Playable("Jonin Exams", "Welcome to Jonin Exams", new JoninExams());
    }

    void jump() throws IOException {
        EscapeRoom room = getEscapeRoom("Space Odyssey");
        traveler.jump(room);
    }

    void welcome() {

        Prompter input = new Prompter(new Scanner(System.in));

        ArrayList<String> villages = new ArrayList<String>();
        villages.add("Hidden Leaf");
        villages.add("The Village Hidden in the Waterfall");
        villages.add("The Village Hidden in the Stones");

        System.out.println("Hello there! Welcome to the Jonin Exams");
        String name = input.prompt("What is your name?");
        String home = input.prompt("OK..." + name + " What village are you from? " + villages);
    }
}