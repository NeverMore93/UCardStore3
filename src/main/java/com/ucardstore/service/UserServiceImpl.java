package com.ucardstore.service;

import com.ucardstore.Constants;
import com.ucardstore.Exceptions.AccountException;
import com.ucardstore.dao.UserDao;
import com.ucardstore.model.LogInUser;
import com.ucardstore.model.LogOutUser;
import com.ucardstore.model.RegisterUser;
import com.ucardstore.entity.User;
import com.ucardstore.model.LogInResult;
import com.ucardstore.model.RegisterResult;
import com.ucardstore.model.Result;
import com.ucardstore.tool.UCSTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by YUAN on 2016/9/4.
 */



@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    private RegisterResult registerResult = new RegisterResult();
    private LogInResult logInResult = new LogInResult();
    private Result result = new Result();
    private User user = new User();
    private UCSTool UCStool = new UCSTool();

    @Override
    public Result register(RegisterUser registerUser) {

        String userID = UCStool.generateUserID();
        String token = UCStool.generateToken();

        registerResult.setTokenStr(token);
        registerResult.setUserID(userID);
        registerResult.setUserName(registerUser.getEmail());

        user.setUserName(registerUser.getEmail());
        user.setUserID(userID);
        user.setToken(token);
        user.setPassword(registerUser.getPassword());
        user.setEmail(registerUser.getEmail());

        userDao.register(user);

        result.setMsg("添加成功");
        result.setData(registerResult);
        result.setCode(Constants.SUCCESS);

        return result;
    }

    public Result login(LogInUser logInUser){
        user = userDao.findUserByEmail(logInUser.getEmail());
        String email = user.getEmail();

        if(email==""){
            throw new AccountException("该账户不存在");
        }

        if(!user.getPassword().equals(logInUser.getPassword())){
            throw new AccountException("密码错误");
        }

        String token = UCStool.generateToken();
        user.setToken(token);

        userDao.updateUserByUser(user);

        logInResult.setToken(token);
        logInResult.setUserID(user.getUserID());
        logInResult.setUserName(user.getUserName());

        result.setCode(Constants.SUCCESS);
        result.setData(logInResult);
        result.setMsg("登录成功");

        return result;
    }

    public Result logout(LogOutUser logOutUser){
        user= userDao.findUserByUserID(logOutUser.getUserID());
        user.setToken(null);
        userDao.updateUserByUser(user);
        result.setCode(Constants.SUCCESS);
        result.setData(null);
        result.setMsg("账户已退出");
        return result;
    }
}
