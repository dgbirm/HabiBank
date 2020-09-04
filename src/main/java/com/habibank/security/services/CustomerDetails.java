package com.habibank.security.services;

public interface CustomerDetails {
        CustomerDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
     
}
