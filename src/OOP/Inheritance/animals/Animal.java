package OOP.Inheritance.animals;

public class Animal {
    protected String name;
    protected int age;
    protected String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if(gender == null || gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String produceSound() {
        return "";
    }

    @Override
    public String toString() {
        return String.format("%s%n" +
                        "%s %d %s%n" +
                        "%s", this.getClass().getSimpleName(),
                name, age, gender,
                produceSound());
    }
}
