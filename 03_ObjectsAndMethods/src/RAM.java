public class RAM {

    private final RAMType type;
    private final int volume;
    private final int mass;

    public RAM(RAMType type, int volume, int mass) {
        this.type = type;
        this.volume = volume;
        this.mass = mass;
    }

    public RAMType getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public int getMass() {
        return mass;
    }

    @Override
    public String toString() {
        return type + ", " + volume + "Гб, " + mass + "г";
    }
}
