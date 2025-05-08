package com.tad.site.auth.model.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@Getter
@ToString
public class CustomUserDetails implements UserDetails{
    private final Long userId;
    private final String username; //USER_EMAIL
    private final String password; //USER_PW
    private final String privateName;
    private final String userNickName;
    private final String userRole;
    private final char isActive;
    private final Collection<? extends GrantedAuthority> authorities;
}
