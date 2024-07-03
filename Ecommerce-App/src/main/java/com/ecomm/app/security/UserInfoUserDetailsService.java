package com.ecomm.app.security;

import com.ecomm.app.model.Users;
import com.ecomm.app.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Users> user= Optional.ofNullable(userRepository.findByEmail(username));
    return user.map(UserInfoUserDetails::new)
            .orElseThrow(()->new UsernameNotFoundException("User does not exist"));
    }
}
