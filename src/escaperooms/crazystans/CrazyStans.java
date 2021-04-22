package escaperooms.crazystans;

import escaperooms.application.EscapeRoom;
import escaperooms.application.Playable;
import escaperooms.application.Traveler;
import escaperooms.application.User;
import escaperooms.music.MusicPlayer;

import java.io.IOException;

public class CrazyStans extends EscapeRoom {

    Traveler traveler;
    User user;

    public CrazyStans() throws IOException {

    }

    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        this.traveler = traveler;
        this.user = traveler.getUser();
        try {
            MusicPlayer musicPlayer = new MusicPlayer();
            musicPlayer.play("feelitstill.wav");
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("You are now in Crazy Stans!");
    }

    public void lobbyChallenge() {

    }

    @Override
    public void terminate() {

    }

    @Override
    public Playable playable() throws IOException {
        return new Playable("Crazy Stans", "Welcome to Stans", new CrazyStans());
    }
}