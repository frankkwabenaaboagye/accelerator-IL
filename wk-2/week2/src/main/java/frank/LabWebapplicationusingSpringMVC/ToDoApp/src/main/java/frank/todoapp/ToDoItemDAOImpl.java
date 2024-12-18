package frank.todoapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ToDoItemDAOImpl implements ToDoItemDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ToDoItem> findAll() {
        Query query = entityManager.createQuery("FROM ToDoItem");
        return query.getResultList();
    }

    @Transactional
    @Override
    public void addToDoItem(ToDoItem toDoItem) {
        entityManager.persist(toDoItem);
    }

    @Transactional
    @Override
    public void markAsComplete(Long id) {
        ToDoItem toDoItem = entityManager.find(ToDoItem.class, id);
        if (toDoItem != null) {
            toDoItem.setCompleted(true);
        }
    }
}