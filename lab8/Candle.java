class Candle implements Thing {
    private final int num;
    private final String state;
    private final Action action;

    Candle() {
        this.num = 0;
        this.state = "Candle flickers.";
        this.action = new Action(0);
    }

    Candle(int num, int numState) {
        this.num = num;

        if (num == 0) {
            this.state = "Candle flickers.";
        } else if (num == 1) {
            this.state = "Candle is getting shorter.";
        } else if (num == 2) {
            this.state = "Candle is about to burn out.";
        } else {
            this.state = "Candle has burned out.";
        }
        this.action = new Action(numState);
    }

    public String identify() {
        return "Candle";
    }

    public String getState() {
        return this.state;
    }

    @Override
    public Candle tick() {
        int n = this.num;
        return new Candle(n + 1, this.action.getNumState());
    }

    public Action getAction() {
        return this.action;
    }

    public int getNum() {
        return this.num;
    }

    public Thing setNumState(int numState) {
        return new Candle(this.num, numState);
    }

    @Override
    public String toString() {
        return String.format("%s", this.state);
    }
}
