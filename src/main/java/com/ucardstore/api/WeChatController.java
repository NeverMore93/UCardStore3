package com.ucardstore.api;

import com.ucardstore.model.WechatUser;
import com.ucardstore.result.Result;
import com.ucardstore.service.WechatService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by YUAN on 2016/9/30.
 */
@RestController
@RequestMapping(value = "/wechat")
public class WeChatController {

    @Resource
    private WechatService wechatService;
    private Result result = new Result();
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Result register(@RequestBody @Validated WechatUser wechatUser){

        return result;
    }

}
