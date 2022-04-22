class Schedule {
    private final ImList<Class> classes;

    Schedule() {
        ImList<Class> emptyList = new ImList<Class>();

        this.classes = emptyList;
    }

    Schedule(ImList<Class> classes) {
        this.classes = classes;
    }

    Schedule add(Class c) {

        int count = 0;

        for (Class i : classes) {
            if (c.clashWith(i)) {
                count++;
                return new Schedule(classes);
            }
        }
        return new Schedule(classes.add(c));
    }

    @Override
    public String toString() {

        String print = "\n";

        for (int i = 0; i < classes.size(); i++) {
            print += classes.get(i);
            print += "\n";
        }

        return print;
    }
}
