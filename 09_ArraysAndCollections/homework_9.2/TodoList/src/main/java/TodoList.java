import java.util.ArrayList;

public class TodoList {

    private final ArrayList<String> list = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        add(-1, todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index >= 0 && index < list.size()) {
            list.add(index, todo);
            System.out.println("Добавлено дело \"" + todo + "\" на позицию " + index);
        } else {
            list.add(todo);
            System.out.println("Добавлено дело \"" + todo + "\" в конец списка");
        }
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index >= 0 && index < list.size()) {
            String oldTodo = list.get(index);
            list.remove(index);
            list.add(index, todo);
            System.out.println("Дело \"" + oldTodo + "\" заменено на \"" + todo + "\"");
        } else {
            System.out.println("Дело с таким индексом не существует");
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index >= 0 && index < list.size()) {
            System.out.println("Дело \"" + list.get(index) + "\" удалено");
            list.remove(index);
        } else {
            System.out.println("Дело с таким индексом не существует");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return list;
    }
}