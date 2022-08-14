package oop.examPreparation.august_14th_2022.unitTesting.test.java.football;

import oop.examPreparation.august_14th_2022.unitTesting.main.java.football.FootballTeam;
import oop.examPreparation.august_14th_2022.unitTesting.main.java.football.Footballer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class FootballTeamTests {

    private static final String footballClubName = "Barca";

    private List<Footballer> footballers;
    private FootballTeam footballTeam;

    @Before
    public void setUp() {
        footballTeam = new FootballTeam(footballClubName, 2);
        this.footballers = getFootballers();
    }

    private List<Footballer> getFootballers() {
        List<Footballer> toReturn = new ArrayList<>();

        for (int i = 0; i < footballTeam.getVacantPositions(); i++) {
            toReturn.add(new Footballer("player_" + i));
        }

        return toReturn;
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateFootballTeam_WithNullName_ShouldThrow() {
        FootballTeam footballTeam = new FootballTeam(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateFootballTeam_WithEmptyName_ShouldThrow() {
        FootballTeam footballTeam = new FootballTeam("    ", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateFootballTeam_WithNegativeNumber_VacantPositions_ShouldThrow() {
        FootballTeam footballTeam = new FootballTeam("Real", -2);
    }

    @Test
    public void test_CreateFootballTeam_Successfully_WithEmptyCollection() {
        int expectedCount = 0;
        int actualCount = footballTeam.getCount();

        String actualName = footballTeam.getName();

        assertEquals(expectedCount, actualCount);
        assertEquals(footballClubName, actualName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddFootballer_NoCapacity_ShouldThrow() {
        Footballer footballer = new Footballer("Ivan");

        footballTeam.addFootballer(footballers.get(0));
        footballTeam.addFootballer(footballers.get(1));
        footballTeam.addFootballer(footballer);
    }

    @Test
    public void test_AddFootballer_Successfully() {
        footballTeam.addFootballer(footballers.get(0));
        footballTeam.addFootballer(footballers.get(1));

        int expectedCount = 2;
        int actualCount = footballTeam.getCount();

        assertEquals(expectedCount, actualCount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveFootballer_WithInvalidName_ShouldThrow() {
        footballTeam.addFootballer(footballers.get(0));
        footballTeam.addFootballer(footballers.get(1));

        footballTeam.removeFootballer("invalid_name");
    }

    @Test
    public void test_RemoveFootballer_Successfully() {
        footballTeam.addFootballer(footballers.get(0));
        footballTeam.addFootballer(footballers.get(1));

        int expectedCountBeforeRemove = 2;
        int actualCountBeforeRemove = footballTeam.getCount();

        assertEquals(expectedCountBeforeRemove, actualCountBeforeRemove);

        footballTeam.removeFootballer("player_0");

        int expectedCountAfterRemove = 1;
        int actualCountAfterRemove = footballTeam.getCount();

        assertEquals(expectedCountAfterRemove, actualCountAfterRemove);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FootballerForSale_WithInvalidName_ShouldThrow() {
        footballTeam.addFootballer(footballers.get(0));
        footballTeam.addFootballer(footballers.get(1));

        footballTeam.footballerForSale("invalid_name");
    }

    @Test
    public void test_FootballerForSale_Successfully_ShouldSetActive_ToFalse() {
        footballTeam.addFootballer(footballers.get(0));
        footballTeam.addFootballer(footballers.get(1));

        Footballer footballer = footballTeam.footballerForSale("player_0");

        assertFalse(footballer.isActive());
    }

    @Test
    public void test_GetStatistics_Successfully() {
        footballTeam.addFootballer(footballers.get(0));
        footballTeam.addFootballer(footballers.get(1));

        String expected = "The footballer player_0, player_1 is in the team Barca.";

        String actual = footballTeam.getStatistics();

        assertEquals(expected, actual);
    }
}
