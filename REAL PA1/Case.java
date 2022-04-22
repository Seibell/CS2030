import java.util.List;

class Case implements Protocol {
    private final Person person;
    private final PCR pcr;
    private final ImList<Test> history;
    private final Protocol protocol;

    Case(Person person, PCR pcr) {
        this.person = person;
        this.pcr = pcr;

        ImList<Test> firstTest = new ImList<Test>();
        firstTest = firstTest.add(pcr);

        this.history = firstTest;
        
        if (person.isHighRisk()) {
            this.protocol = new P1(pcr);
        } else {
            this.protocol = new P2(pcr);
        }
    }

    Case(Person person, Test test, int kekw) {
        this.person = person;
        this.pcr = new PCR("");
        
        ImList<Test> tempTest = new ImList<Test>();
        tempTest = tempTest.add(test);

        this.history = tempTest;

        if (test.isPositive()) {
            if (person.isHighRisk()) {
                this.protocol = new P1(test);
            } else {
                this.protocol = new P2(test);
            }
        } else {
            this.protocol = new P3(test);
        }
    }

    Case(Person person, ImList<Test> history, Protocol protocol) {
        this.person = person;
        this.history = history;
        this.pcr = new PCR("");
        this.protocol = protocol;
    }

    Case test(Test t) {
        ImList<Test> tempHistory = history;

        if (t.isValid()) {
            tempHistory = tempHistory.add(t);
        }

        return new Case(person, tempHistory, next(this.person, t, -1));
    }

    public Protocol next(Person person, Test test, int numOfDays) {
        if (!(test.isValid())) {
            return this.protocol;
        }
        
        int count = 0;

        for (Test t : history) {
            if (t.isPositive() == false) {
                count++;
            }
            if (count == history.size()) {
                return new P3(test).next(person, test, history.size());
            }
        }

        if (history.get(0).isPositive() == false) {
            if (test.isPositive()) {
                return new P3("Discharged: seek medical attention");
            }
        }

        if (person.isHighRisk()) {
            if (isReinfected(test) == false) {
                if (test.isPositive()) {
                    return this.protocol;
                 }
             } else {
                 return new P1("Discharged: seek medical attention");
            }
            return new P1(test).next(person, test, -1);

        } else { //person is not high risk
            if (isReinfected(test) == false) {
                return new P2(test).next(person, test, daysInfected(test));
            } else {
                if (daysInfected(test) > 7) {
                    return new P2("Discharged: seek medical attention");
                } else {
                    return new P2(test).next(person, test, daysInfected(test));
                }
            }
        }
    }

    int daysInfected(Test test) {

        ImList<Test> tempTest = history;
        tempTest = tempTest.add(test);

        int daysSinceInfection = 0;
        boolean recovered = false;
        boolean startCounting = false;

        for (int i = 0; i < tempTest.size(); i++) {
            if (tempTest.get(i).isPositive()) {
                startCounting = true;
            }
            if (startCounting == true) {
                daysSinceInfection++;
                if (tempTest.get(i).isPositive() == false) {
                    recovered = true;
                }
            }
        }
        return daysSinceInfection;
    }

    boolean isReinfected(Test test) {
        
        ImList<Test> tempTest = history;
        tempTest = tempTest.add(test);

        boolean infected = false;
        boolean reinfected = false;
        boolean recovered = false;

        for (int i = 0; i < tempTest.size(); i++) {
            if (tempTest.get(i).isPositive()) {
                infected = true;
            }
            if (infected == true) {
                if (tempTest.get(i).isPositive() == false) {
                    recovered = true;
                }
            }
            if (infected && recovered) {
                if (tempTest.get(i).isPositive()) {
                    reinfected = true;
                }
            }
        }

        if (reinfected == true) {
            return true;
        } else {
            return false;
        }
    }

    public Protocol getCurrentProtocol() {
        return this.protocol;
    }

    public ImList<Test> getTestHistory() {
        return history;
    }

    public Person getPerson() {
        return this.person;
    }

    ImList<Case> getLineage() { 
        ImList<Case> temp = new ImList<Case>(List.of(this));
        return temp;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", person.toString(),
                history.toString(), this.getCurrentProtocol());
    }
}
