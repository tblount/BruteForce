package com.escaperooms.crazystans;

import com.escaperooms.application.EscapeRoom;

import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.ansi;

class BeyoncesRoom {
    Hinter hinter;

    String start() {
        generateHints();
        System.out.println(welcomeMessage());
        askQuestion();
        return "beyoncesGrammy";
    }

    private void askQuestion() {
        String hint = EscapeRoom.prompt("What album won Beyonce her first solo Grammy? ",
                challengeAnswer() + "|hint", "That is not the correct answer.");
        if (hint.equals("hint")) {
            hintChecker();
        }
    }

    private void generateHints() {
        hinter = new Hinter("It was her debut solo album.", "It was a love of the dangerous type");
    }

    private void hintChecker() {
        if (hinter.isEmpty()) {
            System.out.println(ansi().fg(RED).a("NO MORE HINTS! SOLVE IT! USE GOOGLE!").reset());
        } else {
            System.out.println("Hint: " + hinter.getHint());
        }
        askQuestion();
    }

    String welcomeMessage() {
        return "Welcome to the Crazy Stans Beyonce room.";
    }

    String challengeAnswer() {
        return "dangerously in love";
    }

}
