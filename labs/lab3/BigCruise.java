class BigCruise extends Cruise {

    private final String identifier;
    private final int arrivalTime;
    private final int cruiseLength;
    private final int numOfPassengers;

    private static final double rateOfService = 50.0;
    private static final double maxPerLoaderLength = 40.0;

    BigCruise(String identifier, int arrivalTime, int cruiseLength, int numOfPassengers) {
        super(identifier, arrivalTime, (int) Math.ceil(cruiseLength / maxPerLoaderLength), 
                (int) Math.ceil(numOfPassengers / rateOfService));

        this.identifier = identifier;
        this.arrivalTime = arrivalTime;
        this.cruiseLength = cruiseLength;
        this.numOfPassengers = numOfPassengers;
    }

}
