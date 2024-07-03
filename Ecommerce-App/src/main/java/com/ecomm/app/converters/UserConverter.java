package com.ecomm.app.converters;

import com.ecomm.app.dto.UserDTO;
import com.ecomm.app.model.Users;

public class UserConverter {

    public static Users dtoToEntity(UserDTO dto){
        Users users =new Users();
        users.setId(dto.getId());
        users.setFirstName(dto.getFirstName());
        users.setLastName(dto.getLastName());
        users.setEmail(dto.getEmail());
        users.setMobile(dto.getMobile());
        users.setAddress(dto.getAddress());
        users.setCity(dto.getCity());
        users.setState(dto.getState());
        users.setZip(dto.getZip());
        users.setPassword(dto.getPassword());
        users.setRoles(dto.getRoles());
        return users;
    }
    public static UserDTO entityToDTO(Users users){
        UserDTO dto=new UserDTO();
        dto.setId(users.getId());
        dto.setFirstName(users.getFirstName());
        dto.setLastName(users.getLastName());
        dto.setEmail(users.getEmail());
        dto.setMobile(users.getMobile());
        dto.setAddress(users.getAddress());
        dto.setCity(users.getCity());
        dto.setState(users.getState());
        dto.setZip(users.getZip());
        return dto;
    }
}
