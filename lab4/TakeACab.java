class TakeACab implements Service {

    private static final int BASE_FARE = 200;
    private static final int FEE_PER_KM = 33;

    public int computeFare(Request request) {
        return BASE_FARE + request.getDistance() * FEE_PER_KM;
    }

    public String toString() {
        return "TakeACab";
    }
}
