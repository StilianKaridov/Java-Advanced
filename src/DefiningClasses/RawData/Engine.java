package DefiningClasses.RawData;

public class Engine {
    private int speed;
    private int power;

    public Engine(int engineSpeed, int enginePower) {
        this.speed = engineSpeed;
        this.power = enginePower;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
