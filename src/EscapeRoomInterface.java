interface EscapeRoomInterface {
    default Playable playable() {
        return null;
    }

    default void run(Traveler traveler, EscapeRoom escapeRoom) {

    }
    default void terminate() {

    }
}