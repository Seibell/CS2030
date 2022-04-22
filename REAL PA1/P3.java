class P3 implements Protocol {
    private final String id;
    private final Test test;

    P3(Test test) {
        this.test = test;
        this.id = "P3";
    }

    P3(String id) {
        this.id = id;
        this.test = new PCR("");
    }

    public Protocol next(Person person, Test test, int numOfDays) {

        boolean canDischarge = false;

        if (numOfDays == 5) {
            canDischarge = true;
            if (test.isPositive() == false) {
                return new P3("Discharged: complete");
            } else {
                if (person.isHighRisk()) {
                    return new P1("P1");
                } else {
                    return new P2("P2");
                }
            }
        }
        if (numOfDays > 5) {
            if (test.isPositive() == false) {
                return new P3("Discharged: complete");
            } else {
                return new P3("Discharged: seek medical attention");
            }
        }
        if (test.isPositive()) {
            if (person.isHighRisk()) {
                return new P1("P1");
            } else {
                return new P2("P2");
            }
        }
        return new P3("P3");
    }

    public Protocol getCurrentProtocol() {
        return this;
    }

    @Override
    public String toString() {
        return id;
    }
}
