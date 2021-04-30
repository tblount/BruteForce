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
    void welcome() {

        Ninja fighter1 = new Ninja("Kakashi", 10);
        Ninja fighter2 = new Ninja("Gaara", 10);

        Prompter input = new Prompter(new Scanner(System.in));

        ArrayList<String> villages = new ArrayList<String>();
        villages.add("1: Hidden Leaf Village");
        villages.add("2: The Village Hidden in the Stones");

        System.out.println("=====================================================================================");
        System.out.println("Hello " + user.getName() + "...Wow I use to know a legendary Ninja by that name!!");
        System.out.println("=====================================================================================");
        System.out.println("Welcome to the Jonin Exams, there will be some tough opponents today!");
        System.out.println("=====================================================================================");
        System.out.println("Ok here is a list of villages that can compete in the Jonin Exams today");
        System.out.println("=====================================================================================");
        System.out.println(villages.get(0));
        System.out.println(villages.get(1));

        System.out.println("=====================================================================================");
        String home = input.prompt("What village are you from?");
        System.out.println("=====================================================================================");

        switch (home) {
            case "1":
                System.out.println("Looks like you wil facing the Legendary..." + fighter1.getNinjaName());
                break;
            case "2":
                System.out.println("Ok..." + user.getName() + " You will be fighting " + fighter2.getNinjaName());
                break;
            default:
                System.out.println("That village is not allowed to participate in the exams.");
        }
        System.out.println("=====================================================================================");

        System.out.println("Ok lets get started!!");
        String ready = input.prompt(user.getName() + " Are you ready to battle?");

        switch (ready) {
            case "yes":
                System.out.println("Ok Fight!!!");
            case "no":
                System.out.println(" Welp you better get ready! Fighhhtttt.");
            default:
                System.out.println("Please choose yes or no.");
        }

        user.addItem("leaf headband");
        System.out.println(" ");
        System.out.println("Have fun on journey!!");
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

    @Override
    public String getName() {
        return "Jonin Exams";
    }
}