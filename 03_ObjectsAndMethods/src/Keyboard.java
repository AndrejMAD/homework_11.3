public class Keyboard {

    private final KeyboardType type;
    private final KeyboardBacklight backlight;
    private final int mass;

    public Keyboard(KeyboardType type, KeyboardBacklight backlight, int mass) {
        this.type = type;
        this.backlight = backlight;
        this.mass = mass;
    }

    public KeyboardType getType() {
        return type;
    }

    public KeyboardBacklight getBacklight() {
        return backlight;
    }

    public int getMass() {
        return mass;
    }

    @Override
    public String toString() {
        return type + ", подсветка: " + backlight + ", " + mass + "г";
    }
}
