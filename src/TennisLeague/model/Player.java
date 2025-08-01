package TennisLeague.model;

public class Player {
    private int playerId;
    private String name;
    private String position;
    private int age;
    private int teamId;
    private String phoneNumber;

    // No-arg constructor
    public Player() {
    }

    // All-args constructor
    public Player(int playerId, String name, String position, int age, int teamId, String phoneNumber) {
        this.playerId = playerId;
        this.name = name;
        this.position = position;
        this.age = age;
        this.teamId = teamId;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", teamId=" + teamId +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
