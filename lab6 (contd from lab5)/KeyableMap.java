import java.util.Optional;
import java.util.Map;

class KeyableMap<V extends Keyable> implements Keyable {

    private final String name;
    private final ImmutableMap<String, V> map;
        
    KeyableMap(String name) {
        this.name = name; 
        ImmutableMap<String, V> tempMap = new ImmutableMap<String, V>();
        this.map = tempMap;
    }

    KeyableMap(String name, ImmutableMap<String, V> map) {
        this.name = name;
        this.map = map;
    }

    @Override
    public String getKey() {
        return this.name;
    }

    ImmutableMap<String, V> getMap() {
        return this.map;
    }

    Optional<V> get(String key) {
        return this.map.get(key);
    }

    KeyableMap<V> put(V item) {
        return new KeyableMap<V>(this.name, map.put(item.getKey(), item));
    }

    @Override
    public String toString() {

        String print = "{";

        for (Map.Entry<String, V> e : map) {
            print += e.getValue() + ", ";
        }

        if (print.length() > 2) {
            print = print.substring(0, print.length() - 2);
        }

        print += "}";

        return String.format("%s: %s", this.name, print)
            .replace("[", "{").replace("]", "}");
    }
}
