package com.ecomm.app.repository;

import com.ecomm.app.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Users,Long>{
    public Users findByFirstName(String firstName);

}
