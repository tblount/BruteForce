package escaperooms.spaceodyssey;

import escaperooms.application.EscapeRoom;
import escaperooms.application.Playable;
import escaperooms.application.Traveler;

import java.io.IOException;
import java.util.Scanner;

public class SpaceOdyssey extends EscapeRoom {

    Traveler traveler;

    public SpaceOdyssey () throws IOException {}

    public Playable playable()  throws IOException {
        return new Playable("Space Odyssey", "Welcome to Space Odyssey", new SpaceOdyssey());
    }

    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        this.traveler = traveler;
        traveler.getUser().addItem("ExampleItem");
        traveler.getUser().addItem("ExampleItem");
        System.out.println("running Space Odyssey");
        Prompter prompter = new Prompter(new Scanner(System.in));

        if(prompter.prompt("Do You want to see your inventory?","Y|y|N|n","Enter Valid Answer [Y]/[N]?").toUpperCase().equals("Y")) {
            traveler.getUser().showInventory();
        }else{
            if (prompter.prompt("You sure?!","Y|y|N|n","Enter Valid Answer [Y]/[N]?").toUpperCase().equals("N")) traveler.getUser().showInventory();
        }


    }

    @Override
    public void terminate() {

    }
    void jump() throws IOException {
        EscapeRoom room = getEscapeRoom("Crazy Stans");
        traveler.jump(room);
    }


}