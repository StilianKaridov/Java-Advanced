package oop.examPreparation.august_14th_2022.football.entities.field;

import oop.examPreparation.august_14th_2022.football.entities.player.Player;
import oop.examPreparation.august_14th_2022.football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static oop.examPreparation.august_14th_2022.football.common.ConstantMessages.*;
import static oop.examPreparation.august_14th_2022.football.common.ExceptionMessages.*;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int sumEnergy() {
        return this.supplements.stream()
                .mapToInt(Supplement::getEnergy)
                .sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.players.size() == this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }

        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        this.players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        String playerOutput = players.isEmpty()
                ? "none"
                : players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(" "));


        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):%n", this.name, this.getClass().getSimpleName()));
        sb.append(String.format("Player: %s%n", playerOutput));
        sb.append(String.format("Supplement: %d%n", this.supplements.size()));
        sb.append(String.format("Energy: %d", sumEnergy()));

        return sb.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplement() {
        return supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
