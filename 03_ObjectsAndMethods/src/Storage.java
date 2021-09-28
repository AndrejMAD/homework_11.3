public class Storage {

    private final StorageType type;
    private final int volume;
    private final int mass;

    public Storage(StorageType type, int volume, int mass) {
        this.type = type;
        this.volume = volume;
        this.mass = mass;
    }

    public StorageType getType() {
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
