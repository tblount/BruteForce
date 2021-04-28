package com.escaperooms.spaceodyssey;

import com.escaperooms.application.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.escaperooms.application.Room;
import com.escaperooms.music.MusicPlayer;

import java.util.regex.*;

public class SpaceOdyssey extends EscapeRoom {
    boolean running = true;
    Map<String, Room> innerRooms = new HashMap<>();
    Traveler traveler;


    public SpaceOdyssey () throws IOException {
        super();
    }

    public Playable playable()  throws IOException {
        return new Playable("Space Odyssey", "Welcome to Space Odyssey", new SpaceOdyssey());
    }
//
//    @Override
//    public void run(Traveler traveler, EscapeRoom escapeRoom) {
//        this.traveler = traveler;
//        User user = traveler.getUser();
//        user.newName("Rennie");
//        this.running = true;
//        user.addItem("Aguilera's Microphone");
//        user.addItem("ExampleItem");
//
//        Prompter prompter = new Prompter(new Scanner(System.in));
//
//        user.move("KITCHEN");
//
//        //Start Scene//
//        while (true){
//            if(!running){
//                break;
//            }
//            describeRoom(user.getCurrentRoom(), escapeRoom);
//            Room userCurrentRoom = escapeRoom.innerRooms.get("Space Odyssey : "+user.getCurrentRoom());
//
//            String[] choice = prompter.prompt("Do Something!\n\uD83D\uDE80").toUpperCase().split(" ");
//            switch(choice[0]){
//                case "INVENTORY" : traveler.getUser().showInventory(); break;
//                case "JUMP" : if(choice.length>1){
//                    user.move(choice[1]);
//                } break;
//                case "GET": if(userCurrentRoom.hasItem(choice[1])){
//                    user.addItem(choice[1]);
//                    userCurrentRoom.removeItem(choice[1]);
//                }else{
//                    System.out.println("Can't get "+choice[1]);
//                } break;
//                case "GO":
//                    if(choice.length>1){
//                        switch(choice[1]){
//                            case "CAVE": user.move("CAVE"); break;
//                            case "KITCHEN": user.move("KITCHEN"); break;
//                            default:
//                                System.out.println("Can't go to "+choice[1]); break;
//                        }
//                    } break;
//                case "USE":
//                    if(choice.length>1 && userCurrentRoom.hasUsefulItem(choice[1])&& user.isItemInInventory(choice[1])){
//                        tryNarrate(choice[1],1);
//                        userCurrentRoom.removeUsefulItem(choice[1]);
//                    }else{
//                        System.out.println("Can't use "+choice[1]);
//                    } break;
//                case "TALK":
//                    if(choice.length>1 && userCurrentRoom.hasActor(choice[choice.length-1])){
//                        tryNarrate(choice[choice.length-1],1);
//                        new MusicPlayer(choice[choice.length-1].toUpperCase()+"0.wav").start();
//                    }else{
//                        System.out.println("Can't use "+choice[1]);
//                    }
//                    prompter.prompt("Press Enter"); break;
//                case "QUIT" :running = false; break;
//                default:
//                    System.out.println("I don't understand that command :"+choice[0]); break;
//            }
//
//        }
//        System.out.println("Stay Tuned For more game");
//    }
//
//    @Override
//    public void terminate() {
//
//    }
//
//    void jump() throws IOException {
//        EscapeRoom room = getEscapeRoom("Crazy Stans");
//        traveler.jump(room);
//    }
//
//    void promptRoomChange(Prompter prompter, Traveler traveler, EscapeRoom escapeRoom){
//
//        if(prompter.prompt("Do you want to go to Crazy Stans?\n\uD83D\uDE80","Y|y|N|n","Enter Valid Answer [Y]/[N]?").toUpperCase().equals("Y")) {
//            System.out.println("Teleporting now");
//            EscapeRoom stan = traveler.getRooms().get(1).getEscapeRoom();
//            stan.run(traveler,escapeRoom);
//            running = false;
//        }else{
//            if(prompter.prompt("Do you want to go to Jonin Exams?\n\uD83D\uDE80","Y|y|N|n","Enter Valid Answer [Y]/[N]?").toUpperCase().equals("Y")) {
//                System.out.println("Flying Raijin Jutsu!");
//                EscapeRoom exams = traveler.getRooms().get(0).getEscapeRoom();
//                exams.run(traveler,escapeRoom);
//                running = false;
//            }
//        }
//
//    }
//
//    void tryNarrate(String item){
//        try{
//            new Narrator().spaceTalk(item);
//        }catch(IOException io){
//            System.out.println("I don't understand "+item+" or maybe I can't find my dictionary");
//        }
//    }
//
//    void tryNarrate(String item, int convo){
//        try{
//            new Narrator().spaceTalk(item,convo);
//        }catch(IOException io){
//            System.out.println("I don't understand "+item+" or maybe I can't find my dictionary");
//        }
//    }
//
//    public void describeRoom (String currentRoom, EscapeRoom escapeRoom) {
//        tryNarrate(currentRoom);
//        Room userCurrentRoom = escapeRoom.innerRooms.get("Space Odyssey : "+currentRoom);
//        for(String item : userCurrentRoom.getItems()){
//            tryNarrate(item,0);
//        }
//        for(String actor : userCurrentRoom.getActors()){
//            tryNarrate(actor,0);
//        }
//        for(String actor : userCurrentRoom.getUsefulItems()){
//            tryNarrate(actor,2);
//        }
//    }
//





}