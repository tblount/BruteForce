package escaperooms.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    String name;
    Map<String, String> directions = new HashMap<>();
    List<String> items = new ArrayList<>();
    List<String> usefulItems = new ArrayList<>();
    List<Actor> actors = new ArrayList<>();

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

    public Room(String name, List<String> items, List<String> usefulItems, List<Actor> actors) {
        this(name, items, usefulItems);
        setActors(actors);
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<String> getUsefulItems() {
        return usefulItems;
    }

    public void setUsefulItems(List<String> usefulItems) {
        this.usefulItems = usefulItems;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
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