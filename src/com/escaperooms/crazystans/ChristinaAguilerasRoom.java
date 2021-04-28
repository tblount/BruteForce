package com.escaperooms.crazystans;

import com.escaperooms.application.EscapeRoom;
import com.escaperooms.music.MusicPlayer;

import java.util.Map;

class ChristinaAguilerasRoom {

    Map<String, String> answers = Map.of("challengeOneSoar", "soar", "challengeTwoIWillBe", "i will be");

    String start() {
        System.out.println(welcomeMessage());
        challengeOneSoar();
        challengeTwoIWillBe();
        return "aguilerasMic";
    }

    private void challengeOneSoar() {
        MusicPlayer musicPlayer = startSong("soar.wav");
        EscapeRoom.prompt("What word is the highest note hit in this sequence? ",
                answers.get("challengeOneSoar"), "That is not the correct answer.");
        musicPlayer.stopMusic();
    }

    private void challengeTwoIWillBe() {
        MusicPlayer musicPlayer = startSong("iwillbe.wav");
        EscapeRoom.prompt("Unreleased as apart of the Stripped album, the greatest album of all time, what is the name is this song? ",
                answers.get("challengeTwoIWillBe"), "That is not the correct answer.");
        musicPlayer.stopMusic();
    }

    String welcomeMessage() {
        return "Welcome to Crazy Stans' Christina Aguilera Room. You have been allowed entry into the GOAT's room " +
                "because you have acquired the items from those that aspire to be the GOAT but are not quite there, \n " +
                "and a legend from the past. Here you will be faced with three challenges, the most difficult you have \n" +
                "faced. Solve all 3 challenges, and you will be granted with the mic of the great one.";
    }


    private MusicPlayer startSong(String song) {
        MusicPlayer musicPlayer = new MusicPlayer(song);
        musicPlayer.start();
        return  musicPlayer;
    }

}