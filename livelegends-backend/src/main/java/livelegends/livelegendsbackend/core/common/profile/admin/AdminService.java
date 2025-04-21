package livelegends.livelegendsbackend.core.common.profile.admin;

import livelegends.livelegendsbackend.webapi.common.profile.admin.AdminConverter;
import livelegends.livelegendsbackend.webapi.common.profile.admin.AdminDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<AdminDto> getAllAdmins() {
        List<AdminDto> adminsToSend = new ArrayList<>();
        List<Admin> admins = adminRepository.findAll();
        for (Admin admin : admins) {
            AdminDto adminDto = AdminConverter.convertAdminToDto(admin);
            adminsToSend.add(adminDto);
        }
        return adminsToSend;
    }

    public Admin getAdminById(Long id) {
        Admin admin = adminRepository.findById(id).orElse(null);
        AdminDto adminDto = AdminConverter.convertAdminToDto(admin);
        return admin;
    }

}
