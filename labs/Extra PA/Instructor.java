class Instructor {
    private final String name;

    Instructor(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Instructor) {
            Instructor other = (Instructor) obj;
            return this.getName() == other.getName();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
