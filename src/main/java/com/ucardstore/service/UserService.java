package com.ucardstore.service;

import com.ucardstore.model.LogInUser;
import com.ucardstore.model.LogOutUser;
import com.ucardstore.model.RegisterUser;
import com.ucardstore.model.Result;

/**
 * Created by YUAN on 2016/9/4.
 */

public interface UserService {
     Result register(RegisterUser registerUser);
     Result login(LogInUser logInUser);
     Result logout(LogOutUser logOutUser);
}
