package frank.librarymanagementsystem.controllers;

import frank.librarymanagementsystem.models.MyUser;
import frank.librarymanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class MyUserController {

    private final UserService userService;

    @GetMapping("/list")
    public List<MyUser> listUsers() {
        return userService.getUsers();
    }
}