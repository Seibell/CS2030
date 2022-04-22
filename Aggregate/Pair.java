class Pair<T,U> {
    private final T first;   
    private final U second;

    static <T,U> Pair<T,U> of(T first, U second) {
        return new Pair<T,U>(first, second);
    }

    protected Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    protected T first() {
        return this.first;
    }

    protected U second() {
        return this.second;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", first, second);
    }
}

