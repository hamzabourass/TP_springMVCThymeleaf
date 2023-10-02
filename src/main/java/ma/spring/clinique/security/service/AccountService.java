package ma.spring.clinique.security.service;

import ma.spring.clinique.security.entities.AppRole;
import ma.spring.clinique.security.entities.AppUser;

public interface AccountService {
    AppUser addNewUser(String username,String password,String email,String confirmPassword);
    AppRole addNewRole(String role);

    void addRoleToUser(String username, String role);
    void removeRolefromUser(String username, String role);
    AppUser loadUserByUsername(String username);
}
