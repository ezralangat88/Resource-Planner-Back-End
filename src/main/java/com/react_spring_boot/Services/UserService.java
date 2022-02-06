package com.react_spring_boot.Services;

import com.react_spring_boot.Role.Role;
import com.react_spring_boot.User.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getAllUsers();

    List<Role> getRoles();
}
