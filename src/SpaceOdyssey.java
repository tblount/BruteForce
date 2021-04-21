class SpaceOdyssey extends EscapeRoom{

    Traveler traveler;

    public Playable playable() {
        return new Playable("Space Odyssey", "Welcome to Space Odyssey", new SpaceOdyssey());
    }

    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        this.traveler = traveler;
        System.out.println("running Space Odyssey");
    }

    @Override
    public void terminate() {

    }

}