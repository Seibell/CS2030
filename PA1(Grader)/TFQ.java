import java.util.List;

class TFQ extends MCQ {

    private static final List<String> options = List.of("True", "False");

    TFQ(String str, String ans) {
        super(str, options, ans, 0);
    }

    TFQ(String str, int ans, int guess) {
        super(str, options, ans, guess);
    }

    TFQ answer(String guess) {
        if (guess.equals("True")) {
            return new TFQ(super.getQuestion(), super.getAnswer(), 1);
        } else {
            return new TFQ(super.getQuestion(), super.getAnswer(), 2);
        }
    }

    @Override
    public Question answer(int ans) {
        return new TFQ(super.getQuestion(), super.getAnswer(), ans);
    }
}
