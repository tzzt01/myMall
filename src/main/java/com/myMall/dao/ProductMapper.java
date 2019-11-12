package com.myMall.dao;

import com.myMall.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectList();

    List<Product> selectByNameAndProductId(@Param(value = "productName") String productName,
                                           @Param(value = "productId") Integer productId);

    List<Product> selectByNameAndProductIds(@Param(value = "productName") String productName,
                                           @Param(value = "categoryIdList") List<Integer> categoryIdList);
}