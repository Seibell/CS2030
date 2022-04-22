class ContactCase extends Case {
    private final Case c;
    private final ImList<Test> history;

    ContactCase(Person person, Test test, Case c) {
        super(person, test, -1);
        this.c = c;

        ImList<Test> firstTest = new ImList<Test>();
        firstTest = firstTest.add(test);

        this.history = firstTest;
    }

    ContactCase(Person person, ImList<Test> history, Protocol protocol, Case c) {
        super(person, history, protocol);
        this.c = c;
        this.history = history;
    }
    
    ContactCase test(Test t) {
        ImList<Test> tempHistory = history;

        if (t.isValid()) {
            tempHistory = tempHistory.add(t);
        }
        return new ContactCase(super.getPerson(), tempHistory, next(super.getPerson(), t, -1), c);
    }

    ImList<Case> getLineage() {
        return c.getLineage().add(this);
    }
}
