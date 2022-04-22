class Cruise {
    private final String identifier;
    private final int arrivalTime;
    private final int numOfLoader;
    private final int serviceTime;

    private static final int MINS_PER_HOUR = 60;

    Cruise(String identifier, int arrivalTime, int numOfLoader, int serviceTime) {
        this.identifier = identifier;
        this.arrivalTime = arrivalTime;
        this.numOfLoader = numOfLoader;
        this.serviceTime = serviceTime;
    }

    int getArrivalTime() {
        
        int minutesSinceMidnight = arrivalTime;
        int hours = 0;

        while (minutesSinceMidnight >= 100) {
            hours++;
            minutesSinceMidnight -= 100;
        }

        minutesSinceMidnight += hours * MINS_PER_HOUR;

        return minutesSinceMidnight;
    }

    int getServiceCompletionTime() {
        return this.getArrivalTime() + serviceTime;
    }

    int getNumOfLoadersRequired() {
        return this.numOfLoader;
    }

    int getServiceTime() {
        return this.serviceTime;
    }
    
    @Override
    public String toString() {
        return identifier + "@" + String.format("%04d", arrivalTime);
    }
}
