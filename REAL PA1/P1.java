class P1 implements Protocol {
    private final String id;
    private final Test test;

    P1(Test test) {
        this.test = test;
        if (test.isPositive()) {
            this.id = "P1";
        } else {
            this.id = "Discharged: follow up with doctor";
        }
    }

    P1(String id) {
        this.id = id;
        this.test = new PCR("");
    }

    public Protocol next(Person person, Test test, int numOfDays) {
        if (test.isPositive()) {
            return new P1("Discharged: seek medical attention");
        } else {
            return new P1("Discharged: follow up with doctor");
        
        }
    }

    public Protocol getCurrentProtocol() {
        return this;
    }

    @Override
    public String toString() {
        return id;
    }
}
