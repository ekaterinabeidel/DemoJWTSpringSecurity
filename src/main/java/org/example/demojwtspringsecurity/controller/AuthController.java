package org.example.demojwtspringsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.example.demojwtspringsecurity.dto.*;
import org.example.demojwtspringsecurity.entity.AppUser;
import org.example.demojwtspringsecurity.service.jwt.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
 private final AuthService authService;

 @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody RegisterRequestDto registerRequestDto) {
     return ResponseEntity.ok(authService.register(registerRequestDto));
 }

 @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
     return ResponseEntity.ok(authService.login(loginRequestDto));
 }

 @PostMapping("/refresh")
    public ResponseEntity<RefreshTokenResponseDto> refresh(@RequestBody RefreshTokenRequestDto refreshTokenRequestDto) {
     return ResponseEntity.ok(authService.refresh(refreshTokenRequestDto));
 }
}
