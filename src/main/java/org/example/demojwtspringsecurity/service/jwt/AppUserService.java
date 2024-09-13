package org.example.demojwtspringsecurity.service.jwt;

import lombok.RequiredArgsConstructor;
import org.example.demojwtspringsecurity.entity.AppUser;
import org.example.demojwtspringsecurity.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    public UserDetailsService getDetailsService() {

        UserDetailsService detailsService = new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                AppUser user = appUserRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
                return user;
            }
        };

        return detailsService;
    }
}
