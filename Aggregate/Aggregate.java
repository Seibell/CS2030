import java.util.function.Function;
import java.util.Optional;

class Aggregate<S,T> {
    private final Pair<Optional<S>, Optional<T>> pair; 
    private final Optional<Function<S,Pair<S,T>>> function;

    static <S,T> Aggregate<S,T> of(Function<S,Pair<S,T>> function) {
        return new Aggregate<S,T>(function);
    }

    static <S,T> Aggregate<S,T> seed(S seed) {
        return new Aggregate<S,T>(Optional.of(seed), Optional.empty());
    }

    protected Aggregate() {
        this(Optional.empty(), Optional.empty());
    }

    protected Aggregate(S seed, T object) {
        this(Optional.of(seed), Optional.of(object));
    }

    private Aggregate(Function<S,Pair<S,T>> function) {
        this.pair = Pair.of(Optional.empty(), Optional.empty());
        this.function = Optional.of(function);
    }

    protected Aggregate(Optional<S> seed, Optional<T> object) {
        this.pair = Pair.of(seed, object);
        this.function = Optional.empty();
    }

    protected Optional<S> seed() {
        return this.pair.first();
    }
    
    protected Optional<T> object() {
        return this.pair.second();
    }

    protected Optional<Function<S,Pair<S,T>>> function() {
        return this.function;
    }

    Aggregate<S,T> map(Function<S,S> mapper, T object) {
        return this.seed()
            .map(mapper)
            .map(s -> new Aggregate<S,T>(s, object))
            .orElse(new InvalidAggregate<S,T>());
    }

    Aggregate<S,T> map(Function<S,Pair<S,T>> mapper) {
        return this.seed()
            .map(mapper)
            .map(pair -> new Aggregate<S,T>(pair.first(), pair.second()))
            .orElse(new InvalidAggregate<S,T>());
    }

    <U> Aggregate<S,U> flatMap(Function<T,Aggregate<S,U>> mapper) {
        return this.object() 
            .map(mapper) 
            .flatMap(agg ->  
                this.seed() 
                    .flatMap(seed -> agg.function()
                        .map(func -> func.apply(seed))
                    )
                )
            .map(pair -> new Aggregate<S,U>(pair.first(), pair.second()))
            .orElse(new InvalidAggregate<S,U>());
    }

    @Override
    public String toString() {
        return this.function()
            .map(func -> "Aggregate")
            .orElseGet(
                () -> this.object()
                    .map(object -> String.format(", %s)", object))
                    .map(str -> String.format("(%s", this.seed().get()) + str)
                    .orElse(String.format("(%s)", this.seed().get()))
        );
    }
}

