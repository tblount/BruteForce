
import java.util.HashMap;
import java.util.Map;

public class EscapeRoom implements EscapeRoomInterface {

    Map<String, Playable> escapeRooms = new HashMap<>();

    void generateEscapeRooms() {
        escapeRooms.put("Space Odyssey", new SpaceOdyssey().playable());
        escapeRooms.put("Crazy Stans", new CrazyStans().playable());
        escapeRooms.put("Jonin Exams", new JoninExams().playable());
    }

    Map<String, Playable> getEscapeRooms() {
        return escapeRooms;
    }

    EscapeRoom getEscapeRoom(String room) {
        Map<String, Playable> playables = getEscapeRooms();
        return playables.get(room).getEscapeRoom();
    }

}