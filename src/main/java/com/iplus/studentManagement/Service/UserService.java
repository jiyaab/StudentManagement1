package com.iplus.studentManagement.Service;

import com.iplus.studentManagement.Entity.User;

public interface UserService {
    // This is the core logic for the SIGN UP button
    User saveNewUser(String username, String password, String role);
}