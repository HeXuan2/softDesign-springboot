package com.hexuan.supermarket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hexuan.supermarket.entity.Cart;


import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hexuan
 * @since 2023-09-03
 */
public interface ICartService extends IService<Cart> {
    public int saveCart(Cart cart);
    public int updateCart(Cart cart);
    public int removeCart(Cart cart);
    List<Cart> listCart(String userId, Integer shopId);

    // Subject（被观察者）接口
    void registerObserver(ShoppingCartObserver observer);
    void removeObserver(ShoppingCartObserver observer);
    void notifyObservers();
    int getNumberOfItems();
    void addItem();
    void removeItem();
}
