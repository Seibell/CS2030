class Sword implements Thing {
    private final int num;
    private final String state;
    private final Action action;

    Sword() {
        this.num = 0;
        this.state = "Sword is shimmering.";
        this.action = new Action(0);
    }

    Sword(int num, int numState) {
        this.num = num;
        this.state = "Sword is shimmering.";
        this.action = new Action(numState);
    }

    public String getState() {
        return this.state;
    }

    public String identify() {
        return "Sword";
    }

    public Thing tick() {
        int n = this.num;

        return new Sword(n + 1, this.action.getNumState());
    }

    public int getNum() {
        return this.num;
    }

    public Action getAction() {
        return this.action;
    }

    public Thing setNumState(int numState) {
        return new Sword(this.num, numState);
    }

    @Override
    public String toString() {
        return String.format("%s", this.state);
    }
}
