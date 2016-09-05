package com.ucardstore.api;

import com.ucardstore.Constants;
import com.ucardstore.Exceptions.AccountException;
import com.ucardstore.entity.LogInUser;
import com.ucardstore.entity.LogOutUser;
import com.ucardstore.entity.RegisterUser;
import com.ucardstore.model.Result;
import com.ucardstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by YUAN on 2016/9/4.
 */
@RestController
@RequestMapping(value = "/user")

public class UserController {

    @Resource
    private UserService userService;
    private Result result = new Result();


    @RequestMapping(value = "register",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(value= HttpStatus.OK)
    public Result addUser(@RequestBody @Validated RegisterUser registerUser){
        try {
            result = userService.register(registerUser);
        }catch (Exception e){
            throw new AccountException("注册失败");
        }
//        result = userService.register(registerUser);
        return result;
    }

    @RequestMapping(value = "login",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(value= HttpStatus.OK)
    public Result logIn(@RequestBody @Validated LogInUser logInUser){
        try {
            result = userService.login(logInUser);
        }catch (Exception e){
            throw new AccountException("登录失败");
        }
//        result = userService.login(logInUser);

        return result;
    }

    @RequestMapping(value = "logout",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(value= HttpStatus.OK)
    public Result logIn(@RequestBody @Validated LogOutUser logOutUser){
        try {
            result = userService.logout(logOutUser);
        }catch (Exception e){
            throw new AccountException("退出失败");
        }
//        result = userService.logout(logOutUser);
        return result;
    }

    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AccountException.class)
    public Result AccountException(RuntimeException e){
        result.setCode(Constants.FAIL);
        result.setMsg(e.getMessage());
        result.setData(null);
        return result;
    }



}
