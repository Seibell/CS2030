import java.util.List;

class PrivateCar extends Driver {
    
    PrivateCar(String plate, int waitingTime) {
        super(plate, waitingTime);
    }

    @Override
    String getCarType() {
        return "PrivateCar";
    }

    @Override
    List<String> getServices() {
        return List.of("ShareARide", "JustRide");
    }

    @Override
    public String toString() {
        return super.getPlate() + " (" + super.getWaitingTime() + " mins away) PrivateCar";
    }
}
