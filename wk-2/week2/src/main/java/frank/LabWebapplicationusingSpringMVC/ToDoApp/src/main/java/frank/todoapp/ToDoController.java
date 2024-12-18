package frank.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoController {

    @Autowired
    private ToDoItemDAO toDoItemDAO;

    @GetMapping("/todos")
    public String getToDoList(Model model) {
        model.addAttribute("todos", toDoItemDAO.findAll());
        return "todos"; // JSP view
    }

    @PostMapping("/todo/add")
    public String addToDoItem(ToDoItem toDoItem) {
        toDoItemDAO.addToDoItem(toDoItem);
        return "redirect:/todos";
    }

    @GetMapping("/todo/complete/{id}")
    public String markAsComplete(@PathVariable Long id) {
        toDoItemDAO.markAsComplete(id);
        return "redirect:/todos";
    }
}