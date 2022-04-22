class SmallCruise extends Cruise {
    private final String identifier;
    private final int arrivalTime;

    private static final int NUM_OF_LOADERS = 1;
    private static final int SERVICE_TIME = 30;

    SmallCruise(String identifier, int arrivalTime) {
        super(identifier, arrivalTime, NUM_OF_LOADERS, SERVICE_TIME);
        this.identifier = identifier;
        this.arrivalTime = arrivalTime;
    }

    public String toString() {
        return super.toString();
    }
}
