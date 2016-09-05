package com.ucardstore.service;

import com.ucardstore.entity.LogInUser;
import com.ucardstore.entity.LogOutUser;
import com.ucardstore.entity.RegisterUser;
import com.ucardstore.entity.User;
import com.ucardstore.model.Result;

/**
 * Created by YUAN on 2016/9/4.
 */

public interface UserService {
     Result register(RegisterUser registerUser);
     Result login(LogInUser logInUser);
     Result logout(LogOutUser logOutUser);
}
