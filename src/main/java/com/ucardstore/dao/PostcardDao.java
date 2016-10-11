package com.ucardstore.dao;

import com.ucardstore.entity.Postcard;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YUAN on 2016/9/6.
 */
@Repository
public interface PostcardDao {
    void addPostcard(Postcard postcard);
    List<Postcard> findPostcard(Integer number);
    Postcard findPostcardByID(String cardID);
    void postcardRec(String receiveTime,String cardID);
}
