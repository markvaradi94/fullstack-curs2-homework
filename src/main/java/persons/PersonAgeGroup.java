package persons;

public enum PersonAgeGroup {
    YOUNG("1-30"),
    ADULT("30-50"),
    ELDER("50+");

    private final String ageGroup;

    PersonAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getAgeGroup() {
        return ageGroup;
    }
}
