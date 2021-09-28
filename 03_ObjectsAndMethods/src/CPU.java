public class CPU {

    private final String vendor;
    private final double frequency;
    private final int coreCount;
    private final int mass;

    public CPU(String vendor, double frequency, int coreCount, int mass) {
        this.vendor = vendor;
        this.frequency = frequency;
        this.coreCount = coreCount;
        this.mass = mass;
    }

    public String getVendor() {
        return vendor;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public int getMass() {
        return mass;
    }

    @Override
    public String toString() {
        return vendor + ", " + frequency + "МГц, "  + coreCount + " ядра, " + mass + "г";
    }
}
