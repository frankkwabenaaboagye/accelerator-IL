package frank.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoAppApplication implements CommandLineRunner {

	@Autowired
	private ToDoItemRepository toDoItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Populating...");
		populateDatabase();
		System.out.println("done");

	}

	// Method to populate the database with initial data
	public void populateDatabase() {
		// Create sample ToDoItems
		ToDoItem item1 = new ToDoItem();
		item1.setTitle("Complete Spring Boot project");
		item1.setCompleted(false);

		ToDoItem item2 = new ToDoItem();
		item2.setTitle("Buy groceries");
		item2.setCompleted(false);

		ToDoItem item3 = new ToDoItem();
		item3.setTitle("Read a book");
		item3.setCompleted(true);

		// Save ToDoItems to the database
		toDoItemRepository.save(item1);
		toDoItemRepository.save(item2);
		toDoItemRepository.save(item3);
	}
}
