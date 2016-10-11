package com.ucardstore.dao;

import com.ucardstore.entity.UniversityQRScan;
import org.apache.ibatis.annotations.Insert;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * Created by YUAN on 2016/9/7.
 */
@Repository
public interface  UniversityDao {


    void add(UniversityQRScan universityQRScan);
}
