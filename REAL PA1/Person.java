class Person {

    private final String id;
    private final String vacStatus;
    private final int healthRiskScore;

    Person(String id, String vacStatus, int healthRiskScore) {
        this.id = id;
        this.vacStatus = vacStatus;
        this.healthRiskScore = healthRiskScore;
    }

    boolean isVaccinated() {
        int count = 0;

        for (int i = 0; i < vacStatus.length(); i++) {
            count++;
        }

        if (count >= 2) {
            return true;
        } else { 
            return false;
        }
    }

    boolean isHighRisk() {
        return healthRiskScore >= 8;
    }

    @Override
    public String toString() {

        String riskStatus = "";

        if (this.isHighRisk()) {
            riskStatus += "^";
        } else {
            riskStatus += "v";
        }
        return String.format("%s/%s/%s", this.id, this.vacStatus, riskStatus);
    }
}
