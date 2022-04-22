class P2 implements Protocol {
    private final String id;
    private final Test test;

    P2(Test test) {
        this.test = test;
        if (test.isPositive()) {
            this.id = "P2";
        } else {
            this.id = "Discharged: follow up with doctor";
        }
    }

    P2(String id) {
        this.id = id;
        this.test = new PCR("");
    }

    public Protocol next(Person person, Test test, int numOfDays) {
        if (numOfDays > 3 && numOfDays <= 7) {
            if (test.isPositive()) {
                return new P2("P2");
            } else {
                return new P2("Discharged: complete");
            }
        }
        if (numOfDays > 7 && numOfDays < 15) {
            if (person.isVaccinated()) {
                if (test.isPositive()) {
                    return new P2("Discharged: complete");
                } else {
                    return new P2("Discharged: complete");
                }
            } else {
                if (test.isPositive()) {
                    return new P2("P2");
                } else {
                    return new P2("Discharged: complete");
                }
            }
        }
        if (numOfDays == 15) {
            return new P2("Discharged: complete");
        }

        if (numOfDays > 15) {
            if (test.isPositive()) {
                return new P2("Discharged: seek medical attention");
            } else {
                return new P2("Discharged: complete");
            }
        }

        return new P2("P2");
    }

    public Protocol getCurrentProtocol() {
        return this;
    }

    @Override
    public String toString() {
        return id;
    }
}
