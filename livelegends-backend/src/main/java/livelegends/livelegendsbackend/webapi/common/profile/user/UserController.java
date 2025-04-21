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

    public UserController(UserService adminService) {
        this.userService = adminService;
    }

    @GetMapping(value = "/users")
    public List<User> getAdmins() {
        List<User> admins = userService.getAllUsers();
        return admins;
    }

    @GetMapping(value = "/user/{id}")
    public User getAdmin(@PathVariable Long id) {
        User admin = userService.getUserById(id);
        return admin;
    }
}
