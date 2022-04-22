import java.util.Comparator;

class IntComp implements Comparator<Integer> {
    public int compare(Integer one, Integer two) {
        return one - two;
    }
}
