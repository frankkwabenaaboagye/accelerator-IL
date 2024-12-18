package frank.librarymanagementsystem.repository;

import frank.librarymanagementsystem.models.MyUser;

import java.util.ArrayList;
import java.util.List;

public class StubUserRepository {
    private List<MyUser> users = new ArrayList<>();

    public StubUserRepository() {
        users.add(new MyUser("1", "Alice", "alice@a.com"));
        users.add(new MyUser("2", "Bob", "bob@b.com"));
    }

    public List<MyUser> findAll() {
        return users;
    }
}