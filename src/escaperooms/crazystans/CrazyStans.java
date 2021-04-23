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
    BeyoncesRoom beyoncesRoom = new BeyoncesRoom();
    MusicPlayer musicPlayer = new MusicPlayer("crazystanswelcomemessage.wav", 35000);

    public CrazyStans() throws IOException {
    }

    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        this.traveler = traveler;
        this.user = traveler.getUser();
        musicPlayer.start();
//        musicPlayer.waitToDie();
        musicPlayer.interrupt();
        lobbyChallenge();
        beyonceChallenge();
    }

    private void beyonceChallenge() {
        user.addItem(beyoncesRoom.start());
    }

    private void lobbyChallenge() {
        user.addItem(lobby.start());
    }

    @Override
    public void terminate() {

    }

    @Override
    public Playable playable() throws IOException {
        return new Playable("Crazy Stans", "Welcome to Stans", new CrazyStans());
    }
}