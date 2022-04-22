class PCR implements Test {
    private final String result;

    PCR(String result) {
        this.result = result;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean isPositive() {
        return result.equals("alpha") ||
            result.equals("beta") ||
            result.equals("delta") ||
            result.equals("omicron");
    }

    @Override
    public String toString() {
        String s = "P";

        if (this.isPositive()) {
            s += "+";
        } else {            
            s += "-";
        }
        return s;
    }
}
