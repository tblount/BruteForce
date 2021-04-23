package com.escaperooms.crazystans;

import com.escaperooms.application.EscapeRoom;

class BeyoncesRoom {

    String start() {
        System.out.println(welcomeMessage());
        EscapeRoom.prompt("What album won Beyonce's her first solo Grammy? ",
                challengeAnswer(), "That is not the correct answer.");
        System.out.println(itemUnlocked());
        return "beyoncesGrammy";
    }

    String welcomeMessage() {
        return "Welcome to the Crazy Stans Beyonce room.";
    }

    String challengeAnswer() {
        return "dangerously in love";
    }

    String itemUnlocked() {
        return "beyoncesGrammy acquired";
    }
}