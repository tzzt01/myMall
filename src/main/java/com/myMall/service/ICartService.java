package com.myMall.service;

import com.myMall.common.ServerResponse;
import com.myMall.vo.CartVo;

public interface ICartService {
    ServerResponse<CartVo> add(Integer id, Integer count, Integer productId);

    ServerResponse<CartVo> list(Integer id);

    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked);

    ServerResponse<Integer> getCartProductCount(Integer userId);
}
