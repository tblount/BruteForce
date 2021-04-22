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
    Lobby lobby = new Lobby();
    MusicPlayer musicPlayer = new MusicPlayer();

    public CrazyStans() throws IOException {

    }

    void crazyStansWelcomeMessage() {
        try {
            musicPlayer.play("crazystanswelcomemessage.wav");
        } catch(Exception e) {
            System.out.println("Something went wrong.");
        }
    }

    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        this.traveler = traveler;
        this.user = traveler.getUser();
        crazyStansWelcomeMessage();
        lobbyChallenge();
    }

    public void lobbyChallenge() {
        System.out.println(lobby.welcomeMessage());
    }

    @Override
    public void terminate() {

    }

    @Override
    public Playable playable() throws IOException {
        return new Playable("Crazy Stans", "Welcome to Stans", new CrazyStans());
    }
}