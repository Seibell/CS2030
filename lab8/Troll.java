class Troll implements Thing {
    private final int num;
    private final String state;
    private final Action action;

    private static final int THREE = 3;

    Troll() {
        this.num = 0;
        this.state = "Troll lurks in the shadows.";
        this.action = new Action(0);
    }

    Troll(int num, int numState) {
        this.num = num;

        if (num == 0) {
            this.state = "Troll lurks in the shadows.";
        } else if (num == 1) {
            this.state = "Troll is getting hungry.";
        } else if (num == 2) {
            this.state = "Troll is VERY hungry.";
        } else if (num == THREE) {
            this.state = "Troll is SUPER HUNGRY and is about to ATTACK!";
        } else {
            this.state = "Troll attacks!";
        }
        this.action = new Action(numState);
    }
    
    public String getState() {
        return this.state;
    }

    public Thing tick() {
        int n = this.num;

        return new Troll(n + 1, this.action.getNumState());
    }

    public String identify() {
        return "Troll";
    }

    public Action getAction() {
        return this.action;
    }

    public int getNum() {
        return this.num;
    }

    public Thing setNumState(int numState) {
        return new Troll(this.num, numState);
    }

    @Override
    public String toString() {
        return String.format("%s", this.state);
    }
}
