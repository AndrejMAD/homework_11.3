public class Printer {

    private String queue;
    private int pendingPagesCount;
    private int printedPagesCount;
    private static int allPrintersPagesCount = 0;

    public Printer() {
        clear();
    }

    public void appand(String text) {
        appand(text, "Документ");
    }

    public void appand(String text, String name) {
        appand(text, name, 1);
    }

    public void appand(String text, String name, int pagesCount) {
        pendingPagesCount += pagesCount;

        queue += "\n" + "Имя документа: " + name + "\n" + text + "\n" + "Количество страниц: " + pagesCount + " шт.";
    }

    public int getPendingPagesCount() {
        return pendingPagesCount;
    }

    public int getPrintedPagesCount() {
        return  printedPagesCount;
    }

    public static int getAllPrintersPagesCount() {
        return allPrintersPagesCount;
    }

    public void clear() {
        queue = "";
        pendingPagesCount = 0;
    }

    public void print() {
        System.out.println(queue);
        printedPagesCount += pendingPagesCount;
        clear();
    }

    public void printSystemInfo() {
        System.out.println("Страниц в очереди: " + pendingPagesCount + ", Страниц распечатано: " + printedPagesCount);
    }
}
