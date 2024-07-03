package com.ecomm.app.service;

import com.ecomm.app.converters.UserConverter;
import com.ecomm.app.dto.UserDTO;
import com.ecomm.app.model.Users;
import com.ecomm.app.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public boolean save(UserDTO userDTO) {
        if (userDTO != null) {
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userRepository.save(UserConverter.dtoToEntity(userDTO));
            return true;
        }
        return false;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(users -> UserConverter.entityToDTO(users))
                .collect(Collectors.toList());
    }

    public UserDTO findByEmail(String email){
        Users users =userRepository.findByEmail(email);
        return UserConverter.entityToDTO(users);
    }
}
