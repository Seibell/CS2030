class Assessment implements Keyable {

    private final String lab;
    private final String grade;

    Assessment(String lab, String grade) {
        this.lab = lab;
        this.grade = grade;
    }

    public String getGrade() {
        return this.grade;
    }

    @Override
    public String getKey() {
        return this.lab;
    }

    @Override
    public String toString() {
        return String.format("{%s: %s}", this.lab, this.grade);
    }
}
