class ShareARide implements Service {
    
    private static final int FEE_PER_KM = 50;
    private static final int LOW_LIM_TIME = 600;
    private static final int UP_LIM_TIME = 900;
    private static final int SURCHARGE = 500;

    @Override
    public int computeFare(Request request) {
        int fare = 0;

        if (request.getTime() >= LOW_LIM_TIME && request.getTime() <= UP_LIM_TIME) {
            fare += SURCHARGE;
        }

        return ((request.getDistance() * FEE_PER_KM) + fare) / request.getNumOfPassengers();
    }

    @Override
    public String toString() {
        return "ShareARide";
    }
}
