class Count<T> extends Aggregate<Integer,T> {
    private Count(Integer state, T value) {
        super(state, value);
    }

    static <T> Count<T> of(T value) {
        return new Count<T>(1, value);
    }

    Count<T> map(T value) {
        Aggregate<Integer,T> agg = super.map(x -> x + 1, value);
        return agg.seed().map(x -> new Count<T>(x, value)).get();
    }
}
