package com.ucardstore.dao;

import com.ucardstore.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;


/**
 * Created by YUAN on 2016/9/4.
 */
@Repository

public interface UserDao {
    void register(User user);
    User findUserByEmail(String email);
    void updateUserByUser(User user);
    User findUserByUserID(String userID);

}
