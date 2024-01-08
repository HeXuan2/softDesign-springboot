package com.hexuan.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hexuan.supermarket.entity.Cart;
import com.hexuan.supermarket.entity.Item;
import com.hexuan.supermarket.mapper.CartMapper;
import com.hexuan.supermarket.service.ICartService;
import com.hexuan.supermarket.service.ShoppingCartObserver;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hexuan
 * @since 2023-09-03
 */

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {
    @Resource
    private CartMapper cartMapper;
    @Override
    public List<Cart> listCart(String userId, Integer shopId) {
        QueryWrapper<Cart> itemQueryWrapper = new QueryWrapper<>();
        itemQueryWrapper.eq("userId", userId);
        if (shopId != null) {
            itemQueryWrapper.eq("shopId", shopId);
        }
        List<Cart> itemList = cartMapper.selectList(itemQueryWrapper);
        return itemList;
    }

    @Override
    public int saveCart(Cart cart) {return cartMapper.insert(cart);}

    @Override
    public int updateCart(Cart cart) {
        return cartMapper.updateCart(cart);
    }

    @Override
    public int removeCart(Cart cart) {

        return cartMapper.removeCart(cart);
    }


    private List<ShoppingCartObserver> observers;
    private int numberOfItems;

    public CartServiceImpl() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(ShoppingCartObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ShoppingCartObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ShoppingCartObserver observer : observers) {
            observer.update(numberOfItems);
        }
    }

    @Override
    public int getNumberOfItems() {
        return numberOfItems;
    }

    @Override
    public void addItem() {
        numberOfItems++;
        notifyObservers();
    }

    @Override
    public void removeItem() {
        if (numberOfItems > 0) {
            numberOfItems--;
            notifyObservers();
        }
    }

}
