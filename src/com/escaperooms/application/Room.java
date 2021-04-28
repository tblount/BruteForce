package com.escaperooms.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    String name;
    Map<String, String> directions = new HashMap<>();
    List<String> items = new ArrayList<>();
    List<String> usefulItems = new ArrayList<>();
    List<String> actors = new ArrayList<>();
    List<String> doors = new ArrayList<>();

    public Room(String name) {
        setName(name);
    }

    public Room(String name, List<String> items) {
        this(name);
        setItems(items);
    }

    public Room(String name, List<String> items, List<String> usefulItems) {
        this(name, items);
        setUsefulItems(usefulItems);
    }

    public Room(String name, List<String> items, List<String> usefulItems, List<String> actors) {
        this(name, items, usefulItems);
        setActors(actors);
    }

    public Room(String name, List<String> items, List<String> usefulItems, List<String> actors, List<String> doors) {
        this(name, items, usefulItems,actors);
        setDoors(doors);
    }

    public void setDoors(List<String> doors) {
        this.doors = doors;
    }

    public List<String> getDoors() {
        return this.doors;
    }

    public void addDoor(String door) {
        this.doors.add(door);
    }

    public void removeDoor(String door) {
        this.doors.remove(door);
    }

    public boolean hasDoor(String door) {
        return this.doors.contains(door);
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public List<String> getUsefulItems() {
        return usefulItems;
    }

    public void setUsefulItems(List<String> usefulItems) {
        this.usefulItems = usefulItems;
    }

    public void removeUsefulItem(String item) {
        usefulItems.remove(item);
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasItem(String itemName) {
        return getItems().contains(itemName);
    }

    public boolean hasUsefulItem(String itemName) {
        return getUsefulItems().contains(itemName);
    }

    public boolean hasActor(String actorName) {
        return getActors().contains(actorName);
    }


}