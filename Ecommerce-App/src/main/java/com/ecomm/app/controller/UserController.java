package com.ecomm.app.controller;

import com.ecomm.app.dto.UserDTO;
import com.ecomm.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping()
    public boolean save(UserDTO userDTO){
        return userService.save(userDTO);
    }
    @GetMapping()
    public List<UserDTO> findAll(){
        return userService.findAll();
    }
}
