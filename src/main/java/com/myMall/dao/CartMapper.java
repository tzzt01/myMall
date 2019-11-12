package com.myMall.dao;

import com.myMall.common.ServerResponse;
import com.myMall.pojo.Cart;
import com.myMall.vo.CartVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    List<Cart> selectCartByUserId(Integer userId);

    int selectCartProductCheckedStatusByUserId(Integer userId);

    Cart selectCartByUserIdProductId(@Param(value = "userId") Integer userId,
                                     @Param(value = "productId") Integer productId);

    ServerResponse<CartVo> deleteByUserIdProductIds(@Param(value = "userId") Integer userId,
                                                    @Param(value = "productList") List<String> productList);

    ServerResponse<CartVo> checkedOrUncheckedProduct(@Param(value = "userId") Integer userId,
                                                     @Param(value = "productId") Integer productId,
                                                     @Param(value = "checked") Integer checked);

    int selectCartProductCount(Integer userId);

    List<Cart> selectCheckedCartByUserId(Integer userId);
}