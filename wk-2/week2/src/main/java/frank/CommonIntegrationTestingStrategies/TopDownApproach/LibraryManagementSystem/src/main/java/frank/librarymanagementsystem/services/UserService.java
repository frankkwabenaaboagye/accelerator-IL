package frank.librarymanagementsystem.services;

import frank.librarymanagementsystem.models.MyUser;
import frank.librarymanagementsystem.repository.MyUserRepository;
import frank.librarymanagementsystem.repository.StubUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    /*
    private final StubUserRepository userRepository = new StubUserRepository();

    public List<MyUser> getUsers() {
        return userRepository.findAll();
    }*/

    @Autowired
    private MyUserRepository userRepository;

    public List<MyUser> getUsers() {
        return userRepository.findAll();
    }
}