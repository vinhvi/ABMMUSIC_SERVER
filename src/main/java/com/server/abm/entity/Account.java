package com.server.abm.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_acconut")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String email;
    private String passWordAccount;
    private boolean access;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_account_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> rolesCopy = new HashSet<>(roles);
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : rolesCopy) {
            if (role.getName() != null) {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName());
                list.add(simpleGrantedAuthority);
            }
        }
        return list;
    }

    @Override
    public String getPassword() {
        return passWordAccount;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
