package oop.encapsulation.footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String nameOfThePlayer) {
        if (!players.removeIf(p -> p.getName().equals(nameOfThePlayer))) {
            throw new IllegalArgumentException("Player " + nameOfThePlayer + " is not in " + name + " team.");
        }
    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).sum() / players.size();
    }
}