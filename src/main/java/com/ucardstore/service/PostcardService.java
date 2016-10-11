package com.ucardstore.service;

import com.ucardstore.model.AddPostcard;
import com.ucardstore.result.Result;

/**
 * Created by YUAN on 2016/9/6.
 */
public interface PostcardService {
    Result addPostcard(AddPostcard newPostcard) throws Exception;
    Result findPostcardByID(String cardID);
    Result findPostCards(Integer page);
    Result savePic(String string,String name);
    boolean track(String cardID,String recTime);


}
