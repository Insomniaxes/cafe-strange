package be.cafe_strange.enums;

public enum Gender {

    MALE("MALE"),
    FEMALE("FEMALE"),
    GENDERFLUID("GENDER FLUID");

    private String gender;

    private Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
