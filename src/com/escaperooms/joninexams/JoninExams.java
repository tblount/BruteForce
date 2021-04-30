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
        battle();
    }

    Prompter input = new Prompter(new Scanner(System.in));

    void welcome() {

        Ninja fighter1 = new Ninja("Kakashi", 10);
        Ninja fighter2 = new Ninja("Gaara", 10);

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
                System.out.println("Ok step into the arena!");
                break;
            case "no":
                System.out.println(" Welp you better get ready! Fighhhtttt.");
                break;
            default:
                System.out.println("Please choose yes or no.");
        }

        System.out.println(" ");
        System.out.println("Have fun on journey!!");
    }

    void battle() {
        System.out.println("Ok now that both opponents are ready lets go!!!!!!");
        System.out.println("OK on my count 1.....2....3!!!!!");
        System.out.println("=====================================================================================");
        System.out.println("Your opponent is preparing to use his Ginjutsu");
        String attack = input.prompt("How would you like to attack?");

        switch (attack) {
            case "1":
                System.out.println("You used your ginjutsu and was able to defeat the opponent!!");
                System.out.println("Wow that was fast!! ....and the winner is " + user .getName());
                user.addItem("leaf headband");
                break;
            case "2":
                System.out.println("Your opponent has defeated you before you could blink!!!");
                System.out.println("Better luck next time!!!");
                break;
            case "3":
                System.out.println("You dodged the attack but it was a distraction and your opponent defeated you with a" +
                        " with a blazing kick to the back of your head!");
                System.out.println("Call the medics this match is over!!");
        }
        jump();
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


