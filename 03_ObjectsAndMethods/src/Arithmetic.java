public class Arithmetic {

    private int a;
    private int b;

    public Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {
        return a + b;
    }

    public int multiply() {
        return a * b;
    }

    public int max() {
        if (a > b) {
            return  a;
        } else if (a < b) {
            return b;
        }
        System.out.println("Числа равны");
        return 0;
    }

    public int min() {
        if (a > b) {
            return  b;
        } else if (a < b) {
            return a;
        }
        System.out.println("Числа равны");
        return 0;
    }
}
