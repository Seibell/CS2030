class FillInBlank implements Question, LockQuestion {
    private final String str;
    private final int ans;
    private final int guess;
    private final Grader grader;
    
    FillInBlank(String str, Grader grader) {
        this.str = str;
        this.ans = -1;
        this.guess = 0;
        this.grader = grader;
    }

    FillInBlank(String str, int ans) {
        this.str = str;
        this.ans = ans;
        this.guess = 0;
        this.grader = new Grader(-1);
    }

    FillInBlank(String str, Grader grader, int ans, int guess) {
        this.str = str;
        this.ans = ans;
        this.guess = guess;
        this.grader = grader;
    }

    @Override
    public int mark() {
        if (this.ans == -1) {
            return grader.mark(this.guess);
        } else if (this.ans == this.guess) {
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
    public int getAnswer() {
        return this.ans;
    }

    @Override
    public Question answer(int guess) {
        return new FillInBlank(str, this.grader, ans, guess);
    }

    @Override
    public String toString() {
        return str + "; Your answer: " + guess;
    }
}
