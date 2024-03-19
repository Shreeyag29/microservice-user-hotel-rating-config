package com.shreeya.user.services;


import com.shreeya.user.entities.User;

import java.util.List;

public interface UserService {

    //user operations

    //create
    User saveUser(User user);

    //get all users

    List<User> getAllUsers();

    //get single user of given userId

    User getUser(String userId);

    //Todo

    //delete user
    int deleteUser(String userId);

    //update user
    int updateUser(String userId);





}
