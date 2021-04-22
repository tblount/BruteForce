package escaperooms.joninexams;

import escaperooms.application.EscapeRoom;
import escaperooms.application.Playable;
import escaperooms.application.Traveler;
import escaperooms.application.User;

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

    public static void main(String[] args) {

        ArrayList<String> villages = new ArrayList<String>();
        villages.add("Hidden Leaf");
        villages.add("The Village Hidden in the Waterfall");
        villages.add("The Village Hidden in the Stones");
        villages.add("The Village Hidden in the Sand");
        villages.add("The Village Hidden in the Rain");

        Scanner input = new Scanner(System.in);
        System.out.println("Hello there! Welcome to the Jonin Exams");
        System.out.println("What is your name?");
        String name = input.nextLine();
        System.out.println("What village are you from?" + villages);
        String home = input.nextLine();
        System.out.println(home);
    }
}