package TennisLeague;

import TennisLeague.dao.CoachDao;
import TennisLeague.dao.JdbcCoachDao;
import TennisLeague.model.Coach;

import java.util.List;
import java.util.Scanner;

public class CoachMain {
    private static final Scanner in = new Scanner(System.in);
    private static final CoachDao coachDao;

    static {
        CoachDao temp = null;
        try {
            temp = new JdbcCoachDao(TennisLeague.DB.DBConnection.getConnection());
        } catch (Exception e) {
            System.err.println("Failed to connect to DB: " + e.getMessage());
            System.exit(1);
        }
        coachDao = temp;
    }

    public static void main(String[] args) {
        System.out.println("=== Coach Manager ===");
        boolean running = true;
        while (running) {
            printCoachMenu();
            System.out.print("Choose an option: ");
            String choice = in.nextLine().trim();
            switch (choice) {
                case "1" -> listCoaches();
                case "2" -> addCoach();
                case "3" -> editCoach();
                case "4" -> deleteCoach();
                case "5" -> running = false;
                default  -> System.out.println("Invalid choice.");
            }
            System.out.println();
        }
        System.out.println("Goodbye!");
    }

    private static void printCoachMenu() {
        System.out.println("""
            === Coach Menu ===
            1) List Coaches
            2) Add Coach
            3) Edit Coach
            4) Delete Coach
            5) Exit
        """);
    }

    private static void listCoaches() {
        try {
            List<Coach> coaches = coachDao.findAll();
            if (coaches.isEmpty()) {
                System.out.println("No coaches found.");
            } else {
                System.out.println("Coaches:");
                for (Coach c : coaches) {
                    System.out.println("  " + c);
                }
            }
        } catch (Exception e) {
            System.err.println("Error listing coaches: " + e.getMessage());
        }
    }

    private static void addCoach() {
        try {
            System.out.print("Enter CoachID (int): ");
            int id = Integer.parseInt(in.nextLine().trim());
            System.out.print("Enter Name: ");
            String name = in.nextLine().trim();
            System.out.print("Enter TelephoneNumber: ");
            String phone = in.nextLine().trim();
            System.out.print("Enter TeamNumber (int): ");
            int teamId = Integer.parseInt(in.nextLine().trim());

            Coach c = new Coach(id, name, phone, teamId);
            coachDao.addCoach(c);
            System.out.println("Added: " + c);
        } catch (Exception e) {
            System.err.println("Error adding coach: " + e.getMessage());
        }
    }

    private static void editCoach() {
        try {
            System.out.print("Enter CoachID to edit: ");
            int id = Integer.parseInt(in.nextLine().trim());
            Coach c = coachDao.findById(id);
            if (c == null) {
                System.out.println("No coach with ID " + id);
                return;
            }

            System.out.println("Current: " + c);

            System.out.print("New Name [" + c.getName() + "]: ");
            String name = in.nextLine().trim();
            if (!name.isBlank()) c.setName(name);

            System.out.print("New Phone [" + c.getTelephoneNumber() + "]: ");
            String phone = in.nextLine().trim();
            if (!phone.isBlank()) c.setTelephoneNumber(phone);

            System.out.print("New TeamNumber [" + c.getTeamNumber() + "]: ");
            String team = in.nextLine().trim();
            if (!team.isBlank()) c.setTeamNumber(Integer.parseInt(team));

            coachDao.updateCoach(c);
            System.out.println("Updated: " + c);
        } catch (Exception e) {
            System.err.println("Error editing coach: " + e.getMessage());
        }
    }

    private static void deleteCoach() {
        try {
            System.out.print("Enter CoachID to delete: ");
            int id = Integer.parseInt(in.nextLine().trim());
            coachDao.deleteCoach(id);
            System.out.println("Deleted coach " + id);
        } catch (Exception e) {
            System.err.println("Error deleting coach: " + e.getMessage());
        }
    }
}