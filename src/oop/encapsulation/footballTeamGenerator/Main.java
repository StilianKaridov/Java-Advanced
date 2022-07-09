package oop.encapsulation.footballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Team> teams = new HashMap<>();

        String[] command = scanner.nextLine().split(";");

        while (!"END".equals(command[0])) {
            String teamName = command[1];
            try {
                switch (command[0]) {
                    case "Team":
                        Team team = new Team(teamName);
                        teams.put(teamName, team);
                        break;
                    case "Add":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            String playerName = command[2];
                            int endurance = Integer.parseInt(command[3]);
                            int sprint = Integer.parseInt(command[4]);
                            int dribble = Integer.parseInt(command[5]);
                            int passing = Integer.parseInt(command[6]);
                            int shooting = Integer.parseInt(command[7]);

                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);

                            teams.get(teamName).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        String playerName = command[2];
                        teams.get(teamName).removePlayer(playerName);
                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            long rating = Math.round(teams.get(teamName).getRating());
                            System.out.println(teamName + " - " + rating);
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine().split(";");
        }
    }
}