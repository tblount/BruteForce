package escaperooms.crazystans;

import escaperooms.application.Room;
import escaperooms.music.MusicPlayer;

import java.util.List;

class Lobby {

    public Lobby() {
        List<String> items = List.of("songKey");
        Room room = new Room("Lobby", items);
    }

    String welcomeMessage() {
        return "Welcome to Crazy Stans Lobby";
    }

    void playSong() {
        try {
            MusicPlayer musicPlayer = new MusicPlayer();
            musicPlayer.play("feelitstill.wav");
        } catch(Exception e) {
            System.out.println("Something went wrong.");
        }
    }
}