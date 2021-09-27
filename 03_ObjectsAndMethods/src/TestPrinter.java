public class TestPrinter {

    public static void main(String[] args) {

        Printer printer = new Printer();

        printer.appand("text1");
        printer.appand("text2", "doc2");
        printer.appand("text3", "doc3", 5);

        printer.printSystemInfo();
        printer.print();
        printer.printSystemInfo();
    }
}
