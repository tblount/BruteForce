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
        Ninja fighter3 = new Ninja("Killer B", 10);

        ArrayList<String> villages = new ArrayList<String>();
        villages.add("1: The Hidden Leaf Village");
        villages.add("2: The Village Hidden in the Stones");
        villages.add("3. The Village Hidden in the Clouds");

        System.out.println("=====================================================================================");
        System.out.println("Hello " + user.getName() + "...Wow I use to know a legendary Ninja by that name!!");
        System.out.println("\nWelcome to the Jonin Exams, there will be some tough opponents today!");
        System.out.println("\nOk here is a list of villages that can compete in the Jonin Exams today");

        System.out.println("=====================================");
        System.out.println(villages.get(0));
        System.out.println(villages.get(1));
        System.out.println(villages.get(2));
        System.out.println("=====================================");
        String home = input.prompt("What village are you from? 1-3");

            switch (home) {
                case "1":
                    System.out.println("Looks like you will be facing the Legendary..." + fighter1.getNinjaName());
                    break;
                case "2":
                    System.out.println("Ok..." + user.getName() + " You will be fighting " + fighter2.getNinjaName());
                    break;
                case "3":
                    System.out.println("You will be matched against " + fighter3.getNinjaName());
                    break;
                default:
                    System.out.println("That village is not allowed to participate in the exams.");
            }

        System.out.println("=================================================================");

        System.out.println("Ok lets get started!!");
        String ready = input.prompt(user.getName() + " Are you ready to battle? yes or no");

        switch (ready) {
            case "yes":
                System.out.println("\nOk step into the arena!");
                break;
            case "no":
                System.out.println("\nWelp you better get ready! Get in there!");
                break;
            default:
                System.out.println("\nPlease choose yes or no.");
        }
    }

    void battle() {
        System.out.println("Ok now that both opponents are ready lets go!!!!!!");
        System.out.println("\nOn my count 1.....2....3!!!!!");
        System.out.println("\nYour opponent is preparing to use his Genjutsu");
        System.out.println(" ");
        String attack = input.prompt("How would you like to attack? \n" +
                " 1: Counter Genjutsu \n 2: Ninjutsu \n 3: Dodge ");

        switch (attack) {
            case "1":
                System.out.println("You used your genjutsu and was able to defeat the opponent!!");
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
                break;
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


