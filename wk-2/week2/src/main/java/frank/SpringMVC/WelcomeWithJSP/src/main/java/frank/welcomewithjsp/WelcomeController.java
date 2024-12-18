package frank.welcomewithjsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC with JSP!");
        return "welcome";
    }

    @PostMapping("/")
    public String handleFormSubmission(@RequestParam("name") String userName, Model model) {
        // Add the user's name to the model
        model.addAttribute("userName", userName);

        // Redirect to the greeting page
        return "greeting";
    }
}