package com.habibank.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.habibank.model.Customer;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerDetailsImpl implements CustomerDetails {
    private static final long serialVersionUID = 1L;

	private  Long id;

    private  String userName;

    private  String email;

    @JsonIgnore
    private  String password;

    //private final Collection<? extends GrantedAuthority> authorities;

    public CustomerDetailsImpl( Long id, String userName,  String email, String password,
            Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        //this.authorities = authorities;
    }

    public static CustomerDetailsImpl build(final Customer cust) {

        //Figure out if i should implement abstract class role (customer/admin) that is inherited by user  
        // final List<GrantedAuthority> authorities = cust.getRoles().stream()
        //         .map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

        return new CustomerDetailsImpl(cust.getCustomerID(), cust.getUserName(), cust.getEmail(), cust.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final CustomerDetailsImpl cust = (CustomerDetailsImpl) o;
        return Objects.equals(id, cust.id);
    }

    @Override
    public CustomerDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
}