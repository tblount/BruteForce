package com.escaperooms.crazystans;


import com.escaperooms.application.EscapeRoom;
import com.escaperooms.music.MusicPlayer;

class Lobby {
    MusicPlayer musicPlayer;

    public Lobby() {
    }

    String start() {
        musicPlayer = new MusicPlayer("feelitstill.wav");
        System.out.println(welcomeMessage());
        playSong();
        EscapeRoom.prompt("The answer is in the song. When something's unexpected, it is said to be what? Listen carefully. ",
                challengeAnswer(), "That is not the correct answer.");
        musicPlayer.stopMusic();
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
