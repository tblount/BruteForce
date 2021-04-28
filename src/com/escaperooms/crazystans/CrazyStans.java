package com.escaperooms.crazystans;

import com.escaperooms.application.EscapeRoom;
import com.escaperooms.application.Playable;
import com.escaperooms.application.Traveler;
import com.escaperooms.application.User;
import com.escaperooms.music.MusicPlayer;

import java.io.IOException;

public class CrazyStans extends EscapeRoom {
    private final String name = "Crazy Stans";
    private Traveler traveler;
    User user;
    Lobby lobby = new Lobby();
    BeyoncesRoom beyoncesRoom = new BeyoncesRoom();
    ArianasRoom arianasRoom = new ArianasRoom();
    MichaelJacksonsRoom michaelJacksonsRoom = new MichaelJacksonsRoom();
    ChristinaAguilerasRoom christinaAguilerasRoom = new ChristinaAguilerasRoom();
    MusicPlayer musicPlayer;

    public CrazyStans() throws IOException {
    }

    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        musicPlayer = new MusicPlayer("stansbgm.wav");
        this.traveler = traveler;
        this.user = traveler.getUser();
        user.newName("Nick");
        opening();
        challenges();
        closing();
    }

    private void opening() {
        musicPlayer.start();
        System.out.println(welcomeMessage());
        EscapeRoom.prompt("Type 'start' to begin the challenges ", "start", "Invalid command");
        musicPlayer.stopMusic();
    }

    private void challenges() {
        lobbyChallenge();
        beyonceChallenge();
        arianaChallenge();
        michaelJacksonChallenge();
        christinaAguileraChallenge();
    }

    private void closing() {
        traveler.menu();
    }

    private void beyonceChallenge() {
        user.addItem(beyoncesRoom.start());
    }

    private void lobbyChallenge() {
        user.addItem(lobby.start());
    }

    private void arianaChallenge() {
        user.addItem(arianasRoom.start());
    }

    private void michaelJacksonChallenge() {
        user.addItem(michaelJacksonsRoom.start());
    }

    private void christinaAguileraChallenge() {
        user.addItem(christinaAguilerasRoom.start());
    }

    public String getName() {
        return this.name;
    }

    private String welcomeMessage() {
        return "Welcome to " + name + ".";
    }


    @Override
    public void terminate() {

    }

    @Override
    public Playable playable() throws IOException {
        return new Playable(this.getName(), welcomeMessage(), new CrazyStans());
    }
}