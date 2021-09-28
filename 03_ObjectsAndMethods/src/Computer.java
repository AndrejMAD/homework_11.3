public class Computer {

    private final String name;
    private final String vendor;
    private CPU cpu;
    private RAM ram;
    private Storage storage;
    private Monitor monitor;
    private Keyboard keyboard;

    public Computer(String name, String vendor) {
        this.name = name;
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public int getMass() {
        return cpu.getMass() + ram.getMass() + storage.getMass() + monitor.getMass() + keyboard.getMass();
    }

    @Override
    public String toString() {
        return "Компьютер" + "\n" +
                "Имя: " + name + "\n" +
                "Производитель: " + vendor + "\n" +
                "ЦПУ: " + cpu + "\n" +
                "ОЗУ: " + ram + "\n" +
                "Хранилище: " + storage + "\n" +
                "Монитор: " + monitor + "\n" +
                "Клавиатура: " + keyboard + "\n" +
                "Вес: " + getMass() + "г";
    }
}
