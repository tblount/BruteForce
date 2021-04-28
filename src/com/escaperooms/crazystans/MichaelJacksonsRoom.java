package com.escaperooms.crazystans;

import com.escaperooms.application.EscapeRoom;

class MichaelJacksonsRoom {
    String start() {
        System.out.println(welcomeMessage());
        EscapeRoom.prompt("In the song Billie Jean, what did Michael Jackson state Billie Jean was more like? ",
                challengeAnswer(), "That is not the correct answer.");
        return "michaelJacksonsGlove";
    }

    String welcomeMessage() {
        return "Welcome to the Crazy Stans' Michael Jackson room.";
    }

    String challengeAnswer() {
        return "beauty queen";
    }
}