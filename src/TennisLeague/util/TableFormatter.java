package TennisLeague.util;

import TennisLeague.model.Player;
import TennisLeague.model.Team;
import TennisLeague.model.Coach;
import java.util.List;

public class TableFormatter {

    public static void printPlayersTable(List<Player> players) {
        if (players.isEmpty()) {
            System.out.println("No players found.");
            return;
        }

        System.out.println();
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                    PLAYERS                                      │");
        System.out.println("├─────┬──────────────────────┬─────────────┬─────┬───────┬─────────────────────┤");
        System.out.println("│ ID  │       NAME           │  POSITION   │ AGE │ TEAM  │    PHONE NUMBER     │");
        System.out.println("├─────┼──────────────────────┼─────────────┼─────┼───────┼─────────────────────┤");

        for (Player player : players) {
            System.out.printf("│ %-3d │ %-20s │ %-11s │ %-3d │ %-5d │ %-19s │%n",
                    player.getPlayerId(),
                    truncate(player.getName(), 20),
                    truncate(player.getPosition(), 11),
                    player.getAge(),
                    player.getTeamId(),
                    truncate(player.getPhoneNumber(), 19));
        }

        System.out.println("└─────┴──────────────────────┴─────────────┴─────┴───────┴─────────────────────┘");
        System.out.printf("Total Players: %d%n%n", players.size());
    }

    public static void printTeamsTable(List<Team> teams) {
        if (teams.isEmpty()) {
            System.out.println("No teams found.");
            return;
        }

        System.out.println();
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                     TEAMS                                       │");
        System.out.println("├─────┬──────────────────────┬─────────────────────┬─────────────────────────────┤");
        System.out.println("│ ID  │        NAME          │        CITY         │           MANAGER           │");
        System.out.println("├─────┼──────────────────────┼─────────────────────┼─────────────────────────────┤");

        for (Team team : teams) {
            System.out.printf("│ %-3d │ %-20s │ %-19s │ %-27s │%n",
                    team.getId(),
                    truncate(team.getName(), 20),
                    truncate(team.getCity(), 19),
                    truncate(team.getManagerName(), 27));
        }

        System.out.println("└─────┴──────────────────────┴─────────────────────┴─────────────────────────────┘");
        System.out.printf("Total Teams: %d%n%n", teams.size());
    }

    public static void printCoachesTable(List<Coach> coaches) {
        if (coaches.isEmpty()) {
            System.out.println("No coaches found.");
            return;
        }

        System.out.println();
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                    COACHES                                      │");
        System.out.println("├─────┬──────────────────────┬─────────────────────┬─────────────────────────────┤");
        System.out.println("│ ID  │        NAME          │    PHONE NUMBER     │            TEAM             │");
        System.out.println("├─────┼──────────────────────┼─────────────────────┼─────────────────────────────┤");

        for (Coach coach : coaches) {
            System.out.printf("│ %-3d │ %-20s │ %-19s │ %-27d │%n",
                    coach.getCoachId(),
                    truncate(coach.getName(), 20),
                    truncate(coach.getTelephoneNumber(), 19),
                    coach.getTeamNumber());
        }

        System.out.println("└─────┴──────────────────────┴─────────────────────┴─────────────────────────────┘");
        System.out.printf("Total Coaches: %d%n%n", coaches.size());
    }

    private static String truncate(String text, int maxLength) {
        if (text == null)
            return "";
        if (text.length() <= maxLength)
            return text;
        return text.substring(0, maxLength - 3) + "...";
    }
}
