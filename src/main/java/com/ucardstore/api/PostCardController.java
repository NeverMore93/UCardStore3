package com.ucardstore.api;

import com.ucardstore.model.NewPostcard;
import com.ucardstore.model.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YUAN on 2016/9/5.
 */
@RestController
@RequestMapping(value = "/postcard")
public class PostCardController {
    @RequestMapping(value = "addPostcard",method = RequestMethod.POST)
    public Result addPostCard(NewPostcard newPostcard){


        Result result=null;

        return result;
    }

}
