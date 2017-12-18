package cafe_strange.enums;

public enum  Role {

    OWNER("OWNER"), ADMIN("ADMIN"), MEMBER("MEMBER");

    private String role;

    private Role(String role) {
        this.role = role;
    }

    public String getWeekday() {
        return role;
    }

}
