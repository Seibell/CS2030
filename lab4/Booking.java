class Booking implements Comparable<Booking> { 
    private final Driver driver;
    private final Request request;

    Booking(Driver driver, Request request) {
        this.driver = driver;
        this.request = request;
    }

    @Override
    public int compareTo(Booking other) {

        if (this.getLowestFare() - other.getLowestFare() != 0) {
            return this.getLowestFare() - other.getLowestFare();
        } else {
            return this.driver.getWaitingTime() - other.driver.getWaitingTime();
        }
    }

    public int getLowestFare() {
        
        int fare = 0;

        if (this.driver.getCarType().equals("NormalCab")) {
            if (getJustRideFare() - getTakeACabFare() > 0) {
                fare = getTakeACabFare();
            } else {
                fare = getJustRideFare();
            }
        } else { //if PrivateCar
            if (getJustRideFare() - getShareARideFare() > 0) {
                fare = getShareARideFare();
            } else {
                fare = getJustRideFare();
            }
        }

        return fare;
    }

    public int getJustRideFare() {
        return new JustRide().computeFare(this.request);
    }

    public int getTakeACabFare() {
        return new TakeACab().computeFare(this.request);
    }

    public int getShareARideFare() {
        return new ShareARide().computeFare(this.request);
    }

    String getDollarsCents(int cents) {
        
        int dollars = 0;

        while (cents >= 100) {
            cents -= 100;
            dollars++;
        }

        return "$" + dollars + "." + String.format("%02d", cents);
    }

    @Override
    public String toString() {
        if (this.driver.getCarType().equals("NormalCab")) {
            if (getJustRideFare() - getTakeACabFare() > 0) {
                return getDollarsCents(getTakeACabFare()) +  " using "
                    + this.driver.toString() + " (TakeACab)";
            } else {
                return getDollarsCents(getJustRideFare()) + " using "
                    + this.driver.toString() + " (JustRide)";
            }
        } else { //if PrivateCar
            if (getJustRideFare() - getShareARideFare() > 0) {
                return getDollarsCents(getShareARideFare()) + " using "
                    + this.driver.toString() + " (ShareARide)";
            } else {
                return getDollarsCents(getJustRideFare()) + " using " 
                    + this.driver.toString() + " (JustRide)";
            }
        }
    }
}
