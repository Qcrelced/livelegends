package livelegends.livelegendsbackend.core.configuration.Authent;

import livelegends.livelegendsbackend.core.common.profile.admin.AdminService;
import livelegends.livelegendsbackend.core.common.profile.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminAuthController {

    private final AdminService adminService;

    public AdminAuthController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return adminService.authenticate(loginRequest.getEmail(), loginRequest.getPassword())
                .map(admin -> ResponseEntity.ok("Connexion réussie : " + admin.getEmail()))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants invalides"));
    }
}
