package escaperooms.application;

public class Playable {

    String name;
    String message;
    EscapeRoom escapeRoom;

    public Playable(String name, String message, EscapeRoom escapeRoom) {
        setEscapeRoom(escapeRoom);
        setMessage(message);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EscapeRoom getEscapeRoom() {
        return escapeRoom;
    }

    public void setEscapeRoom(EscapeRoom escapeRoom) {
        this.escapeRoom = escapeRoom;
    }
}