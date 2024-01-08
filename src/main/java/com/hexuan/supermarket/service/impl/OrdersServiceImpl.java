package com.hexuan.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hexuan.supermarket.common.utils.CommonUtil;
import com.hexuan.supermarket.entity.Cart;
import com.hexuan.supermarket.entity.Item;
import com.hexuan.supermarket.entity.Lineitem;
import com.hexuan.supermarket.entity.Orders;
import com.hexuan.supermarket.mapper.ItemMapper;
import com.hexuan.supermarket.mapper.LineitemMapper;
import com.hexuan.supermarket.mapper.OrdersMapper;
import com.hexuan.supermarket.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private LineitemMapper lineitemMapper;
    @Autowired
    IShopService shopService;
    @Autowired
    ICartService cartService;
    @Autowired
    private ILineitemService lineitemService;

    @Override
    @Transactional
    public int createOrders(Orders orders) {
        //1、查询当前用户购物车中当前商家的所有食品
        Cart cart = new Cart();
        cart.setUserId(orders.getUserId());
        cart.setShopId(orders.getShopId());
        List<Cart> cartList = cartService.listCart(cart.getUserId(),cart.getShopId());
        System.out.println("cartList++=="+cartList);

        //2、创建订单（返回生成的订单编号）
        orders.setOrderDate(CommonUtil.getCurrentDate());


        ordersMapper.insert(orders);
        int orderId=orders.getOrderId();

        //3、批量添加订单明细

        for(Cart c : cartList) {

            Lineitem lineitem = new Lineitem();
            lineitem.setOrderId(orderId);
            lineitem.setItemId(c.getItemId());
            lineitem.setQuantity(c.getQuantity());
            lineitemMapper.insert(lineitem);
        }
        List<Lineitem> listLineitem=lineitemService.getLineItemListByOrderId(orderId);

        orders.setLineitemList(listLineitem);
        orders.setShop(shopService.getShopById(orders.getShopId()));

        return orderId;
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        Orders orders=ordersMapper.selectById(orderId);
        orders.setShop(shopService.getShopById(orders.getShopId()));
        List<Lineitem> listLineitem=lineitemService.getLineItemListByOrderId(orderId);
        orders.setLineitemList(listLineitem);
        return orders;
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId){
        QueryWrapper<Orders> ordersQueryWrapper=new QueryWrapper<>();
        ordersQueryWrapper.eq("userId",userId);
        List<Orders> orderList= ordersMapper.selectList(ordersQueryWrapper);
        for (Orders order :orderList){
            order.setShop(shopService.getShopById(order.getShopId()));
            List<Lineitem> listLineitem=lineitemService.getLineItemListByOrderId(order.getOrderId());

            order.setLineitemList(listLineitem);
        }
        return orderList;
    }

    @Override
    public List<Orders> listOrdersByshopId(String shopId) {
        QueryWrapper<Orders> ordersQueryWrapper=new QueryWrapper<>();
        ordersQueryWrapper.eq("shopId",shopId);
        List<Orders> orderList= ordersMapper.selectList(ordersQueryWrapper);
        for (Orders order :orderList){
            order.setShop(shopService.getShopById(order.getShopId()));
            List<Lineitem> listLineitem=lineitemService.getLineItemListByOrderId(order.getOrderId());
            order.setLineitemList(listLineitem);
        }
        return orderList;
    }

    @Override
    public int deleteOrderById(Integer orderId) {
        return ordersMapper.deleteById(orderId);
    }

    @Override
    public int payOrder(Integer orderId) {
        Orders order = getOrdersById(orderId);
        order.setPayState(1);
        Cart cart = new Cart();
        cart.setUserId(order.getUserId());
        cart.setShopId(order.getShopId());
        //4、从购物车表中删除相关食品信息
        cartService.removeCart(cart);
        return ordersMapper.updateById(order);
    }

    @Override
    public int comfirmOrder(Integer orderId) {
        Orders order = getOrdersById(orderId);
        order.setConfirmStatus(1);
        return ordersMapper.updateById(order);
    }

    @Override
    public int refundOrder(Integer orderId) {
        Orders order = getOrdersById(orderId);
        order.setConfirmStatus(2);
        return ordersMapper.updateById(order);
    }


}
