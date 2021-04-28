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
        return new Playable(getName(), "Welcome to Jonin Exams", new JoninExams());
    }

    void jump() {
        traveler.menu();
    }

    void welcome() {

        Ninja fighter1 = new Ninja("Kakashi", 10);
        Ninja fighter2 = new Ninja("Gaara", 10);

        Prompter input = new Prompter(new Scanner(System.in));

        ArrayList<String> villages = new ArrayList<String>();
        villages.add("hidden leaf village");
        villages.add("The Village Hidden in the Stones");

        System.out.println("Hello " + user.getName() + "\n Wow I use to know a legendary Ninja by that name!!");
        System.out.println(" ");
        System.out.println("Ok here is a list of villages that can compete in the Jonin Exams today -------> " + villages);

        String home = input.prompt("...What village did you say you're from? ");

        if (home.equals("hidden leaf village")) {
            System.out.println("Looks like you will be battling..." + fighter1.getNinjaName());
        } else
            System.out.println("Looks like you will go against the mighty! " + fighter2.getNinjaName());

        user.addItem("leaf headband");
        System.out.println(" ");
        System.out.println("Have fun on journey!!");
        jump();
    }
    @Override
    public String getName() {
        return "Jonin Exams";
    }
}