package frank.todoapp;

import java.util.List;

public interface ToDoItemDAO {
    List<ToDoItem> findAll();
    void addToDoItem(ToDoItem toDoItem);
    void markAsComplete(Long id);
}