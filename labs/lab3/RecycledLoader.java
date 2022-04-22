class RecycledLoader extends Loader {

    private final int identifier;
    private final Cruise cruise;

    private static final int MTN = 60;
    
    RecycledLoader(int identifier, Cruise cruise) {
        super(identifier, cruise);
        this.identifier = identifier;
        this.cruise = cruise;
    }

    @Override
    int getNextAvailableTime() {
        return this.cruise.getServiceCompletionTime() + MTN;
    }

    @Override
    public String toString() {
        return "Recycled Loader " + this.identifier + " serving " + this.cruise.toString();
    }   
}
