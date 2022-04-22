import java.util.List;

class MCQ implements Question, LockQuestion {
    private final String str;
    private final List<String> options;
    private final Object ans;
    private final int guess;

    MCQ(String str, List<String> options, Object ans) {
        this.str = str;
        this.options = options;
        this.ans = ans;
        this.guess = 0;
    }

    MCQ(String str, List<String> options, Object ans, int guess) {
        if (ans.toString().equals("True")) {
            this.ans = 1;
        } else if (ans.toString().equals("False")) {
            this.ans = 2;
        } else {
            this.ans = ans;
        }
        this.str = str;
        this.options = options;
        this.guess = guess;
    }

    @Override
    public int mark() {
        if (this.getAnswer() == this.guess) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public LockQuestion lock() {
        return this;
    }

    @Override
    public Question answer(int guess) {
        return new MCQ(str, options, ans, guess);
    }

    String getQuestion() {
        return this.str;
    }

    @Override
    public int getAnswer() {
        return (int) this.ans;
    }

    @Override
    public String toString() {

        ImList<String> numOptions = new ImList<String>();

        for (int i = 0; i < options.size(); i++) {
            numOptions = numOptions.add(String.format("%d:" + options.get(i), i + 1));
        }

        String printable = str + " ";

        for (String s : numOptions) {
            printable += "[" + s + "]";
        }

        String printGuess = "";

        if (guess == 0) {
            printGuess += "[ ? ]";
        } else {
            printGuess += "[ " + numOptions.get(guess - 1) + " ]";
        }

        return printable + "; Your answer: " + printGuess;
    }
}
