package ma.spring.clinique.security.service;

import lombok.AllArgsConstructor;
import ma.spring.clinique.security.entities.AppRole;
import ma.spring.clinique.security.entities.AppUser;
import ma.spring.clinique.security.repo.AppRoleRepository;
import ma.spring.clinique.security.repo.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    AppUserRepository appUserRepository;
    AppRoleRepository appRoleRepository;
    PasswordEncoder passwordEncoder;
    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmPassword) {
        AppUser user = appUserRepository.findByUsername(username);
        if (user!=null) throw new RuntimeException("User Already Exist!");
        if (!password.equals(confirmPassword)) throw new RuntimeException("Password not match");
        user = AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        return appUserRepository.save(user);
    }

    @Override
    public AppRole addNewRole(String role) {
        AppRole rol = appRoleRepository.findById(role).orElse(null);
        if (rol!=null) throw new RuntimeException("Role already exist");
        rol=AppRole.builder().role(role).build();
        return appRoleRepository.save(rol);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findById(role).get();
        appUser.getRoles().add(appRole);
        //appUserRepository.save(appUser);
    }

    @Override
    public void removeRolefromUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findById(role).get();
        appUser.getRoles().remove(appRole);

    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
