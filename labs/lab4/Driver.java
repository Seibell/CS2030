import java.util.List;

abstract class Driver {
    private final String plate;
    private final int waitingTime;

    Driver(String plate, int waitingTime) {
        this.plate = plate;
        this.waitingTime = waitingTime;
    }

    abstract String getCarType();

    abstract List<String> getServices();
    
    int getWaitingTime() {
        return this.waitingTime;
    }

    String getPlate() {
        return this.plate;
    }
}
