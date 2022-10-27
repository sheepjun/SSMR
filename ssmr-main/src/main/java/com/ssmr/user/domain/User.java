//package com.ssmr.user.domain;
//
//import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class User implements UserDetails {
//    private String USER_ID;
//    private String EMAIL;
//    private String USER_NAME;
//    private String NICKNAME;
//    private String USER_TYPE;
//    private String GENDER;
//    private String BIRTHDAY;
//    private String PASSWORD;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.a();
//    }
//
//    @Override
//    public String getPassword() {
//        return this.pas;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
