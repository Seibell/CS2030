import java.util.function.Function;

class InvalidAggregate<S, T> extends Aggregate<S, T> {
    protected InvalidAggregate() {
        super();
    }

    @Override
    Aggregate<S,T> map(Function<S,S> mapper, T object) {
        return new InvalidAggregate<S, T>();
    }

    @Override
    Aggregate<S,T> map(Function<S,Pair<S,T>> mapper) {
        return new InvalidAggregate<S, T>();
    }

    @Override
    <U> Aggregate<S,U> flatMap(Function<T,Aggregate<S,U>> mapper) {
        return new InvalidAggregate<S, U>();
    }

    @Override
    public String toString() {
        return "Invalid Aggregate";
    }
}
