package TennisLeague.model;

public class Coach {
    private int coachId;
    private String name;
    private String telephoneNumber;
    private int teamNumber;

    // No-arg constructor
    public Coach() {
    }

    // All-args constructor
    public Coach(int coachId, String name, String telephoneNumber, int teamNumber) {
        this.coachId = coachId;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.teamNumber = teamNumber;
    }

    // Getters and Setters
    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

// display coach info
    @Override
    public String toString() {
        return "Coach{" +
                "coachId=" + coachId +
                ", name='" + name + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", teamNumber=" + teamNumber +
                '}';
    }
}