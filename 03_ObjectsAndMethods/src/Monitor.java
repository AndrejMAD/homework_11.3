public class Monitor {

    private final MonitorType type;
    private final double diagonal;
    private final int mass;

    public Monitor(MonitorType type, double diagonal, int mass) {
        this.type = type;
        this.diagonal = diagonal;
        this.mass = mass;
    }

    public MonitorType getType() {
        return type;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public int getMass() {
        return mass;
    }

    @Override
    public String toString() {
        return type + ", " + diagonal + ", " + mass + "г";
    }
}
