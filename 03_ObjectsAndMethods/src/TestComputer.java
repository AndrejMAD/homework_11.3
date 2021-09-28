public class TestComputer {
    public static void main(String[] args) {

        CPU cpu = new CPU("Intel", 3000, 4, 100);
        RAM ram = new RAM(RAMType.DDR4, 8, 50);
        Storage storage = new Storage(StorageType.SSD, 1000, 500);
        Monitor monitor = new Monitor(MonitorType.IPS, 21, 2000);
        Keyboard keyboard = new Keyboard(KeyboardType.USB, KeyboardBacklight.YES, 100);

        Computer pc = new Computer("PC", "Intel");
        pc.setCpu(cpu);
        pc.setRam(ram);
        pc.setStorage(storage);
        pc.setMonitor(monitor);
        pc.setKeyboard(keyboard);

        System.out.println(pc);
    }
}
