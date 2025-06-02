package livelegends.livelegendsbackend.webapi.common.profile.admin;

import livelegends.livelegendsbackend.core.common.profile.admin.Admin;

public class AdminConverter {

    public static AdminDto convertAdminToDto(final Admin admin) {
        AdminDto adminDto = null;
        if (admin != null) {
            adminDto = new AdminDto();
            adminDto.setId(admin.getId());
            adminDto.setEmail(admin.getEmail());
            adminDto.setPassword(admin.getPassword());
            adminDto.setRole(admin.getRole());
        }
        return adminDto;
    }

}
