package livelegends.livelegendsbackend.core.common.profile.user;

import livelegends.livelegendsbackend.core.common.profile.admin.AdminRole;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasAnyRole('"+ AdminRole.ADMIN +"')")
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @PreAuthorize("hasAnyRole('"+ AdminRole.ADMIN +"')")
    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }
}
