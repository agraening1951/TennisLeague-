package TennisLeague.model;

public class Team {
    private int id;
    private String name;
    private String city;
    private String managerName;

    // No-arg constructor
    public Team() { }

    // All-args constructor
    public Team(int id, String name, String city, String managerName) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.managerName = managerName;
    }

    // Getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return String.format(
                "Team{id=%d, name='%s', city='%s', manager='%s'}",
                id, name, city, managerName
        );
    }
}