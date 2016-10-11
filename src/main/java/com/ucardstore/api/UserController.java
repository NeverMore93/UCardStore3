package com.ucardstore.api;

import com.ucardstore.Constants;
import com.ucardstore.Exceptions.AccountException;
import com.ucardstore.model.LogInUser;
import com.ucardstore.model.LogOutUser;
import com.ucardstore.model.RegisterUser;
import com.ucardstore.model.UpdateJpush;
import com.ucardstore.result.Result;
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




    @RequestMapping(value = "/register",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(value= HttpStatus.OK)
    public Result addUser(@RequestBody @Validated RegisterUser registerUser){
            result = userService.register(registerUser);

        return result;
    }

    @RequestMapping(value = "/login",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(value= HttpStatus.OK)
    public Result logIn(@RequestBody @Validated LogInUser logInUser){
        result = userService.login(logInUser);
        return result;
    }

    @RequestMapping(value = "/logout",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(value= HttpStatus.OK)
    public Result logIn(@RequestBody @Validated LogOutUser logOutUser){
        result = userService.logout(logOutUser);
        return result;
    }

    @RequestMapping(value = "/updatejpushID",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(value= HttpStatus.OK)
    public Result updatejpushID(@RequestBody @Validated UpdateJpush updateJpush){
        result = userService.updatejpushIDByToken(updateJpush);
        return result;
    }

    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AccountException.class)
    public Result AccountExceptionHandler(AccountException e){
        result.setCode(Constants.FAIL);
        result.setMsg(e.getMessage());
        result.setData(null);
        return result;
    }



}
