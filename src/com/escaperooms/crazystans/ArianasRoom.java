package com.escaperooms.crazystans;

import com.escaperooms.application.EscapeRoom;

class ArianasRoom {
    String start() {
        System.out.println(welcomeMessage());
        EscapeRoom.prompt("What kind of donut did Ariana Grande lick? ",
                challengeAnswer(), "That is not the correct answer.");
        return "lickedDonut";
    }

    String welcomeMessage() {
        return "Welcome to the Crazy Stans' Ariana Grande room.";
    }

    String challengeAnswer() {
        return "cream filled";
    }

}