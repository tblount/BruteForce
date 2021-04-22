import java.io.IOException;

interface EscapeRoomInterface {
    default Playable playable() throws IOException {
        return null;
    }

    default void run(Traveler traveler, EscapeRoom escapeRoom) {

    }
    default void terminate() {

    }
}