import java.util.List;

class Traveler {
    List<Playable> escapeRooms;
    User user;
    EscapeRoom escapeRoom;


    public Traveler(User user, List<Playable> escapeRooms, EscapeRoom escapeRoom) {
        this.escapeRooms = escapeRooms;
        this.user = user;
        this.escapeRoom = escapeRoom;
    }

    void jump(EscapeRoom room) {
        room.run(this, escapeRoom);
    }

    User getUser() {
        return this.user;
    }

    List<Playable> getRooms() {
        return escapeRooms;
    }
}