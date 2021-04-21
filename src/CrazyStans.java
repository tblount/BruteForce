class CrazyStans extends EscapeRoom {

    Traveler traveler;

    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        this.traveler = traveler;
        System.out.println("You are now in Crazy Stans!");
    }

    @Override
    public void terminate() {

    }

    @Override
    public Playable playable() {
        return new Playable("Crazy Stans", "Welcome to Stans", new CrazyStans());
    }
}