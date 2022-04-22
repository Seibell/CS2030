import java.util.List;

class MRQ implements Question, LockQuestion {
    private final String str;
    private final List<String> options;
    private final List<Integer> ans;
    private final ImList<Integer> guesses;

    MRQ(String str, List<String> options, List<Integer> ans) {
        this.str = str;
        this.options = options;
        this.ans = ans;
        this.guesses = new ImList<Integer>();
    }

    MRQ(String str, List<String> options, List<Integer> ans, ImList<Integer> guesses) {
        this.str = str;
        this.options = options;
        this.ans = ans;
        this.guesses = guesses;
    }

    @Override
    public int mark() {
        if (guesses.size() != ans.size()) {
            return 0;
        } 
        for (int i : ans) {
            if (contains(guesses, i) == -1) {
                return 0;
            }
        }
        return 1;
    }

    @Override
    public LockQuestion lock() {
        return this;
    }

    @Override
    public int getAnswer() {
        return -1;
    }

    public int contains(ImList<Integer> guesses, int guess) {
        for (int i = 0; i < guesses.size(); i++) {
            if (guesses.get(i) == guess) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Question answer(int guess) {

        ImList<Integer> newGuesses = guesses;

        if (contains(newGuesses, guess) == -1) {
            newGuesses = newGuesses.add(guess);
        } else {
            int rmIdx = contains(newGuesses, guess);

            ImList<Integer> removed = new ImList<Integer>();

            for (int i = 0; i < newGuesses.size(); i++) {
                if (i != rmIdx) {
                    removed = removed.add(newGuesses.get(i));
                }
            }
            newGuesses = removed;
        }

        newGuesses = newGuesses.sort(new IntComp());

        return new MRQ(str, options, ans, newGuesses);
    }

    @Override
    public String toString() {
        String choices = "";

        for (int i = 0; i < options.size(); i++) {
            choices += String.format("[%d:%s]", i + 1, options.get(i));
        }

        String printGuesses = "[ ";
        for (int i = 1; i <= guesses.size(); i++) {
            printGuesses += String.format("%d ", guesses.get(i - 1));
        }
        printGuesses += "]";
    
        return String.format("%s %s; Your answer: %s", this.str, choices, printGuesses);
    }
}
