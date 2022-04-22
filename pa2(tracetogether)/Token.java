class Token {
    private static final int MAX_TOKENS = 20;
    private final int id;
    private final ImList<Integer> times;

    Token(int id) {
        this.id = id;

        ImList<Integer> tempTimes = new ImList<Integer>();

        for (int i = 0; i < MAX_TOKENS; i++) {
            tempTimes = tempTimes.add(0);
        }

        times = tempTimes;
    }

    Token(Token t) {
        this.id = t.id;
        this.times = t.times;
    }
    
    Token(int id, ImList<Integer> times) {
        this.id = id;
        this.times = times;
    }

    Token ping(Token t, int time) {
        return new Token(this.id, times.set(t.id, time));
    }

    String getTimes(int time) {

        boolean hasAtLeastOnePing = false;

        String s = String.format("DataStore: Token #%d:", this.id);

        for (int i = 0; i < times.size(); i++) {
            if (times.get(i) > 0 && times.get(i) == time) {
                hasAtLeastOnePing = true;
                s += String.format(" #%d@%d", i, times.get(i));
            }
        }

        if (hasAtLeastOnePing == false) {
            s += " none";
        }

        return s;
    }

    @Override
    public String toString() {
        boolean hasAtLeastOnePing = false;

        String print = String.format("Token #%d:", this.id);

        for (int i = 0; i < times.size(); i++) {
            if (times.get(i) > 0) {
                hasAtLeastOnePing = true;
                print += String.format(" #%d@%d", i, times.get(i));
            }
        }
        if (hasAtLeastOnePing == false) {
            print += " none";
        }

        return print;
    }
}
