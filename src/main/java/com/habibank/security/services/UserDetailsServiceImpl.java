package com.habibank.security.services;

import com.habibank.model.User;
import com.habibank.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // change user to customer or find a way to link both models together
    @Autowired 
    UserRepository userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = userRepo.getByuserName(username);
    			//.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
                
        return UserDetailsImpl.build(user);

    }

    
}
