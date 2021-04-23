package escaperooms.crazystans;

import escaperooms.application.EscapeRoom;
import escaperooms.music.MusicPlayer;

class Lobby {
    MusicPlayer musicPlayer = new MusicPlayer("feelitstill.wav", 500000);

    public Lobby() {
    }

    String start() {
        System.out.println(welcomeMessage());
        playSong();
        EscapeRoom.prompt("When something's unexpected, it said to be what? Listen carefully. ",
                challengeAnswer(), "That is not the correct answer.");
        MusicPlayer.stopMusic(musicPlayer);
        return "songKey";
    }

    String welcomeMessage() {
        return "Welcome to Crazy Stans Lobby";
    }

    void playSong() {
        musicPlayer.start();
    }

    String challengeAnswer() {
        return "coming out of left field";
    }
}