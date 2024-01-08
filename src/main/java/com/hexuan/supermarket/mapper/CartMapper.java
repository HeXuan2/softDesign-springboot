package com.hexuan.supermarket.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hexuan.supermarket.entity.Cart;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hexuan
 * @since 2023-09-03
 */
public interface CartMapper extends BaseMapper<Cart> {

    int updateCart(Cart cart);

    int removeCart(Cart cart);
}
