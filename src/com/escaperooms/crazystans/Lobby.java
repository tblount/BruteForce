package com.escaperooms.crazystans;

import com.escaperooms.application.Room;
import com.escaperooms.music.MusicPlayer;

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
        MusicPlayer musicPlayer = new MusicPlayer("feelitstill.wav", 50000);
        musicPlayer.start();
        MusicPlayer.stopMusic(musicPlayer, 6000);
    }
}