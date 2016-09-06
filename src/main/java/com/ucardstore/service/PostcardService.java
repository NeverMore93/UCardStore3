package com.ucardstore.service;

import com.ucardstore.model.NewPostcard;
import com.ucardstore.model.Result;

/**
 * Created by YUAN on 2016/9/6.
 */
public interface PostcardService {
    Result addPostcard(NewPostcard newPostcard);

}
