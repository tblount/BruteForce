package escaperooms.spaceodyssey;

import escaperooms.application.EscapeRoom;
import escaperooms.application.Playable;
import escaperooms.application.Traveler;

import java.io.IOException;

public class SpaceOdyssey extends EscapeRoom {

    Traveler traveler;

    public SpaceOdyssey () throws IOException {}

    public Playable playable()  throws IOException {
        return new Playable("Space Odyssey", "Welcome to Space Odyssey", new SpaceOdyssey());
    }

    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        this.traveler = traveler;
        System.out.println("running Space Odyssey");

    }

    @Override
    public void terminate() {

    }
    void jump() throws IOException {
        EscapeRoom room = getEscapeRoom("Crazy Stans");
        traveler.jump(room);
    }

}