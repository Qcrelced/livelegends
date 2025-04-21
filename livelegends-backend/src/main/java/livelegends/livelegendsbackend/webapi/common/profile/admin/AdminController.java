package livelegends.livelegendsbackend.webapi.common.profile.admin;

import livelegends.livelegendsbackend.core.common.profile.admin.Admin;
import livelegends.livelegendsbackend.core.common.profile.admin.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static livelegends.livelegendsbackend.webapi.common.WebApiConstants.ADMIN_ROOT_PATH;

@RestController
@RequestMapping( ADMIN_ROOT_PATH + "/profile")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admins")
    public List<AdminDto> getAdmins() {
        List<AdminDto> admins = adminService.getAllAdmins();
        return admins;
    }

    @GetMapping("/admin/{id}")
    public Admin getAdmin(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        return admin;
    }

    @PostMapping("/admin")
    public void createAdmin(@RequestBody Admin admin) {
        //TODO
    }
}
