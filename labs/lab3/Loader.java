class Loader {
    private final int identifier;
    private final Cruise cruise;

    Loader(int identifier, Cruise cruise) {
        this.identifier = identifier;
        this.cruise = cruise;
    }

    public boolean canServe(Cruise cruise) {
        return this.getNextAvailableTime() <= cruise.getArrivalTime();
    }

    Loader serve(Cruise cruise) {
        if (canServe(cruise)) {
            return new Loader(this.identifier, cruise);
        } 
        return this;
    }

    int getIdentifier() {
        return this.identifier;
    }

    int getNextAvailableTime() {
        return this.cruise.getServiceCompletionTime();
    }

    public String toString() {
        return "Loader " + this.identifier + " serving " + this.cruise.toString();    
    }

}
