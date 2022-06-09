package DefiningClasses.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemonList;
    private List<Parent> parents;
    private List<Child> children;

    public Person(String name) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.name).append(System.lineSeparator());

        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(String.format("%s %s %.2f%n",
                    this.company.getName(), this.company.getDepartment(), this.company.getSalary()));
        }

        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(String.format("%s %d%n", this.car.getModel(), this.car.getSpeed()));
        }

        sb.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemonList) {
            sb.append(String.format("%s %s%n", pokemon.getName(), pokemon.getType()));
        }

        sb.append("Parents:").append(System.lineSeparator());
        for (Parent parent : parents) {
            sb.append(String.format("%s %s%n", parent.getName(), parent.getBirthday()));
        }

        sb.append("Children:").append(System.lineSeparator());
        for (Child child : children) {
            sb.append(String.format("%s %s%n", child.getName(), child.getBirthday()));
        }

        return sb.toString().trim();
    }
}
