package com.fgmedia.fgmediawebapp.security.entity;

//import com.fgmedia.fgmediawebapp.security.constant.Role;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "USER")
//public class UserEntity implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String firstName;
//
//    private String lastName;
//
//    private String email;
//
//    private String password;
//
//    private Role role;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(role.name()));
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}