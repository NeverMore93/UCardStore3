package com.ucardstore.service;

import com.ucardstore.entity.User;
import com.ucardstore.result.Result;
import com.ucardstore.tool.UCSTool;
import org.springframework.stereotype.Service;

/**
 * Created by YUAN on 2016/10/7.
 */
@Service("wechatService")
public class WechatServiceImpl implements WechatService{

    private Result result = new Result();
    private User user = new User();
    private UCSTool UCStool = new UCSTool();
    @Override
    public Result wechatLogin() {

        return  result;
    }
}
