class ART implements Test {
    private final String result;

    ART(String result) {
        this.result = result;
    }

    @Override
    public boolean isValid() {
        if (result.equals("T")) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isPositive() {
        if (result.equals("CT")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String s = "A";

        if (this.isValid()) {
            if (this.isPositive()) {
                s += "+";
            } else {
                s += "-";
            }
        } else {
            s += "X";
        }

        return s;
    }
}
