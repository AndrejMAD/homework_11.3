import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.*;

public class Main {

    private static final TodoList todoList = new TodoList();
    private static final String split = "\\s";
    private static final String commandsInfo = "Наберите команду: LIST, ADD, EDIT, DELETE";
    private static final String addCommandInfo = "Введите команду в формате: ADD index \"todo\", если index не задан, то дело будет добавлено в конец списка";
    private static final String editCommandInfo = "Введите команду в формате: EDIT index \"todo\"";
    private static final String deleteCommandInfo = "Введите команду в формате: DELETE index";

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        Scanner scanner = new Scanner(System.in);

        System.out.println(commandsInfo);
        while (true) {
            String input = scanner.nextLine();
            String[] commands = input.split(split);

            if (input.equals("0")) {
                break;
            }
            if (commands[0].equals("LIST")) {
                ArrayList<String> todos = todoList.getTodos();
                if (todos.size() == 0) {
                    System.out.println("Список дел пуст");
                }
                for (int i = 0; i < todos.size(); i++) {
                    System.out.println(i + " - " + todos.get(i));
                }
                continue;
            }
            if (commands[0].equals("ADD")) {
                String todo;
                int index = -1;

                if (commands.length < 2) {
                    System.out.println(addCommandInfo);
                    continue;
                }

                if (commands[1].matches("[0-9]+")) {
                    index = parseInt(commands[1]);
                    int startTodo = input.indexOf(commands[1]) + commands[1].length();
                    todo = input.substring(startTodo).trim();
                } else {
                    int startTodo = input.indexOf(commands[0]) + commands[0].length();
                    todo = input.substring(startTodo).trim();
                }

                if (todo.isEmpty()) {
                    System.out.println(addCommandInfo);
                    continue;
                }

                if (index > -1) {
                    todoList.add(index, todo);
                } else {
                    todoList.add(todo);
                }

                continue;
            }
            if (commands[0].equals("EDIT")) {
                if (commands.length < 3) {
                    System.out.println(editCommandInfo);
                    continue;
                }
                if (!commands[1].matches("[0-9]+")) {
                    System.out.println(editCommandInfo);
                    continue;
                }

                int index = parseInt(commands[1]);
                int startTodo = input.indexOf(commands[1]) + commands[1].length();
                String todo = input.substring(startTodo).trim();

                if (todo.isEmpty()) {
                    System.out.println(editCommandInfo);
                    continue;
                }

                todoList.edit(todo, index);

                continue;
            }
            if (commands[0].equals("DELETE")) {
                if (commands.length != 2) {
                    System.out.println(deleteCommandInfo);
                    continue;
                }
                if (!commands[1].matches("[0-9]+")) {
                    System.out.println(deleteCommandInfo);
                    continue;
                }

                int index = parseInt(commands[1]);
                todoList.delete(index);

                continue;
            }
            System.out.println(commandsInfo);
        }
    }
}
