package be.cafe_strange.enums;

public enum Weekday {

    MONDAY("MAANDAG"),
    THUESDAY("DINSDAG"),
    WEDNESDAY("WOENSDAG"),
    THURSDAY("DONDERDAG"),
    FRIDAY("VRIJDAG"),
    SATERDAY("ZATERDAG"),
    SUNDAY("ZONDAG");

    private String weekday;

    private Weekday(String weekday) {
        this.weekday = weekday;
    }

    public String getWeekday() {
        return weekday;
    }

}
