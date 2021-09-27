public class Elevator {

    // Текщий этаж
    private int currentFloor;
    // Мин. этаж
    private int minFloor;
    // Макс. этаж
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.currentFloor = 1;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        System.out.println("Введите значение этажа в диапазоне от " + minFloor + " до " + maxFloor + ".");
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor--;
    }

    public void moveUp() {
        currentFloor++;
    }

    public void move(int floor) {

        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Вы ввели не верное значение этажа!!! Введите значение этажа в диапазоне от " + minFloor + " до " + maxFloor + ".");
            return;
        }

        if (floor == currentFloor) {
            return;
        }

        if (floor > currentFloor) {
            while (currentFloor < floor) {
                moveUp();
                System.out.println("Текущий этаж: " + currentFloor);
            }
            return;
        }

        if (floor < currentFloor) {
            while (currentFloor > floor) {
                moveDown();
                System.out.println("Текущий этаж: " + currentFloor);
            }
            return;
        }
    }
}
