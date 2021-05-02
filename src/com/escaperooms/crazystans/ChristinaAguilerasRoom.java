package com.escaperooms.crazystans;

import com.escaperooms.application.EscapeRoom;
import com.escaperooms.music.MusicPlayer;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.ansi;

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
        EscapeRoom.prompt("Type 'start' to begin the challenge ", "start", "Invalid command");
        MusicPlayer musicPlayer = startSong("soar.wav");
        EscapeRoom.prompt("What word is the highest note hit in this sequence? ",
                answers.get("challengeOneSoar"), "That is not the correct answer.");
        musicPlayer.stopMusic();
    }

    private void challengeTwoIWillBe() {
        EscapeRoom.prompt("Type 'start' to begin the challenge ", "start", "Invalid command");
        MusicPlayer musicPlayer = startSong("iwillbe.wav");
        EscapeRoom.prompt("Unreleased as apart of the Stripped album, the greatest album of all time, what is the name of this song? ",
                answers.get("challengeTwoIWillBe"), "That is not the correct answer.");
        musicPlayer.stopMusic();
    }

    String welcomeMessage() {
        return "Welcome to Crazy Stans' Christina Aguilera Room.\nYou have been allowed entry into the GOAT's room " +
                "because you have acquired the items from those that aspire to be the GOAT but can never be " +
                "and a legend from the past.\nHere you will be faced with three challenges, the most difficult you have " +
                "faced.\n" + ansi().fg(RED).a("There are no hints in this room.").reset() + "\nSolve both challenges, " +
                "and you will be granted with the mic of the great one and be allowed to escape.";
    }


    private MusicPlayer startSong(String song) {
        MusicPlayer musicPlayer = new MusicPlayer(song);
        musicPlayer.start();
        return  musicPlayer;
    }
}