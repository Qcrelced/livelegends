package livelegends.livelegendsbackend.webapi.common.profile.user;

import livelegends.livelegendsbackend.core.common.profile.user.User;
import livelegends.livelegendsbackend.core.common.profile.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @GetMapping(value = "/user/{id}")
    public User getAdmin(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user;
    }
}
