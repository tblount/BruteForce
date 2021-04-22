import java.io.IOException;
import java.util.List;

class JoninExams extends EscapeRoom {
    Traveler traveler;
    User user;
    EscapeRoom escapeRoom;

    public JoninExams () throws IOException {

    }
    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        this.escapeRoom = escapeRoom;
        this.traveler = traveler;
        this.user = traveler.getUser();
        escapeRoom.getEscapeRooms().remove("Jonin Exams");
    }

    @Override
    public void terminate() {

    }

    @Override
    public Playable playable() throws IOException {
        return new Playable("Jonin Exams", "Welcome to Jonin Exams", new JoninExams());
    }

    void jump() throws IOException {
        EscapeRoom room = getEscapeRoom("Space Odyssey");
        traveler.jump(room);
    }

}