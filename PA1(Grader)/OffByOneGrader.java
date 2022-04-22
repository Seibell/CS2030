class OffByOneGrader extends Grader {
    
    OffByOneGrader(int ans) {
        super(ans);
    }

    int mark(int guess) {
        if (Math.abs(super.getAns() - guess) == 1) {
            return 1;
        } else if ((super.getAns() - guess) == 0) {
            return 2;
        } else {
            return 0;
        }
    }
}
