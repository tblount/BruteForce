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

    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        this.traveler = traveler;
        User user = traveler.getUser();
        user.newName("Rennie");
        this.running = true;
        user.addItem("Aguilera's Microphone");
        user.addItem("ExampleItem");

        Prompter prompter = new Prompter(new Scanner(System.in));

        user.move("KITCHEN");

        //Start Scene//
        while (true){
            if(!running){
                break;
            }
            describeRoom(user.getCurrentRoom(), escapeRoom);
            Room userCurrentRoom = escapeRoom.innerRooms.get("Space Odyssey : "+user.getCurrentRoom());

            String inputAction = prompter.prompt("What do you want to do?\n\uD83D\uDE80").toUpperCase();
            String[] choice = inputAction.split(" ");
                    switch(choice[0]){
                case "INVENTORY" : traveler.getUser().showInventory(); prompter.prompt("Press Enter to Continue"); break;
                        case "TAKE":
                        case "GRAB":
                        case "GET": if(userCurrentRoom.hasItem(choice[1])){
                    user.addItem(choice[1]);
                    userCurrentRoom.removeItem(choice[1]);
                }else{
                    System.out.println("Can't get "+choice[1]);
                } prompter.prompt("Press Enter to Continue\n"); break;
                        case "CLIMB":
                        case "SWIM":
                        case "WALK":
                        case "RUN":
                        case "GO":
                    if(choice.length>=2){
                        if (choice[1].equals("TO")){
                            String room = inputAction.substring(6);
                            if(userCurrentRoom.hasDoor(room)){
                                user.move(room);
                            }else{
                                System.out.println("Can't go to "+room);
                            }
                        }else{
                            String room = inputAction.substring(3);
                            if(userCurrentRoom.hasDoor(room)){
                                user.move(room);
                            }else{
                                System.out.println("Can't go to "+room);
                            }
                        }
                    } prompter.prompt("Press Enter to Continue\n"); break;
                        case "THROW":
                        case "TRY":
                        case "PUSH":
                        case "PULL":
                        case "KICK":
                        case "FIX":
                        case "CLEAN":
                        case "USE":
                    if(choice.length>1 && userCurrentRoom.hasUsefulItem(choice[1]) && user.isItemInInventory(choice[1])){
                        tryNarrate(choice[1],1);
                        userCurrentRoom.removeUsefulItem(choice[1]);
                        user.addAnswer(choice[1]);
                    }else{
                        System.out.println("Can't use "+choice[1]);
                    } prompter.prompt("Press Enter to Continue\n"); break;
                case "TALK":
                    if(choice.length>1 && userCurrentRoom.hasActor(choice[choice.length-1])){
                        if(user.isCurrentRoom("KITCHEN") && user.hasAnswer("ROCK") && user.hasAnswer("MATCH") && !user.hasAnswer("APRON") ){
                            tryNarrate(choice[choice.length-1],2);
                            System.out.println("But you're not a chef, so GET OUT OF MY KITCHEN!");
                            new MusicPlayer("soup.wav").start();
                            user.getFinishTime();
                            running = false;
                            break;
                        }else if(user.isCurrentRoom("KITCHEN") && user.hasAnswer("ROCK") && user.hasAnswer("MATCH") && user.hasAnswer("APRON") ){
                            tryNarrate(choice[choice.length-1],2);
                            user.addItem("Golden Spatula");
                            System.out.println("Before you have to thank them, you are sucked into a time loop");
                            prompter.prompt("Press Enter to Continue\n");
                            running = false;
                            EscapeRoom stan = traveler.getRooms().get(1).getEscapeRoom();
                            stan.run(traveler,escapeRoom);
                        }
                        else{
                            tryNarrate(choice[choice.length-1],1);
                            tryPlayConvo(choice[choice.length-1]);
                        }
                    }else{
                        System.out.println("Can't talk to "+choice[choice.length-1]);
                    }
                    prompter.prompt("Press Enter to Continue\n"); break;
                case "QUIT" :running = false; break;
                default:
                    System.out.println("I don't understand that command :"+choice[0]); prompter.prompt("Press Enter to Continue\n"); break;
            }

        }
    }

    @Override
    public void terminate() {

    }

    void tryPlayConvo(String convo){
        try{
            new MusicPlayer(convo+"0.wav").start();
        }catch(Exception e){
            System.out.println("I don't understand "+convo+" or maybe I can't find my dictionary");
        }
    }

    void tryPlayConvo(String convo,int index){
        try{
            new MusicPlayer(convo+index+".wav").start();
        }catch(Exception e){
            System.out.println("I don't understand "+convo+" or maybe I can't find my dictionary");
        }
    }

    void tryNarrate(String item){
        try{
            new Narrator().spaceTalk(item);
        }catch(IOException io){
            System.out.println("I don't understand "+item+" or maybe I can't find my dictionary");
        }
    }

    void tryNarrate(String item, int convo){
        try{
            new Narrator().spaceTalk(item,convo);
        }catch(IOException io){
            System.out.println("I don't understand "+item+" or maybe I can't find my dictionary");
        }
    }

    public void describeRoom (String currentRoom, EscapeRoom escapeRoom) {
        tryNarrate(currentRoom);
        Room userCurrentRoom = escapeRoom.innerRooms.get("Space Odyssey : "+currentRoom);
        for(String item : userCurrentRoom.getItems()){
            if(item.length()>1){
                tryNarrate(item,0);
            }
        }
        for(String actor : userCurrentRoom.getActors()){
            if(actor.length()>1){
                tryNarrate(actor,0);
            }
        }
        for(String item : userCurrentRoom.getUsefulItems()){
            if(item.length()>1){
                tryNarrate(item,2);
            }
        }
        if(userCurrentRoom.getDoors().size()==1){
            System.out.println("You can go to "+userCurrentRoom.getDoors()+ ".");
        }
        if(userCurrentRoom.getDoors().size()>1){
            System.out.println("You can go to "+userCurrentRoom.getDoors().subList(0,userCurrentRoom.getDoors().size()-1)+ " or "+userCurrentRoom.getDoors().get(userCurrentRoom.getDoors().size()-1)+".");
        }

    }






}