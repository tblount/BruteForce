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
    MusicPlayer musicPlayer = new MusicPlayer("crazystanswelcomemessage.wav", 50000);

    public CrazyStans() throws IOException {

    }

    void crazyStansWelcomeMessage() {
       musicPlayer.start();
    }

    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {

        this.traveler = traveler;
        this.user = traveler.getUser();
//        crazyStansWelcomeMessage();
        lobbyChallenge();
    }

    public void lobbyChallenge() {
        lobby.playSong();
    }

    @Override
    public void terminate() {

    }

    @Override
    public Playable playable() throws IOException {
        return new Playable("Crazy Stans", "Welcome to Stans", new CrazyStans());
    }
}