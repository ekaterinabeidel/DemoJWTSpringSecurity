package org.example.demojwtspringsecurity.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.demojwtspringsecurity.enums.AppRole;

@Data
@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullname;
    private String email;
    private String password;
    private AppRole role;
}
