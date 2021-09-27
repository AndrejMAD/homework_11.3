public class DeliveryOrder {

    private final Dimensions dimensions;
    private final int weight;
    private final String address;
    private final boolean notUpend;
    private final String regNumber;
    private final boolean delicate;

    public DeliveryOrder(Dimensions dimensions, int weight, String address, boolean notUpend, String regNumber, boolean delicate) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.address = address;
        this.notUpend = notUpend;
        this.regNumber = regNumber;
        this.delicate = delicate;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public DeliveryOrder setDimensions(Dimensions dimensions) {
        return new DeliveryOrder(dimensions, weight, address, notUpend, regNumber, delicate);
    }

    public int getWeight() {
        return weight;
    }

    public DeliveryOrder setWeight(int weight) {
        return new DeliveryOrder(dimensions, weight, address, notUpend, regNumber, delicate);
    }

    public String getAddress() {
        return address;
    }

    public DeliveryOrder setAddress(String address) {
        return new DeliveryOrder(dimensions, weight, address, notUpend, regNumber, delicate);
    }

    public boolean isNotUpend() {
        return notUpend;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public boolean isDelicate() {
        return delicate;
    }
}
