import java.util.Comparator;

class CompareBooking implements Comparator<Booking> {
    
    @Override
    public int compare(Booking one, Booking two) {
        return one.compareTo(two);
    }
}
