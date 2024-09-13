package org.example.demojwtspringsecurity;

import org.example.demojwtspringsecurity.entity.AppUser;
import org.example.demojwtspringsecurity.enums.AppRole;
import org.example.demojwtspringsecurity.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoJwtSpringSecurityApplication implements CommandLineRunner {

    @Autowired
    private AppUserRepository appUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoJwtSpringSecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createUserIfNotExists("admin@admin.admin", AppRole.ADMIN);
        createUserIfNotExists("user@user.user", AppRole.USER);
    }

    private void createUserIfNotExists(String email, AppRole role) {
        if (appUserRepository.findByEmail(email).isEmpty()) {
            AppUser account = new AppUser();
            account.setEmail(email);
            account.setPassword(new BCryptPasswordEncoder().encode("pass"));
            account.setRole(role);
            appUserRepository.save(account);
        }
    }
}
