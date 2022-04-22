abstract class Registry {
    private final DataStore ds;
    private final String id;

    Registry(String id) {
        this.id = id;
        this.ds = new DataStore();
    }

    void store(String message) {
        ds.write(message);
    }

    String getID() {
        return this.id;
    }

    abstract void alert(int time);

    @Override
    public String toString() {
        return String.format("[%s]", id);
    }
}
