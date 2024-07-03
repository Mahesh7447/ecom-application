package com.ecomm.app.controller;

import com.ecomm.app.common.AuthRequest;
import com.ecomm.app.dto.UserDTO;
import com.ecomm.app.service.JwtService;
import com.ecomm.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authManager;
    @PostMapping()
    public boolean save(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping()
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest request) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(request.getEmail());
        }
        else
            throw new UsernameNotFoundException("User does not exist");
    }
}
