package TennisLeague.main;
import TennisLeague.DB.DBConnection;
import TennisLeague.dao.TeamDao;
import TennisLeague.dao.CoachDao;
import TennisLeague.dao.JdbcTeamDao;
import TennisLeague.dao.JdbcCoachDao;
import TennisLeague.model.Team;
import TennisLeague.model.Coach;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            TeamDao teamDao = new JdbcTeamDao(connection);
            CoachDao coachDao = new JdbcCoachDao(connection);

            int choice;
            do {
                System.out.println("\n=== Tennis League Management ===");
                System.out.println("1. View all teams");
                System.out.println("2. Add a team");
                System.out.println("3. Update a team");
                System.out.println("4. Delete a team");
                System.out.println("5. View all coaches");
                System.out.println("6. Add a coach");
                System.out.println("7. Update a coach");
                System.out.println("8. Delete a coach");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        List<Team> teams = teamDao.getAllTeams();
                        for (Team team : teams) {
                            System.out.println(team);
                        }
                        break;
                    case 2:
                        System.out.print("Enter team number: ");
                        int tNum = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter team name: ");
                        String tName = scanner.nextLine();
                        System.out.print("Enter city: ");
                        String tCity = scanner.nextLine();
                        System.out.print("Enter manager name: ");
                        String tManager = scanner.nextLine();
                        teamDao.addTeam(new Team(tNum, tName, tCity, tManager));
                        System.out.println("Team added.");
                        break;
                    case 3:
                        System.out.print("Enter team number to update: ");
                        int tUpdateNum = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new name: ");
                        String tUpdateName = scanner.nextLine();
                        System.out.print("Enter new city: ");
                        String tUpdateCity = scanner.nextLine();
                        System.out.print("Enter new manager name: ");
                        String tUpdateManager = scanner.nextLine();
                        teamDao.updateTeam(new Team(tUpdateNum, tUpdateName, tUpdateCity, tUpdateManager));
                        System.out.println("Team updated.");
                        break;
                    case 4:
                        System.out.print("Enter team number to delete: ");
                        int tDeleteNum = Integer.parseInt(scanner.nextLine());
                        teamDao.deleteTeam(tDeleteNum);
                        System.out.println("Team deleted.");
                        break;
                    case 5:
                        List<Coach> coaches = coachDao.findAll();
                        for (Coach coach : coaches) {
                            System.out.println(coach);
                        }
                        break;
                    case 6:
                        System.out.print("Enter coach ID: ");
                        int cID = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter coach name: ");
                        String cName = scanner.nextLine();
                        System.out.print("Enter phone: ");
                        String cPhone = scanner.nextLine();
                        System.out.print("Enter team number: ");
                        int cTeamNum = Integer.parseInt(scanner.nextLine());
                        coachDao.addCoach(new Coach(cID, cName, cPhone, cTeamNum));
                        System.out.println("Coach added.");
                        break;
                    case 7:
                        System.out.print("Enter coach ID to update: ");
                        int cUpdateID = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new name: ");
                        String cUpdateName = scanner.nextLine();
                        System.out.print("Enter new phone: ");
                        String cUpdatePhone = scanner.nextLine();
                        System.out.print("Enter new team number: ");
                        int cUpdateTeam = Integer.parseInt(scanner.nextLine());
                        coachDao.updateCoach(new Coach(cUpdateID, cUpdateName, cUpdatePhone, cUpdateTeam));
                        System.out.println("Coach updated.");
                        break;
                    case 8:
                        System.out.print("Enter coach ID to delete: ");
                        int cDeleteID = Integer.parseInt(scanner.nextLine());
                        coachDao.deleteCoach(cDeleteID);
                        System.out.println("Coach deleted.");
                        break;
                    case 0:
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } while (choice != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}