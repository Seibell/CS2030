import java.util.List;

class NormalCab extends Driver {

    NormalCab(String plate, int waitingTime) {
        super(plate, waitingTime);
    }

    @Override
    String getCarType() {
        return "NormalCab";
    }

    List<String> getServices() {
        return List.of("JustRide", "TakeACab");
    }

    @Override
    public String toString() {
        return super.getPlate() + " (" + super.getWaitingTime() +  " mins away) NormalCab"; 
    }
}
