package com.shreeya.user.repositories;

import com.shreeya.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,String> {

}
