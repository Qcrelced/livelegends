package livelegends.livelegendsbackend.core.common.profile.admin;

import livelegends.livelegendsbackend.webapi.common.profile.admin.AdminConverter;
import livelegends.livelegendsbackend.webapi.common.profile.admin.AdminDto;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PreAuthorize("hasAnyRole('"+ AdminRole.ADMIN +"')")
    public List<AdminDto> getAllAdmins() {
        List<AdminDto> adminsToSend = new ArrayList<>();
        List<Admin> admins = adminRepository.findAll();
        for (Admin admin : admins) {
            AdminDto adminDto = AdminConverter.convertAdminToDto(admin);
            adminsToSend.add(adminDto);
        }
        return adminsToSend;
    }

    @PreAuthorize("hasAnyRole('"+ AdminRole.ADMIN +"')")
    public AdminDto getAdminById(Long id) {
        Admin admin = adminRepository.findById(id).orElse(null);
        AdminDto adminDto = AdminConverter.convertAdminToDto(admin);
        return adminDto;
    }

    public Optional<Admin> authenticate(String email, String password) {
        return adminRepository.findByEmail(email)
                .filter(admin -> admin.getPassword().equals(password)); // à remplacer par BCrypt + encode en prod
    }

}
