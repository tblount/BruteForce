import java.io.IOException;

class CrazyStans extends EscapeRoom {

    Traveler traveler;

    public CrazyStans ()  throws IOException {

    }

    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        this.traveler = traveler;
        System.out.println("You are now in Crazy Stans!");
    }

    @Override
    public void terminate() {

    }

    @Override
    public Playable playable() throws IOException {
        return new Playable("Crazy Stans", "Welcome to Stans", new CrazyStans());
    }
}